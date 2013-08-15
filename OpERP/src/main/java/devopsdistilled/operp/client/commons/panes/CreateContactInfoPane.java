package devopsdistilled.operp.client.commons.panes;

import javax.swing.JComponent;
import javax.swing.JPanel;

import devopsdistilled.operp.client.abstracts.SubTaskPane;
import devopsdistilled.operp.client.commons.panes.controllers.CreateContactInfoPaneController;
import devopsdistilled.operp.client.commons.panes.models.observers.CreateContactInfoPaneModelObserver;

public class CreateContactInfoPane extends SubTaskPane implements
		CreateContactInfoPaneModelObserver {

	private CreateContactInfoPaneController controller;

	private final JPanel pane;

	public CreateContactInfoPane() {
		pane = new JPanel();
	}

	@Override
	public JComponent getPane() {
		return pane;
	}

	public void setController(CreateContactInfoPaneController controller) {
		this.controller = controller;
	}
}
