package devopsdistilled.operp.client.stock;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;
import devopsdistilled.operp.client.ClientApp;
import devopsdistilled.operp.client.abstracts.TaskPane;

import javax.swing.SwingConstants;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class StockMgmtPane extends TaskPane{

	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return new String("Stock Management");
	}
	/**
	 * @wbp.parser.entryPoint
	 */
	@Override
	public JComponent getPane() {
		JPanel pane=new JPanel();
		pane.setLayout(new MigLayout("", "[grow]", "[][][]"));
		
		JLabel lblStockManagement = new JLabel("Stock Management");
		lblStockManagement.setFont(new Font("Dialog", Font.BOLD, 16));
		pane.add(lblStockManagement, "cell 0 0,alignx center");
		
		JButton btnStock=new JButton("Stock");
		btnStock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			}
		});
		pane.add(btnStock,"flowx,cell 0 1");
		
		JButton btnaddwarehouse=new JButton("Add WareHouse");
		btnaddwarehouse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			}
		});
		pane.add(btnaddwarehouse,"cell 0 1,gapx 25");
		
		JButton btnStocklist = new JButton("StockList");
		pane.add(btnStocklist, "flowx,split 3,cell 0 2");
		
		JButton btnWarehouseList = new JButton("WareHouse LIst");
		pane.add(btnWarehouseList, "cell 0 2");
		
		
		return pane;
	}

}
