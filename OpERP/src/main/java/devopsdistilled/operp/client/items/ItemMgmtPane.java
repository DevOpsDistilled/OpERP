package devopsdistilled.operp.client.items;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import devopsdistilled.operp.client.abstracts.TaskPane;

public final class ItemMgmtPane extends TaskPane {

	@Override
	public String toString() {
		return new String("Items");
	}

	@Override
	public JComponent getPane() {
		JPanel pane = new JPanel();
		pane.add(new JLabel("Items Management"));
		return pane;
	}

}
