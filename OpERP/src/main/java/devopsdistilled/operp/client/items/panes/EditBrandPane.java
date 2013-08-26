package devopsdistilled.operp.client.items.panes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

import javax.inject.Inject;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;
import devopsdistilled.operp.client.abstracts.SubTaskPane;
import devopsdistilled.operp.client.exceptions.EntityValidationException;
import devopsdistilled.operp.client.items.controllers.ManufacturerController;
import devopsdistilled.operp.client.items.models.observers.ManufacturerModelObserver;
import devopsdistilled.operp.client.items.panes.controllers.EditBrandPaneController;
import devopsdistilled.operp.client.items.panes.details.BrandDetailsPane;
import devopsdistilled.operp.client.items.panes.models.observers.EditBrandPaneModelObserver;
import devopsdistilled.operp.server.data.entity.items.Brand;
import devopsdistilled.operp.server.data.entity.items.Manufacturer;

public class EditBrandPane extends SubTaskPane implements
		EditBrandPaneModelObserver, ManufacturerModelObserver {

	@Inject
	private EditBrandPaneController controller;

	@Inject
	private BrandDetailsPane brandDetailsPane;
	
	@Inject
	private ManufacturerController manufacturerController;

	private final JPanel pane;
	private final JTextField brandIdField;
	private final JTextField brandNameField;
	private final JComboBox<Manufacturer> manufacturersCombo;
	private final AbstractButton btnNewManufacturer;
	
	private Brand brand;
	
	public EditBrandPane() {
		pane = new JPanel();
		pane.setLayout(new MigLayout("", "[][]", "[][][][][]"));

		JLabel lblBrandId = new JLabel("Brand ID");
		pane.add(lblBrandId, "cell 0 0,alignx trailing");

		brandIdField = new JTextField();
		brandIdField.setEditable(false);
		pane.add(brandIdField, "cell 1 0,growx");
		brandIdField.setColumns(10);

		JLabel lblBrandName = new JLabel("Brand Name");
		pane.add(lblBrandName, "cell 0 1,alignx trailing");

		brandNameField = new JTextField();
		pane.add(brandNameField, "cell 1 1,growx");
		brandNameField.setColumns(10);

		JLabel lblManufacturer = new JLabel("Manufacturer");
		pane.add(lblManufacturer, "cell 0 2,alignx trailing");

		manufacturersCombo = new JComboBox<>();
		manufacturersCombo.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED)
					getDialog().pack();
				
			}
		});
		manufacturersCombo.setSelectedItem(null);
		pane.add(manufacturersCombo, "flowx,cell 1 2,growx");
		
		btnNewManufacturer = new JButton("New Manufacturer");
		btnNewManufacturer.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				manufacturerController.create();
			}
		});
		pane.add(btnNewManufacturer, "cell 1 2");

		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				getDialog().dispose();
			}
		});
		pane.add(btnCancel, "flowx,cell 1 4");

		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Brand newBrand = new Brand();
				newBrand.setBrandID(brand.getBrandID());

				newBrand.setBrandName(brandNameField.getText().trim());
				newBrand.setManufacturer((Manufacturer) manufacturersCombo
						.getSelectedItem());

				try {
					controller.validate(newBrand);
					newBrand = controller.save(newBrand);
					getDialog().dispose();
					brandDetailsPane.show(newBrand, getPane());

				} catch (EntityValidationException e1) {
					JOptionPane.showMessageDialog(getPane(), e1.getMessage());
				}
			}
		});

		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				updateEntity(brand);
			}
		});
		pane.add(btnReset, "cell 1 4");
		pane.add(btnUpdate, "cell 1 4");
		
		
	}

	@Override
	public JComponent getPane() {
		return pane;
	}

	@Override
	public void updateEntity(Brand brand) {
		this.brand = brand;
		brandIdField.setText(brand.getBrandID().toString());
		brandNameField.setText(brand.getBrandName());
		manufacturersCombo.setSelectedItem(brand.getManufacturer());
	}

	@Override
	public void updateManufacturers(List<Manufacturer> manufacturers) {
		Manufacturer prevSelected = (Manufacturer) manufacturersCombo
				.getSelectedItem();
		manufacturersCombo.removeAllItems();

		for (Manufacturer manufacturer : manufacturers) {
			manufacturersCombo.addItem(manufacturer);
			if (prevSelected != null)
				if (prevSelected.compareTo(manufacturer) == 0)
					manufacturersCombo.setSelectedItem(manufacturer);
		}
	}

}
