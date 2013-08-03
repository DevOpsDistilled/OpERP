package devopsdistilled.operp.client.items.panes;

import javax.inject.Inject;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;
import devopsdistilled.operp.client.abstracts.SubTaskPane;
import devopsdistilled.operp.client.items.panes.controllers.CreateProductPaneController;
import devopsdistilled.operp.client.items.panes.models.observers.CreateProductPaneModelObserver;

public class CreateProductPane extends SubTaskPane implements
		CreateProductPaneModelObserver {

	@Inject
	private CreateProductPaneController controller;

	private final JPanel pane;
	private final JTextField productNameField;

	public CreateProductPane() {
		pane = new JPanel();
		pane.setLayout(new MigLayout("", "[][grow]", "[][grow][]"));

		JLabel lblProductName = new JLabel("Product Name");
		pane.add(lblProductName, "cell 0 0,alignx trailing");

		productNameField = new JTextField();
		pane.add(productNameField, "cell 1 0,growx");
		productNameField.setColumns(10);

		JLabel lblCategory = new JLabel("Category");
		pane.add(lblCategory, "cell 0 1");

		JPanel categoryPanel = new JPanel();
		categoryPanel.setLayout(new MigLayout("", "[92px]", "[23px]"));
		categoryPanel.add(new JCheckBox("Check Me"), "cell 0 0,alignx left,aligny top");

		JScrollPane scrollPane = new JScrollPane(categoryPanel);
		pane.add(scrollPane, "cell 1 1,grow");

		JButton btnCancel = new JButton("Cancel");
		pane.add(btnCancel, "flowx,cell 1 2");

		JButton btnCreate = new JButton("Create");
		pane.add(btnCreate, "cell 1 2");
	}

	@Override
	public JComponent getPane() {
		return pane;
	}

}
