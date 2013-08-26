package devopsdistilled.operp.client.items.panes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.inject.Inject;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;
import devopsdistilled.operp.client.abstracts.SubTaskPane;
import devopsdistilled.operp.client.exceptions.EntityValidationException;
import devopsdistilled.operp.client.items.panes.controllers.CreateCategoryPaneController;
import devopsdistilled.operp.client.items.panes.details.CategoryDetailsPane;
import devopsdistilled.operp.client.items.panes.models.observers.CreateCategoryPaneModelObserver;
import devopsdistilled.operp.server.data.entity.items.Category;

public class CreateCategoryPane extends SubTaskPane implements
		CreateCategoryPaneModelObserver {

	@Inject
	private CreateCategoryPaneController controller;

	@Inject
	private CategoryDetailsPane categoryDetailsPane;

	private final JPanel pane;
	private final JTextField categoryNameField;
	

	public CreateCategoryPane() {
		pane = new JPanel();
		pane.setLayout(new MigLayout("", "[][grow]", "[][]"));

		JLabel lblCategoryName = new JLabel("Category Name");
		pane.add(lblCategoryName, "cell 0 0,alignx trailing");

		categoryNameField = new JTextField();
		pane.add(categoryNameField, "cell 1 0,growx");
		categoryNameField.setColumns(10);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				getDialog().dispose();
			}
		});
		pane.add(btnCancel, "flowx,cell 1 1");

		JButton btnCreate = new JButton("Create");
		btnCreate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Category category = new Category();
				category.setCategoryName(categoryNameField.getText().trim());
				try {
					controller.validate(category);
					category = controller.save(category);
					getDialog().dispose();

					categoryDetailsPane.show(category, getPane());

				} catch (EntityValidationException e1) {
					JOptionPane.showMessageDialog(getPane(), e1.getMessage());
				}
			}
		});
		pane.add(btnCreate, "cell 1 1");
	}

	@Override
	public JComponent getPane() {
		return pane;
	}

}
