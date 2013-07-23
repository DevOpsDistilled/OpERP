package devopsdistilled.operp.client.abstracts;

import javax.swing.JComponent;
import javax.swing.JDialog;

import net.miginfocom.swing.MigLayout;

public abstract class SubTaskPane {
	protected JDialog dialog;
	protected JComponent owner;

	public SubTaskPane() {
		dialog = new JDialog();
	}

	public abstract JComponent getPane();

	public void setOwner(JComponent owner) {
		this.owner = owner;
	}

	public JDialog getDialog() {
		dialog.getContentPane().setLayout(new MigLayout("debug"));
		dialog.getContentPane().add(getPane());
		dialog.setLocationRelativeTo(owner);
		dialog.setSize(400, 600);
		dialog.setVisible(true);
		return dialog;
	}

}
