package devopsdistilled.operp.client.items;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.inject.Inject;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;
import devopsdistilled.operp.client.abstracts.TaskPane;
import devopsdistilled.operp.client.items.controllers.BrandController;
import devopsdistilled.operp.client.items.controllers.CategoryController;
import devopsdistilled.operp.client.items.controllers.ItemController;
import devopsdistilled.operp.client.items.controllers.ManufacturerController;
import devopsdistilled.operp.client.items.controllers.ProductController;
import devopsdistilled.operp.client.main.utils.StandardButtonHelper;


public final class ItemMgmtPane extends TaskPane {

	@Inject
	private ItemController itemController;

	@Inject
	private CategoryController categoryController;

	@Inject
	private ProductController productController;

	@Inject
	private ManufacturerController manufacturerController;

	@Inject
	private BrandController brandController;

	private JButton btnListItems;
	private JButton btnCreateCategory;
	private JButton btnNewItemButton;
	private JButton btnListCategories;
	private JButton btnCreateProduct;
	private JButton btnCreateManufacturer;
	private JButton btnListManufacturers;
	private JButton btnCreateBrand;
	private JButton btnListBrand;
	private JButton btnListProducts;

	private ImageIcon iconCreateItem;
	private ImageIcon iconListItems;
	private ImageIcon iconCreateCategory;
	private ImageIcon iconlistCategories;
	private ImageIcon iconCreateProduct;
	private ImageIcon iconListProduct;
	private ImageIcon iconCreateManufacturer;
	private ImageIcon iconListManufacturer;
	private ImageIcon iconCreateBrand;
	private ImageIcon iconListBrand;

	@Override
	public String toString() {
		return new String("Items");
	}


	@Override
	public Icon getIcon() {
		return new ImageIcon(getClass().getResource(
				"/client/icons/item_24.png"));
	}

	/**
	 * @wbp.parser.entryPoint
	 */

	@Override
	public JComponent getPane() {
		JPanel pane = new JPanel();
		pane.setLayout(new MigLayout("", "[]50[]50[][grow]", "[]20[]25[]25[]25[][]"));

		JLabel lblitemManagement = new JLabel("Item Management");
		lblitemManagement.setFont(new Font("Dialog", Font.BOLD, 20));
		pane.add(lblitemManagement, "cell 0 0 5 1,alignx center");

		btnNewItemButton = new JButton("Create Item");
		btnNewItemButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				itemController.create();
			}
		});
		iconCreateItem = new ImageIcon(
				ItemMgmtPane.class.getResource("/client/icons/create-item.png"));
		btnNewItemButton.setIcon(StandardButtonHelper
				.SetStandardSizeForImage(iconCreateItem));
		pane.add(
				StandardButtonHelper.SetStandardSizeForButton(btnNewItemButton),
				"cell 0 1");

		btnListItems = new JButton("List Items");
		btnListItems.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				itemController.list();
			}
		});
		
		iconListItems = new ImageIcon(ItemMgmtPane.class.
					getResource("/client/icons/list2.png"));
		btnListItems.setIcon(StandardButtonHelper.SetStandardSizeForImage(iconListItems));
		pane.add(StandardButtonHelper.SetStandardSizeForButton(btnListItems), "cell 1 1");
		

		btnCreateCategory = new JButton("<html>Create<br/> Category</html>");
		btnCreateCategory.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				categoryController.create();
			}
		});
		iconCreateCategory = new ImageIcon(
				ItemMgmtPane.class
						.getResource("/client/icons/create-category.png"));
		btnCreateCategory.setIcon(StandardButtonHelper
				.SetStandardSizeForImage(iconCreateCategory));
		pane.add(StandardButtonHelper
				.SetStandardSizeForButton(btnCreateCategory), "flowx, cell 2 1");

		btnListCategories = new JButton("<html>List<br/>Categories</html>");
		btnListCategories.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				categoryController.list();
			}
		});
		iconlistCategories=new ImageIcon(getClass().
					getResource("/client/icons/list3.png"));	
		btnListCategories.setIcon(StandardButtonHelper
				.SetStandardSizeForImage(iconlistCategories));
		pane.add(StandardButtonHelper
				.SetStandardSizeForButton(btnListCategories), "flowx,cell 0 2");

		btnCreateProduct = new JButton("<html>Create<br/> Product</html>");
		btnCreateProduct.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				productController.create();
			}
		});
		iconCreateProduct = new ImageIcon(
				ItemMgmtPane.class.getResource("/client/icons/create-product.png"));
		btnCreateProduct.setIcon(StandardButtonHelper
				.SetStandardSizeForImage(iconCreateProduct));
		pane.add(
				StandardButtonHelper.SetStandardSizeForButton(btnCreateProduct),
				"cell 1 2");

		btnListProducts = new JButton("List Products");
		btnListProducts.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				productController.list();
			}
		});
		iconListProduct = new ImageIcon(
				getClass().getResource("/client/icons/list.png"));
		btnListProducts.setIcon(StandardButtonHelper
				.SetStandardSizeForImage(iconListProduct));
		pane.add(
				StandardButtonHelper.SetStandardSizeForButton(btnListProducts),
				"cell 2 2");

		btnCreateManufacturer = new JButton(
				"<html>Create<br/> Manufacturer</html>");
		btnCreateManufacturer.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				manufacturerController.create();
			}
		});
		iconCreateManufacturer = new ImageIcon(
				ItemMgmtPane.class
						.getResource("/client/icons/Manufacturer.png"));
		btnCreateManufacturer.setIcon(StandardButtonHelper
				.SetStandardSizeForImage(iconCreateManufacturer));
		pane.add(StandardButtonHelper
				.SetStandardSizeForButton(btnCreateManufacturer), "cell 0 3");

		btnListManufacturers = new JButton(
				"<html>List<br/> Manufacturers</html>");
		btnListManufacturers.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				manufacturerController.list();
			}
		});
		iconListManufacturer = new ImageIcon(getClass().
					getResource("/client/icons/list.png"));
		btnListManufacturers.setIcon(StandardButtonHelper.SetStandardSizeForImage(iconListManufacturer));
		pane.add(StandardButtonHelper.SetStandardSizeForButton(btnListManufacturers), "cell 1 3");
		
		btnCreateBrand = new JButton("<html>Create<br/> Brand</html>");
		btnCreateBrand.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				brandController.create();
			}
		});
		iconCreateBrand = new ImageIcon(
				ItemMgmtPane.class.getResource("/client/icons/Brand.png"));
		btnCreateBrand.setIcon(StandardButtonHelper
				.SetStandardSizeForImage(iconCreateBrand));
		pane.add(StandardButtonHelper.SetStandardSizeForButton(btnCreateBrand),
				"cell 2 3");

		btnListBrand = new JButton("List Brands");
		btnListBrand.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				brandController.list();
			}
		});
		iconListBrand = new ImageIcon(
				getClass().getResource("/client/icons/list.png"));
		btnListBrand.setIcon(StandardButtonHelper
				.SetStandardSizeForImage(iconListBrand));
		pane.add(StandardButtonHelper.SetStandardSizeForButton(btnListBrand),
				"cell 0 4");

		return pane;
	}

}
