package devopsdistilled.operp.client.items.panes;

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
import devopsdistilled.operp.client.abstracts.SubTaskPane;
import devopsdistilled.operp.client.exceptions.EntityValidationException;
import devopsdistilled.operp.client.items.panes.controllers.EditCategoryPaneController;
import devopsdistilled.operp.client.items.panes.details.CategoryDetailsPane;
import devopsdistilled.operp.client.items.panes.models.observers.EditCategoryPaneModelObserver;
import devopsdistilled.operp.server.data.entity.items.Category;

public class EditCategoryPane extends SubTaskPane implements
		EditCategoryPaneModelObserver {

	@Inject
	private EditCategoryPaneController controller;

	@Inject
	private CategoryDetailsPane categoryDetailsPane;

	private Category category;

	private final JPanel pane;
	private final JTextField categoryIdField;
	private final JTextField categoryNameField;
	private final JButton btnCancel;
	private final JButton btnUpdate;
	private final JButton btnReset;

	public void init(){
		super.init();
	}
	
	public EditCategoryPane() {
		pane = new JPanel();
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
		pane.add(categoryNameField, "cell 1 1,growx");
		categoryNameField.setColumns(10);

		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				getDialog().dispose();
			}
		});
		pane.add(btnCancel, "flowx,cell 1 3");

		btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				Long categoryId = category.getCategoryId();
				Category category = new Category();
				category.setCategoryId(categoryId);

				String categoryName = categoryNameField.getText().trim();
				category.setCategoryName(categoryName);

				try {
					controller.validate(category);
					category = controller.save(category);
					getDialog().dispose();
					categoryDetailsPane.show(category, getPane());

				} catch (EntityValidationException e1) {
					JOptionPane.showMessageDialog(getPane(), e1.getMessage());
				}
			}
		});

		btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				updateEntity(category);
			}
		});
		pane.add(btnReset, "cell 1 3");
		pane.add(btnUpdate, "cell 1 3");

	}

	@Override
	public JComponent getPane() {
		return pane;
	}

	@Override
	public void updateEntity(Category category) {
		this.category = category;
		categoryIdField.setText(category.getCategoryId().toString());
		categoryNameField.setText(category.getCategoryName());
	}

}
