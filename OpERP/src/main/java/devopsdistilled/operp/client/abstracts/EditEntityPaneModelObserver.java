package devopsdistilled.operp.client.abstracts;

import devopsdistilled.operp.server.data.entity.Entiti;

public interface EditEntityPaneModelObserver<E extends Entiti<?>> extends
		PaneModelObserver {

	public void updateEntity(E entity);
}
