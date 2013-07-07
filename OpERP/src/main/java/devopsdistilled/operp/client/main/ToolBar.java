package devopsdistilled.operp.client.main;

import javax.swing.JButton;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

public class ToolBar {

	private static JToolBar toolBar;

	private ToolBar() {
		toolBar = new JToolBar(SwingConstants.HORIZONTAL);
		toolBar.setRollover(true);

		toolBar.add(new JButton("New"));
		toolBar.add(new JButton("Edit"));

	}

	public static JToolBar getInstance() {
		if (toolBar == null) {
			new ToolBar();
		}

		return toolBar;
	}
}
