package devopsdistilled.operp.client.items;

import devopsdistilled.operp.client.abstracts.Observer;

public interface ItemModelObserver extends Observer {

	void updateProducts();

	void updateBrands();

}
