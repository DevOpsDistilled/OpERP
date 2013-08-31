package devopsdistilled.operp.client.items.models.impl;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.remoting.rmi.RmiServiceExporter;

import devopsdistilled.operp.client.abstracts.AbstractEntityModel;
import devopsdistilled.operp.client.items.models.ItemModel;
import devopsdistilled.operp.client.items.models.observers.ItemModelObserver;
import devopsdistilled.operp.server.data.entity.items.Item;
import devopsdistilled.operp.server.data.service.items.ItemService;

public class ItemModelImpl extends
		AbstractEntityModel<Item, ItemService, ItemModelObserver> implements
		ItemModel {

	@Inject
	private ApplicationContext context;

	@Inject
	private ItemService service;

	@Override
	public ItemService getService() {
		return service;
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
		propertyValues.addPropertyValue("serviceInterface", ItemModel.class);
		propertyValues.addPropertyValue("serviceName",
				ItemModel.class.getCanonicalName());
		propertyValues.addPropertyValue("service", this);
		propertyValues.addPropertyValue("registryPort", "1099");
		beanDefinition.setPropertyValues(propertyValues);

		registry.registerBeanDefinition("itemModelServiceExporter",
				beanDefinition);
		context.getBean("itemModelServiceExporter"); // Need this else
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
						service.registerClient(netAddr.getHostAddress());
						break;
					}

				}
			}
		} catch (SocketException e) {
			e.printStackTrace();
		}
	}
}
