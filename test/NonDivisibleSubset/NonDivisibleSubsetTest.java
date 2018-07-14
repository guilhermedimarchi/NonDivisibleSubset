package NonDivisibleSubset;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class NonDivisibleSubsetTest {
	
	@Test
	void test() {
		NonDivisibleSubset nds = new NonDivisibleSubset();
		assertEquals(3, nds.encontrar(3, Arrays.asList(1, 7, 2, 4)));
	}

}
