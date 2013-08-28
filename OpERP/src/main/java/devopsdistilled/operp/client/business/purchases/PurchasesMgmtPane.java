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
import devopsdistilled.operp.client.business.purchases.controllers.PurchaseController;
import devopsdistilled.operp.client.main.utils.StandardButtonHelper;

public class PurchasesMgmtPane extends TaskPane {

	@Inject
	private PurchaseController purchaseController;

	private JButton btnNewPurchase;
	private ImageIcon iconNewPurchase;

	private JButton btnListPurchases;

	private ImageIcon iconListPurchases;

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
		pane.setLayout(new MigLayout("", "[]50[]", "[]20[][]"));
		JLabel label = new JLabel("Purchases Management");
		label.setFont(new Font("Dialog", Font.BOLD, 20));
		pane.add(label, "cell 0 0 500 1,alignx center,aligny top");

		btnNewPurchase = new JButton("<html>New Purchase</html>");
		btnNewPurchase.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				purchaseController.create();
			}
		});
		iconNewPurchase = new ImageIcon(getClass().getResource(
				"/client/icons/new-purchase.jpg"));
		btnNewPurchase.setIcon(StandardButtonHelper
				.SetStandardSizeForImage(iconNewPurchase));
		pane.add(StandardButtonHelper.SetStandardSizeForButton(btnNewPurchase),
				"cell 0 1");

		btnListPurchases = new JButton("<html>List Purchases</html>");
		btnListPurchases.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				purchaseController.list();
			}
		});
		iconListPurchases=new ImageIcon(
					getClass().getResource("/client/icons/list.png"));
		btnListPurchases.setIcon(StandardButtonHelper.SetStandardSizeForImage(iconListPurchases));
		pane.add(StandardButtonHelper.SetStandardSizeForButton(btnListPurchases), "cell 1 1");
		return pane;
	}

	@Override
	public Icon getIcon() {
		return new ImageIcon(getClass()
				.getResource("/client/icons/purchase_24.png"));
	}

}
