package devopsdistilled.operp.client.items;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

public class ManufacturerPane {

	private final JPanel pane;
	private final JTextField textField;
	
	public ManufacturerPane() {
		pane = new JPanel();
		pane.setLayout(new MigLayout("", "[][grow]", "[][][grow]"));
		
		JLabel lblName = new JLabel("Name");
		pane.add(lblName, "cell 0 0,alignx trailing");
		
		textField = new JTextField();
		pane.add(textField, "cell 1 0,growx");
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Cancel");
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});
		pane.add(btnNewButton, "flowx,cell 1 1");
		
		JButton btnSave = new JButton("Save");
		pane.add(btnSave, "cell 1 1");
	}
}
