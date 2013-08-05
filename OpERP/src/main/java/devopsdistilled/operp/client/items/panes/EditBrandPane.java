package devopsdistilled.operp.client.items.panes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;
import devopsdistilled.operp.client.abstracts.SubTaskPane;
import devopsdistilled.operp.client.items.models.observers.ManufacturerModelObserver;
import devopsdistilled.operp.client.items.panes.models.observers.EditBrandPaneModelObserver;
import devopsdistilled.operp.server.data.entity.items.Brand;
import devopsdistilled.operp.server.data.entity.items.Manufacturer;

public class EditBrandPane extends SubTaskPane implements
		EditBrandPaneModelObserver, ManufacturerModelObserver {

	private final JPanel pane;
	private final JTextField brandIdField;
	private final JTextField brandNameField;
	private final JComboBox<Manufacturer> manufacturersCombo;

	public EditBrandPane() {
		pane = new JPanel();
		pane.setLayout(new MigLayout("", "[][grow]", "[][][][][]"));

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
		pane.add(manufacturersCombo, "cell 1 2,growx");

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
			}
		});
		pane.add(btnUpdate, "cell 1 4");
	}

	@Override
	public JComponent getPane() {
		return pane;
	}

	@Override
	public void updateEntity(Brand brand) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateManufacturers(List<Manufacturer> manufacturers) {
		// TODO Auto-generated method stub

	}

}
