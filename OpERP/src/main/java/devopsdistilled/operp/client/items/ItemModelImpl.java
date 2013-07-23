package devopsdistilled.operp.client.items;

import java.util.List;

import devopsdistilled.operp.client.abstracts.AbstractModel;
import devopsdistilled.operp.server.data.entity.items.Brand;
import devopsdistilled.operp.server.data.entity.items.Item;
import devopsdistilled.operp.server.data.entity.items.Product;

public class ItemModelImpl extends AbstractModel<ItemModelObserver> implements
		ItemModel {

	private Item item;
	private List<Product> products;
	private List<Brand> brands;

	public ItemModelImpl() {
	}

	public ItemModelImpl(Item item) {
		this.item = item;
	}

	@Override
	public Item getItem() {
		return item;
	}

	@Override
	public List<Product> getProducts() {
		return products;
	}

	@Override
	public List<Brand> getBrands() {
		return brands;
	}

	@Override
	public void setBrands(List<Brand> brands) {
		this.brands = brands;
		for (ItemModelObserver observer : observers) {
			observer.updateBrands();
		}
	}

	@Override
	public void setProducts(List<Product> products) {
		this.products = products;
		for (ItemModelObserver observer : observers) {
			observer.updateProducts();
		}
	}
}
