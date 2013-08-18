package devopsdistilled.operp.client.party.panes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;
import devopsdistilled.operp.client.abstracts.EntityOperation;
import devopsdistilled.operp.client.abstracts.EntityPane;
import devopsdistilled.operp.client.exceptions.EntityValidationException;
import devopsdistilled.operp.client.party.panes.controllers.VendorPaneController;
import devopsdistilled.operp.client.party.panes.models.observers.VendorPaneModelObserver;
import devopsdistilled.operp.server.data.entity.party.Vendor;

public class VendorPane extends EntityPane<VendorPaneController> implements
		VendorPaneModelObserver {

	private final JPanel pane;
	private final JTextField nameField;
	private final JTextField panVatField;
	private final JButton btnCancel;
	private final JButton btnOperation;
	private final JLabel lblVendorId;
	private final JTextField vendorIdField;
	private JPanel contactInfoPanel;
	private final JPanel createEditOpPanel;
	private final JButton btnDelete;
	private final JButton btnEdit;
	private final JButton btnOk;
	private final JPanel detailsOpPanel;

	public VendorPane() {
		pane = new JPanel();
		pane.setLayout(new MigLayout("", "[][grow]", "[][][][][]"));

		lblVendorId = new JLabel("Vendor ID");
		pane.add(lblVendorId, "cell 0 0,alignx trailing");

		vendorIdField = new JTextField();
		vendorIdField.setEditable(false);
		pane.add(vendorIdField, "cell 1 0,growx");
		vendorIdField.setColumns(10);

		JLabel lblVendorName = new JLabel("Vendor Name");
		pane.add(lblVendorName, "cell 0 1,alignx trailing");

		nameField = new JTextField();
		nameField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				controller.getModel().getEntity()
						.setPartyName(nameField.getText().trim());
			}
		});
		pane.add(nameField, "cell 1 1,growx");
		nameField.setColumns(10);

		JLabel lblPanvat = new JLabel("PAN/VAT");
		pane.add(lblPanvat, "cell 0 2,alignx trailing");

		panVatField = new JTextField();
		panVatField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				controller.getModel().getEntity()
						.setPanVat(panVatField.getText().trim());
			}
		});
		pane.add(panVatField, "cell 1 2,growx");
		panVatField.setColumns(10);

		contactInfoPanel = new JPanel();
		pane.add(contactInfoPanel, "cell 0 3 2 1,grow");

		createEditOpPanel = new JPanel();
		pane.add(createEditOpPanel, "cell 1 5,grow");
		createEditOpPanel.setLayout(new MigLayout("", "[grow]", "[]"));

		btnCancel = new JButton("Cancel");
		createEditOpPanel.add(btnCancel, "flowx,cell 0 0");

		btnOperation = new JButton("EntityOperation");
		createEditOpPanel.add(btnOperation, "cell 0 0");
		btnOperation.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					controller.validate();

					Vendor vendor = controller.save();

					dispose();

					controller.init(vendor, EntityOperation.Details);

				} catch (EntityValidationException e1) {
					JOptionPane.showMessageDialog(getPane(), e1.getMessage());
				}
			}
		});

		detailsOpPanel = new JPanel();
		pane.add(detailsOpPanel, "cell 1 6,grow");
		detailsOpPanel.setLayout(new MigLayout("", "[grow]", "[]"));

		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});
		detailsOpPanel.add(btnDelete, "flowx,cell 0 0");

		btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});
		detailsOpPanel.add(btnEdit, "cell 0 0");
		detailsOpPanel.add(btnOk, "cell 0 0");
		btnCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
	}

	@Override
	public JComponent getPane() {
		return pane;
	}

	public void setContactInfopanel(JPanel contactInfoPanel) {
		MigLayout layout = (MigLayout) pane.getLayout();
		Object constraints = layout
				.getComponentConstraints(this.contactInfoPanel);

		pane.remove(this.contactInfoPanel);
		pane.add(contactInfoPanel, constraints);
		this.contactInfoPanel = contactInfoPanel;
		pane.validate();
	}

	@Override
	public void updateEntity(Vendor vendor, EntityOperation entityOperation) {
		if (EntityOperation.Create == entityOperation) {
			lblVendorId.setVisible(false);
			vendorIdField.setVisible(false);
			createEditOpPanel.setVisible(true);

		} else if (EntityOperation.Edit == entityOperation) {
			vendorIdField.setText(vendor.getPartyId().toString());
			createEditOpPanel.setVisible(true);

		} else if (EntityOperation.Details == entityOperation) {
			nameField.setEditable(false);
			panVatField.setEditable(false);
			detailsOpPanel.setVisible(true);

		}

		btnOperation.setText(entityOperation.toString());
		nameField.setText(vendor.getPartyName());
		panVatField.setText(vendor.getPanVat());
	}

	@Override
	protected void resetComponents() {
		lblVendorId.setVisible(true);
		vendorIdField.setVisible(true);
		nameField.setEditable(true);
		panVatField.setEditable(true);
		createEditOpPanel.setVisible(false);
		detailsOpPanel.setVisible(false);
	}

}
