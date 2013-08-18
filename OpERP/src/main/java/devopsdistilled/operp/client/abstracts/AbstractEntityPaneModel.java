package devopsdistilled.operp.client.abstracts;

import devopsdistilled.operp.server.data.entity.Entiti;

public abstract class AbstractEntityPaneModel<E extends Entiti<?>, O extends EntityPaneModelObserver<E>>
		extends AbstractPaneModel<O> implements EntityPaneModel<E, O> {

	protected E entity;

	protected EntityOperation entityOperation;

	@Override
	public E getEntity() {
		return entity;
	}

	@Override
	public EntityOperation getEntityOperation() {
		return entityOperation;
	}

	@Override
	public void setEntityAndEntityOperation(E entity,
			EntityOperation entityOperation) {
		this.entity = entity;
		this.entityOperation = entityOperation;

		for (O observer : observers) {
			observer.updateEntity(getEntity(), getEntityOperation());
		}

	}

}
