package devopsdistilled.operp.client.stock;

import javax.inject.Inject;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import devopsdistilled.operp.client.abstracts.TaskPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class StockMgmtPane extends TaskPane{

	@Inject
	private StockController stockController;
	
	@Override
	public String toString() {
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
		
		JButton btnUpdateStock=new JButton("Update Stock");
		btnUpdateStock.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				stockController.updateStock();
				
			}
			
		});
		pane.add(btnUpdateStock,"flowx,cell 0 1");
		
		
		
		return pane;
	}

}
