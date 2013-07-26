package devopsdistilled.operp.client.abstracts;

import java.io.Serializable;
import java.util.List;

import devopsdistilled.operp.server.data.entity.Entiti;
import devopsdistilled.operp.server.data.service.EntityService;

public interface EntityModel<E extends Entiti, ES extends EntityService<E, ID>, EO extends EntityObserver, ID extends Serializable>
		extends Model<EO> {

	public List<E> getEntities();

	void setEntities(List<E> entities);

	public ES getService();
	
	public E saveAndUpdateModel(E entity);

}
