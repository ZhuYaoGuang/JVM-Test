package cn.com.classloader.test;

import java.net.URL;
import java.net.URLClassLoader;

public class HotClassLoader extends URLClassLoader {

	public HotClassLoader(URL[] urls) {
		super(urls);
	}

	// ����˫��ģʽ����֤�Լ�����ᱻ�Լ���classloader����
	@Override
	protected synchronized Class<?> loadClass(String name, boolean resolve)
			throws ClassNotFoundException {
		Class c = findLoadedClass(name);
		if (c == null) {
			try {
				c=findClass(name);
			} catch (Exception e) {
			}
		}
		if(c==null){
			c=super.loadClass(name, resolve);
		}
		return c;
	}

}
