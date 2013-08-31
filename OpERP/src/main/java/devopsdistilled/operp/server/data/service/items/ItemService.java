package devopsdistilled.operp.server.data.service.items;

import devopsdistilled.operp.server.data.entity.items.Brand;
import devopsdistilled.operp.server.data.entity.items.Item;
import devopsdistilled.operp.server.data.entity.items.Product;
import devopsdistilled.operp.server.data.service.EntityService;

public interface ItemService extends EntityService<Item, Long> {

	boolean isProductBrandPairExists(Product productName, Brand brandName);

	boolean isItemNameExists(String itemName);

	boolean isProductBrandPairValidForItem(Long itemId, Product product,
			Brand brand);

	boolean isItemNameValidForItem(Long itemId, String itemName);

	void registerClient(String clientAddress);

}
