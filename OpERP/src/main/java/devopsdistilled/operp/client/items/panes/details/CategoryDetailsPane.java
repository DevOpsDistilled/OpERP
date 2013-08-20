package devopsdistilled.operp.client.items.panes.details;

import javax.inject.Inject;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;
import devopsdistilled.operp.client.abstracts.AbstractEntityDetailsPane;
import devopsdistilled.operp.client.items.controllers.CategoryController;
import devopsdistilled.operp.server.data.entity.items.Category;

public class CategoryDetailsPane extends
		AbstractEntityDetailsPane<Category, CategoryController> {

	@Inject
	private CategoryController categoryController;

	private Category category;

	private final JPanel pane;
	private final JTextField categoryIdField;
	private final JTextField categoryNameField;

	public CategoryDetailsPane() {
		dialog.setTitle("Category Details");
		pane = new JPanel();
		pane.setLayout(new MigLayout("", "[][grow]", "[][][][]"));

		JLabel lblCategoryId = new JLabel("Category ID");
		pane.add(lblCategoryId, "cell 0 0,alignx trailing");

		categoryIdField = new JTextField();
		categoryIdField.setEditable(false);
		pane.add(categoryIdField, "cell 1 0,growx");
		categoryIdField.setColumns(30);

		JLabel lblCategoryName = new JLabel("Category Name");
		pane.add(lblCategoryName, "cell 0 1,alignx trailing");

		categoryNameField = new JTextField();
		categoryNameField.setEditable(false);
		pane.add(categoryNameField, "cell 1 1,growx");
		categoryNameField.setColumns(30);

	}

	@Override
	public JPanel getPane() {
		return pane;
	}

	@Override
	public void show(Category category, JComponent owner) {
		this.category = category;
		if (category != null) {
			categoryIdField.setText(category.getCategoryId().toString());
			categoryNameField.setText(category.getCategoryName());

			showDetailsPane(getPane(), owner);

		} else {

			dialog.dispose();
			JOptionPane.showMessageDialog(getPane(), "Null category");
		}
	}

	@Override
	public String getTitle() {
		return "Category Details";
	}

	@Override
	public CategoryController getEntityController() {
		return categoryController;
	}

	@Override
	protected Category getEntity() {
		return category;
	}
}
