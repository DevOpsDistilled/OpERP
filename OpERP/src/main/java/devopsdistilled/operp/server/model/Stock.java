package devopsdistilled.operp.server.model;

import javax.persistence.Id;
import javax.persistence.OneToMany;

//@Entity
public class Stock {
    private Item item;
    private int quantity;

    @Id
    @OneToMany
    public Item getItem() {
	return item;
    }

    public void setItem(Item item) {
	this.item = item;
    }

    public int getQuantity() {
	return quantity;
    }

    public void setQuantity(int quantity) {
	this.quantity = quantity;
    }
}
