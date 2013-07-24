package devopsdistilled.operp.client.stock;

import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import net.miginfocom.swing.MigLayout;
import devopsdistilled.operp.client.abstracts.SubTaskPane;

public class ListStockPane extends SubTaskPane  {
	private JPanel pane;
	private JTable table;
	private StockTableModel tableModel;
	/**
	 * @wbp.parser.entryPoint
	 */
	@Override
	public void init() {
		pane = new JPanel(new MigLayout("debug, fill", "[]", "[]"));

		tableModel = new StockTableModel();
		table = new JTable(tableModel);

		final JScrollPane scrollPane = new JScrollPane(table,
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		pane.add(scrollPane, "cell 0 0,grow");
		
	}
	
	@Override
	public JComponent getPane() {
		return pane;
	}
	

		
		
	
}
