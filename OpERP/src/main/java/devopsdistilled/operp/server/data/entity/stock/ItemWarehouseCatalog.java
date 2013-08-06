package devopsdistilled.operp.server.data.entity.stock;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import devopsdistilled.operp.server.data.entity.Entiti;

@Entity
public class ItemWarehouseCatalog extends Entiti<Long> {

	private static final long serialVersionUID = 3934073452536868286L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long itemWarehouseCatalogId;
	
	//@ManyToMany(mappedBy="itemWarehouse")
	//private List<Item> item;
	
	@ManyToMany(mappedBy="itemWarehouses")
	private List<Warehouse> warehouses;
	
	public Long getItemWarehouseCatalogId() {
		return itemWarehouseCatalogId;
	}
	public void setItemWarehouseCatalogId(Long itemWarehouseCatalogId) {
		this.itemWarehouseCatalogId = itemWarehouseCatalogId;
	}
	public List<Warehouse> getWarehouses() {
		return warehouses;
	}
	public void setWarehouses(List<Warehouse> warehouses) {
		this.warehouses = warehouses;
	}
	public Long getQuantity() {
		return quantity;
	}
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
	private Long quantity;

	@Override
	public Long id() {
		return itemWarehouseCatalogId;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}
}
