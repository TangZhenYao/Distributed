package Thread.Runnable.Interface;

public class Test {

	public static void main(String[] args) {
		new Thread(new Thread2("C")).start();  
        new Thread(new Thread2("D")).start();  

	}

}
