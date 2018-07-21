
public class JvmXMTest {
    public static void main(String[] args) {
		byte[] b = new byte[4*1024*1024];
		System.out.println("分配了4M空间给数组");
		
		System.out.print("Xmx=");//最大堆空间
		System.out.println(Runtime.getRuntime().maxMemory()/1024.0/1024.0+"M");
		
		System.out.print("free mem=");//空闲堆空间
		System.out.println(Runtime.getRuntime().freeMemory()/1024.0/1024.0+"M");
		
		System.out.print("total mem=");//被分配的总空间
		System.out.println(Runtime.getRuntime().totalMemory()/1024.0/1024.0+"M");
		
		System.gc();
		System.out.println("回收内存");
		
		System.out.print("Xmx=");//最大堆空间
		System.out.println(Runtime.getRuntime().maxMemory()/1024.0/1024.0+"M");
		
		System.out.print("free mem=");//空闲堆空间
		System.out.println(Runtime.getRuntime().freeMemory()/1024.0/1024.0+"M");
		
		System.out.print("total mem=");//被分配的总空间
		System.out.println(Runtime.getRuntime().totalMemory()/1024.0/1024.0+"M");
	}
}
