package devopsdistilled.operp.client.abstracts;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import devopsdistilled.operp.server.data.entity.Entiti;
import devopsdistilled.operp.server.data.service.EntityService;

public abstract class AbstractEntityModel<E extends Entiti, ES extends EntityService<E, ID>, EO extends EntityObserver, ID extends Serializable>
		extends AbstractModel<EO> implements EntityModel<E, ES, EO, ID> {

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

	@SuppressWarnings("unchecked")
	@Override
	public void notifyObservers() {
		for (EO observer : observers) {
			observer.update(getEntities());
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public void registerObserver(EO observer) {
		super.registerObserver(observer);
		update();
		observer.update(getEntities());
	}
}
