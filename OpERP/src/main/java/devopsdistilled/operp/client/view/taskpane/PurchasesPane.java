package devopsdistilled.operp.client.view.taskpane;

import devopsdistilled.operp.client.view.taskpane.iface.TaskPane;

public class PurchasesPane implements TaskPane {
	@Override
	public String toString() {
		return "Purchases";
	}

	@Override
	public void makeCurrentWorkingTaskPane() {
		System.out.println("PurchasesPane as new TaskPane");
		
	}
}
