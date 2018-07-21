
public class CanReliveObj {
    public static CanReliveObj obj;
    
	@Override//重写Object类的finalize方法
	protected void finalize() throws Throwable {
		super.finalize();
		System.out.println("CanReliveObj finalize called");
		obj = this;//重新指定对象为当前类
	}
	
	@Override//重写Object类的toString方法
	public String toString() {
		return "I am CanReliveObj";
	}
    
	public static void main(String[] args) throws InterruptedException {
		obj = new CanReliveObj();
		obj = null;//可复活
		System.gc();//进行垃圾回收
		Thread.sleep(1000);
		if(obj == null){
			System.out.println("obj 是 null");
		}else{
			System.out.println("obj可用:"+obj.toString());
		}
		System.out.println("第二次gc");
		obj = null;//不可复活
		System.gc();//进行垃圾回收
		Thread.sleep(1000);
		if(obj == null){
			System.out.println("obj 是 null");
		}else{
			System.out.println("obj可用:"+obj.toString());
		}
	}
}
