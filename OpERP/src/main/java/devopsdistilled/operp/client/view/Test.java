package devopsdistilled.operp.client.view;

public class Test {

	public Test() {
	}

	public static void main(String[] args) {
		Test test = new Test();
		String field = new String("Test");
		test.compare(field);
	}

	public void compare(String taskPane) {
		String field = taskPane;

		String local = new String("Test");
		if (local.equals(field))
			System.out.println("one equals two");
		else
			System.out.println("one is not equals two");

		if (local == field)
			System.out.println("one == two");
		else
			System.out.println("one !=two");
	}
}
