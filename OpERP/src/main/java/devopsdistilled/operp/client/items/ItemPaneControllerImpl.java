package devopsdistilled.operp.client.items;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import devopsdistilled.operp.server.data.entity.items.Brand;
import devopsdistilled.operp.server.data.service.items.BrandService;
import devopsdistilled.operp.server.data.service.items.ItemService;
import devopsdistilled.operp.server.data.service.items.ProductService;

public class ItemPaneControllerImpl implements ItemPaneController {

	private final ItemModel model;

	@Inject
	private ItemService itemService;

	@Inject
	private ProductService productService;

	@Inject
	private BrandService brandService;

	public ItemPaneControllerImpl(ItemModel itemModel) {
		this.model = itemModel;
	}

	@Override
	public void populateData() {
		List<Brand> brands = new ArrayList<>();
		System.out.println("BrandService = " + brandService);
		brands = brandService.findAll();
		model.setBrands(brands);
	}

}
