package devopsdistilled.operp.client.main;

import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;


public class NavigationTreeListener implements TreeSelectionListener {

	private final JTree tree;

	public NavigationTreeListener(final JTree tree) {
		this.tree = tree;
	}

	@Override
	public void valueChanged(TreeSelectionEvent e) {
		DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) tree
				.getLastSelectedPathComponent();

		if (selectedNode == null)
			// Nothing is selected.
			return;

		TaskPaneOld taskPane = (TaskPaneOld) selectedNode.getUserObject();
		taskPane.makeCurrentWorkingTaskPane();
	}

}
