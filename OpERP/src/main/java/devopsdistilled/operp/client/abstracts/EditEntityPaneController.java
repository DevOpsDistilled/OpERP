package devopsdistilled.operp.client.abstracts;

import devopsdistilled.operp.server.data.entity.Entiti;

public interface EditEntityPaneController<E extends Entiti<?>> {

	public void init(E entity);

	public void validate(E entity) throws Exception;

	public E save(E entity);

}
