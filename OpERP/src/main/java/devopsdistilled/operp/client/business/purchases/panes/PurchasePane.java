package devopsdistilled.operp.client.business.purchases.panes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

import javax.inject.Inject;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;
import devopsdistilled.operp.client.abstracts.EntityOperation;
import devopsdistilled.operp.client.abstracts.EntityPane;
import devopsdistilled.operp.client.business.purchases.controllers.PurchaseController;
import devopsdistilled.operp.client.business.purchases.panes.controllers.PurchasePaneController;
import devopsdistilled.operp.client.business.purchases.panes.models.observers.PurchasePaneModelObserver;
import devopsdistilled.operp.client.party.controllers.VendorController;
import devopsdistilled.operp.client.party.models.observers.VendorModelObserver;
import devopsdistilled.operp.server.data.entity.business.Purchase;
import devopsdistilled.operp.server.data.entity.party.Vendor;

public class PurchasePane extends
		EntityPane<Purchase, PurchaseController, PurchasePaneController> implements
		PurchasePaneModelObserver, VendorModelObserver {

	@Inject
	private PurchaseController saleController;

	@Inject
	private VendorController vendorController;

	private final JPanel pane;
	private final JComboBox<Vendor> vendorCombo;
	private JPanel opBtnPanel;
	private JPanel saleDescPanel;

	public PurchasePane() {
		pane = new JPanel();
		pane.setLayout(new MigLayout("", "[][grow]", "[][][][][]"));

		JLabel lblVendor = new JLabel("Vendor");
		pane.add(lblVendor, "cell 0 0,alignx trailing");

		vendorCombo = new JComboBox<>();
		vendorCombo.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED)
					getController().getModel().getEntity()
							.setParty((Vendor) e.getItem());
			}
		});
		pane.add(vendorCombo, "flowx,cell 1 0,growx");

		JButton btnNewVendor = new JButton("New Vendor");
		btnNewVendor.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				vendorController.create();
			}
		});
		pane.add(btnNewVendor, "cell 1 0");

		saleDescPanel = new JPanel();
		pane.add(saleDescPanel, "cell 0 2 2097051 1,grow");
		saleDescPanel.setLayout(new MigLayout("", "[]", "[]"));

		opBtnPanel = new JPanel();
		pane.add(opBtnPanel, "cell 1 4,grow");
		opBtnPanel.setLayout(new MigLayout("", "[][][grow]", "[grow]"));

		JPanel panel = new JPanel();
		opBtnPanel.add(panel, "cell 2 0,grow");
	}

	@Override
	public void resetComponents() {
		// TODO Auto-generated method stub

	}

	@Override
	public PurchaseController getEntityController() {
		return saleController;
	}

	@Override
	public JComponent getPane() {
		return pane;
	}

	@Override
	public void updateEntity(Purchase sale, EntityOperation entityOperation) {
		if (EntityOperation.Create == entityOperation) {
			getController().getModel().setTitle("New Purchase");
			opBtnPanel = setBtnPanel(createOpPanel, opBtnPanel);
		}
	}

	public void setPurchaseDescpanel(JPanel saleDescPanel) {
		MigLayout layout = (MigLayout) pane.getLayout();
		Object constraints = layout.getComponentConstraints(this.saleDescPanel);

		pane.remove(this.saleDescPanel);
		pane.add(saleDescPanel, constraints);
		this.saleDescPanel = saleDescPanel;
		pane.validate();
	}

	@Override
	public void updateVendors(List<Vendor> vendors) {
		Vendor prevSelected = (Vendor) vendorCombo.getSelectedItem();
		vendorCombo.removeAllItems();

		for (Vendor vendor : vendors) {
			vendorCombo.addItem(vendor);
			if (prevSelected != null)
				if (prevSelected.compareTo(vendor) == 0)
					vendorCombo.setSelectedItem(vendor);
		}
	}
}
