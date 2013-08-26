package devopsdistilled.operp.client.items.panes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;

import javax.inject.Inject;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;
import devopsdistilled.operp.client.abstracts.SubTaskPane;
import devopsdistilled.operp.client.exceptions.EntityValidationException;
import devopsdistilled.operp.client.items.controllers.CategoryController;
import devopsdistilled.operp.client.items.models.observers.CategoryModelObserver;
import devopsdistilled.operp.client.items.panes.controllers.CreateProductPaneController;
import devopsdistilled.operp.client.items.panes.details.ProductDetailsPane;
import devopsdistilled.operp.client.items.panes.models.observers.CreateProductPaneModelObserver;
import devopsdistilled.operp.server.data.entity.items.Category;
import devopsdistilled.operp.server.data.entity.items.Product;
import java.awt.Dimension;

public class CreateProductPane extends SubTaskPane implements
		CreateProductPaneModelObserver, CategoryModelObserver {

	@Inject
	private CreateProductPaneController controller;

	@Inject
	private ProductDetailsPane productDetailsPane;

	@Inject
	private CategoryController categoryController;

	private final JPanel pane;
	private final JTextField productNameField;
	private final JPanel categoryPanel;

	DefaultListModel<Category> listModel;
	private final JList<Category> categoryList;
	
	public CreateProductPane() {
		pane = new JPanel();
		pane.setLayout(new MigLayout("", "[][grow]", "[][][]"));

		JLabel lblProductName = new JLabel("Product Name");
		pane.add(lblProductName, "cell 0 0,alignx trailing");

		productNameField = new JTextField();
		pane.add(productNameField, "cell 1 0,growx");
		productNameField.setColumns(10);

		JLabel lblCategory = new JLabel("Category");
		pane.add(lblCategory, "cell 0 1");

		categoryPanel = new JPanel();
		categoryPanel.setMinimumSize(new Dimension(10, 120));
		categoryPanel
				.setLayout(new MigLayout("flowy", "[92px,grow]", "[23px]"));
		JButton btnNewCategory = new JButton("New Category");
		btnNewCategory.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				categoryController.create();
			}
		});
		categoryPanel.add(btnNewCategory, "south");
		JScrollPane scrollPane = new JScrollPane(categoryPanel);
		scrollPane.setMinimumSize(new Dimension(100, 130));

		categoryList = new JList<>();
		categoryList.setMinimumSize(new Dimension(0, 100));
		categoryPanel.add(categoryList, "cell 0 0,grow");
		pane.add(scrollPane, "cell 1 1 ,grow");

		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				getDialog().dispose();
			}
		});
		pane.add(btnCancel, "flowx,cell 1 2");

		JButton btnCreate = new JButton("Create");
		btnCreate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				List<Category> categories = new LinkedList<>();
				categories.addAll(categoryList.getSelectedValuesList());
				Product product = new Product();
				String productName = productNameField.getText().trim();
				product.setProductName(productName);
				product.setCategories(categories);

				try {

					controller.validate(product);
					product = controller.save(product);

					getDialog().dispose();
					productDetailsPane.show(product, getPane());

				} catch (EntityValidationException e1) {
					JOptionPane.showMessageDialog(getPane(), e1.getMessage());

				}
			}
		});
		pane.add(btnCreate, "cell 1 2");
	}

	@Override
	public JComponent getPane() {
		return pane;
	}

	@Override
	public void updateCategories(List<Category> categories) {

		List<Category> selCat = categoryList.getSelectedValuesList();
		int[] selectedIndices = new int[selCat.size()];
		for (int i = 0; i < selCat.size(); i++) {
			selectedIndices[i] = -1;
		}

		listModel = null;
		listModel = new DefaultListModel<>();
		for (Category category : categories) {
			listModel.addElement(category);
		}
		categoryList.setModel(listModel);

		for (Category selCategory : selCat) {
			for (Category category : categories) {
				if (selCategory.compareTo(category) == 0) {
					selectedIndices[selCat.indexOf(selCategory)] = listModel
							.indexOf(category);
				}
			}
		}

		categoryList.setSelectedIndices(selectedIndices);
	}
}
