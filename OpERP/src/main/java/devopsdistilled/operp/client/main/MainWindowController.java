package devopsdistilled.operp.client.main;

import devopsdistilled.operp.client.abstracts.TaskPane;

public interface MainWindowController {

	void changeTaskPane(TaskPane newTaskPane, TaskPane oldTaskPane);

}
