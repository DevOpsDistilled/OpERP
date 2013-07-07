package devopsdistilled.operp.client.controller;

import javax.inject.Inject;

import devopsdistilled.operp.client.main.MainWindow;

public class MainWindowController {

	@Inject
	private MainWindow mainWindow;

	public MainWindow getMainWindow() {
		return mainWindow;
	}

	public void setMainWindow(MainWindow mainWindow) {
		this.mainWindow = mainWindow;
	}

	private static MainWindowController mainWindowController = new MainWindowController();

	private MainWindowController() {
	}

	public static MainWindowController getInstance() {
		return mainWindowController;
	}

	public void dispose() {
		getMainWindow().getMainFrame().dispose();
	}

	public void display() {
		mainWindow.display();
	}

}
