package devopsdistilled.operp.server.data.service.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.LinkedList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;

import devopsdistilled.operp.client.abstracts.EntityModel;
import devopsdistilled.operp.server.data.entity.Entiti;
import devopsdistilled.operp.server.data.service.EntityService;

public abstract class AbstractEntityService<E extends Entiti<?>, ID extends Serializable, ER extends JpaRepository<E, ID>, EM extends EntityModel<E, ?, ?>>
		implements EntityService<E, ID> {

	private static final long serialVersionUID = 4892118695516828793L;

	@Inject
	private ApplicationContext context;

	protected abstract ER getRepo();

	protected List<EM> entityModels = new LinkedList<>();

	public void registerEntityModel(EM entityModel) {
		entityModels.add(entityModel);
	}

	public void removeEntityModel(EM entityModel) {
		int i = entityModels.indexOf(entityModel);
		if (i >= 0) {
			entityModels.remove(i);
		}
	}

	@Override
	public boolean isEntityNameExists(String entityName) {
		E entity = findByEntityName(entityName);
		if (entity != null)
			return true;

		return false;
	}

	@Override
	public boolean isEntityNameValidForTheEntity(ID id, String entityName) {
		E entity = findByEntityName(entityName);

		if (entity == null)
			return true;

		if (entity.id().equals(id))
			return true;

		return false;
	}

	protected abstract E findByEntityName(String entityName);

	@Override
	public List<E> findAll() {
		return getRepo().findAll();
	}

	@Override
	public List<E> findAll(Sort sort) {
		return getRepo().findAll(sort);
	}

	@Override
	public <S extends E> List<S> save(Iterable<S> entities) {
		return getRepo().save(entities);
	}

	@Override
	public void flush() {
		getRepo().flush();
	}

	@Override
	public E saveAndFlush(E entity) {
		return getRepo().saveAndFlush(entity);
	}

	@Override
	public void deleteInBatch(Iterable<E> entities) {
		getRepo().deleteInBatch(entities);
	}

	@Override
	public void deleteAllInBatch() {
		getRepo().deleteAllInBatch();
	}

	@Override
	public Page<E> findAll(Pageable pageable) {
		return getRepo().findAll(pageable);
	}

	@Override
	public <S extends E> S save(S entity) {
		return getRepo().save(entity);
	}

	@Override
	public E findOne(ID id) {
		return getRepo().findOne(id);
	}

	@Override
	public boolean exists(ID id) {
		return getRepo().exists(id);
	}

	@Override
	public long count() {
		return getRepo().count();
	}

	@Override
	public void delete(ID id) {
		getRepo().delete(id);
	}

	@Override
	public void delete(E entity) {
		getRepo().delete(entity);
	}

	@Override
	public void delete(Iterable<? extends E> entities) {
		getRepo().delete(entities);
	}

	@Override
	public void deleteAll() {
		getRepo().deleteAll();
	}

	@Override
	public Iterable<E> findAll(Iterable<ID> ids) {
		return getRepo().findAll(ids);
	}

	@Override
	public void registerClient(String clientAddress) {
		System.out.println("Client from " + clientAddress);

		AutowireCapableBeanFactory factory = context
				.getAutowireCapableBeanFactory();
		BeanDefinitionRegistry registry = (BeanDefinitionRegistry) factory;
		GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
		beanDefinition.setBeanClass(RmiProxyFactoryBean.class);
		beanDefinition.setAutowireCandidate(true);

		Class<EM> entityModelInterfaceClass = getEntityModelInterfaceClass();

		MutablePropertyValues propertyValues = new MutablePropertyValues();
		propertyValues.addPropertyValue("serviceInterface",
				entityModelInterfaceClass);
		propertyValues.addPropertyValue("serviceUrl", "rmi://" + clientAddress
				+ ":1099/" + entityModelInterfaceClass.getCanonicalName());
		beanDefinition.setPropertyValues(propertyValues);

		registry.registerBeanDefinition(
				entityModelInterfaceClass.getCanonicalName(), beanDefinition);
		EM entityModel = context.getBean(entityModelInterfaceClass);
		registerEntityModel(entityModel);
		System.out.println(entityModel);

	}

	@SuppressWarnings("unchecked")
	protected Class<EM> getEntityModelInterfaceClass() {
		Type superclass = getClass().getGenericSuperclass();

		Type[] typeArguments = ((ParameterizedType) superclass)
				.getActualTypeArguments();
		Class<EM> observerClass = (Class<EM>) (typeArguments[typeArguments.length - 1]);
		return observerClass;

	}

}
