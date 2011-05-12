public class A {
	public int i = 0;
	public void m(A o) {
		System.out.println("A.m");
		if (i >= 10)
			return;
		i++;
		m(o);
	}

	public void f(A o) {
		System.out.println("A.f");
		if (i >= 10)
			return;
		i++;
		f(o);
	}
}
