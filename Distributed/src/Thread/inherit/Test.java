package Thread.inherit;

public class Test {
	public static void main(String[] args) {
		Thread mTh1=new Thread1("A");  
        Thread mTh2=new Thread1("B");  
        mTh1.start();  
        mTh2.start();  
	}

}
