package devopsdistilled.operp.client.items.views;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import net.miginfocom.swing.MigLayout;
import devopsdistilled.operp.client.abstracts.SubTaskPane;
import devopsdistilled.operp.client.items.ItemTableModel;
import devopsdistilled.operp.client.items.controllers.ListItemPaneController;
import devopsdistilled.operp.client.items.models.observers.ListItemPaneModelObserver;

public class ListItemPane extends SubTaskPane implements
		ListItemPaneModelObserver {

	private final ListItemPaneController controller;
	private final ListItemModel model;

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
	public void init() {

		controller.loadData();
	}

	@Override
	public void updateAll() {
		// TODO Auto-generated method stub

	}

	@Override
	public JComponent getPane() {
		return pane;
	}

	@Override
	public void updateItemList() {
		tableModel.setItems(model.getItems());
	}

}
