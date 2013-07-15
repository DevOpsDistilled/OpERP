package devopsdistilled.operp.client.main;

import javax.inject.Inject;
import javax.swing.JComponent;
import javax.swing.JScrollPane;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;

import devopsdistilled.operp.client.abstracts.ViewPane;

public class NavigationPane extends ViewPane implements TreeSelectionListener {

	@Inject
	private NavigationTree navigationTree;

	@Inject
	private MainWindow mainWindow;

	@Override
	public JComponent getPane() {
		navigationTree.setListener(this);
		return new JScrollPane(navigationTree.getTree());
	}

	@Override
	public void valueChanged(TreeSelectionEvent e) {
		System.out.println("Value Changed");
	}

}
