package devopsdistilled.operp.client.items.panes.details;

import javax.inject.Inject;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;
import devopsdistilled.operp.client.abstracts.AbstractEntityDetailsPane;
import devopsdistilled.operp.client.items.controllers.ManufacturerController;
import devopsdistilled.operp.server.data.entity.items.Manufacturer;

public class ManufacturerDetailsPane extends
		AbstractEntityDetailsPane<Manufacturer, ManufacturerController> {

	@Inject
	private ManufacturerController manufacturerController;

	private Manufacturer manufacturer;

	private final JPanel pane;
	private final JTextField manufacturerIdField;
	private final JTextField manufacturerNameField;

	public ManufacturerDetailsPane() {
		pane = new JPanel();

		pane.setLayout(new MigLayout("", "[][grow]", "[][][][]"));

		JLabel lblManufacturerId = new JLabel("Manufacturer ID");
		pane.add(lblManufacturerId, "cell 0 0,alignx trailing");

		manufacturerIdField = new JTextField();
		manufacturerIdField.setEditable(false);
		pane.add(manufacturerIdField, "cell 1 0,growx");
		manufacturerIdField.setColumns(30);

		JLabel lblManufacturerName = new JLabel("Manufacturer Name");
		pane.add(lblManufacturerName, "cell 0 1,alignx trailing");

		manufacturerNameField = new JTextField();
		manufacturerNameField.setEditable(false);
		pane.add(manufacturerNameField, "cell 1 1,growx");
		manufacturerNameField.setColumns(30);

	}

	@Override
	public JPanel getPane() {
		return pane;
	}

	@Override
	public void show(Manufacturer manufacturer, JComponent owner) {
		this.manufacturer = manufacturer;

		if (manufacturer != null) {
			manufacturerIdField.setText(manufacturer.getManufacturerId()
					.toString());
			manufacturerNameField.setText(manufacturer.getManufacturerName());

			showDetailsPane(getPane(), owner);

		} else {

			getDialog().dispose();
			JOptionPane.showMessageDialog(getPane(), "Got Null Manufacturer");
		}
	}

	@Override
	public String getTitle() {
		return "Manufacturer Details";
	}

	@Override
	public ManufacturerController getEntityController() {
		return manufacturerController;
	}

	@Override
	protected Manufacturer getEntity() {
		return manufacturer;
	}

}
