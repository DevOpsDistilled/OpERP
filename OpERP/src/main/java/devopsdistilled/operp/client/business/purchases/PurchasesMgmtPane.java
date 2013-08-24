package devopsdistilled.operp.client.business.purchases;

import java.awt.Font;
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
import devopsdistilled.operp.client.business.sales.controllers.SaleController;

public class PurchasesMgmtPane extends TaskPane {

	@Inject
	private SaleController saleController;

	@Override
	public String toString() {
		return new String("Sales Management");
	}

	/**
	 * @wbp.parser.entryPoint
	 */
	@Override
	public JComponent getPane() {
		JPanel pane = new JPanel();
		pane.setLayout(new MigLayout("", "[136px,grow]", "[15px][][]"));
		pane.add(new JLabel("Sales Management"),
				"cell 0 0 2097051 1,alignx center,aligny top");

		JButton btnNewSale = new JButton("New Sale");
		btnNewSale.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				saleController.create();
			}
		});
		btnNewSale.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		pane.add(btnNewSale, "cell 0 2");
		return pane;
	}

	@Override
	public Icon getIcon() {
		return new ImageIcon(getClass().getResource("/client/icons/sale_24.png"));
	}

}
