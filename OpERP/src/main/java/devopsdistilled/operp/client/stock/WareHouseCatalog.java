package devopsdistilled.operp.client.stock;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import net.miginfocom.swing.MigLayout;
import devopsdistilled.operp.client.abstracts.SubTaskPane;

public class WareHouseCatalog extends SubTaskPane{
	private JPanel pane;
	private JTable table;
	
	/**
	 * @wbp.parser.entryPoint
	 */
	@Override
	public void init() {
		pane=new JPanel();
		pane.setLayout(new MigLayout("debug,fill", "", ""));

		final JScrollPane scrollPane = new JScrollPane(
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		pane.add(scrollPane, "grow");
		
		
		
		
	}
	
	@Override
	public JComponent getPane() {
		return pane;
	}
}
