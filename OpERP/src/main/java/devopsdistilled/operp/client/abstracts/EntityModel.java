package devopsdistilled.operp.client.abstracts;

import java.util.List;

import devopsdistilled.operp.server.data.entity.Entiti;
import devopsdistilled.operp.server.data.service.EntityService;

public interface EntityModel<E extends Entiti, ES extends EntityService<E, ?>, EO extends EntityModelObserver>
		extends Model<EO> {

	public List<E> getEntities();

	void setEntities(List<E> entities);

	public ES getService();

	public E saveAndUpdateModel(E entity);

	public void deleteAndUpdateModel(E entity);

}
