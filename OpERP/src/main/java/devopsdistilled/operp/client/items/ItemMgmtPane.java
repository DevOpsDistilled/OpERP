package devopsdistilled.operp.client.items;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;
import devopsdistilled.operp.client.abstracts.TaskPane;

public final class ItemMgmtPane extends TaskPane {

	private JComponent owner;

	@Override
	public String toString() {
		return new String("Items");
	}

	/**
	 * @wbp.parser.entryPoint
	 */
	@Override
	public JComponent getPane() {
		JPanel pane = new JPanel();
		pane.setLayout(new MigLayout("", "[]", "[][][]"));

		JLabel lblitemManagement = new JLabel("Item Management");
		pane.add(lblitemManagement, "cell 0 0");

		JButton btnNewItemButton = new JButton("New Item Button");
		btnNewItemButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ItemModel itemModel = new ItemModelImpl();
				ItemPaneController itemPaneController = new ItemPaneControllerImpl(
						itemModel);
				ItemPane itemPane = new ItemPane(itemModel, itemPaneController);
			}
		});
		pane.add(btnNewItemButton, "cell 0 1");

		return pane;
	}
}
