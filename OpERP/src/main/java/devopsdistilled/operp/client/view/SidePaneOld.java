package devopsdistilled.operp.client.view;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import net.miginfocom.swing.MigLayout;

public class SidePane {
	private static JPanel sidePane;

	private SidePane() {
		sidePane = new JPanel();
		sidePane.setLayout(new MigLayout("", "[]", "[]"));
		JScrollPane scrollPane = new JScrollPane(NavigationTree.getInstance(),
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		sidePane.add(scrollPane,"growy, flowy, hmin 98%, wmin 98%");
	}

	public static JPanel getInstance() {
		if (sidePane == null) {
			new SidePane();
		}

		return sidePane;
	}
}
