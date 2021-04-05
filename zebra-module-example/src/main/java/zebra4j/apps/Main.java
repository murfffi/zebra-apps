package zebra4j.apps;

public class Main {

	public static void main(String[] args) {
		System.out.println(System.getProperty("java.class.path"));
		System.out.println("Hello from " + Main.class.getModule().getName());
		zebra4j.Demo.questionPuzzle();
	}

}
