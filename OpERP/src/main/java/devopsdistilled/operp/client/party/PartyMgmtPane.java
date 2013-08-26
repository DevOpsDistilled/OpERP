package devopsdistilled.operp.client.party;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.inject.Inject;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;
import devopsdistilled.operp.client.abstracts.TaskPane;
import devopsdistilled.operp.client.main.utils.StandardButtonHelper;
import devopsdistilled.operp.client.party.controllers.CustomerController;
import devopsdistilled.operp.client.party.controllers.VendorController;

public class PartyMgmtPane extends TaskPane {

	@Inject
	private VendorController vendorController;

	@Inject
	private CustomerController customerController;

	private JButton btnCreateVendor;
	private JButton btnListVendors;
	private JButton btnCreateCustomer;
	private JButton btnListCustomers;

	private ImageIcon iconCreateVendor;
	private ImageIcon iconListVendors;

	private ImageIcon iconCreateCustomer;

	private ImageIcon iconListCustomers;
	private JLabel lblPartyManagement;

	@Override
	public String toString() {
		return new String("Parties");
	}

	@Override
	public Icon getIcon() {
		return new ImageIcon(getClass().getResource(
				"/client/icons/party_24.png"));
	}

	/**
	 * @wbp.parser.entryPoint
	 */
	@Override
	public JComponent getPane() {
		JPanel panel = new JPanel();
		panel.setLayout(new MigLayout("", "[]50[][grow]", "[]20[]25[][]"));

		lblPartyManagement = new JLabel("Party Management");
		lblPartyManagement.setFont(new Font("Dialog", Font.BOLD, 20));
		panel.add(lblPartyManagement, "cell 0 0 3 1,alignx center");

		btnCreateVendor = new JButton("<html>Create<br/> Vendor</");
		btnCreateVendor.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				vendorController.create();
			}
		});
		iconCreateVendor = new ImageIcon(getClass().getResource(
				"/client/icons/create-vendor.png"));
		btnCreateVendor.setIcon(StandardButtonHelper
				.SetStandardSizeForImage(iconCreateVendor));
		panel.add(
				StandardButtonHelper.SetStandardSizeForButton(btnCreateVendor),
				"cell  0 1");

		btnListVendors = new JButton("List Vendors");
		btnListVendors.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				vendorController.list();
			}
		});
		iconListVendors = new ImageIcon(getClass().getResource(
				"/client/icons/list-vendor.png"));
		btnListVendors.setIcon(StandardButtonHelper
				.SetStandardSizeForImage(iconListVendors));
		panel.add(
				StandardButtonHelper.SetStandardSizeForButton(btnListVendors),
				"cell 1 1 ");

		btnCreateCustomer = new JButton("<html>Create<br/> Customer</html>");
		btnCreateCustomer.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				customerController.create();
			}
		});
		iconCreateCustomer = new ImageIcon(getClass().getResource(
				"/client/icons/create-customer.png"));
		btnCreateCustomer.setIcon(StandardButtonHelper
				.SetStandardSizeForImage(iconCreateCustomer));
		panel.add(StandardButtonHelper
				.SetStandardSizeForButton(btnCreateCustomer), "cell 0 2");

		btnListCustomers = new JButton("<html>List<br/> Customers</html>");
		btnListCustomers.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				customerController.list();
			}
		});
		iconListCustomers = new ImageIcon(getClass().getResource(
				"/client/icons/list-vendor.png"));
		btnListCustomers.setIcon(StandardButtonHelper
				.SetStandardSizeForImage(iconListCustomers));
		panel.add(
				StandardButtonHelper.SetStandardSizeForButton(btnListCustomers),
				"cell 1 2");

		return panel;
	}

}
