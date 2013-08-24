package devopsdistilled.operp.client.party;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.inject.Inject;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;
import devopsdistilled.operp.client.abstracts.TaskPane;
import devopsdistilled.operp.client.party.controllers.CustomerController;
import devopsdistilled.operp.client.party.controllers.VendorController;

public class PartyMgmtPane extends TaskPane {

	@Inject
	private VendorController vendorController;

	@Inject
	private CustomerController customerController;

	@Override
	public String toString() {
		return new String("Parties");
	}
	
	@Override
	public Icon getIcon() {
		return new ImageIcon(getClass().getResource("/client/icons/party_24.png"));
	}

	/**
	 * @wbp.parser.entryPoint
	 */
	@Override
	public JComponent getPane() {
		JPanel panel = new JPanel();
		panel.setLayout(new MigLayout("", "[][][]", "[][][]"));

		JButton btnCreateVendor = new JButton("Create Vendor");
		btnCreateVendor.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				vendorController.create();
			}
		});
		panel.add(btnCreateVendor, "cell 0 0");

		JButton btnListVendors = new JButton("List Vendors");
		btnListVendors.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				vendorController.list();
			}
		});
		panel.add(btnListVendors, "cell 2 0");

		JButton btnCreateCustomer = new JButton("Create Customer");
		btnCreateCustomer.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				customerController.create();
			}
		});
		panel.add(btnCreateCustomer, "cell 0 2");

		JButton btnListCustomers = new JButton("List Customers");
		btnListCustomers.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				customerController.list();
			}
		});
		panel.add(btnListCustomers, "cell 2 2");
		return panel;
	}

}
