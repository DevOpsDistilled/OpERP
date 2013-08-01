package devopsdistilled.operp.client.items.panes;

import java.util.List;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import net.miginfocom.swing.MigLayout;
import devopsdistilled.operp.client.abstracts.SubTaskPane;
import devopsdistilled.operp.client.abstracts.libs.BeanTableModel;
import devopsdistilled.operp.client.items.models.observers.CategoryModelObserver;
import devopsdistilled.operp.client.items.panes.models.observers.ListCategoryPaneModelObserver;
import devopsdistilled.operp.server.data.entity.items.Category;

public class ListCategoryPane extends SubTaskPane implements
		ListCategoryPaneModelObserver, CategoryModelObserver {

	private final JPanel pane;

	private final JTable table;
	BeanTableModel<Category> tableModel;

	public ListCategoryPane() {
		pane = new JPanel(new MigLayout("debug, fill"));

		tableModel = new BeanTableModel<>(Category.class);
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
	public void updateCategories(List<Category> categories) {
		if (tableModel.getRowCount() != 0) {
			int lastRow = tableModel.getRowCount() - 1;
			tableModel.removeRowRange(0, lastRow);
		}

		tableModel.insertRows(0, categories);
	}
}
