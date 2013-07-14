package devopsdistilled.operp.client.main;

import javax.swing.JComponent;
import javax.swing.JScrollPane;

public class NavigationPane extends ViewPane {

	private final NavigationTree navigationTree;

	public NavigationPane() {
		navigationTree = new NavigationTree();
	}

	@Override
	public JComponent getPane() {
		return new JScrollPane(navigationTree.getTree());
	}

}
