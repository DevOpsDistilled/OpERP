package devopsdistilled.operp.client.view;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

import devopsdistilled.operp.client.inventory.view.InventoryPane;

public class NavigationTree {
	private static JTree tree;

	private NavigationTree() {
		DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode("OpERP");
		DefaultMutableTreeNode module;

		module = new DefaultMutableTreeNode(new InventoryPane());
		module.add(new DefaultMutableTreeNode(new SalesPane()));
		rootNode.add(module);

		module = new DefaultMutableTreeNode(new SalesPane());
		rootNode.add(module);

		module = new DefaultMutableTreeNode(new PurchasesPane());
		rootNode.add(module);

		tree = new JTree(rootNode);
		tree.addTreeSelectionListener(new NavigationTreeController(tree));
		tree.setRootVisible(false);

	}

	public static JTree getInstance() {
		if (tree == null)
			new NavigationTree();

		return tree;
	}
}
