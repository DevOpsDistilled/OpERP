package devopsdistilled.operp.client.abstracts;

import devopsdistilled.operp.server.data.entity.Entiti;

public interface EntityPaneModelObserver<E extends Entiti<?>> extends
		PaneModelObserver {

	public void updateEntity(E entity, EntityOperation entityOperation);
}
