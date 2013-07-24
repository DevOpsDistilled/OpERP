package devopsdistilled.operp.client.stock;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

import javax.swing.JTextField;

import devopsdistilled.operp.client.abstracts.SubTaskPane;

import javax.swing.JComboBox;
import javax.swing.JButton;

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
		pane.setLayout(new MigLayout("", "[][grow]", "[][][][][]"));
		
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
		
		
		
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				getDialog().setVisible(false);
			}
		});
		pane.add(btnCancel, "flowx,split 2,cell 1 3");
		
		JButton btnSave = new JButton("Save");
		pane.add(btnSave, "cell 1 3");
		
	}
	@Override	
	public JComponent getPane() {
		return pane;
	
	}
}
