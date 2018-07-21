package cn.com.classloader.test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

public class MyClassLoader extends ClassLoader{
	
	public static final String drive = "F:/";
	public static final String fileType = ".class";
	
	public static void main(String[] args) throws Exception {
		MyClassLoader loader = new MyClassLoader();
		Class<?> objClass = loader.loadClass("HelloWorld", true);
		Object obj = objClass.newInstance();
		System.out.println(objClass.getName());
		System.out.println(objClass.getClassLoader());
		System.out.println(obj.getClass().toString());
	}

	//重写父类加载器的findClass方法
	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		//调用自定义的loadClassData方法，从drive找到相关的类文件并加载
		byte[] data = loadClassData(name);
		//调用父类defineClass方法，从byte中定义类的实例
		return super.defineClass(name,data,0,data.length);
	}
	
	//根据类名从指定的区域加载类的byte流
	public byte[] loadClassData(String name){
		FileInputStream fis = null;
		byte[] data = null;
		
		try {
			fis = new FileInputStream(new File(drive+name+fileType));//获取文件输入流
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			int index = 0;
			while((index = fis.read()) != -1){
				baos.write(index);
			}
			data = baos.toByteArray();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return data;
	}
}
