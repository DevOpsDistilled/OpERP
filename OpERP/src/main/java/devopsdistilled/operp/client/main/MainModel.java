package devopsdistilled.operp.client.main;

import devopsdistilled.operp.client.abstracts.Model;
import devopsdistilled.operp.client.abstracts.TaskPane;

public interface MainModel extends Model {

	public void setSelectedTaskPane(TaskPane taskPane);

	public TaskPane getSelectedTaskPane();

	public String getTitle();

	public void setTitle(String title);

}
