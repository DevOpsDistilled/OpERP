package devopsdistilled.operp.client.items.panes;

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
import devopsdistilled.operp.client.items.panes.models.observers.CreateBrandPaneModelObserver;
import devopsdistilled.operp.server.data.entity.items.Manufacturer;

public class CreateBrandPane extends SubTaskPane implements
		CreateBrandPaneModelObserver, ManufacturerModelObserver {

	private final JPanel pane;
	private final JTextField brandNameField;

	public CreateBrandPane() {
		pane = new JPanel();
		pane.setLayout(new MigLayout("", "[][grow]", "[][][][]"));
		
		JLabel lblBrandName = new JLabel("Brand Name");
		pane.add(lblBrandName, "cell 0 0,alignx trailing");
		
		brandNameField = new JTextField();
		pane.add(brandNameField, "cell 1 0,growx");
		brandNameField.setColumns(10);
		
		JLabel lblManufacturer = new JLabel("Manufacturer");
		pane.add(lblManufacturer, "cell 0 1,alignx trailing");
		
		JComboBox manufacturerCombo = new JComboBox();
		pane.add(manufacturerCombo, "flowx,cell 1 1,growx");
		
		JButton btnNewManufacturer = new JButton("New Manufacturer");
		pane.add(btnNewManufacturer, "cell 1 1");
		
		JButton btnCancel = new JButton("Cancel");
		pane.add(btnCancel, "flowx,cell 1 3");
		
		JButton btnCreate = new JButton("Create");
		pane.add(btnCreate, "cell 1 3");
		// TODO
	}

	@Override
	public JComponent getPane() {
		return pane;
	}

	@Override
	public void updateManufacturers(List<Manufacturer> manufacturers) {
		// TODO Auto-generated method stub

	}

}
