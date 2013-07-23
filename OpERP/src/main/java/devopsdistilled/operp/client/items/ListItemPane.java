package devopsdistilled.operp.client.items;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import net.miginfocom.swing.MigLayout;
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
	@Override
	public void init() {
		pane = new JPanel(new MigLayout("debug, fill"));

		tableModel = new ItemTableModel();
		table = new JTable(tableModel);

		final JScrollPane scrollPane = new JScrollPane(table,
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		pane.add(scrollPane, "grow");

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
