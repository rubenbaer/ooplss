public class Main {
	public static void main(String[] args) {
		A<Foo> foo = new B.B$Foo$();
		A<Bar> bar = new B.B$Bar$();
		A<FooBar> foobar = new B.B$FooBar$();
		B<Foo> foo2 = new B.B$Foo$();
		B<Bar> bar2 = new B.B$Bar$();
		B<FooBar> foobar2 = new B.B$FooBar$();
		if (foo instanceof A.A$Foo$) 
			System.out.println("true");
		else
			System.out.println("false");
		if (foo instanceof B.B$Foo$) 
			System.out.println("true");
		else
			System.out.println("false");
	}
}
