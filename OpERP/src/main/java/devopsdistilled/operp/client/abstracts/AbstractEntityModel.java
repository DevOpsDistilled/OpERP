package devopsdistilled.operp.client.abstracts;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.remoting.rmi.RmiServiceExporter;

import devopsdistilled.operp.server.data.entity.Entiti;
import devopsdistilled.operp.server.data.service.EntityService;

public abstract class AbstractEntityModel<E extends Entiti<?>, ES extends EntityService<E, ?>, EO extends EntityModelObserver>
		extends AbstractModel<EO> implements EntityModel<E, ES, EO> {

	@Inject
	private ApplicationContext context;

	protected List<E> entities;

	public AbstractEntityModel() {
		entities = new LinkedList<>();
	}

	@Override
	public List<E> getEntities() {
		return entities;
	}

	@Override
	public void setEntities(List<E> entities) {

		this.entities = entities;
		notifyObservers();

	}

	@Override
	public void update() {
		setEntities(getService().findAll());
	}

	@Override
	public void notifyObservers() {
		for (EO observer : observers) {

			Method updateMethod = getUpdateMethod();
			try {
				updateMethod.invoke(observer, getEntities());
			} catch (IllegalAccessException | IllegalArgumentException
					| InvocationTargetException e) {
				e.printStackTrace();
			}
		}
	}

	@SuppressWarnings("unchecked")
	protected Class<EO> getObserverClass() {
		Type superclass = getClass().getGenericSuperclass();

		Type[] typeArguments = ((ParameterizedType) superclass)
				.getActualTypeArguments();
		Class<EO> observerClass = (Class<EO>) (typeArguments[2]);
		return observerClass;

	}

	private Method getUpdateMethod() {
		Method[] methods = getObserverClass().getMethods();
		return methods[0];
	}

	@Override
	// @Transactional
	public E saveAndUpdateModel(E entity) {
		E savedEntity = getService().save(entity);
		update();
		return savedEntity;
	}

	@Override
	public void deleteAndUpdateModel(E entity) {
		getService().delete(entity);
		update();
	}

	@PostConstruct
	public void registerWithServer() {
		AutowireCapableBeanFactory factory = context
				.getAutowireCapableBeanFactory();
		BeanDefinitionRegistry registry = (BeanDefinitionRegistry) factory;
		GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
		beanDefinition.setBeanClass(RmiServiceExporter.class);
		beanDefinition.setAutowireCandidate(true);

		MutablePropertyValues propertyValues = new MutablePropertyValues();

		Class<?> serviceInterface = this.getClass().getInterfaces()[0];

		propertyValues.addPropertyValue("serviceInterface", serviceInterface);
		String serviceName = serviceInterface.getCanonicalName();
		propertyValues.addPropertyValue("serviceName", serviceName);
		propertyValues.addPropertyValue("service", this);
		propertyValues.addPropertyValue("registryPort", "1099");
		beanDefinition.setPropertyValues(propertyValues);

		registry.registerBeanDefinition(serviceName, beanDefinition);
		context.getBean(serviceName); // Need this else
										// NotBoundException

		try {
			Enumeration<NetworkInterface> networkInterfaces = NetworkInterface
					.getNetworkInterfaces();
			while (networkInterfaces.hasMoreElements()) {
				NetworkInterface network = networkInterfaces.nextElement();

				if (!network.isUp() || network.isLoopback()
						|| network.isVirtual())
					continue;

				Enumeration<InetAddress> addresses = network.getInetAddresses();
				while (addresses.hasMoreElements()) {
					InetAddress netAddr = addresses.nextElement();

					if (!netAddr.isLoopbackAddress()
							&& (netAddr instanceof Inet4Address)) {
						getService().registerClient(netAddr.getHostAddress());
						break;
					}

				}
			}
		} catch (SocketException e) {
			e.printStackTrace();
		}
	}
}
