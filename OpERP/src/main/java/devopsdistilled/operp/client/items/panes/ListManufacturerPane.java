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
import devopsdistilled.operp.client.items.models.observers.ManufacturerModelObserver;
import devopsdistilled.operp.client.items.panes.details.ManufacturerDetailsPane;
import devopsdistilled.operp.client.items.panes.models.observers.ListManufacturerPaneModelObserver;
import devopsdistilled.operp.server.data.entity.items.Manufacturer;

public class ListManufacturerPane extends SubTaskPane implements
		ListManufacturerPaneModelObserver, ManufacturerModelObserver {

	@Inject
	private ManufacturerDetailsPane manufacturerDetailsPane;

	private final JPanel pane;

	private final JTable table;
	BeanTableModel<Manufacturer> tableModel;
	
	public ListManufacturerPane() {
		pane = new JPanel(new MigLayout("fill"));

		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (SwingUtilities.isLeftMouseButton(e)
						&& e.getClickCount() == 2
						&& table.getSelectedRow() != -1) {

					Manufacturer manufacturer = tableModel.getRow(table
							.getSelectedRow());

					manufacturerDetailsPane.show(manufacturer, getPane());
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
	public void updateManufacturers(List<Manufacturer> manufacturers) {
		tableModel = null;
		tableModel = new BeanTableModel<>(Manufacturer.class, manufacturers);

		for (int i = 0; i < tableModel.getColumnCount(); i++) {
			tableModel.setColumnEditable(i, false);
		}

		tableModel.setModelEditable(false);
		table.setModel(tableModel);
	}

}
