package devopsdistilled.operp.client.main;

import javax.inject.Inject;
import javax.swing.JComponent;
import javax.swing.JScrollPane;

import devopsdistilled.operp.client.abstracts.ViewPane;

public class NavigationPane extends ViewPane {

	@Inject
	private NavigationTree navigationTree;

	@Override
	public JComponent getPane() {
		System.out.println(navigationTree);
		return new JScrollPane(navigationTree.getTree());
	}

}
