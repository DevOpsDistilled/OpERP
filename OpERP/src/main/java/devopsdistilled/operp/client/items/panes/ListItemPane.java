package devopsdistilled.operp.client.items.panes;

import java.util.List;

import javax.inject.Inject;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import net.miginfocom.swing.MigLayout;
import devopsdistilled.operp.client.abstracts.SubTaskPane;
import devopsdistilled.operp.client.items.models.impl.ItemTableModel;
import devopsdistilled.operp.client.items.models.observers.ItemModelObserver;
import devopsdistilled.operp.client.items.models.observers.ListItemPaneModelObserver;
import devopsdistilled.operp.client.items.panes.controllers.ListItemPaneController;
import devopsdistilled.operp.server.data.entity.items.Item;

public class ListItemPane extends SubTaskPane implements
		ListItemPaneModelObserver, ItemModelObserver {

	@SuppressWarnings("unused")
	@Inject
	private ListItemPaneController controller;

	private final JPanel pane;
	private final JTable table;
	private final ItemTableModel tableModel;

	public ListItemPane() {
		pane = new JPanel(new MigLayout("debug, fill"));

		tableModel = new ItemTableModel();
		table = new JTable(tableModel);

		final JScrollPane scrollPane = new JScrollPane(table,
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		pane.add(scrollPane, "grow");
	}

	@Override
	public JComponent getPane() {
		return pane;
	}

	@Override
	public void updateItems(List<Item> items) {
		tableModel.setItems(items);
	}

}
