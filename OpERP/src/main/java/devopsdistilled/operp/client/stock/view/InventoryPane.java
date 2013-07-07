package devopsdistilled.operp.client.stock.view;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import devopsdistilled.operp.client.main.TaskPaneOld;

public class InventoryPane implements TaskPaneOld {

	private JPanel pane;

	public JPanel getPane() {
		return pane;
	}

	public void setPane(JPanel pane) {
		this.pane = pane;
	}

	@Override
	public String toString() {
		return "Inventory";
	}

	@Override
	public void makeCurrentWorkingTaskPane() {
		pane = new JPanel();
		pane.add(new JLabel("From Inventory Pane"));
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				//MainWindow.getInstance().setTaskPane(pane);

			}
		});
	}
}
