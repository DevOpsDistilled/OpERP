package devopsdistilled.operp.client.abstracts;

import javax.swing.JComponent;
import javax.swing.JDialog;

import devopsdistilled.operp.server.data.entity.Entiti;

public abstract class AbstractEntityDetailsPane<E extends Entiti<?>> {

	protected final JDialog dialog;

	public AbstractEntityDetailsPane() {
		dialog = new JDialog();
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		dialog.setTitle(getTitle());
		dialog.setSize(400, 300);
	}

	public abstract JComponent getPane();

	public abstract void show(E entity);

	public abstract String getTitle();

	public JDialog getDialog() {
		return dialog;
	}
}
