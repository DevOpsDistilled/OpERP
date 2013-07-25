package devopsdistilled.operp.client.stock;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;
import devopsdistilled.operp.client.abstracts.SubTaskPane;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class StockPane extends SubTaskPane  {
	private JPanel pane;
	private JTextField textField;
	private JTextField textField_1;
	
	/**
	 * @wbp.parser.entryPoint
	 */
	@Override
	public void init(){
		pane=new JPanel();
		pane.setLayout(new MigLayout("", "[]25[grow]", "[][][][][]"));
		
		JLabel lblItemName = new JLabel("Item Name");
		pane.add(lblItemName, "cell 0 0,alignx trailing");
		
		JComboBox comboBox = new JComboBox();
		pane.add(comboBox, "cell 1 0,growx");
		
		JLabel lblWarehouseName = new JLabel("Warehouse Name");
		pane.add(lblWarehouseName, "cell 0 1,alignx trailing");
		
		JComboBox comboBox_1 = new JComboBox();
		pane.add(comboBox_1, "cell 1 1,growx");
		
		JLabel lblQuantity = new JLabel("Quantity");
		pane.add(lblQuantity, "cell 0 2,alignx trailing");
		
		textField = new JTextField();
		pane.add(textField, "cell 1 2,growx");
		textField.setColumns(15);
		
		JButton btnCancel = new JButton("Cancel");
		pane.add(btnCancel, "flowx,split 3,cell 1 4");
		
		JButton btnUpdate = new JButton("Update");
		pane.add(btnUpdate, "cell 1 4");
		
	
		
		
		
		
		
		
		
		
		
}

	@Override
	public JComponent getPane() {
		
		return pane;
	}
}
	
	
