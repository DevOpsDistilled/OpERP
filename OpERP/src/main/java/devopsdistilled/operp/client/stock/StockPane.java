package devopsdistilled.operp.client.stock;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import devopsdistilled.operp.client.abstracts.TaskPane;

public class StockPane extends TaskPane {

	@Override
	public String toString() {
		return new String("Stock Management");
	}

	@Override
	public JComponent getPane() {
		JPanel pane = new JPanel();
		pane.add(new JLabel("Stock Management"));
		return pane;
	}

}
