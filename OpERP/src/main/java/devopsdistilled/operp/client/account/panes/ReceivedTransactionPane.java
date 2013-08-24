package devopsdistilled.operp.client.account.panes;

import javax.inject.Inject;
import javax.swing.JComponent;
import javax.swing.JPanel;

import devopsdistilled.operp.client.abstracts.EntityOperation;
import devopsdistilled.operp.client.abstracts.EntityPane;
import devopsdistilled.operp.client.account.controllers.ReceivedTransactionController;
import devopsdistilled.operp.client.account.panes.controllers.ReceivedTransactionPaneController;
import devopsdistilled.operp.client.account.panes.models.observers.ReceivedTransactionPaneModelObserver;
import devopsdistilled.operp.server.data.entity.account.ReceivedTransaction;

public class ReceivedTransactionPane
		extends
		EntityPane<ReceivedTransaction, ReceivedTransactionController, ReceivedTransactionPaneController>
		implements ReceivedTransactionPaneModelObserver {

	@Inject
	private ReceivedTransactionController receivedTransactionController;

	private final JPanel pane;

	public ReceivedTransactionPane() {
		pane = new JPanel();
	}

	@Override
	public void updateEntity(ReceivedTransaction entity,
			EntityOperation entityOperation) {
		// TODO Auto-generated method stub

	}

	@Override
	public void resetComponents() {
		// TODO Auto-generated method stub

	}

	@Override
	public ReceivedTransactionController getEntityController() {
		return receivedTransactionController;
	}

	@Override
	public JComponent getPane() {
		return pane;
	}

}
