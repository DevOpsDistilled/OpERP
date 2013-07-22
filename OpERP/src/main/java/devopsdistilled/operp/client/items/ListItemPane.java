package devopsdistilled.operp.client.items;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import devopsdistilled.operp.client.abstracts.SubTaskPane;

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
		Object[][] data = { { 1.0, 0.0, 0.0 }, { 0.0, 1.0, 0.0 },
				{ 0.0, 0.0, 1.0 } };

		Object[] columnNames = { "First", "Second", "Third" };
		tableModel = new DefaultTableModel(data, columnNames);
		table = new JTable(tableModel);

		table.setShowHorizontalLines(true);
		pane.add(new JScrollPane(table));
		pane.add(new JLabel("Label in Pane"));

		// controller.loadData();
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
		// TODO Auto-generated method stub

	}

	@Override
	public void updateColumnNames() {
		tableModel.setColumnIdentifiers(model.getTableColumnNames());
	}
}
