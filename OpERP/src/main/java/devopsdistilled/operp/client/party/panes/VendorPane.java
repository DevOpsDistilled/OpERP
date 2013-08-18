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

		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		contactInfoPanel = new JPanel();
		pane.add(contactInfoPanel, "cell 0 3,grow,span");
		pane.add(btnCancel, "flowx,cell 1 4");

		btnOperation = new JButton("EntityOperation");
		btnOperation.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					controller.validate();

					controller.save();

					dispose();
				} catch (EntityValidationException e1) {
					JOptionPane.showMessageDialog(getPane(), e1.getMessage());
				}
			}
		});
		pane.add(btnOperation, "cell 1 4");
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

		} else if (EntityOperation.Edit == entityOperation) {
			lblVendorId.setVisible(true);
			vendorIdField.setVisible(true);
			vendorIdField.setText(vendor.getPartyId().toString());
		}

		btnOperation.setText(entityOperation.toString());
		nameField.setText(vendor.getPartyName());
		panVatField.setText(vendor.getPanVat());
	}

	@Override
	protected void resetComponents() {
		// TODO Auto-generated method stub

	}

}
