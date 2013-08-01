package devopsdistilled.operp.client.items;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.inject.Inject;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import devopsdistilled.operp.client.abstracts.TaskPane;
import devopsdistilled.operp.client.items.controllers.CategoryController;
import devopsdistilled.operp.client.items.controllers.ItemController;

public final class ItemMgmtPane extends TaskPane {

	@Inject
	private ItemController itemController;

	@Inject
	private CategoryController categoryController;

	@Override
	public String toString() {
		return new String("Items");
	}

	/**
	 * @wbp.parser.entryPoint
	 */
	@Override
	public JComponent getPane() {
		JPanel pane = new JPanel();
		pane.setLayout(new MigLayout("", "[]", "[][][][]"));

		JLabel lblitemManagement = new JLabel("Item Management");
		pane.add(lblitemManagement, "cell 0 0");

		JButton btnNewItemButton = new JButton("New Item Button");
		btnNewItemButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				itemController.createItem();
			}
		});
		pane.add(btnNewItemButton, "cell 0 1");

		JButton btnListItems = new JButton("List Items");
		btnListItems.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				itemController.listItems();
			}
		});
		pane.add(btnListItems, "cell 0 2");

		JButton btnCreateCategory = new JButton("Create Category");
		btnCreateCategory.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				categoryController.create();
			}
		});
		pane.add(btnCreateCategory, "cell 0 3");

		return pane;
	}
}
