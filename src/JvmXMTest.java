
public class JvmXMTest {
    public static void main(String[] args) {
		byte[] b = new byte[4*1024*1024];
		System.out.println("������4M�ռ������");
		
		System.out.print("Xmx=");//���ѿռ�
		System.out.println(Runtime.getRuntime().maxMemory()/1024.0/1024.0+"M");
		
		System.out.print("free mem=");//���жѿռ�
		System.out.println(Runtime.getRuntime().freeMemory()/1024.0/1024.0+"M");
		
		System.out.print("total mem=");//��������ܿռ�
		System.out.println(Runtime.getRuntime().totalMemory()/1024.0/1024.0+"M");
		
		System.gc();
		System.out.println("�����ڴ�");
		
		System.out.print("Xmx=");//���ѿռ�
		System.out.println(Runtime.getRuntime().maxMemory()/1024.0/1024.0+"M");
		
		System.out.print("free mem=");//���жѿռ�
		System.out.println(Runtime.getRuntime().freeMemory()/1024.0/1024.0+"M");
		
		System.out.print("total mem=");//��������ܿռ�
		System.out.println(Runtime.getRuntime().totalMemory()/1024.0/1024.0+"M");
	}
}
