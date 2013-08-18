package devopsdistilled.operp.client.abstracts;

import devopsdistilled.operp.server.data.entity.Entiti;

public interface EntityPaneModel<E extends Entiti<?>, O extends EntityPaneModelObserver<E>>
		extends PaneModel<O> {

	public E getEntity();

	public void setEntityAndEntityOperation(E entity,
			EntityOperation entityOperation);

	public EntityOperation getEntityOperation();

}