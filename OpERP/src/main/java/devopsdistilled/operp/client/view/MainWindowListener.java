package devopsdistilled.operp.client.view;

import javax.inject.Inject;

import devopsdistilled.operp.client.view.controller.MainWindowController;

public class MainWindowListener {
	
	@Inject
	private MainWindowController controller;

	public MainWindowController getController() {
		return controller;
	}

	public void setController(MainWindowController controller) {
		this.controller = controller;
	}

	public void buttonPressed() {
		controller.dispose();
	}
}
