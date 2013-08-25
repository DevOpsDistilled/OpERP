package devopsdistilled.operp.client.employee.panes;

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
import devopsdistilled.operp.client.employee.controllers.EmployeeController;
import devopsdistilled.operp.client.employee.models.observers.EmployeeModelObserver;
import devopsdistilled.operp.client.employee.panes.models.observers.ListEmployeePaneModelObserver;
import devopsdistilled.operp.server.data.entity.employee.Employee;

public class ListEmployeePane extends SubTaskPane implements
		ListEmployeePaneModelObserver, EmployeeModelObserver {

	@Inject
	private EmployeeController employeeController;

	private final JPanel pane;
	private final JTable table;
	BeanTableModel<Employee> tableModel;

	public ListEmployeePane() {
		pane = new JPanel();
		pane.setLayout(new MigLayout("fill"));
		table = new JTable(tableModel);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (SwingUtilities.isLeftMouseButton(e)
						&& e.getClickCount() == 2
						&& table.getSelectedRow() != -1) {
					Employee employee = tableModel.getRow(table
							.getSelectedRow());

					employeeController.showDetails(employee);

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
	public void updateEmployees(List<Employee> employees) {
		tableModel = null;
		tableModel = new BeanTableModel<>(Employee.class, employees);

		for (int i = 0; i < table.getColumnCount(); i++) {
			tableModel.setColumnEditable(i, false);
		}
		tableModel.setModelEditable(false);
		table.setModel(tableModel);
	}

}
