package devopsdistilled.operp.client.commons.panes;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;
import devopsdistilled.operp.client.abstracts.SubTaskPane;
import devopsdistilled.operp.client.commons.panes.models.observers.CreateAddressPaneModelObserver;

public class CreateAddressPane extends SubTaskPane implements
		CreateAddressPaneModelObserver {

	private final JPanel pane;
	private final JTextField countryField;
	private final JTextField zoneField;
	private final JTextField districtField;
	private final JTextField cityField;
	private final JTextField streetField;

	public CreateAddressPane() {
		pane = new JPanel();
		pane.setLayout(new MigLayout("", "[][grow]", "[][][][][]"));
		
		JLabel lblCountry = new JLabel("Country");
		pane.add(lblCountry, "cell 0 0,alignx trailing");
		
		countryField = new JTextField();
		countryField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				
			}
		});
		pane.add(countryField, "cell 1 0,growx");
		countryField.setColumns(10);
		
		JLabel lblZone = new JLabel("Zone");
		pane.add(lblZone, "cell 0 1,alignx trailing");
		
		zoneField = new JTextField();
		pane.add(zoneField, "cell 1 1,growx");
		zoneField.setColumns(10);
		
		JLabel lblDistrict = new JLabel("District");
		pane.add(lblDistrict, "cell 0 2,alignx trailing");
		
		districtField = new JTextField();
		pane.add(districtField, "cell 1 2,growx");
		districtField.setColumns(10);
		
		JLabel lblCity = new JLabel("City");
		pane.add(lblCity, "cell 0 3,alignx trailing");
		
		cityField = new JTextField();
		pane.add(cityField, "cell 1 3,growx");
		cityField.setColumns(10);
		
		JLabel lblStreet = new JLabel("Street");
		pane.add(lblStreet, "cell 0 4,alignx trailing");
		
		streetField = new JTextField();
		pane.add(streetField, "cell 1 4,growx");
		streetField.setColumns(10);
	}

	@Override
	public JComponent getPane() {
		return pane;
	}

}
