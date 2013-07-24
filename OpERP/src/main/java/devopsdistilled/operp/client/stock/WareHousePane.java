package devopsdistilled.operp.client.stock;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextField;
import devopsdistilled.operp.client.abstracts.SubTaskPane;
import javax.swing.JButton;

public class WareHousePane extends SubTaskPane{
	private JPanel pane;
	private JTextField textField;
	
	/**
	 * @wbp.parser.entryPoint
	 */
	@Override
	public void init() {
		pane=new JPanel();
		pane.setLayout(new MigLayout("", "[][grow]", "[][][][][]"));
		
		JLabel lblWarehouseName = new JLabel("WareHouse Name");
		pane.add(lblWarehouseName, "cell 0 0,alignx trailing");
		
		textField = new JTextField();
		pane.add(textField, "cell 1 0,growx");
		textField.setColumns(10);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				getDialog().setVisible(false);
			}
		});
		pane.add(btnCancel, "flowx,cell 1 1");
		
		JButton btnSave = new JButton("Save");
		pane.add(btnSave, "cell 1 1");
		
	}
	
	@Override	
	public JComponent getPane() {
		return pane;
	}
}
