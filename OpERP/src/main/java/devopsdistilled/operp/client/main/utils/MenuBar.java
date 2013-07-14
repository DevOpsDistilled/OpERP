package devopsdistilled.operp.client.main.utils;

import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public class MenuBar {

	private static JMenuBar menuBar;

	private MenuBar() {
		menuBar = new JMenuBar();

		JMenu fileMenu = new JMenu("File");
		JMenuItem exitMenuItem = new JMenuItem("Quit");
		exitMenuItem.setMnemonic(KeyEvent.VK_Q);
		exitMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q,
				InputEvent.CTRL_MASK));
		fileMenu.add(exitMenuItem);

		menuBar.add(fileMenu);

		JMenu helpMenu = new JMenu("Help");
		menuBar.add(helpMenu);

		JMenuItem aboutMenuItem = new JMenuItem("About");

		aboutMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q,
				InputEvent.CTRL_MASK));
		helpMenu.add(aboutMenuItem);
	}

	public static JMenuBar getInstance() {
		if (menuBar == null) {
			new MenuBar();
		}

		return menuBar;
	}
}
