package devopsdistilled.operp.client.business.sales;

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
import devopsdistilled.operp.client.main.utils.StandardButtonHelper;

public class SalesMgmtPane extends TaskPane {

	@Inject
	private SaleController saleController;
	private JButton btnNewSale;
	private JButton btnListSales;
	
	private ImageIcon iconNewSale;
	private ImageIcon iconListSales;

	@Override
	public String toString() {
		return new String("Sales");
	}

	@Override
	public Icon getIcon() {
		return new ImageIcon(getClass()
				.getResource("/client/icons/sale_24.png"));
	}

	/**
	 * @wbp.parser.entryPoint
	 */
	@Override
	public JComponent getPane() {
		JPanel pane = new JPanel();
		pane.setLayout(new MigLayout("", "[]50[]", "[]15[][]"));
		JLabel label = new JLabel("Sales Management");
		pane.add(label, "cell 0 0 2097051 1,alignx center,aligny top");

		label.setFont(new Font("Dialog", Font.BOLD, 20));
		pane.add(label, "cell 0 0 3 1,alignx center,aligny top");

		btnNewSale = new JButton("New Sale");
		btnNewSale.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				saleController.create();
			}
		});
		iconNewSale=new ImageIcon(getClass().
					getResource("/client/icons/new-sale.png"));
		btnNewSale.setIcon(StandardButtonHelper.SetStandardSizeForImage(iconNewSale));
		pane.add(StandardButtonHelper.SetStandardSizeForButton(btnNewSale), "cell 0 1");
		

		btnListSales = new JButton("List Sales");
		btnListSales.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				saleController.list();
			}
		});
		iconListSales=new ImageIcon(getClass().
					getResource("/client/icons/list.png"));
		btnListSales.setIcon(StandardButtonHelper.SetStandardSizeForImage(iconListSales));
		pane.add(StandardButtonHelper.SetStandardSizeForButton(btnListSales), "cell 1 1 ");
		return pane;
	}

}
