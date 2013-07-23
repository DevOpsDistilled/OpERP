package devopsdistilled.operp.client.stock;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

import javax.swing.JTextField;

import devopsdistilled.operp.client.abstracts.SubTaskPane;

public class WareHousePane extends SubTaskPane{
	private JPanel pane;
	private JTextField textField;
	private JTextField textField_1;
		
	
	
	
	/**
	 * @wbp.parser.entryPoint
	 */
	@Override
	public void init() {
		pane=new JPanel();
		pane.setLayout(new MigLayout("", "[][grow]", "[][][]"));
		
		JLabel lblWarehouseId = new JLabel("WareHouse Id");
		pane.add(lblWarehouseId, "cell 0 0");
		
		JLabel lblWarehouseName = new JLabel("WareHouse Name");
		pane.add(lblWarehouseName, "cell 0 1,alignx trailing");
		
		textField = new JTextField();
		pane.add(textField, "cell 1 1,growx");
		textField.setColumns(10);
		
		JLabel lblLocation = new JLabel("Location");
		pane.add(lblLocation, "cell 0 2,alignx trailing");
		
		textField_1 = new JTextField();
		pane.add(textField_1, "cell 1 2,growx");
		textField_1.setColumns(10);
		
	}
	@Override	
	public JComponent getPane() {
		return pane;
	
	}
}
