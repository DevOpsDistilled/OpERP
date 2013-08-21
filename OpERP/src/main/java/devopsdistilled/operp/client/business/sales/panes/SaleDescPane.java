package devopsdistilled.operp.client.business.sales.panes;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;
import devopsdistilled.operp.client.abstracts.EntityOperation;
import devopsdistilled.operp.client.abstracts.EntityPane;
import devopsdistilled.operp.client.business.sales.controllers.SaleDescController;
import devopsdistilled.operp.client.business.sales.panes.controllers.SaleDescPaneController;
import devopsdistilled.operp.client.business.sales.panes.models.observers.SaleDescPaneModelObserver;
import devopsdistilled.operp.server.data.entity.business.SaleDesc;

public class SaleDescPane extends
		EntityPane<SaleDesc, SaleDescController, SaleDescPaneController>
		implements SaleDescPaneModelObserver {

	private final JPanel pane;
	private final JTextField discountField;
	private final JTextField amountField;

	public SaleDescPane() {
		pane = new JPanel();
		pane.setLayout(new MigLayout("", "[][grow]", "[][][]"));
		
		JPanel rowDescPanel = new JPanel();
		pane.add(rowDescPanel, "cell 0 0,grow");
		rowDescPanel.setLayout(new MigLayout("", "[]", "[]"));
		
		JScrollPane scrollPane = new JScrollPane();
		pane.add(scrollPane, "cell 1 0,grow");
		
		JLabel lblDiscount = new JLabel("Discount");
		pane.add(lblDiscount, "flowx,cell 1 1,alignx right");
		
		JLabel lblAmount = new JLabel("Amount");
		pane.add(lblAmount, "flowx,cell 1 2,alignx right");
		
		discountField = new JTextField();
		pane.add(discountField, "cell 1 1,alignx right");
		discountField.setColumns(10);
		
		amountField = new JTextField();
		amountField.setEditable(false);
		pane.add(amountField, "cell 1 2,alignx right");
		amountField.setColumns(10);
	}

	@Override
	public void resetComponents() {
		// TODO Auto-generated method stub

	}

	@Override
	public SaleDescController getEntityController() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JComponent getPane() {
		return pane;
	}

	@Override
	public void updateEntity(SaleDesc entity, EntityOperation entityOperation) {
		// TODO Auto-generated method stub

	}

}
