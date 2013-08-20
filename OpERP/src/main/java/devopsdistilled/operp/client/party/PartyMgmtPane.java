package devopsdistilled.operp.client.party;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import devopsdistilled.operp.client.abstracts.TaskPane;

public class PartyMgmtPane extends TaskPane {

	@Override
	public String toString() {
		return new String("Parties");
	}

	@Override
	public Icon getIcon() {
		return new ImageIcon(getClass().getResource("/client/icons/Alerts.png"));
	}

	@Override
	public JComponent getPane() {
		JPanel panel = new JPanel();
		panel.add(new JLabel("Parties Pane"));
		return panel;
	}

}
