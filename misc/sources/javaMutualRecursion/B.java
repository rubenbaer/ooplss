public class B extends A {
	public void m(B o) {
		System.out.println("B.m");
		if (i >= 10)
			return;
		i++;
		super.m(o);
	}

	public void f(A o) {
		System.out.println("B.f");
		if (i >= 20)
			return;
		i++;
		super.f(o);
	}

	public static void main(String[] args) {
		B b = new B();
		b.m(b);
		b.i = 0;
		System.out.println("-------");
		b.f(b);
	}
}
