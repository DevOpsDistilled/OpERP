package devopsdistilled.operp.client.abstracts;

import devopsdistilled.operp.server.data.entity.Entiti;

public abstract class AbstractEditEntityPaneModel<E extends Entiti<?>, PMO extends EditEntityPaneModelObserver<E>>
		extends AbstractPaneModel<PMO> implements EditEntityPaneModel<E, PMO> {

	protected E entity;

	@Override
	public abstract String getTitle();

	@Override
	public void setEntity(E entity) {
		this.entity = entity;
		for (PMO observer : observers) {
			observer.updateEntity(entity);
		}
	}

	@Override
	public E getEntity() {
		return entity;
	}

	@Override
	public void update() {
		super.update();
		setEntity(getEntity());
	}
}
