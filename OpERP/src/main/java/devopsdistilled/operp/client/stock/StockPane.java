package devopsdistilled.operp.client.stock;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;
import devopsdistilled.operp.client.abstracts.SubTaskPane;
import devopsdistilled.operp.client.abstracts.TaskPane;

import javax.swing.JButton;
import javax.swing.JTextField;

public class StockPane extends SubTaskPane  {
	private JPanel pane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	
	/**
	 * @wbp.parser.entryPoint
	 */
	@Override
	public void init(){
		pane=new JPanel();
		pane.setLayout(new MigLayout("", "[]25[grow]", "[][][]"));
		
		JLabel lblStockId = new JLabel("Stock Id");
		pane.add(lblStockId, "cell 0 0,alignx trailing");
		
		textField_1 = new JTextField();
		pane.add(textField_1, "cell 1 0,growx");
		textField_1.setColumns(10);
		
		JLabel lblWarehouseId = new JLabel("Warehouse Id");
		pane.add(lblWarehouseId, "cell 0 1,alignx trailing");
		
		textField_2 = new JTextField();
		pane.add(textField_2, "cell 1 1,growx");
		textField_2.setColumns(10);
		
		JLabel lblQantity = new JLabel("Qantity");
		pane.add(lblQantity, "cell 0 2,alignx trailing");
		
		textField_3 = new JTextField();
		pane.add(textField_3, "cell 1 2,growx");
		textField_3.setColumns(10);
		
		
		
		
		
}

	@Override
	public JComponent getPane() {
		
		return pane;
	}
}
	
	
