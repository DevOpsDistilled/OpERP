package devopsdistilled.operp.client.items.panes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;
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
import devopsdistilled.operp.client.items.panes.controllers.EditProductPaneController;
import devopsdistilled.operp.client.items.panes.details.ProductDetailsPane;
import devopsdistilled.operp.client.items.panes.models.observers.EditProductPaneModelObserver;
import devopsdistilled.operp.server.data.entity.items.Category;
import devopsdistilled.operp.server.data.entity.items.Product;
import java.awt.Dimension;

public class EditProductPane extends SubTaskPane implements
		EditProductPaneModelObserver, CategoryModelObserver {

	@Inject
	private EditProductPaneController controller;

	@Inject
	private CategoryController categoryController;

	@Inject
	private ProductDetailsPane productDetailsPane;

	private final JPanel pane;
	private final JTextField productNameField;
	private final JPanel categoryPanel;

	DefaultListModel<Category> categoryListModel = new DefaultListModel<>();;
	private final JList<Category> categoryList;
	private final JTextField productIdField;

	private Product product;
	
	public EditProductPane() {
		pane = new JPanel();
		pane.setLayout(new MigLayout("", "[][grow]", "[][][grow][]"));

		JLabel lblProductId = new JLabel("Product ID");
		pane.add(lblProductId, "cell 0 0,alignx trailing");

		productIdField = new JTextField();
		productIdField.setEditable(false);
		pane.add(productIdField, "cell 1 0,growx");
		productIdField.setColumns(10);

		JLabel lblProductName = new JLabel("Product Name");
		pane.add(lblProductName, "cell 0 1,alignx trailing");

		productNameField = new JTextField();
		pane.add(productNameField, "cell 1 1,growx");
		productNameField.setColumns(10);

		JLabel lblCategory = new JLabel("Category");
		pane.add(lblCategory, "cell 0 2");

		categoryPanel = new JPanel();
		categoryPanel.setMinimumSize(new Dimension(100, 120));
		categoryPanel.setLayout(new MigLayout("flowy", "[92px,grow]",
				"[23px,grow]"));
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
		pane.add(scrollPane, "cell 1 2,grow");

		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				getDialog().dispose();
			}
		});
		pane.add(btnCancel, "flowx,cell 1 3");

		JButton btnCreate = new JButton("Update");
		btnCreate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Long productId = product.getProductId();
				Product product = new Product();
				product.setProductId(productId);

				List<Category> categories = new LinkedList<>();
				categories.addAll(categoryList.getSelectedValuesList());
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

		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				updateEntity(product);
			}
		});
		pane.add(btnReset, "cell 1 3");
		pane.add(btnCreate, "cell 1 3");
	}

	@Override
	public void updateEntity(Product product) {
		this.product = product;
		productIdField.setText(product.getProductId().toString());
		productNameField.setText(product.getProductName());
		List<Category> productCategories = product.getCategories();

		int[] selectedIndices = new int[productCategories.size()];
		for (int i = 0; i < productCategories.size(); i++) {
			selectedIndices[i] = -1;
		}

		for (Category productCategory : productCategories) {
			Enumeration<Category> categories = categoryListModel.elements();

			while (categories.hasMoreElements()) {
				Category category = categories.nextElement();
				if (productCategory.compareTo(category) == 0) {
					selectedIndices[productCategories.indexOf(productCategory)] = categoryListModel
							.indexOf(category);
				}
			}
		}

		categoryList.setSelectedIndices(selectedIndices);
	}

	@Override
	public JComponent getPane() {
		return pane;
	}

	@Override
	public void updateCategories(List<Category> categories) {
		categoryListModel = new DefaultListModel<>();
		List<Category> selCat = categoryList.getSelectedValuesList();
		int[] selectedIndices = new int[selCat.size()];
		for (int i = 0; i < selCat.size(); i++) {
			selectedIndices[i] = -1;
		}

		for (Category category : categories) {
			categoryListModel.addElement(category);
		}
		categoryList.setModel(categoryListModel);

		for (Category selCategory : selCat) {
			for (Category category : categories) {
				if (selCategory.compareTo(category) == 0) {
					selectedIndices[selCat.indexOf(selCategory)] = categoryListModel
							.indexOf(category);
				}
			}
		}

		categoryList.setSelectedIndices(selectedIndices);
	}

}
