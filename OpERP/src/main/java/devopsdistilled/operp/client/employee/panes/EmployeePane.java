package devopsdistilled.operp.client.employee.panes;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.inject.Inject;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;
import devopsdistilled.operp.client.abstracts.EntityOperation;
import devopsdistilled.operp.client.abstracts.EntityPane;
import devopsdistilled.operp.client.employee.controllers.EmployeeController;
import devopsdistilled.operp.client.employee.panes.controllers.EmployeePaneController;
import devopsdistilled.operp.client.employee.panes.models.observers.EmployeePaneModelObserver;
import devopsdistilled.operp.server.data.entity.employee.Employee;

public class EmployeePane extends
		EntityPane<Employee, EmployeeController, EmployeePaneController>
		implements EmployeePaneModelObserver {

	@Inject
	private EmployeeController employeeController;

	private final JPanel pane;
	private final JTextField nameField;
	private final JLabel lblEmployeeId;
	private final JTextField employeeIdField;
	private JPanel contactInfoPanel;
	private JPanel opBtnPanel;
	private final JLabel lblDesignation;
	private final JTextField designationField;
	private final JLabel lblSalary;
	private final JTextField salaryField;
	private final JLabel lblJoinDate;
	private final JTextField dateField;

	public EmployeePane() {
		pane = new JPanel();
		pane.setLayout(new MigLayout("", "[][grow]", "[][][][][][][][]"));

		lblEmployeeId = new JLabel("Employee ID");
		pane.add(lblEmployeeId, "cell 0 0,alignx trailing");

		employeeIdField = new JTextField();
		employeeIdField.setEditable(false);
		pane.add(employeeIdField, "cell 1 0,growx");
		employeeIdField.setColumns(10);

		JLabel lblEmployeeName = new JLabel("Employee Name");
		pane.add(lblEmployeeName, "cell 0 1,alignx trailing");

		nameField = new JTextField();
		nameField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				getController().getModel().getEntity()
						.setEmployeeName(nameField.getText().trim());
			}
		});
		pane.add(nameField, "cell 1 1,growx");
		nameField.setColumns(10);

		lblDesignation = new JLabel("Designation");
		pane.add(lblDesignation, "cell 0 2,alignx trailing");

		designationField = new JTextField();
		designationField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
			}
		});
		pane.add(designationField, "cell 1 2,growx");
		designationField.setColumns(10);

		lblSalary = new JLabel("Salary");
		pane.add(lblSalary, "cell 0 3,alignx trailing");

		salaryField = new JTextField();
		salaryField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
			}
		});
		pane.add(salaryField, "cell 1 3,growx");
		salaryField.setColumns(10);

		lblJoinDate = new JLabel("Join Date");
		pane.add(lblJoinDate, "cell 0 4,alignx trailing");

		dateField = new JTextField();
		dateField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
			}
		});
		pane.add(dateField, "cell 1 4,growx");
		dateField.setColumns(10);

		contactInfoPanel = new JPanel();
		pane.add(contactInfoPanel, "cell 0 5 2 1,grow");

		opBtnPanel = new JPanel();
		pane.add(opBtnPanel, "cell 1 7,grow");

	}

	@Override
	public JComponent getPane() {
		return pane;
	}

	public void setContactInfopanel(JPanel contactInfoPanel) {
		MigLayout layout = (MigLayout) pane.getLayout();
		Object constraints = layout
				.getComponentConstraints(this.contactInfoPanel);

		pane.remove(this.contactInfoPanel);
		pane.add(contactInfoPanel, constraints);
		this.contactInfoPanel = contactInfoPanel;
		pane.validate();
	}

	@Override
	public void updateEntity(Employee employee, EntityOperation entityOperation) {
		if (EntityOperation.Create == entityOperation) {

			getController().getModel().setTitle("Create Employee");

			opBtnPanel = setBtnPanel(createOpPanel, opBtnPanel);

			lblEmployeeId.setVisible(false);
			employeeIdField.setVisible(false);

		} else if (EntityOperation.Edit == entityOperation) {
			getController().getModel().setTitle("Edit Employee");

			opBtnPanel = setBtnPanel(editOpPanel, opBtnPanel);

		} else if (EntityOperation.Details == entityOperation) {
			getController().getModel().setTitle("Employee Details");

			opBtnPanel = setBtnPanel(detailsOpPanel, opBtnPanel);

			employeeIdField.setText(employee.getEmployeeId().toString());
			nameField.setEditable(false);
			detailsOpPanel.setVisible(true);
		}

		nameField.setText(employee.getEmployeeName());
	}

	@Override
	public void resetComponents() {

		lblEmployeeId.setVisible(true);
		employeeIdField.setVisible(true);
		nameField.setEditable(true);
	}

	@Override
	public EmployeeController getEntityController() {
		return employeeController;
	}

}
