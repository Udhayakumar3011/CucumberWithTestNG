package stepDefinitions;

public class ThrowTest {

	public static void main(String[] args) {

		try {
			int a = 1 / 0;
			System.out.println("Done");
			throw new ArithmeticException();
		} catch (ArithmeticException e) {
			e.printStackTrace();
		//	System.out.println("Catch Block");
		}
	}

}
