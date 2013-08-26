package devopsdistilled.operp.client.abstracts;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;
import devopsdistilled.operp.client.exceptions.EntityValidationException;
import devopsdistilled.operp.server.data.entity.Entiti;

public abstract class EntityPane<E extends Entiti<?>, EC extends EntityController<E>, C extends EntityPaneController<?, ?, ?>>
		extends SubTaskPane {

	protected C controller;

	protected final JPanel createOpPanel;
	protected final JPanel detailsOpPanel;
	protected final JPanel editOpPanel;

	public EntityPane() {

		// create Create Mode button panel
		createOpPanel = new JPanel();
		createOpPanel.setLayout(new MigLayout("", "[grow]", "[]"));

		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		createOpPanel.add(btnCancel, "flowx,cell 0 0");

		JButton btnCreate = new JButton("Create");
		btnCreate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					getController().validate();

					@SuppressWarnings("unchecked")
					E entity = (E) getController().save();

					dispose();

					getEntityController().showDetails(entity);

				} catch (EntityValidationException e1) {
					JOptionPane.showMessageDialog(getPane(), e1.getMessage());
				}
			}
		});
		createOpPanel.add(btnCreate, "cell 0 0");

		// Create Edit Mode button panel
		editOpPanel = new JPanel();
		editOpPanel.setLayout(new MigLayout("", "[grow]", "[]"));

		JButton btnEditCancel = new JButton("Cancel");
		btnEditCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		editOpPanel.add(btnEditCancel, "flowx,cell 0 0");

		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					getController().validate();

					@SuppressWarnings("unchecked")
					E entity = (E) getController().save();

					dispose();

					getEntityController().showDetails(entity);

				} catch (EntityValidationException e1) {
					JOptionPane.showMessageDialog(getPane(), e1.getMessage());
				}
			}
		});
		editOpPanel.add(btnUpdate, "cell 0 0");

		// Create Details Mode Button Panel
		detailsOpPanel = new JPanel();
		detailsOpPanel.setLayout(new MigLayout("", "[grow]", "[]"));

		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			@SuppressWarnings("unchecked")
			@Override
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(
						getPane(), "Delete "
								+ controller.getModel().getEntity().toString()
								+ " ?", "Delete ?", JOptionPane.YES_NO_OPTION)) {

					dispose();
					getEntityController().delete(
							(E) getController().getModel().getEntity());
				}

			}
		});
		detailsOpPanel.add(btnDelete, "flowx,cell 0 0");

		JButton btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			@SuppressWarnings("unchecked")
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				getEntityController().edit(
						(E) getController().getModel().getEntity());
			}
		});
		detailsOpPanel.add(btnEdit, "cell 0 0");

		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		detailsOpPanel.add(btnOk, "cell 0 0");
	}

	public void setController(C controller) {
		this.controller = controller;
	}

	public C getController() {
		return controller;
	}

	public void dispose() {
		resetComponents();
		getDialog().dispose();
	}

	public abstract void resetComponents();

	protected JPanel setBtnPanel(JPanel btnPanel, JPanel tobeReplaced) {

		MigLayout layout = (MigLayout) getPane().getLayout();
		Object opBtnPanelconstraints = layout
				.getComponentConstraints(tobeReplaced);
		getPane().remove(tobeReplaced);
		getPane().add(btnPanel, opBtnPanelconstraints);
		return btnPanel;
	}

	public abstract EC getEntityController();
}
