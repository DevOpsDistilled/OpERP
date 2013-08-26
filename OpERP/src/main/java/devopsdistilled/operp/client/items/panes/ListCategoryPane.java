package devopsdistilled.operp.client.items.panes;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.inject.Inject;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;

import net.miginfocom.swing.MigLayout;
import devopsdistilled.operp.client.abstracts.SubTaskPane;
import devopsdistilled.operp.client.abstracts.libs.BeanTableModel;
import devopsdistilled.operp.client.items.models.observers.CategoryModelObserver;
import devopsdistilled.operp.client.items.panes.details.CategoryDetailsPane;
import devopsdistilled.operp.client.items.panes.models.observers.ListCategoryPaneModelObserver;
import devopsdistilled.operp.server.data.entity.items.Category;

public class ListCategoryPane extends SubTaskPane implements
		ListCategoryPaneModelObserver, CategoryModelObserver {

	@Inject
	private CategoryDetailsPane categoryDetailsPane;

	private final JPanel pane;

	private final JTable table;
	BeanTableModel<Category> tableModel;

	public ListCategoryPane() {
		pane = new JPanel(new MigLayout("fill"));

		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (SwingUtilities.isLeftMouseButton(e)
						&& e.getClickCount() == 2
						&& table.getSelectedRow() != -1) {

					Category category = tableModel.getRow(table
							.getSelectedRow());

					categoryDetailsPane.show(category, getPane());
				}
			}
		});

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
		tableModel = null;
		tableModel = new BeanTableModel<>(Category.class, categories);

		for (int i = 0; i < tableModel.getColumnCount(); i++) {
			tableModel.setColumnEditable(i, false);
		}

		tableModel.setModelEditable(false);
		table.setModel(tableModel);

	}
}
