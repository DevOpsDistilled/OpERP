package devopsdistilled.operp.client.account;

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
import devopsdistilled.operp.client.account.controllers.PaidTransactionController;
import devopsdistilled.operp.client.account.controllers.ReceivedTransactionController;
import devopsdistilled.operp.client.main.utils.StandardButtonHelper;
import java.awt.Font;

public class AccountMgmtPane extends TaskPane {

	@Inject
	private ReceivedTransactionController receivedTransactionController;

	@Inject
	private PaidTransactionController paidTransactionController;

	private JButton btnReceivePayment;
	private JButton btnPayPayment;

	private ImageIcon iconReceivePayment;
	private ImageIcon iconPayPayment;

	@Override
	public String toString() {
		return new String("Account");
	}
	
	@Override
	public Icon getIcon() {
		return new ImageIcon(getClass().getResource(
				"/client/icons/stock_24.png"));	
	}
	
	/**
	 * @wbp.parser.entryPoint
	 */
	@Override
	public JComponent getPane() {
		JPanel pane = new JPanel();
		pane.setLayout(new MigLayout("", "[]50[][grow]", "[]20[]"));
		JLabel label = new JLabel("Account Management");
		label.setFont(new Font("Dialog", Font.BOLD, 20));
		pane.add(label,
				"cell 0 0 3 1,alignx center,aligny top");

		btnReceivePayment = new JButton("<html>Receive<br/> Payment</html>");
		btnReceivePayment.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				receivedTransactionController.create();
			}
		});
		iconReceivePayment=new ImageIcon(getClass().
					getResource("/client/icons/receive-payment.png"));
		btnReceivePayment.setIcon(StandardButtonHelper.SetStandardSizeForImage(iconReceivePayment));
		pane.add(StandardButtonHelper.SetStandardSizeForButton(btnReceivePayment), "cell 0 1 ");
		

		btnPayPayment = new JButton("<html>Pay<br/> Payment</html>");
		btnPayPayment.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			paidTransactionController.create();
			}
		});
		iconPayPayment=new ImageIcon(getClass().
				getResource("/client/icons/pay-payment.png"));
		btnPayPayment.setIcon(StandardButtonHelper.SetStandardSizeForImage(iconPayPayment));
		pane.add(StandardButtonHelper.SetStandardSizeForButton(btnPayPayment), "cell 1 1 ");
		return pane;
	}


}
