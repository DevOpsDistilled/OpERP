package devopsdistilled.operp.client.stock;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;
import devopsdistilled.operp.client.abstracts.TaskPane;

import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		pane.setLayout(new MigLayout("", "[grow]", "[]"));
		
		JLabel lblStockManagement = new JLabel("Stock Management");
		pane.add(lblStockManagement, "cell 0 0,alignx center,wrap");
		
		JButton testButton=new JButton("Stock");
		testButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		pane.add(testButton,"split 2");
		
		JButton testBt2=new JButton("stock 2");
		pane.add(testBt2,"gapx 25");
		
		
		return pane;
	}

}
