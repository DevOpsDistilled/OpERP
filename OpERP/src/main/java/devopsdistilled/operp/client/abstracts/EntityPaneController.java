package devopsdistilled.operp.client.abstracts;

import devopsdistilled.operp.client.exceptions.EntityValidationException;
import devopsdistilled.operp.server.data.entity.Entiti;

public interface EntityPaneController<E extends Entiti<?>, M extends EntityPaneModel<E, ?>>
		extends SubTaskPaneController {

	public void validate() throws EntityValidationException;

	public E save();

	public abstract M getModel();

}
