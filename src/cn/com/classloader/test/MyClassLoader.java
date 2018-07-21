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

	//��д�����������findClass����
	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		//�����Զ����loadClassData��������drive�ҵ���ص����ļ�������
		byte[] data = loadClassData(name);
		//���ø���defineClass��������byte�ж������ʵ��
		return super.defineClass(name,data,0,data.length);
	}
	
	//����������ָ��������������byte��
	public byte[] loadClassData(String name){
		FileInputStream fis = null;
		byte[] data = null;
		
		try {
			fis = new FileInputStream(new File(drive+name+fileType));//��ȡ�ļ�������
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
