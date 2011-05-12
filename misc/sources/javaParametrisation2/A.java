public interface A<X> {
	public X m(X x);

	static public class A$Foo$ implements A<Foo> {
		public Foo m(Foo x) {
			return x;
		}
	}

	static public class A$Bar$ implements A<Bar> {
		public Bar m(Bar x) {
			return x;
		}
	}

	static public class A$FooBar$ implements A<FooBar> {
		public FooBar m(FooBar x) {
			return x;
		}
	}
}
