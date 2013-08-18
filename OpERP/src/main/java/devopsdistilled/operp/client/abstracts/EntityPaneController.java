package devopsdistilled.operp.client.abstracts;

import devopsdistilled.operp.client.exceptions.EntityValidationException;
import devopsdistilled.operp.server.data.entity.Entiti;

public interface EntityPaneController<E extends Entiti<?>, M extends EntityPaneModel<E, ?>, V extends EntityPane<?>> {

	public void validate() throws EntityValidationException;

	public E save();

	public abstract M getModel();

	public abstract V getView();

	public void init(E entity, EntityOperation op);

}
