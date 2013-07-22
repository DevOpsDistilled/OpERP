package devopsdistilled.operp.client.items;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import devopsdistilled.operp.client.abstracts.SubTaskPane;

public class ListItemPane extends SubTaskPane implements ListItemModelObserver {

	private final ListItemPaneController controller;
	private final ListItemModel model;

	private JPanel pane;
	private JTable table;
	private ItemTableModel tableModel;

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
		tableModel = new ItemTableModel();
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
		tableModel.setItems(model.getItems());
	}

	
}
