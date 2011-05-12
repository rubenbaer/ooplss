public abstract class B<X> extends A<X> {
	public abstract X f(X x);

	static public class B$Foo$ extends B<Foo> {
		public Foo m(Foo x) {
			return x;
		}
	}

	static public class B$Bar$ extends B<Bar> {
		public Bar m(Bar x) {
			return x;
		}
	}

	static public class B$FooBar$ extends B<FooBar> {
		public FooBar m(FooBar x) {
			return x;
		}
	}
}
