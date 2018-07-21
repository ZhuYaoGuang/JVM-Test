public class FieldParsingTest {
	public static void main(String[] args) {
		System.out.println(C.a); 
	}
}

class A{  
    public static int a = 1;  
}  

class B extends A{  
    public static int a = 2;  
}  

class C extends B{ 
	
}  