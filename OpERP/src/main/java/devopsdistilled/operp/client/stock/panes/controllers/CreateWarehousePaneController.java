package devopsdistilled.operp.client.stock.panes.controllers;

import devopsdistilled.operp.client.abstracts.SubTaskPaneController;
import devopsdistilled.operp.client.exceptions.NullFieldException;
import devopsdistilled.operp.client.items.exceptions.EntityNameExistsException;
import devopsdistilled.operp.server.data.entity.stock.Warehouse;

public interface CreateWarehousePaneController extends SubTaskPaneController{
		
	void validate(Warehouse warehouse) throws NullFieldException,
			EntityNameExistsException;
	
	Warehouse save(Warehouse warehouse);	
}
