package devopsdistilled.operp.server.data.entity;


public class Stock {
    private Item item;
    private int quantity;

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
