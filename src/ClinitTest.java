public class ClinitTest {
	public static void main(String[] args) {
		//Son son = new Son();
		System.out.println(Son.a);
	}
}

class GrandParent{
	public static int a = 1;  
	static{
		System.out.println("I'am GrandParent");
	}
}

class Parent extends GrandParent{
	public static int a = 2;  
	static{
		System.out.println("I'am Parent");
	}
}

class Son extends Parent{
	static{
		System.out.println("I'am Son");
	}
}
