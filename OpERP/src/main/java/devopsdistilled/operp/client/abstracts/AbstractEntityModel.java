package devopsdistilled.operp.client.abstracts;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.LinkedList;
import java.util.List;

import devopsdistilled.operp.server.data.entity.Entiti;
import devopsdistilled.operp.server.data.service.EntityService;

public abstract class AbstractEntityModel<E extends Entiti<?>, ES extends EntityService<E, ?>, EO extends EntityModelObserver>
		extends AbstractModel<EO> implements EntityModel<E, ES, EO> {

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
//	@Transactional
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
}
