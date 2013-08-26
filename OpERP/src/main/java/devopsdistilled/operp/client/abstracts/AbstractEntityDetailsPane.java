package devopsdistilled.operp.client.abstracts;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;
import devopsdistilled.operp.server.data.entity.Entiti;

public abstract class AbstractEntityDetailsPane<E extends Entiti<?>, EC extends EntityController<E>> {

	protected final JDialog dialog;

	protected JPanel btnPanel;

	public AbstractEntityDetailsPane() {
		dialog = new JDialog();
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		dialog.setTitle(getTitle());
		dialog.setSize(400, 300);
		dialog.getContentPane().setLayout(new MigLayout("fill", "[]", "[]"));

		btnPanel = new JPanel();
		btnPanel.setLayout(new MigLayout("alignx right"));

		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(
						getPane(), "Delete " + getEntity() + " ?", "Delete ?",
						JOptionPane.YES_NO_OPTION)) {

					getDialog().dispose();
					getEntityController().delete(getEntity());
				}
			}

		});
		btnPanel.add(btnDelete);

		JButton btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				getDialog().dispose();
				getEntityController().edit(getEntity());
			}
		});
		btnPanel.add(btnEdit);

		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				getDialog().dispose();
			}
		});
		btnPanel.add(btnOk);

	}

	public abstract EC getEntityController();

	protected abstract E getEntity();

	public abstract JPanel getPane();

	public abstract void show(E entity, JComponent owner);

	public abstract String getTitle();

	public JDialog getDialog() {
		return dialog;
	}

	public void showDetailsPane(JPanel detailsPane, JComponent owner) {
		getPane().add(btnPanel, "south");
		dialog.getContentPane().add(getPane(), "grow");
		getDialog().setLocationRelativeTo(owner);
		getDialog().pack();
		getDialog().setVisible(true);

	}

}
