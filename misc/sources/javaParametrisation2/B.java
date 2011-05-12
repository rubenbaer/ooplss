public interface B<X> extends A<X> {
	public X f(X x);

	static public class B$Foo$ extends A$Foo$ implements B<Foo> {
		public Foo f(Foo x) {
			return x;
		}
	}

	static public class B$Bar$ extends A$Bar$ implements B<Bar> {
		public Bar f(Bar x) {
			return x;
		}
	}

	static public class B$FooBar$ extends A$FooBar$ implements B<FooBar> {
		public FooBar f(FooBar x) {
			return x;
		}
	}
}
