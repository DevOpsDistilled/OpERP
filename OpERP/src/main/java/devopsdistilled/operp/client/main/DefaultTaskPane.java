package devopsdistilled.operp.client.main;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

public class DefaultTaskPane extends TaskPane {

	@Override
	public String toString() {
		return "OpERP";
	}

	@Override
	public JComponent getPane() {
		JPanel panel = new JPanel();
		panel.setLayout(new MigLayout("debug"));
		panel.add(new JLabel("DefaultTaskPane"));
		return panel;
	}
}
