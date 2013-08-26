package devopsdistilled.operp.client.employee;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.inject.Inject;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;
import devopsdistilled.operp.client.abstracts.TaskPane;
import devopsdistilled.operp.client.employee.controllers.EmployeeController;
import devopsdistilled.operp.client.main.utils.StandardButtonHelper;

import java.awt.Font;

public class EmployeeMgmtPane extends TaskPane {

	@Inject
	private EmployeeController employeeController;
	
	private JButton btnRegisterNewEmployee;
	private JButton btnListEmployees;
	
	private ImageIcon iconRegisterNewEmployee;
	private ImageIcon iconListEmployee;

	@Override
	public String toString() {
		return new String("Employees");
	}
	
	@Override
	public Icon getIcon() {
		return new ImageIcon(getClass().getResource(
				"/client/icons/employee_24.png"));	
	}
	/**
	 * @wbp.parser.entryPoint
	 */
	@Override
	public JComponent getPane() {
		JPanel pane = new JPanel();
		pane.setLayout(new MigLayout("", "[]50[][grow]", "[]20[]"));
		JLabel label = new JLabel("Employee Management");
		label.setFont(new Font("Dialog", Font.BOLD, 20));
		pane.add(label,"cell 0 0 3 1,alignx center,aligny top");
				
		btnRegisterNewEmployee = new JButton("<html>New Employee</html>");
		btnRegisterNewEmployee.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
				employeeController.create();
			}
		});
		iconRegisterNewEmployee=new ImageIcon(getClass().
					getResource("/client/icons/new-employee.png"));
		btnRegisterNewEmployee.setIcon(StandardButtonHelper.SetStandardSizeForImage(iconRegisterNewEmployee));
		pane.add(StandardButtonHelper.SetStandardSizeForButton(btnRegisterNewEmployee), "flowx,cell 0 1");
						
		btnListEmployees = new JButton("<html>List Employee</html>");
		btnListEmployees.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
				employeeController.list();
			}
		});
		iconListEmployee=new ImageIcon(getClass().
				getResource("/client/icons/list-employee.png"));
		btnListEmployees.setIcon(StandardButtonHelper.SetStandardSizeForImage(iconListEmployee));
		pane.add(StandardButtonHelper.SetStandardSizeForButton(btnListEmployees), "cell 1 1");
		
		return pane;
	}

	

}
