package devopsdistilled.operp.client.view;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;


public class SalesPane implements TaskPane {

	private JPanel pane;

	@Override
	public String toString() {
		return "Sales";
	}

	@Override
	public void makeCurrentWorkingTaskPane() {
		pane = new JPanel();
		pane.add(new JLabel("From Sales Pane"));
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				MainWindow.getInstance().setTaskPane(pane);

			}
		});
	}
}
