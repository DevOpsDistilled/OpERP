package devopsdistilled.operp.client.employee;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;
import devopsdistilled.operp.client.abstracts.TaskPane;

public class EmployeeMgmtPane extends TaskPane {

	@Override
	public String toString() {
		return new String("Employees");
	}

	/**
	 * @wbp.parser.entryPoint
	 */
	@Override
	public JComponent getPane() {
		JPanel pane = new JPanel();
		pane.setLayout(new MigLayout("", "[136px,grow]", "[15px][][]"));
		pane.add(new JLabel("Employee Management"),
				"cell 0 0,alignx center,aligny top");

		JButton btnRegisterNewEmployee = new JButton("Register New Employee");
		btnRegisterNewEmployee.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});
		pane.add(btnRegisterNewEmployee, "cell 0 2");
		return pane;
	}

}
