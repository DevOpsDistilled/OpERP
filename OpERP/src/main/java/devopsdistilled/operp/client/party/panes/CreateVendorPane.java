package devopsdistilled.operp.client.party.panes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;
import devopsdistilled.operp.client.abstracts.SubTaskPane;
import devopsdistilled.operp.client.party.panes.models.observers.CreateVendorPaneModelObserver;

public class CreateVendorPane extends SubTaskPane implements
		CreateVendorPaneModelObserver {

	private final JPanel pane;
	private final JTextField nameField;
	private final JTextField panVatField;
	private final JButton btnCancel;
	private final JButton btnCreate;
	private JPanel contactInfopanel;

	public CreateVendorPane() {
		pane = new JPanel();
		pane.setLayout(new MigLayout("", "[][grow]", "[][][grow][]"));

		JLabel lblVendorName = new JLabel("Vendor Name");
		pane.add(lblVendorName, "cell 0 0,alignx trailing");

		nameField = new JTextField();
		pane.add(nameField, "cell 1 0,growx");
		nameField.setColumns(10);

		JLabel lblPanvat = new JLabel("PAN/VAT");
		pane.add(lblPanvat, "cell 0 1,alignx trailing");

		panVatField = new JTextField();
		pane.add(panVatField, "cell 1 1,growx");
		panVatField.setColumns(10);

		contactInfopanel = new JPanel();
		pane.add(contactInfopanel, "cell 1 2,grow");

		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				getDialog().dispose();
			}
		});
		pane.add(btnCancel, "flowx,cell 1 3");

		btnCreate = new JButton("Create");
		pane.add(btnCreate, "cell 1 3");
	}

	@Override
	public JComponent getPane() {
		return pane;
	}

	public void setContactInfopanel(JPanel contactInfopanel) {
		this.contactInfopanel = contactInfopanel;
	}

}
