package devopsdistilled.operp.client.stock.panes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;
import devopsdistilled.operp.client.abstracts.SubTaskPane;
import devopsdistilled.operp.client.stock.panes.models.observers.TransferStockPaneModelObserver;

public class TransferStockPane extends SubTaskPane implements
		TransferStockPaneModelObserver {

	private final JPanel pane;
	private final JTextField quantityField;
	private final JComboBox toWarehouseCombo;

	public TransferStockPane() {
		pane = new JPanel();
		pane.setLayout(new MigLayout("", "[][grow]", "[][][][][]"));

		JLabel lblFromWarehouse = new JLabel("From Warehouse");
		pane.add(lblFromWarehouse, "cell 0 0,alignx trailing");

		JComboBox fromWarehouseCombo = new JComboBox();
		pane.add(fromWarehouseCombo, "cell 1 0,growx");

		JLabel lblToWarehouse = new JLabel("To Warehouse");
		pane.add(lblToWarehouse, "cell 0 1,alignx trailing");

		toWarehouseCombo = new JComboBox();
		pane.add(toWarehouseCombo, "flowx,cell 1 1,growx");

		JLabel lblQuantity = new JLabel("Quantity");
		pane.add(lblQuantity, "cell 0 2,alignx trailing");

		JButton btnNewWarehouse = new JButton("New Warehouse");
		pane.add(btnNewWarehouse, "cell 1 1");

		quantityField = new JTextField();
		pane.add(quantityField, "cell 1 2,growx");
		quantityField.setColumns(10);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				getDialog().dispose();
			}
		});
		pane.add(btnCancel, "flowx,cell 1 4");

		JButton btnTransfer = new JButton("Transfer");
		btnTransfer.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});
		pane.add(btnTransfer, "cell 1 4");
	}

	@Override
	public JComponent getPane() {
		return pane;
	}

}
