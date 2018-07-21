import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import net.sf.cglib.beans.BeanGenerator;
import net.sf.cglib.beans.BeanMap;

public class PermSizeTest {
    public static void main(String[] args) {
    	for (int i = 0; i < 100000; i++) {
    		CglibBean bean = new CglibBean("geym.jvm.ch3.perm.bean"+i,new HashMap());
		}
	}
}

class CglibBean {
	/**
	 * ʵ��Object
	 */
	public Object object = null;

	/**
	 * ����map
	 */
	public BeanMap beanMap = null;

	public CglibBean() {
		super();
	}

	@SuppressWarnings("unchecked")
	public CglibBean(String name,Map propertyMap) {
		this.object = generateBean(name,propertyMap);
		this.beanMap = BeanMap.create(this.object);
	}

	/**
	 * ��bean���Ը�ֵ
	 * 
	 * @param property
	 *            ������
	 * @param value
	 *            ֵ
	 */
	public void setValue(String property, Object value) {
		beanMap.put(property, value);
	}

	/**
	 * ͨ���������õ�����ֵ
	 * 
	 * @param property
	 *            ������
	 * @return ֵ
	 */
	public Object getValue(String property) {
		return beanMap.get(property);
	}

	/**
	 * �õ���ʵ��bean����
	 * 
	 * @return
	 */
	public Object getObject() {
		return this.object;
	}

	@SuppressWarnings("unchecked")
	private Object generateBean(String name,Map propertyMap) {
		BeanGenerator generator = new BeanGenerator();
		Set keySet = propertyMap.keySet();
		for (Iterator i = keySet.iterator(); i.hasNext();) {
			String key = name +(String) i.next();
			generator.addProperty(key, (Class) propertyMap.get(key));
		}
		return generator.create();
	}
}