package devopsdistilled.operp.client.main;

import java.awt.Component;
import java.util.EventListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import devopsdistilled.operp.client.abstracts.TaskPane;

public class NavigationTree {

	Map<String, DefaultMutableTreeNode> nodeMap;

	private final DefaultTreeModel treeModel;
	private JTree tree;

	private EventListener listener;


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

		tree = new JTree(treeModel);
		tree.setRootVisible(true);
		tree.setSelectionRow(0);
		tree.setCellRenderer(new DefaultTreeCellRenderer() {

			private static final long serialVersionUID = 6394043979244091638L;

			@Override
			public Component getTreeCellRendererComponent(JTree tree,
					Object value, boolean sel, boolean expanded, boolean leaf,
					int row, boolean hasFocus) {
				super.getTreeCellRendererComponent(tree, value, sel, expanded,
						leaf, row, hasFocus);
				DefaultMutableTreeNode node = (DefaultMutableTreeNode) value;
				TaskPane taskPane = (TaskPane) node.getUserObject();
				if (taskPane.getIcon() != null)
					setIcon(taskPane.getIcon());
				else
					setIcon(leafIcon);

				tree.revalidate();
				tree.repaint();
				return this;
			}
		});
	}
	public void setListener(EventListener listener) {
		this.listener = listener;
		tree.addTreeSelectionListener((TreeSelectionListener) this.listener);
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
}
