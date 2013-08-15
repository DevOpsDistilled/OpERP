package devopsdistilled.operp.client.abstracts;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JComponent;
import javax.swing.JDialog;

import net.miginfocom.swing.MigLayout;

public abstract class SubTaskPane implements PaneModelObserver {
	protected JDialog dialog;

	public SubTaskPane() {
		dialog = new JDialog();
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		dialog.getContentPane().setLayout(new MigLayout("fill"));
		
	}

	public abstract JComponent getPane();

	public void init() {
		dialog.getContentPane().add(getPane(), "grow");
		dialog.setLocationRelativeTo(null);
		dialog.pack();
		final Toolkit toolkit = Toolkit.getDefaultToolkit();
		final Dimension screenSize = toolkit.getScreenSize();
		final int x = (screenSize.width - dialog.getWidth()) / 2;
		final int y = (screenSize.height - dialog.getHeight()) / 2;
		dialog.setLocation(x, y);
		dialog.requestFocus();
		dialog.setVisible(true);

		

	}

	public JDialog getDialog() {
		return dialog;
	}

	@Override
	public void updateTitle(String title) {
		getDialog().setTitle(title);
	}
}
