package cn.com.classloader.test;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

public class HotClassLoaderMain {
	
	private URLClassLoader classLoader;
	private Object worker;
	private long lastTime;
	private String classDir="G:\\Space-JavaDevelopMent\\JVM-Test\\bin\\";
	
	public static void main(String[] args) throws Exception {
		HotClassLoaderMain helloMain=new HotClassLoaderMain();
		helloMain.execute();
	}
	
	private void execute() throws Exception {
		while(true){
			//����Ƿ���Ҫ����
			if(checkIsNeedLoad()){
				System.out.println("��⵽�°汾��׼�����¼���");
				reload();
				System.out.println("���¼������");
			}
			//һ��
			invokeMethod();
			Thread.sleep(1000);
		}
	}
	
	private void invokeMethod() throws Exception {
		//ͨ�����䷽ʽ����
		//ʹ�÷������Ҫԭ���ǣ�����Work��appclassloader���أ�
		//�����appclassloader���صĻ�����ͨ���Զ�����������ػ��е�����
		Method method=worker.getClass().getDeclaredMethod("sayHello", null);
		method.invoke(worker, null);
	}

	private void reload() throws Exception {
		classLoader = new HotClassLoader(new URL[] { new URL(
				"file:"+classDir)});
		worker =  classLoader.loadClass("cn.com.classloader.test.Worker")
				.newInstance();
		
	}

	//����ļ��Ƿ񱻸���
	private boolean checkIsNeedLoad() {
		File file=new File(classDir+"cn\\com\\classloader\\test\\Worker.class");
		long newTime=file.lastModified();
		if(lastTime<newTime){
			lastTime=newTime;
			return true;
		}
		return false;
	}
}
