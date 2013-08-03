package devopsdistilled.operp.client.stock.panes;

import java.util.List;

import javax.inject.Inject;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import net.miginfocom.swing.MigLayout;
import devopsdistilled.operp.client.abstracts.SubTaskPane;
import devopsdistilled.operp.client.stock.models.impl.WarehouseTableModel;
import devopsdistilled.operp.client.stock.models.observers.ListWarehousePaneObserver;
import devopsdistilled.operp.client.stock.models.observers.WarehouseModelObserver;
import devopsdistilled.operp.client.stock.panes.controllers.ListWarehousePaneController;
import devopsdistilled.operp.server.data.entity.stock.Warehouse;

public class ListWarehousePane extends SubTaskPane implements 
ListWarehousePaneObserver,WarehouseModelObserver{
	
	@Inject
	private ListWarehousePaneController controller;
	
	private JComponent pane;
	private JTable table;
	private WarehouseTableModel tableModel;
	

	public ListWarehousePane(){
		pane=new JPanel();
		pane.setLayout(new MigLayout("debug,fill","[]","[]"));
		tableModel=new WarehouseTableModel();
		table=new JTable(tableModel);
		
		final JScrollPane scrollPane=new JScrollPane(table,
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		pane.add(scrollPane,"grow");
	
	}
	
	@Override
	public JComponent getPane() {
		return pane;
	}
	
}
