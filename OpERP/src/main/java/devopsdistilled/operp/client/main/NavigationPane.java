package devopsdistilled.operp.client.main;

import javax.swing.JComponent;
import javax.swing.JScrollPane;

import devopsdistilled.operp.client.abstracts.ViewPane;

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
