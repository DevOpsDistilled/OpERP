package devopsdistilled.operp.client.view;

import java.awt.Label;

import javax.swing.JPanel;

public class StatusPane {
	private static JPanel statusPane;

	private StatusPane() {
		statusPane = new JPanel();
		statusPane.add(new Label("Status: OK"));

	}

	public static JPanel getInstance() {
		if (statusPane == null) {
			new StatusPane();
		}
		return statusPane;
	}
}
