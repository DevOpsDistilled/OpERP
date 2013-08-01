package devopsdistilled.operp.server.data.service.items;

import devopsdistilled.operp.server.data.entity.items.Category;
import devopsdistilled.operp.server.data.service.EntityService;

public interface CategoryService extends EntityService<Category, Long> {

	boolean isCategoryNameExists(String categoryName);

}
