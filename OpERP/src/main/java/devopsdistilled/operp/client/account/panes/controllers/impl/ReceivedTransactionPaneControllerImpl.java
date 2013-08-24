package devopsdistilled.operp.client.account.panes.controllers.impl;

import javax.inject.Inject;

import devopsdistilled.operp.client.abstracts.EntityOperation;
import devopsdistilled.operp.client.account.panes.ReceivedTransactionPane;
import devopsdistilled.operp.client.account.panes.controllers.ReceivedTransactionPaneController;
import devopsdistilled.operp.client.account.panes.models.ReceivedTransactionPaneModel;
import devopsdistilled.operp.client.exceptions.EntityValidationException;
import devopsdistilled.operp.server.data.entity.account.ReceivedTransaction;

public class ReceivedTransactionPaneControllerImpl implements
		ReceivedTransactionPaneController {

	@Inject
	private ReceivedTransactionPane view;

	@Inject
	private ReceivedTransactionPaneModel model;

	@Override
	public void validate() throws EntityValidationException {
		// TODO Auto-generated method stub

	}

	@Override
	public ReceivedTransaction save() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ReceivedTransactionPaneModel getModel() {
		return model;
	}

	@Override
	public ReceivedTransactionPane getView() {
		return view;
	}

	@Override
	public void init(ReceivedTransaction entity, EntityOperation entityOperation) {

		view.setController(this);
		model.registerObserver(view);
		view.init();
	}

}
