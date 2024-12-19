package business;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FahrradTest {
	
	private Fahrrad fahrrad;

	@BeforeEach
	void setUp() throws Exception {
		//this.fahrrad = new Fahrrad("Querenburg", 21, "a", "b", null);
	}

	@AfterEach
	void tearDown() throws Exception {
		this.fahrrad = null;
	}

	@Test
	//void test() {
	//	assertTrue(this.fahrrad.getName() == "Querenburg", () -> "Das Ergebnis muss true sein");
	//}
	
	void test2() {
		Throwable exc = assertThrows(NullPointerException.class, () -> new Fahrrad("Querenburg", 21, "a", "b", null));	
	}

}
