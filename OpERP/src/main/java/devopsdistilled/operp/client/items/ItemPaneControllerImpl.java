package devopsdistilled.operp.client.items;

import java.util.List;

import javax.inject.Inject;

import devopsdistilled.operp.server.data.entity.items.Brand;
import devopsdistilled.operp.server.data.entity.items.Item;
import devopsdistilled.operp.server.data.entity.items.Product;
import devopsdistilled.operp.server.data.service.items.BrandService;
import devopsdistilled.operp.server.data.service.items.ItemService;
import devopsdistilled.operp.server.data.service.items.ProductService;

public class ItemPaneControllerImpl implements ItemPaneController {

	@Inject
	private ItemModel model;

	@Inject
	private ItemService itemService;

	@Inject
	private ProductService productService;

	@Inject
	private BrandService brandService;

	public ItemPaneControllerImpl(ItemModel itemModel, ItemService itemService,
			ProductService productService, BrandService brandService) {
		this.model = itemModel;
		this.itemService = itemService;
		this.productService = productService;
		this.brandService = brandService;
	}

	public ItemPaneControllerImpl(ItemModel itemModel) {
		System.out.println("@Injected Model in Controller: " + this.model);
		this.model = itemModel;
		System.out.println("Controller instantiated: " + this);

		System.out.println("Model in Controller = " + this.model);
	}

	public ItemPaneControllerImpl() {
	}

	@Override
	public void populateData() {
		List<Brand> brands = brandService.findAll();
		model.setBrands(brands);

		List<Product> products = productService.findAll();
		model.setProducts(products);
	}

	@Override
	public boolean validate(Item item) {
		return true;
	}

	@Override
	public Item save(Item item) {
		return itemService.save(item);
	}

	@Override
	public ItemModel getModel() {
		return model;
	}

}
