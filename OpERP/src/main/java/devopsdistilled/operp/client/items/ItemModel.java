package devopsdistilled.operp.client.items;

import java.util.List;

import devopsdistilled.operp.client.abstracts.Model;
import devopsdistilled.operp.server.data.entity.items.Brand;
import devopsdistilled.operp.server.data.entity.items.Item;
import devopsdistilled.operp.server.data.entity.items.Product;

public interface ItemModel extends Model {

	public Item getItem();

	public void setProducts(List<Product> products);
	
	public void setBrands(List<Brand> brands);

	public List<Product> getProducts();

	public List<Brand> getBrands();

}
