package devopsdistilled.operp.client.sales;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import devopsdistilled.operp.client.abstracts.TaskPane;

public class SalesPane extends TaskPane {

	@Override
	public String toString() {
		return new String("Sales Management");
	}

	@Override
	public JComponent getPane() {
		JPanel pane = new JPanel();
		pane.add(new JLabel("Sales Management"));
		return pane;
	}

}
