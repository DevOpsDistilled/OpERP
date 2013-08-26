package devopsdistilled.operp.client.main;

import javax.inject.Inject;
import javax.swing.JComponent;
import javax.swing.JScrollPane;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;

import devopsdistilled.operp.client.abstracts.TaskPane;
import devopsdistilled.operp.client.abstracts.ViewPane;

public class NavigationPane extends ViewPane implements TreeSelectionListener {

	@Inject
	private NavigationTree navigationTree;

	@Inject
	private MainWindow mainWindow;

	@Override
	public JComponent getPane() {
		navigationTree.getTree().expandRow(0);
		navigationTree.setListener(this);
		return new JScrollPane(navigationTree.getTree());
	}

	@Override
	public void valueChanged(TreeSelectionEvent event) {

		DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) event
				.getPath().getLastPathComponent();

		DefaultMutableTreeNode prevNode = (DefaultMutableTreeNode) event
				.getOldLeadSelectionPath().getLastPathComponent();

		TaskPane newTaskPane = (TaskPane) selectedNode.getUserObject();

		TaskPane oldTaskPane = (TaskPane) prevNode.getUserObject();
		mainWindow.getController().changeTaskPane(newTaskPane, oldTaskPane);
		
	}

}
