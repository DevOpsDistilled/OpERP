package devopsdistilled.operp.client.items;

import java.util.Vector;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import devopsdistilled.operp.client.abstracts.SubTaskPane;
import devopsdistilled.operp.server.data.entity.items.Item;

public class ListItemPane extends SubTaskPane implements ListItemModelObserver {

	private final ListItemPaneController controller;
	private final ListItemModel model;

	private JPanel pane;
	private JTable table;
	private DefaultTableModel tableModel;

	public ListItemPane(ListItemPaneController controller, ListItemModel model) {
		this.controller = controller;

		this.model = model;
		model.registerObserver(this);
	}

	/**
	 * @wbp.parser.entryPoint
	 */
	public void init() {
		pane = new JPanel();
		tableModel = new DefaultTableModel();
		table = new JTable(tableModel);
		pane.add(new JScrollPane(table));

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
		Vector<Item> items = new Vector<>(model.getItems());
		tableModel.setDataVector(items, model.getTableColumnNames());
	}

	@Override
	public void updateColumnNames() {
		tableModel.setColumnIdentifiers(model.getTableColumnNames());
	}
}
