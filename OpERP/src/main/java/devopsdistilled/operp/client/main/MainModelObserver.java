package devopsdistilled.operp.client.main;

public interface MainModelObserver extends Observer {

	public void updateTaskPane(TaskPane taskPane);

	public void updateTitle(String title);
}
