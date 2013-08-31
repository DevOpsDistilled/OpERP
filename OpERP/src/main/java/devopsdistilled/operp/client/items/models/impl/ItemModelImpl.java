package devopsdistilled.operp.client.items.models.impl;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.springframework.context.ApplicationContext;

import devopsdistilled.operp.client.abstracts.AbstractEntityModel;
import devopsdistilled.operp.client.items.models.ItemModel;
import devopsdistilled.operp.client.items.models.observers.ItemModelObserver;
import devopsdistilled.operp.server.data.entity.items.Item;
import devopsdistilled.operp.server.data.service.items.ItemService;

public class ItemModelImpl extends
		AbstractEntityModel<Item, ItemService, ItemModelObserver> implements
		ItemModel {

	@Inject
	private ApplicationContext context;

	@Inject
	private ItemService service;

	@Override
	public ItemService getService() {
		return service;
	}

	@Override
	@PostConstruct
	public void registerWithServer() {

		super.registerWithServer();
	}
}
