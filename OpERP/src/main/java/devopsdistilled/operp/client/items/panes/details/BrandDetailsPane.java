package devopsdistilled.operp.client.items.panes.details;

import javax.inject.Inject;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;
import devopsdistilled.operp.client.abstracts.CopyOfAbstractEntityDetailsPane;
import devopsdistilled.operp.client.items.controllers.BrandController;
import devopsdistilled.operp.server.data.entity.items.Brand;
import devopsdistilled.operp.server.data.entity.items.Manufacturer;

public class BrandDetailsPane extends
		CopyOfAbstractEntityDetailsPane<Brand, BrandController> {

	@Inject
	private BrandController brandController;

	private final JPanel pane;

	private Brand brand;
	private final JTextField brandIdField;
	private final JTextField brandNameField;
	private final JTextField manufacturerField;

	public BrandDetailsPane() {
		pane = new JPanel();
		pane.setLayout(new MigLayout("", "[][grow]", "[][][]"));

		JLabel lblBrandId = new JLabel("Brand ID");
		pane.add(lblBrandId, "cell 0 0,alignx trailing");

		brandIdField = new JTextField();
		brandIdField.setEditable(false);
		pane.add(brandIdField, "cell 1 0,growx");
		brandIdField.setColumns(10);

		JLabel lblBrandName = new JLabel("Brand Name");
		pane.add(lblBrandName, "cell 0 1,alignx trailing");

		brandNameField = new JTextField();
		brandNameField.setEditable(false);
		pane.add(brandNameField, "cell 1 1,growx");
		brandNameField.setColumns(10);

		JLabel lblManufacturer = new JLabel("Manufacturer");
		pane.add(lblManufacturer, "cell 0 2,alignx trailing");

		manufacturerField = new JTextField();
		manufacturerField.setEditable(false);
		pane.add(manufacturerField, "cell 1 2,growx");
		manufacturerField.setColumns(10);

		super.showDetailsPane(getPane());
	}

	@Override
	public JPanel getPane() {
		return pane;
	}

	@Override
	public void show(Brand brand) {
		this.brand = brand;
		if (brand != null) {
			brandIdField.setText(brand.getBrandID().toString());
			brandNameField.setText(brand.getBrandName());
			manufacturerField.setText(brand.getManufacturer().toString());

			getDialog().setVisible(true);

		} else {

			getDialog().dispose();
			JOptionPane.showMessageDialog(getPane(), "Got Null Product");
		}
	}

	@Override
	public String getTitle() {
		return "Brand Details";
	}

	@Override
	public BrandController getEntityController() {
		return brandController;
	}

	@Override
	protected Brand getEntity() {
		return brand;
	}

	public static void main(String[] args) {
		Brand brand = new Brand();
		brand.setBrandID(20L);
		brand.setBrandName("Branded");
		Manufacturer manufacturer = new Manufacturer();
		manufacturer.setManufacturerName("Factory");
		brand.setManufacturer(manufacturer);
		new BrandDetailsPane().show(brand);
	}

}
