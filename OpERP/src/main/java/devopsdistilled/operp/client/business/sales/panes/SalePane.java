package devopsdistilled.operp.client.business.sales.panes;

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
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;
import devopsdistilled.operp.client.abstracts.EntityOperation;
import devopsdistilled.operp.client.abstracts.EntityPane;
import devopsdistilled.operp.client.business.sales.controllers.SaleController;
import devopsdistilled.operp.client.business.sales.panes.controllers.SalePaneController;
import devopsdistilled.operp.client.business.sales.panes.models.observers.SalePaneModelObserver;
import devopsdistilled.operp.client.exceptions.EntityValidationException;
import devopsdistilled.operp.client.party.controllers.CustomerController;
import devopsdistilled.operp.client.party.models.observers.CustomerModelObserver;
import devopsdistilled.operp.server.data.entity.business.Sale;
import devopsdistilled.operp.server.data.entity.party.Customer;

public class SalePane extends
		EntityPane<Sale, SaleController, SalePaneController> implements
		SalePaneModelObserver, CustomerModelObserver {

	@Inject
	private SaleController saleController;

	@Inject
	private CustomerController customerController;

	private final JPanel pane;
	private final JComboBox<Customer> customerCombo;
	private JPanel saleDescPanel;
	private final JButton btnCancel;
	private final JButton btnSale;

	public SalePane() {
		pane = new JPanel();
		pane.setLayout(new MigLayout("", "[][grow]", "[][][][][]"));

		JLabel lblCustomer = new JLabel("Customer");
		pane.add(lblCustomer, "cell 0 0,alignx trailing");

		customerCombo = new JComboBox<>();
		customerCombo.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED)
					getController().getModel().getEntity()
							.setParty((Customer) e.getItem());
			}
		});
		pane.add(customerCombo, "flowx,cell 1 0,growx");

		JButton btnNewCustomer = new JButton("New Customer");
		btnNewCustomer.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				customerController.create();
			}
		});
		pane.add(btnNewCustomer, "cell 1 0");

		saleDescPanel = new JPanel();
		pane.add(saleDescPanel, "cell 0 2 2 1,grow");
		saleDescPanel.setLayout(new MigLayout("", "[]", "[]"));

		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		pane.add(btnCancel, "flowx,cell 1 4,alignx right");

		btnSale = new JButton("Sale");
		btnSale.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					getController().validate();

					Sale sale = getController().save();

					dispose();

					saleController.showDetails(sale);

				} catch (EntityValidationException e1) {
					JOptionPane.showMessageDialog(getPane(), e1.getMessage());
				}
			}
		});
		pane.add(btnSale, "cell 1 4,alignx right");
	}

	@Override
	public void resetComponents() {
		// TODO Auto-generated method stub

	}

	@Override
	public SaleController getEntityController() {
		return saleController;
	}

	@Override
	public JComponent getPane() {
		return pane;
	}

	@Override
	public void updateEntity(Sale sale, EntityOperation entityOperation) {
		if (EntityOperation.Create == entityOperation) {
			getController().getModel().setTitle("New Sale");
		}
	}

	public void setSaleDescpanel(JPanel saleDescPanel) {
		MigLayout layout = (MigLayout) pane.getLayout();
		Object constraints = layout.getComponentConstraints(this.saleDescPanel);

		pane.remove(this.saleDescPanel);
		pane.add(saleDescPanel, constraints);
		this.saleDescPanel = saleDescPanel;
		pane.validate();
	}

	@Override
	public void updateCustomers(List<Customer> customers) {
		Customer prevSelected = (Customer) customerCombo.getSelectedItem();
		customerCombo.removeAllItems();

		for (Customer customer : customers) {
			customerCombo.addItem(customer);
			if (prevSelected != null)
				if (prevSelected.compareTo(customer) == 0)
					customerCombo.setSelectedItem(customer);
		}
	}
}
