import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class MyThread extends Thread{
    HashMap<Long,byte[]> map = new HashMap<Long,byte[]>();
	@Override
	public void run() {
		try {
			while(true){
				System.out.println("time:"+new SimpleDateFormat("ss.SSS") .format(new Date()));
				if(map.size()*512/1024/1024>=440){
					//��map��С����440Mʱ�������ڴ�
					System.out.println("===׼������===��"+map.size());
					map.clear();
				}
				for(int i=0;i<1024;i++){
					map.put(System.nanoTime(), new byte[512]);
				}
				Thread.sleep(1);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
    
	public static void main(String[] args) {
		MyThread t = new MyThread();
		t.start();
	}
}
