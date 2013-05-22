package devopsdistilled.operp.client.view;

import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;

import devopsdistilled.operp.client.view.taskpane.iface.TaskPane;

public class NavigationTreeController implements TreeSelectionListener {

	private final JTree tree;

	public NavigationTreeController(final JTree tree) {
		this.tree = tree;
	}

	@Override
	public void valueChanged(TreeSelectionEvent e) {
		DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) tree
				.getLastSelectedPathComponent();

		if (selectedNode == null)
			// Nothing is selected.
			return;

		TaskPane taskPane = (TaskPane) selectedNode.getUserObject();
		taskPane.makeCurrentWorkingTaskPane();
	}

}
