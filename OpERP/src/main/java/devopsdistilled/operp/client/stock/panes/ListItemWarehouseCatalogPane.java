package devopsdistilled.operp.client.stock.panes;

import java.util.List;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import net.miginfocom.swing.MigLayout;
import devopsdistilled.operp.client.abstracts.SubTaskPane;
import devopsdistilled.operp.client.abstracts.libs.BeanTableModel;
import devopsdistilled.operp.client.stock.models.observers.ItemWarehouseCatalogModelObserver;
import devopsdistilled.operp.client.stock.panes.models.observers.ListItemWarehouseCatalogPaneModelObserver;
import devopsdistilled.operp.server.data.entity.stock.ItemWarehouseCatalog;

public class ListItemWarehouseCatalogPane extends SubTaskPane 
		implements ListItemWarehouseCatalogPaneModelObserver,
		ItemWarehouseCatalogModelObserver{
	
	private JPanel pane;
	private JTable table;
	BeanTableModel<ItemWarehouseCatalog> tableModel;
	
	public ListItemWarehouseCatalogPane(){
		pane=new JPanel();
		pane.setLayout(new MigLayout("debug","[]","[]"));
		table=new JTable(tableModel);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		final JScrollPane scrollPane=new JScrollPane(table,
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		pane.add(scrollPane,"grow");
		
		
		
	}
	@Override
	public JComponent getPane() {
		return pane;
	}
	@Override
	public void updateItemWarehouseCatalog(
			List<ItemWarehouseCatalog> itemWarehouses) {
		tableModel=null;
		tableModel=new BeanTableModel<>(ItemWarehouseCatalog.class,itemWarehouses);
		for(int i=0;i<table.getColumnCount();i++){
			tableModel.setColumnEditable(i, false);
		}
		tableModel.setModelEditable(false);
		table.setModel(tableModel);
		
		
	}

}
