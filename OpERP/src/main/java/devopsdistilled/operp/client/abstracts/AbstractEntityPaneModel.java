package devopsdistilled.operp.client.abstracts;

import devopsdistilled.operp.server.data.entity.Entiti;

public abstract class AbstractEntityPaneModel<E extends Entiti<?>, O extends EntityPaneModelObserver<E>>
		extends AbstractPaneModel<O> implements EntityPaneModel<E, O> {

	protected E entity;

	@Override
	public E getEntity() {
		return entity;
	}

	@Override
	public void setEntity(E entity) {
		this.entity = entity;
	}

}
