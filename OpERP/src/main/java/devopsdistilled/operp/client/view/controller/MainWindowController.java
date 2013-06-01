package devopsdistilled.operp.client.view.controller;

import devopsdistilled.operp.client.view.MainWindow;

public class MainWindowController {

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
	
	public void show() {
		mainWindow.display();
	}
}
