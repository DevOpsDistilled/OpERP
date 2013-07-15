package devopsdistilled.operp.client.main;

import javax.inject.Inject;

import devopsdistilled.operp.client.abstracts.TaskPane;

public class MainWindowControllerImpl implements MainWindowController {

	@Inject
	private MainModel model;

	@Override
	public void changeTaskPane(TaskPane newTaskPane, TaskPane oldTaskPane) {
		model.setSelectedTaskPane(newTaskPane);
	}
}
