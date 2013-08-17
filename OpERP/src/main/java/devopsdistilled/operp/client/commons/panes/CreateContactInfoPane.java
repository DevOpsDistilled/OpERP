package devopsdistilled.operp.client.commons.panes;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;
import devopsdistilled.operp.client.abstracts.EntityPane;
import devopsdistilled.operp.client.commons.panes.controllers.CreateContactInfoPaneController;
import devopsdistilled.operp.client.commons.panes.models.observers.CreateContactInfoPaneModelObserver;
import devopsdistilled.operp.server.data.entity.commons.ContactInfo;
import devopsdistilled.operp.server.data.entity.commons.PhoneType;

public class CreateContactInfoPane extends
		EntityPane<CreateContactInfoPaneController> implements
		CreateContactInfoPaneModelObserver {

	private CreateContactInfoPaneController controller;

	private final JPanel pane;
	private final JTextField emailField;
	private final JTextField workNumField;
	private final JTextField mobileNumField;
	private final JTextField homeNumField;

	public CreateContactInfoPane() {
		pane = new JPanel();
		pane.setLayout(new MigLayout("", "[][grow]", "[][][][][][][][][]"));

		JLabel lblAddress = new JLabel("Address");
		pane.add(lblAddress, "flowx,cell 0 0");

		JLabel lblEmail = new JLabel("Email");
		pane.add(lblEmail, "cell 0 3");

		emailField = new JTextField();
		emailField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				controller.getModel().getContactInfo()
						.setEmail(emailField.getText().trim());
			}
		});
		pane.add(emailField, "cell 1 3,growx");
		emailField.setColumns(10);

		JLabel lblPhone = new JLabel("Phone");
		pane.add(lblPhone, "cell 0 5");

		JLabel lblWork = new JLabel("Work");
		pane.add(lblWork, "cell 0 6,alignx trailing");

		workNumField = new JTextField();
		workNumField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (!workNumField.getText().trim().equalsIgnoreCase(""))
					controller.getModel().getContactInfo().getPhoneNumbers()
							.put(PhoneType.Work, workNumField.getText().trim());

			}
		});
		pane.add(workNumField, "cell 1 6,growx");
		workNumField.setColumns(10);

		JLabel lblMobile = new JLabel("Mobile");
		pane.add(lblMobile, "cell 0 7,alignx trailing");

		mobileNumField = new JTextField();
		mobileNumField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (!mobileNumField.getText().trim().equalsIgnoreCase(""))
					controller
							.getModel()
							.getContactInfo()
							.getPhoneNumbers()
							.put(PhoneType.Mobile,
									mobileNumField.getText().trim());
			}
		});
		pane.add(mobileNumField, "cell 1 7,growx");
		mobileNumField.setColumns(10);

		JLabel lblHome = new JLabel("Home");
		pane.add(lblHome, "cell 0 8,alignx trailing");

		homeNumField = new JTextField();
		homeNumField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (!homeNumField.getText().trim().equalsIgnoreCase(""))
					controller.getModel().getContactInfo().getPhoneNumbers()
							.put(PhoneType.Home, homeNumField.getText().trim());
			}
		});
		pane.add(homeNumField, "cell 1 8,growx");
		homeNumField.setColumns(10);
	}

	@Override
	public JComponent getPane() {
		return pane;
	}

	@Override
	public void setController(CreateContactInfoPaneController controller) {
		this.controller = controller;
	}

	public void setAddressPanel(JPanel addressPanel) {
		pane.add(addressPanel, "cell 0 1,grow,span");
		pane.validate();
	}

	@Override
	public void updateEntity(ContactInfo contactInfo) {
		emailField.setText(contactInfo.getEmail());
		workNumField.setText(contactInfo.getPhoneNumbers().get(PhoneType.Work));
		mobileNumField.setText(contactInfo.getPhoneNumbers().get(
				PhoneType.Mobile));
		homeNumField.setText(contactInfo.getPhoneNumbers().get(PhoneType.Home));
	}
}
