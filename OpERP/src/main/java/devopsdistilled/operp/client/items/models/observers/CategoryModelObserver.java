package devopsdistilled.operp.client.items.models.observers;

import java.util.List;

import devopsdistilled.operp.client.abstracts.EntityModelObserver;
import devopsdistilled.operp.server.data.entity.items.Category;

public interface CategoryModelObserver extends EntityModelObserver {

	public void updateCategories(List<Category> categories);

}
