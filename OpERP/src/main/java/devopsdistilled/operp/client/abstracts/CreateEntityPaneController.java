package devopsdistilled.operp.client.abstracts;

import devopsdistilled.operp.server.data.entity.Entiti;

public interface CreateEntityPaneController<E extends Entiti<?>> extends
		SubTaskPaneController {

	public void validate(E entity) throws Exception;

	public E save(E entity);

}
