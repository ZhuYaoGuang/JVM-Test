
public class PrintThread extends Thread{
    public static final long starttime = System.currentTimeMillis();

	@Override
	public void run() {
		while(true){
			try {
				long t = System.currentTimeMillis();
				System.out.println("time:"+t);
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		PrintThread p = new PrintThread();
		p.start();
	}
    
}
