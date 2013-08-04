package devopsdistilled.operp.client.abstracts;

import devopsdistilled.operp.server.data.entity.Entiti;

public interface EditEntityPaneModel<E extends Entiti<?>, PMO extends EditEntityPaneModelObserver<E>>
		extends PaneModel<PMO> {

	public void setEntity(E entity);

	public E getEntity();
}
