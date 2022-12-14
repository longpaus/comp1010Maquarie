package samplePracExams.pracExam1;

//IMPORTANT! Do NOT change any method headers

import static org.junit.Assert.*;
import org.junit.*;
import java.io.*;
import java.text.*;
import java.util.*;
import org.junit.rules.*;
import java.lang.reflect.*;

 
//10 marks
@SuppressWarnings("unused")
public class Question2 { //begin class 
  /**
   * @param a
   * @param b
   * @param c
   * @return true if at least one of the three values is positive,
   * false otherwise
   */
  public static boolean silverLining(int a, int b, int c) {
	  if(a > 0 || b > 0|| c > 0) {
		  return true;
	  }
	  return false;
  }
    //IMPORTANT!!! DO NOT MODIFY ANY CODE BELOW THIS LINE!

	@SuppressWarnings("deprecation")
	@Rule
	public TestRule timeout = new DisableOnDebug(new Timeout(1000));

	@Test @Graded(description="silverLining(int,int,int)", marks=10)
	public void testSilverLining() {
		assertTrue(Question2.silverLining(2, -4, 0));
		assertTrue(Question2.silverLining(-2, 4, 0));
		assertTrue(Question2.silverLining(-2, -4, 10));
		assertTrue(Question2.silverLining(2, 4, 0));
		assertTrue(Question2.silverLining(-2, 4, 10));
		assertTrue(Question2.silverLining(2, 4, 10));
		assertFalse(Question2.silverLining(-2, -4, -6));
		assertFalse(Question2.silverLining(-2, -4, 0));
		assertFalse(Question2.silverLining(0, 0, 0));

	}
} //end class (do not delete this closing bracket)
