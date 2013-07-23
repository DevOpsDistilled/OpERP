package devopsdistilled.operp.client.abstracts;

import javax.swing.JComponent;
import javax.swing.JDialog;

import net.miginfocom.swing.MigLayout;

public abstract class SubTaskPane {
	protected JDialog dialog;

	public SubTaskPane() {
		dialog = new JDialog();
	}

	public abstract JComponent getPane();

	public void init() {
		dialog.getContentPane().setLayout(new MigLayout("debug, fill"));
		dialog.getContentPane().add(getPane(), "grow");
		dialog.setSize(400, 600);
		dialog.setVisible(true);

	}

	public JDialog getDialog() {
		return dialog;
	}

}
