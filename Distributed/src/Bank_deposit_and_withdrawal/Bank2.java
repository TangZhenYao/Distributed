package Bank_deposit_and_withdrawal;

//���д�ȡ��
public class Bank2 {
    private static int money;
    public int getMoney(){
        return money;
    }
    public void saveMoney(int m){
        synchronized (this) {
            System.out.println("��Ǯ����ܽ�"+(money+=m));   
        }
    }
    public void drawMoney(int m){
        synchronized (this) {
        	Bank2 bank = new Bank2();
            if (bank.getMoney()<=0) {
                System.out.println("û��Ǯ��ȡ��pi");
            }else {
                System.out.println("ȡǮ��ʣ���ܽ�"+(money-=m));        
            }
        }
    }
     
    public static void main(String[] args) {
        Man m1 = new Man();
        Women w = new Women();
        Thread t1 = new Thread(m1);
        Thread t2 = new Thread(m1);
        Thread t3 = new Thread(m1);
        Thread t4 = new Thread(w);
        Thread t5 = new Thread(w);
        Thread t6 = new Thread(w);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        }
 
}
 
class Man implements Runnable{
    private Bank2 bank = new Bank2();
 
    public void run() {
        int m = 100;
        int i=0;
        while (i<5) {
                bank.saveMoney(m);
                i++;
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }  
        }
    }
}
class Women implements Runnable{
    private Bank2 bank = new Bank2();
 
    public void run() {
        int m = 100;
        int i=0;
        //bank.getMoney()>0
        while (i<5) {
                    bank.drawMoney(m);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        i++;
        }
    }

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//	}

}
