public abstract class A<X> {
	public abstract X m(X x);

	static public class A$Foo$ extends A<Foo> {
		public Foo m(Foo x) {
			return x;
		}
	}

	static public class A$Bar$ extends A<Bar> {
		public Bar m(Bar x) {
			return x;
		}
	}

	static public class A$FooBar$ extends A<FooBar> {
		public FooBar m(FooBar x) {
			return x;
		}
	}
}
