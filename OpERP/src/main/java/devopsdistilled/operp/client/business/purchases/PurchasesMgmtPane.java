package devopsdistilled.operp.client.business.purchases;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.inject.Inject;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;
import devopsdistilled.operp.client.abstracts.TaskPane;
import devopsdistilled.operp.client.business.purchases.controllers.PurchaseController;

public class PurchasesMgmtPane extends TaskPane {

	@Inject
	private PurchaseController purchaseController;

	@Override
	public String toString() {
		return new String("Purchases");
	}

	/**
	 * @wbp.parser.entryPoint
	 */
	@Override
	public JComponent getPane() {
		JPanel pane = new JPanel();
		pane.setLayout(new MigLayout("", "[136px,grow]", "[15px][][]"));
		pane.add(new JLabel("Purchases Management"),
				"cell 0 0 2097051 1,alignx center,aligny top");

		JButton btnNewPurchase = new JButton("New Purchase");
		btnNewPurchase.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				purchaseController.create();
			}
		});
		btnNewPurchase.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		pane.add(btnNewPurchase, "cell 0 2");
		return pane;
	}

}
