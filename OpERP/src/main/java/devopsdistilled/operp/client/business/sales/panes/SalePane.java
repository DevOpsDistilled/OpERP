package devopsdistilled.operp.client.business.sales.panes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.inject.Inject;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;
import devopsdistilled.operp.client.abstracts.EntityOperation;
import devopsdistilled.operp.client.abstracts.EntityPane;
import devopsdistilled.operp.client.business.sales.controllers.SaleController;
import devopsdistilled.operp.client.business.sales.panes.controllers.SalePaneController;
import devopsdistilled.operp.client.business.sales.panes.models.observers.SalePaneModelObserver;
import devopsdistilled.operp.client.party.controllers.CustomerController;
import devopsdistilled.operp.server.data.entity.business.Sale;
import devopsdistilled.operp.server.data.entity.party.Customer;

public class SalePane extends
		EntityPane<Sale, SaleController, SalePaneController> implements
		SalePaneModelObserver {

	@Inject
	private SaleController saleController;

	@Inject
	private CustomerController customerController;

	private final JPanel pane;
	private final JTextField saleIdField;
	private final JComboBox<Customer> customerCombo;

	public SalePane() {
		pane = new JPanel();
		pane.setLayout(new MigLayout("", "[][grow]", "[][][][][]"));

		JLabel lblSaleId = new JLabel("Sale Id");
		pane.add(lblSaleId, "cell 0 0,alignx trailing");

		saleIdField = new JTextField();
		saleIdField.setEditable(false);
		pane.add(saleIdField, "cell 1 0,growx");
		saleIdField.setColumns(10);

		JLabel lblCustomer = new JLabel("Customer");
		pane.add(lblCustomer, "cell 0 1,alignx trailing");

		customerCombo = new JComboBox<>();
		customerCombo.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED)
					getController().getModel().getEntity()
							.setParty((Customer) e.getItem());
			}
		});
		pane.add(customerCombo, "flowx,cell 1 1,growx");

		JButton btnNewCustomer = new JButton("New Customer");
		btnNewCustomer.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				customerController.create();
			}
		});
		pane.add(btnNewCustomer, "cell 1 1");

		JPanel saleDescPanel = new JPanel();
		pane.add(saleDescPanel, "cell 0 2 2097051 1,grow");
		saleDescPanel.setLayout(new MigLayout("", "[]", "[]"));

		JPanel opBtnPanel = new JPanel();
		pane.add(opBtnPanel, "cell 1 4,grow");
		opBtnPanel.setLayout(new MigLayout("", "[]", "[]"));
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
		// TODO Auto-generated method stub

	}
}
