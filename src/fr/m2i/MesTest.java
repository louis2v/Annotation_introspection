package fr.m2i;

public class MesTest {

	@Test
	public int add(int nb1, int nb2) {
		return nb1 + nb2;
	}

	@Test
	public void testError(int nb1, int nb2) throws Exception {
		// ...
		throw new Exception("simule un test en échec");
	}
}
