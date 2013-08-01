package devopsdistilled.operp.client.items.panes.models.observers;

import devopsdistilled.operp.client.abstracts.PaneModelObserver;
import devopsdistilled.operp.server.data.entity.items.Category;

public interface EditCategoryPaneModelObserver extends PaneModelObserver {

	public void updateCategory(Category category);
}
