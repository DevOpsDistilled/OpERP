package devopsdistilled.operp.client.main;

public class TestTaskPane extends TaskPane {

	String name;

	public TestTaskPane(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}

}
