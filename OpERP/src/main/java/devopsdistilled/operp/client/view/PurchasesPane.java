package devopsdistilled.operp.client.view;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;


public class PurchasesPane implements TaskPane {
	private JPanel pane;

	@Override
	public String toString() {
		return "Purchases";
	}

	@Override
	public void makeCurrentWorkingTaskPane() {
		pane = new JPanel();
		pane.add(new JLabel("From Purchases Pane"));
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				MainWindow.getInstance().setTaskPane(pane);

			}
		});

	}
}
