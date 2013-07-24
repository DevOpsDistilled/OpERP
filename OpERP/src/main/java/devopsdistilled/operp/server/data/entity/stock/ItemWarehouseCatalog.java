package devopsdistilled.operp.server.data.entity.stock;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import devopsdistilled.operp.server.data.entity.items.Item;

@Entity
public class ItemWarehouseCatalog implements Serializable {

	private static final long serialVersionUID = 3934073452536868286L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long itemWarehouseCatalogId;
	
	@OneToMany
	private List<Item> item;
	
	@OneToMany
	private List<Warehouse> warehouse;
}
