package pastAssignments.s2_2021.assignment2.stage_1_fresh_food;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.*;

import pastAssignments.s2_2021.assignment2.common.Graded;

//DO NOT MODIFY
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class FreshFoodTest {
	public static int score = 0;
	public static String result = "";
	public static String currentMethodName = null;
	public static ArrayList<String> methodsPassed = new ArrayList<String>();
	Carton c1, c2, c3, c4, c5, c6, c7, c8;

	@BeforeEach
	void run() {
		c1 = new Carton("Carton 1", new Tray[] {});
		c2 = new Carton("Carton 2", new Tray[] { new Tray(new TrayType(5), 4) });
		c3 = new Carton("Carton 3", new Tray[] { new Tray(new TrayType(10), 4), new Tray(new TrayType(70), 70),
				new Tray(new TrayType(20), 25), new Tray(new TrayType(90), 5) });
		c4 = new Carton("Carton 4", new Tray[] { new Tray(new TrayType(10), 4), new Tray(new TrayType(70), 70),
				new Tray(new TrayType(20), 25), new Tray(new TrayType(90), 5), new Tray(new TrayType(20), 25) });
		c5 = new Carton("Carton 5", new Tray[] { new Tray(new TrayType(1), 1), new Tray(new TrayType(70), 70),
				new Tray(new TrayType(20), 25), new Tray(new TrayType(15), 15), new Tray(new TrayType(20), 25) });
		c6 = new Carton("Carton 6", new Tray[] { null, new Tray(new TrayType(70), 70), null,
				new Tray(new TrayType(20), 25), new Tray(new TrayType(20), 25) });
	}
 
	@Test @Timeout(value = 100, unit = TimeUnit.MILLISECONDS) @Order(1)
	@Graded(description = "testTrayTypeConstructor", marks=4)
	public void testTrayTypeConstructor() {
		TrayType a = new TrayType(-1);
		assertEquals(1, a.capacity);
		
		TrayType b = new TrayType(-5);
		assertEquals(1, b.capacity);

		TrayType c = new TrayType(101);
		assertEquals(100, c.capacity);

		for (int i = 1; i < 101; i++) {
			TrayType d = new TrayType(i);
			assertEquals(i, d.capacity);
		}
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Timeout(value = 100, unit = TimeUnit.MILLISECONDS) @Order(2)
	@Graded(description = "testTrayTypeCompareTo", marks=3)
	public void testTrayTypeCompareTo() {
		testTrayTypeConstructor(); //ensure TrayType constructor passes before this is attempted
		TrayType a = new TrayType(1);
		TrayType b = new TrayType(5);
		TrayType c = new TrayType(5);
		assertEquals(-1, a.compareTo(b));
		assertEquals(1, b.compareTo(a));
		assertEquals(0, c.compareTo(b));
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Timeout(value = 100, unit = TimeUnit.MILLISECONDS) @Order(3)
	@Graded(description = "testTrayConstructor", marks=4)
	public void testTrayConstructor() {
		testTrayTypeConstructor(); //ensure TrayType constructor passes before this is attempted
		TrayType a = new TrayType(20);
		Tray t1 = new Tray(a, 15);
		assertEquals(15, t1.quantity);
		assertEquals(a.capacity, t1.type.capacity);
		a.capacity = 10;
		assertEquals(15, t1.quantity);
		assertEquals(a.capacity, t1.type.capacity);

		Tray t2 = new Tray(new TrayType(70), 74);
		assertEquals(70, t2.type.capacity);
		assertEquals(70, t2.quantity);

		t2 = new Tray(new TrayType(70), -10);
		assertEquals(70, t2.type.capacity);
		assertEquals(0, t2.quantity);
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Timeout(value = 100, unit = TimeUnit.MILLISECONDS) @Order(4)
	@Graded(description = "testCartonConstructor", marks=4)
	public void testCartonConstructor() {
		testTrayConstructor(); //ensure Tray constructor passes before this is attempted
		c7 = new Carton("Carton 7", null);
		assertEquals("Carton 7", c7.name);
		assertNotNull(c7.trays);
		assertEquals(0, c7.trays.length);

		assertEquals("Carton 3", c3.name);
		assertEquals(4, c3.trays.length);
		assertEquals("Carton 3:\n" 
						+ "10-fruit tray containing 4 fruits\n" 
						+ "70-fruit tray containing 70 fruits\n"
						+ "20-fruit tray containing 20 fruits\n" 
						+ "90-fruit tray containing 5 fruits\n",
						c3.toString());

		Tray t1 = new Tray(new TrayType(20), 15);
		Tray t2 = new Tray(new TrayType(70), 74);
		c7 = new Carton(null, new Tray[] { t1, t2, t1 });
		assertEquals("-", c7.name);
		assertEquals(3, c7.trays.length);
		assertEquals("-:\n" 
						+ "20-fruit tray containing 15 fruits\n" 
						+ "70-fruit tray containing 70 fruits\n"
						+ "20-fruit tray containing 15 fruits\n", c7.toString());

		t1.quantity = 10;
		assertEquals("-:\n" 
						+ "20-fruit tray containing 10 fruits\n" 
						+ "70-fruit tray containing 70 fruits\n"
						+ "20-fruit tray containing 10 fruits\n", c7.toString());

		assertEquals("Carton 6:\n" 
						+ "null\n" 
						+ "70-fruit tray containing 70 fruits\n" 
						+ "null\n"
						+ "20-fruit tray containing 20 fruits\n" 
						+ "20-fruit tray containing 20 fruits\n",
						c6.toString());

		c7 = new Carton(null, null);
		assertEquals("-:\n", c7.toString());
		assertNotNull(c7.trays);
		assertEquals(0, c7.trays.length);
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Timeout(value = 100, unit = TimeUnit.MILLISECONDS) @Order(5)
	@Graded(description = "testCountFullTrays", marks=3)
	public void testCountFullTrays() {
		testCartonConstructor(); //ensure Carton constructor passes before this is attempted
		assertEquals(0, c1.countFullTrays());
		assertEquals(0, c1.countFullTrays());
		assertEquals(0, c2.countFullTrays());
		assertEquals(2, c3.countFullTrays());
		assertEquals(3, c4.countFullTrays());
		assertEquals(5, c5.countFullTrays());
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Timeout(value = 100, unit = TimeUnit.MILLISECONDS) @Order(6)
	@Graded(description = "testCountFullTraysAdvanced", marks=1)
	public void testCountFullTraysAdvanced() {
		testCountFullTrays();
		assertEquals(3, c6.countFullTrays());
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Timeout(value = 100, unit = TimeUnit.MILLISECONDS) @Order(7)
	@Graded(description = "testAllTraysFull", marks=3)
	public void testAllTraysFull() {
		testCartonConstructor(); //ensure Carton constructor passes before this is attempted
		assertTrue(c1.allTraysFull());
		assertTrue(c1.allTraysFull());
		assertFalse(c2.allTraysFull());
		assertFalse(c3.allTraysFull());
		assertFalse(c4.allTraysFull());
		assertTrue(c5.allTraysFull());
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Timeout(value = 100, unit = TimeUnit.MILLISECONDS) @Order(8)
	@Graded(description = "testAllTraysFullAdvanced", marks=1)
	public void testAllTraysFullAdvanced() {
		testAllTraysFull();
		assertTrue(c6.allTraysFull());

		c6.trays[1].quantity = 1;
		assertFalse(c6.allTraysFull());
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Timeout(value = 100, unit = TimeUnit.MILLISECONDS) @Order(9)
	@Graded(description = "testGetIndicesOfFullTrays", marks=3)
	public void testGetIndicesOfFullTrays() {
		testCartonConstructor(); //ensure Carton constructor passes before this is attempted
		assertEquals("[]", Arrays.toString(c1.getIndicesOfFullTrays()));
		assertEquals("[]", Arrays.toString(c1.getIndicesOfFullTrays()));
		assertEquals("[]", Arrays.toString(c2.getIndicesOfFullTrays()));
		assertEquals("[1, 2]", Arrays.toString(c3.getIndicesOfFullTrays()));
		assertEquals("[1, 2, 4]", Arrays.toString(c4.getIndicesOfFullTrays()));
		assertEquals("[0, 1, 2, 3, 4]", Arrays.toString(c5.getIndicesOfFullTrays()));
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Timeout(value = 100, unit = TimeUnit.MILLISECONDS) @Order(10)
	@Graded(description = "testGetIndicesOfFullTraysAdvanced", marks=1)
	public void testGetIndicesOfFullTraysAdvanced() {
		testGetIndicesOfFullTrays();
		assertEquals("[1, 3, 4]", Arrays.toString(c6.getIndicesOfFullTrays()));
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Timeout(value = 100, unit = TimeUnit.MILLISECONDS) @Order(11)
	@Graded(description = "testIdentical", marks=3)
	public void testIdentical() {
		testCartonConstructor(); //ensure Carton constructor passes before this is attempted
		assertTrue(c1.identical(c1));
		assertFalse(c3.identical(c4));
		assertFalse(c4.identical(c3));

		c7 = new Carton("Carton 7", new Tray[] { new Tray(new TrayType(10), 4), new Tray(new TrayType(70), 70),
				new Tray(new TrayType(20), 25), new Tray(new TrayType(90), 5) });
		assertTrue(c3.identical(c7));

		c7 = new Carton("Carton 7", new Tray[] { new Tray(new TrayType(10), 4), new Tray(new TrayType(70), 70),
				new Tray(new TrayType(20), 25), new Tray(new TrayType(90), 6) });
		assertFalse(c3.identical(c7));
		c7 = new Carton("Carton 7", new Tray[] { new Tray(new TrayType(9), 4), new Tray(new TrayType(70), 70),
				new Tray(new TrayType(20), 25), new Tray(new TrayType(90), 5) });
		assertFalse(c3.identical(c7));
		c7 = new Carton("Carton 7", new Tray[] { new Tray(new TrayType(70), 70), new Tray(new TrayType(10), 4),
				new Tray(new TrayType(20), 25), new Tray(new TrayType(90), 5) }); // False if different order
		assertFalse(c3.identical(c7));
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Timeout(value = 100, unit = TimeUnit.MILLISECONDS) @Order(12)
	@Graded(description = "testIdenticalAdvanced", marks=1)
	public void testIdenticalAdvanced() {
		testIdentical();
		c7 = new Carton("Carton 7", new Tray[] { null, new Tray(new TrayType(70), 70), null,
				new Tray(new TrayType(20), 25), new Tray(new TrayType(20), 25) });
		assertTrue(c6.identical(c7));


		c7 = new Carton("Carton 7",
				new Tray[] { null, null, null, new Tray(new TrayType(20), 25), new Tray(new TrayType(20), 25) });
		assertFalse(c6.identical(c7));
		assertFalse(c7.identical(c6));
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Timeout(value = 100, unit = TimeUnit.MILLISECONDS) @Order(13)
	@Graded(description = "testSameButRearranged", marks=3)
	public void testSameButRearranged() {
		testCartonConstructor(); //ensure Carton constructor passes before this is attempted
		assertTrue(c1.sameButRearranged(c1));
		assertFalse(c3.sameButRearranged(c4));
		assertFalse(c4.sameButRearranged(c3));

		c7 = new Carton("Carton 7", new Tray[] { new Tray(new TrayType(10), 4), new Tray(new TrayType(70), 70),
				new Tray(new TrayType(20), 25), new Tray(new TrayType(90), 5) });
		assertTrue(c3.identical(c7));

		assertEquals("Carton 3:\n"
				+ "10-fruit tray containing 4 fruits\n"
				+ "70-fruit tray containing 70 fruits\n"
				+ "20-fruit tray containing 20 fruits\n"
				+ "90-fruit tray containing 5 fruits\n",c3.toString());
		assertEquals("Carton 7:\n"
				+ "10-fruit tray containing 4 fruits\n"
				+ "70-fruit tray containing 70 fruits\n"
				+ "20-fruit tray containing 20 fruits\n"
				+ "90-fruit tray containing 5 fruits\n",c7.toString());
		assertEquals("Carton 4:\n"
				+ "10-fruit tray containing 4 fruits\n"
				+ "70-fruit tray containing 70 fruits\n"
				+ "20-fruit tray containing 20 fruits\n"
				+ "90-fruit tray containing 5 fruits\n"
				+ "20-fruit tray containing 20 fruits\n",c4.toString());

		c7 = new Carton("Carton 7", new Tray[] { new Tray(new TrayType(70), 70), new Tray(new TrayType(10), 4),
				new Tray(new TrayType(20), 25), new Tray(new TrayType(90), 5) });
		assertTrue(c3.sameButRearranged(c7));

		c7 = new Carton("Carton 7", new Tray[] { new Tray(new TrayType(1), 1), new Tray(new TrayType(2), 2),
				new Tray(new TrayType(1), 1), new Tray(new TrayType(1), 1), new Tray(new TrayType(2), 2) });
		c8 = new Carton("Carton 8", new Tray[] { new Tray(new TrayType(1), 1), new Tray(new TrayType(1), 1),
				new Tray(new TrayType(1), 1), new Tray(new TrayType(1), 1), new Tray(new TrayType(2), 2) });
		assertFalse(c7.sameButRearranged(c8));
		c8.trays[2] = new Tray(new TrayType(2), 2);
		assertTrue(c7.sameButRearranged(c8));
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Timeout(value = 100, unit = TimeUnit.MILLISECONDS) @Order(14)
	@Graded(description = "testSameButRearrangedAdvanced", marks=1)
	public void testSameButRearrangedAdvanced() {
		testSameButRearranged();
		c7 = new Carton("Carton 7", new Tray[] { null, new Tray(new TrayType(70), 70), null,
				new Tray(new TrayType(20), 25), new Tray(new TrayType(20), 25) });
		assertTrue(c6.sameButRearranged(c7));

		c7 = new Carton("Carton 7",
				new Tray[] { null, null, null, new Tray(new TrayType(20), 25), new Tray(new TrayType(20), 25) });
		assertFalse(c6.sameButRearranged(c7));
		assertFalse(c7.sameButRearranged(c6));

		c7.trays[2] = new Tray(new TrayType(70), 70);
		assertTrue(c7.sameButRearranged(c6));

		c7 = new Carton("Carton 7", new Tray[] { null, new Tray(new TrayType(15), 10) });
		c8 = new Carton("Carton 8", new Tray[] { new Tray(new TrayType(30), 10), null });
		assertFalse(c7.sameButRearranged(c8));
		assertFalse(c8.sameButRearranged(c7));
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}
	
	@Test @Timeout(value = 100, unit = TimeUnit.MILLISECONDS) @Order(15)
	@Graded(description = "testGetFreshFoodClientSampleOutputA", marks=5)
	public void testGetFreshFoodClientSampleOutputA() {
		testCartonConstructor(); //ensure Carton constructor passes before this is attempted
		String expected = "Carton 1:\n"
				+ "10-fruit tray containing 5 fruits\n"
				+ "20-fruit tray containing 13 fruits\n"
				+ "30-fruit tray containing 21 fruits\n"
				+ "40-fruit tray containing 29 fruits\n"
				+ "50-fruit tray containing 37 fruits\n"
				+ "60-fruit tray containing 45 fruits\n"
				+ "70-fruit tray containing 53 fruits\n"
				+ "80-fruit tray containing 61 fruits\n"
				+ "\n"
				+ "Carton 2:\n"
				+ "10-fruit tray containing 5 fruits\n"
				+ "20-fruit tray containing 13 fruits\n"
				+ "30-fruit tray containing 21 fruits\n"
				+ "40-fruit tray containing 29 fruits\n"
				+ "50-fruit tray containing 37 fruits\n"
				+ "60-fruit tray containing 45 fruits\n"
				+ "70-fruit tray containing 53 fruits\n"
				+ "80-fruit tray containing 61 fruits\n"
				+ "\n"
				+ "identical?: true\n"
				+ "same (with re-arrangement)?: true\n"
				+ "After swapping in carton 2\n"
				+ "Carton 2:\n"
				+ "40-fruit tray containing 29 fruits\n"
				+ "30-fruit tray containing 21 fruits\n"
				+ "60-fruit tray containing 45 fruits\n"
				+ "50-fruit tray containing 37 fruits\n"
				+ "10-fruit tray containing 5 fruits\n"
				+ "20-fruit tray containing 13 fruits\n"
				+ "70-fruit tray containing 53 fruits\n"
				+ "80-fruit tray containing 61 fruits\n"
				+ "\n"
				+ "identical?: false\n"
				+ "same (with re-arrangement)?: true\n"
				+ "increasing quantity of 4th item in carton 2\n"
				+ "same (with re-arrangement)?: false\n"
				+ "decreasing quantity back of 4th item in carton 2\n"
				+ "same (with re-arrangement)?: true\n"
				+ "decreasing quantity of last item in carton 1\n"
				+ "same (with re-arrangement)?: false\n";
		String actual = FreshFoodClient.getFreshFoodClientSampleOutputA();
		
		//get rid of newlines and leading trailing spaces
		expected = expected.replaceAll("\n","").replaceAll("\r","").trim();
		actual = actual.replaceAll("\n","").replaceAll("\r","").trim();
		
		assertEquals(expected, actual);
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}
	
	@AfterEach
	public void logSuccess() throws NoSuchMethodException, SecurityException {
		if (currentMethodName != null && !methodsPassed.contains(currentMethodName)) {
			methodsPassed.add(currentMethodName);
			Method method = getClass().getMethod(currentMethodName);
			Graded graded = method.getAnnotation(Graded.class);
			score += graded.marks();
			result += graded.description() + " passed. Marks awarded: " + graded.marks() + "\n";
		}
	}

	@AfterAll
	public static void wrapUp() throws IOException {
		if (result.length() != 0) {
			result = result.substring(0, result.length() - 1); // remove the last "\n"
		}
		System.out.println(result + "\n" + score);
	}
}