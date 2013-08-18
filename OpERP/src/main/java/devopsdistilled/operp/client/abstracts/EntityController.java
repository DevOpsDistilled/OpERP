package devopsdistilled.operp.client.abstracts;

import devopsdistilled.operp.server.data.entity.Entiti;

public interface EntityController<E extends Entiti<?>> {

	public void create();

	public void edit(E entity);

	public void list();

	public void delete(E entity);

	public void showDetails(E entity);
}
