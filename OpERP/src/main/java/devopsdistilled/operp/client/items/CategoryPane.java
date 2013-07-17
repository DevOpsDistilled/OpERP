package devopsdistilled.operp.client.items;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

public class CategoryPane {

	private final JPanel pane;
	private final JTextField textField;
	private final JTextField textField_1;

	public CategoryPane() {
		pane = new JPanel();
		pane.setLayout(new MigLayout("", "[70px][grow]", "[15px][][]"));
		
		JLabel lblCategoryId = new JLabel("Category ID");
		pane.add(lblCategoryId, "cell 0 0,alignx trailing");
		
		textField = new JTextField();
		pane.add(textField, "cell 1 0,growx");
		textField.setColumns(10);
		
		JLabel lblCategoryName = new JLabel("Category Name");
		pane.add(lblCategoryName, "cell 0 1,alignx trailing");
		
		textField_1 = new JTextField();
		pane.add(textField_1, "cell 1 1,growx");
		textField_1.setColumns(10);
		
		JButton btnCancel = new JButton("Cancel");
		pane.add(btnCancel, "flowx,cell 1 2");
		
		JButton btnSave = new JButton("Save");
		pane.add(btnSave, "cell 1 2");
	}

	public JComponent getPane() {
		return pane;
	}

	public JDialog getDialog() {
		JDialog dialog = new JDialog();
		dialog.getContentPane().add(getPane());
		dialog.setSize(600, 400);
		dialog.setVisible(true);
		return dialog;
	}

}
