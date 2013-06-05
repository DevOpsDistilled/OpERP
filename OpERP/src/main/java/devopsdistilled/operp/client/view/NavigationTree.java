package devopsdistilled.operp.client.view;

import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

public class NavigationTree {

	Map<String, DefaultMutableTreeNode> nodeMap;

	private DefaultTreeModel treeModel;
	private JTree tree;

	public JTree getTree() {
		return tree;
	}

	public void setTree(JTree tree) {
		this.tree = tree;
	}

	public NavigationTree() {

		nodeMap = new HashMap<>();

		TaskPane rootNodePane = new DefaultTaskPane();
		String rootNodeDesc = new String(rootNodePane.toString());
		DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode(
				rootNodePane);
		treeModel = new DefaultTreeModel(rootNode);

		nodeMap.put(rootNodeDesc, rootNode);

		// rootNode.add(new DefaultMutableTreeNode(new DefaultTaskPane()));

		tree = new JTree(treeModel);
		tree.setRootVisible(true);

		/*
		 * DefaultMutableTreeNode rootNode = new
		 * DefaultMutableTreeNode("OpERP"); DefaultMutableTreeNode module;
		 * 
		 * module = new DefaultMutableTreeNode(new InventoryPane());
		 * module.add(new DefaultMutableTreeNode(new SalesPane()));
		 * rootNode.add(module);
		 * 
		 * module = new DefaultMutableTreeNode(new SalesPane());
		 * rootNode.add(module);
		 * 
		 * module = new DefaultMutableTreeNode(new PurchasesPane());
		 * rootNode.add(module);
		 */

	}

	public void addNode(TaskPane taskPane) {
		addNode(taskPane, new DefaultTaskPane().toString());
	}

	public void addNode(TaskPane taskPane, int index) {
		addNode(taskPane, new DefaultTaskPane().toString(), index);
	}

	public void addNode(TaskPane taskPane, String parentTaskPaneToString) {
		addNode(taskPane, parentTaskPaneToString, -1);
	}

	public void addNode(TaskPane taskPane, String parentTaskPaneToString,
			int index) {
		if (nodeMap.containsKey(parentTaskPaneToString)) {
			DefaultMutableTreeNode parentNode = nodeMap
					.get(parentTaskPaneToString);
			DefaultMutableTreeNode node = new DefaultMutableTreeNode(taskPane);

			if (index == -1)
				parentNode.add(node);
			else
				parentNode.insert(node, index);

			nodeMap.put(taskPane.toString(), node);
		} else
			throw new IllegalArgumentException("Illegal arguements in addNode");
	}

	public static void main(String[] args) {
		NavigationTree nav = new NavigationTree();
		JFrame frame = new JFrame();
		frame.getContentPane().add(nav.getTree());

		nav.addNode(new TestTaskPane("First one"),
				new DefaultTaskPane().toString(), 0);

		nav.addNode(new TestTaskPane("Zero"),
				new TestTaskPane("First one").toString(), 0);

		nav.addNode(new TestTaskPane("One"),
				new TestTaskPane("First one").toString(), 1);
		nav.addNode(new TestTaskPane("Two"), 1);
		nav.addNode(new TestTaskPane("Three"));

		nav.treeModel.reload();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(20, 20, 200, 200);
	}
}
