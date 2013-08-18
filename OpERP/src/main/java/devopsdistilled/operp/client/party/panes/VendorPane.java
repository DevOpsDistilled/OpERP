package devopsdistilled.operp.client.party.panes;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.inject.Inject;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;
import devopsdistilled.operp.client.abstracts.EntityOperation;
import devopsdistilled.operp.client.abstracts.EntityPane;
import devopsdistilled.operp.client.party.controllers.VendorController;
import devopsdistilled.operp.client.party.panes.controllers.VendorPaneController;
import devopsdistilled.operp.client.party.panes.models.observers.VendorPaneModelObserver;
import devopsdistilled.operp.server.data.entity.party.Party;
import devopsdistilled.operp.server.data.entity.party.Vendor;

public class VendorPane extends
		EntityPane<Vendor, VendorController, VendorPaneController> implements
		VendorPaneModelObserver {

	@Inject
	private VendorController vendorController;

	private final JPanel pane;
	private final JTextField nameField;
	private final JTextField panVatField;
	private final JLabel lblVendorId;
	private final JTextField vendorIdField;
	private JPanel contactInfoPanel;
	private JPanel opBtnPanel;

	public VendorPane() {
		pane = new JPanel();
		pane.setLayout(new MigLayout("", "[][grow]", "[][][][][][]"));

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
				((Party) getController().getModel().getEntity())
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
				((Party) getController().getModel().getEntity())
						.setPanVat(panVatField.getText().trim());
			}
		});
		pane.add(panVatField, "cell 1 2,growx");
		panVatField.setColumns(10);

		contactInfoPanel = new JPanel();
		pane.add(contactInfoPanel, "cell 0 3 2 1,grow");

		opBtnPanel = new JPanel();
		pane.add(opBtnPanel, "cell 1 5,grow");

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

			opBtnPanel = setBtnPanel(createOpPanel, opBtnPanel);

			lblVendorId.setVisible(false);
			vendorIdField.setVisible(false);

		} else if (EntityOperation.Edit == entityOperation) {

			opBtnPanel = setBtnPanel(editOpPanel, opBtnPanel);

			vendorIdField.setText(vendor.getPartyId().toString());

		} else if (EntityOperation.Details == entityOperation) {

			opBtnPanel = setBtnPanel(detailsOpPanel, opBtnPanel);

			vendorIdField.setText(vendor.getPartyId().toString());
			nameField.setEditable(false);
			panVatField.setEditable(false);
			detailsOpPanel.setVisible(true);
		}

		nameField.setText(vendor.getPartyName());
		panVatField.setText(vendor.getPanVat());
	}

	@Override
	public void resetComponents() {

		lblVendorId.setVisible(true);
		vendorIdField.setVisible(true);
		nameField.setEditable(true);
		panVatField.setEditable(true);
	}

	@Override
	public VendorController getEntityController() {
		return vendorController;
	}

}
