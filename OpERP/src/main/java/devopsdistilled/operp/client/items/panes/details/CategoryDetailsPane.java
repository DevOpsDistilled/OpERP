package devopsdistilled.operp.client.items.panes.details;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.inject.Inject;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;
import devopsdistilled.operp.client.abstracts.AbstractEntityDetailsPane;
import devopsdistilled.operp.client.items.controllers.CategoryController;
import devopsdistilled.operp.server.data.entity.items.Category;

public class CategoryDetailsPane extends AbstractEntityDetailsPane<Category> {

	@Inject
	private CategoryController categoryController;

	private Category category;

	private final JPanel pane;
	private final JTextField categoryIdField;
	private final JTextField categoryNameField;
	private final JButton btnDelete;
	private final JButton btnEdit;
	private final JButton btnOk;

	public CategoryDetailsPane() {
		dialog.setTitle("Category Details");
		pane = new JPanel();
		getDialog().getContentPane().add(getPane());
		pane.setLayout(new MigLayout("", "[][grow]", "[][][][]"));

		JLabel lblCategoryId = new JLabel("Category ID");
		pane.add(lblCategoryId, "cell 0 0,alignx trailing");

		categoryIdField = new JTextField();
		categoryIdField.setEditable(false);
		pane.add(categoryIdField, "cell 1 0,growx");
		categoryIdField.setColumns(10);

		JLabel lblCategoryName = new JLabel("Category Name");
		pane.add(lblCategoryName, "cell 0 1,alignx trailing");

		categoryNameField = new JTextField();
		categoryNameField.setEditable(false);
		pane.add(categoryNameField, "cell 1 1,growx");
		categoryNameField.setColumns(10);

		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				getDialog().dispose();
				categoryController.delete(category);
			}
		});
		pane.add(btnDelete, "flowx,cell 1 3");

		btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				getDialog().dispose();
				categoryController.edit(category);
			}
		});
		pane.add(btnEdit, "cell 1 3");

		btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				getDialog().dispose();
			}
		});
		pane.add(btnOk, "cell 1 3");

	}

	@Override
	public JComponent getPane() {
		return pane;
	}

	@Override
	public void show(Category category) {
		this.category = category;
		if (category != null) {
			categoryIdField.setText(category.getCategoryId().toString());
			categoryNameField.setText(category.getCategoryName());

			getDialog().setVisible(true);

		} else {

			dialog.dispose();
			JOptionPane.showMessageDialog(getPane(), "Null category");
		}
	}
}
