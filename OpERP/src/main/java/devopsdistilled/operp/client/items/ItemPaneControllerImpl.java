package devopsdistilled.operp.client.items;

import java.util.List;

import devopsdistilled.operp.server.data.entity.items.Brand;
import devopsdistilled.operp.server.data.entity.items.Product;
import devopsdistilled.operp.server.data.service.items.BrandService;
import devopsdistilled.operp.server.data.service.items.ItemService;
import devopsdistilled.operp.server.data.service.items.ProductService;

public class ItemPaneControllerImpl implements ItemPaneController {

	private final ItemModel model;

	private final ItemService itemService;

	private final ProductService productService;

	private final BrandService brandService;

	public ItemPaneControllerImpl(ItemModel itemModel, ItemService itemService,
			ProductService productService, BrandService brandService) {
		this.model = itemModel;
		this.itemService = itemService;
		this.productService = productService;
		this.brandService = brandService;
	}

	@Override
	public void populateData() {
		List<Brand> brands = brandService.findAll();
		model.setBrands(brands);
		
		List<Product> products = productService.findAll();
		model.setProducts(products);
	}

}
