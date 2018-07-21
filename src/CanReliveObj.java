
public class CanReliveObj {
    public static CanReliveObj obj;
    
	@Override//��дObject���finalize����
	protected void finalize() throws Throwable {
		super.finalize();
		System.out.println("CanReliveObj finalize called");
		obj = this;//����ָ������Ϊ��ǰ��
	}
	
	@Override//��дObject���toString����
	public String toString() {
		return "I am CanReliveObj";
	}
    
	public static void main(String[] args) throws InterruptedException {
		obj = new CanReliveObj();
		obj = null;//�ɸ���
		System.gc();//������������
		Thread.sleep(1000);
		if(obj == null){
			System.out.println("obj �� null");
		}else{
			System.out.println("obj����:"+obj.toString());
		}
		System.out.println("�ڶ���gc");
		obj = null;//���ɸ���
		System.gc();//������������
		Thread.sleep(1000);
		if(obj == null){
			System.out.println("obj �� null");
		}else{
			System.out.println("obj����:"+obj.toString());
		}
	}
}
