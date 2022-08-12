package pastAssignments.s2_2021.assignment1.basic;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class OrderingLogicTest {
	OrderingLogic eng1, eng2;

	@BeforeEach
	public void run() {
		eng1 = new OrderingLogic(10);
	}

	@Test
	public void testOrderingLogic() {
		assertEquals(10, eng1.data.length);
		for(int i=0; i < 10; i++) {
			assertTrue(eng1.data[i]>=1 && eng1.data[i]<=90, eng1.data[i]+" isn't a valid item");
		}
		eng1 = new OrderingLogic(0);
		assertEquals(1, eng1.data.length);
		eng1 = new OrderingLogic(16);
		assertEquals(15, eng1.data.length);
		eng1 = new OrderingLogic(-10);
		assertEquals(1, eng1.data.length);

		for(int run=0; run<100; run++) {
			eng1 = new OrderingLogic(20);
			assertEquals(15, eng1.data.length);	
			for(int i=0; i < 15; i++) {
				assertTrue(eng1.data[i]>=1 && eng1.data[i]<=90, eng1.data[i]+" isn't a valid item");
			}
		}
		
		int[] freq = new int[90];
		for(int i=1; i < 90000; i++) {
			eng1 = new OrderingLogic(10);
			for(int k=0; k < eng1.data.length; k++) {
				freq[eng1.data[k]-1]++;
			}
		}
		for(int i=0; i < freq.length; i++) {
			assertTrue(freq[i]>=300, "value "+(i+1)+" doesn't occur enough times over a long series of experiments"); //expected value is 1000 so this is fairly lenient
		}
	}

	@Test
	public void testIsValidIndex() {
		assertTrue(eng1.isValidIndex(0), "0 is a valid index for "+Arrays.toString(eng1.data));
		assertFalse(eng1.isValidIndex(10), "10 is not a valid index for "+Arrays.toString(eng1.data));
		assertTrue(eng1.isValidIndex(9), "9 is a valid index for "+Arrays.toString(eng1.data));
		assertFalse(eng1.isValidIndex(-1), "-1 is not a valid index for "+Arrays.toString(eng1.data));
		assertFalse(eng1.isValidIndex(-21), "-21 is not a valid index for "+Arrays.toString(eng1.data));
		assertFalse(eng1.isValidIndex(20), "20 is not a valid index for "+Arrays.toString(eng1.data));
		assertFalse(eng1.isValidIndex(-50), "-50 is not a valid index for "+Arrays.toString(eng1.data));
	}

//	@Test
//	public void testRemove() {
//		int[] copy = Arrays.copyOf(eng1.data, 10);
//		int itemRemoved = eng1.data[0];
//		String before = Arrays.toString(eng1.data);
//		String expected = "["+before.substring(before.indexOf(",")+2);
//		eng1.remove(0);
//		String actual = Arrays.toString(eng1.data);
//		assertEquals(9, eng1.data.length, "After removing item "+itemRemoved+
//					" from "+before+", it should be "+expected+", but is "+actual);
//		for(int i=1; i < copy.length; i++) {
//			assertEquals(eng1.data[i-1], copy[i], "After removing item "+itemRemoved+
//					" from "+before+", it should be "+expected+", but is "+actual);
//		}
//		before = Arrays.toString(eng1.data);
//		expected = "["+before.substring(before.indexOf(",")+2);
//		itemRemoved = eng1.data[eng1.data.length-1];
//		eng1.remove(eng1.data.length-1);
//		actual = Arrays.toString(eng1.data);
//		assertEquals(8, eng1.data.length, "After removing item "+itemRemoved+
//				" from "+before+", it should be "+expected+", but is "+actual);
//		for(int i=1; i < eng1.data.length; i++) {
//			assertEquals(eng1.data[i-1], copy[i], "After removing item "+itemRemoved+
//					" from "+before+", it should be "+expected+", but is "+actual);
//		}
//
//		before = Arrays.toString(eng1.data);
//		expected = "["+before.substring(before.indexOf(",")+2);
//		itemRemoved = eng1.data[4];
//		eng1.remove(4);
//		actual = Arrays.toString(eng1.data);
//		assertEquals(7, eng1.data.length, "After removing item "+itemRemoved+
//				" from "+before+", it should be "+expected+", but is "+actual);
//		for(int i=1; i <= 4; i++) {
//			assertEquals(eng1.data[i-1], copy[i], "After removing item "+itemRemoved+
//					" from "+before+", it should be "+expected+", but is "+actual);
//		}
//		for(int i=6; i < eng1.data.length; i++) {
//			assertEquals(eng1.data[i-2], copy[i], "After removing item "+itemRemoved+
//					" from "+before+", it should be "+expected+", but is "+actual);
//		}
//	}
	
	@Test
	public void testRemove() {
        eng1.data = new int[]{10,15,20,25,30,35,40,45,50,55};
		int[] copy = Arrays.copyOf(eng1.data, eng1.data.length);
		int itemRemoved = eng1.data[0];
		System.out.println("Array: "+Arrays.toString(eng1.data));
		System.out.println("Trying to remove "+itemRemoved);
		eng1.remove(0); //remove first item
		System.out.println("Array, after removing "+itemRemoved+": "+Arrays.toString(eng1.data));
		assertEquals(9, eng1.data.length);
		for(int i=0; i < eng1.data.length; i++) {
			assertEquals(eng1.data[i], copy[i+1]);
		}
		
		copy = Arrays.copyOf(eng1.data, eng1.data.length);
		itemRemoved = eng1.data[eng1.data.length-1];
		System.out.println("Array: "+Arrays.toString(eng1.data));
		System.out.println("Trying to remove "+itemRemoved);
		eng1.remove(eng1.data.length-1); //remove last item
		System.out.println("Array, after removing "+itemRemoved+": "+Arrays.toString(eng1.data));
		assertEquals(8, eng1.data.length);
		for(int i=0; i < eng1.data.length; i++) {
			assertEquals(eng1.data[i], copy[i]);
		}
		
		copy = Arrays.copyOf(eng1.data, eng1.data.length);
		itemRemoved = eng1.data[4];
		System.out.println("Array: "+Arrays.toString(eng1.data));
		System.out.println("Trying to remove "+itemRemoved);
		eng1.remove(4); //remove item from middle
		System.out.println("Array, after removing "+itemRemoved+": "+Arrays.toString(eng1.data));
		assertEquals(7, eng1.data.length);
		for(int i=0; i < eng1.data.length; i++) {
			if(i < 4) 
				assertEquals(eng1.data[i], copy[i]);
			else
				assertEquals(eng1.data[i], copy[i+1]);		
		}
	}

	@Test
	public void testIsSorted() {
		//left sortedCount and display of array in there to help you out
		//int sortedCount = 0;
		for(int i=0; i < 1000; i++) {
			eng1 = new OrderingLogic((int)(Math.random()*10) + 1);
			int[] copy = Arrays.copyOf(eng1.data, eng1.data.length);
			Arrays.sort(copy);
			if(Arrays.equals(eng1.data, copy)) {
				assertTrue(eng1.isSorted(), Arrays.toString(eng1.data)+" is sorted but your code deemed it's not");;
				//System.out.println(Arrays.toString(eng1.data));
				//sortedCount++;
			}
			else {
				reverse(copy);
				if(Arrays.equals(eng1.data, copy)) {
					assertTrue(eng1.isSorted(), Arrays.toString(eng1.data)+" is sorted but your code deemed it's not");;
					//System.out.println(Arrays.toString(eng1.data));
					//sortedCount++;
				}
				else {
					assertFalse(eng1.isSorted(), Arrays.toString(eng1.data)+" is not sorted but your code deemed it is");;
				}
			}
		}
		//System.out.println(sortedCount);
	}

	private void reverse(int[] a) {
		for(int i=0; i < a.length/2; i++) {
			int temp = a[a.length - i - 1];
			a[a.length- i - 1] = a[i];
			a[i] = temp;
		}
	}
}
