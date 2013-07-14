package devopsdistilled.operp.client.main;

import devopsdistilled.operp.client.abstracts.Observer;
import devopsdistilled.operp.client.abstracts.TaskPane;

public interface MainModelObserver extends Observer {

	public void updateTaskPane(TaskPane taskPane);

	public void updateTitle(String title);
}
