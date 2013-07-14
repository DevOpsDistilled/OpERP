package devopsdistilled.operp.client.main;

public interface MainModel extends Model {

	public void setSelectedTaskPane(TaskPane taskPane);

	public TaskPane getSelectedTaskPane();

	public String getTitle();

	public void setTitle(String title);

	public void castObservers();
}
