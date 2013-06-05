package devopsdistilled.operp.client.view.controller;

import java.awt.BorderLayout;

import javax.inject.Inject;

import devopsdistilled.operp.client.view.MainWindow;

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

	public void hideTaskbar() {
		mainWindow.getMainFrame().remove(mainWindow.getToolBar());
		mainWindow.getMainFrame().validate();
	}

	public void showTaskBar() {
		mainWindow.getMainFrame().add(mainWindow.getToolBar(),BorderLayout.NORTH);
		mainWindow.getMainFrame().validate();
	}
}
