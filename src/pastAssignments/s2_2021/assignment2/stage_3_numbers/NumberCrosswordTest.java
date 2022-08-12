	package pastAssignments.s2_2021.assignment2.stage_3_numbers;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.*;

import pastAssignments.s2_2021.assignment2.common.Graded;

//DO NOT MODIFY
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class NumberCrosswordTest {
	public static int score = 0;
	public static String result = "";
	public static String currentMethodName = null;
	public static ArrayList<String> methodsPassed = new ArrayList<String>();

	public int[][] data = {{3, 5, 7, 5, 7}, 
			{6, 5, 5, 2, 6},
			{6, 6, 5, 6, 1},
			{3, 9, 3, 9, 7},
			{4, 5, 7, 3, 3}};
	public int target1 = 9;
	public int target2 = 20;
	public int target3 = 200;
	public int target4 = 2000;
	NumberCrossword_Stage1 stage1 = new NumberCrossword_Stage1(data);
	NumberCrossword_Stage2 stage2 = new NumberCrossword_Stage2(data);
	NumberCrossword_Stage3 stage3 = new NumberCrossword_Stage3(data);
	NumberCrossword_Stage4 stage4 = new NumberCrossword_Stage4(data);

	@Test @Timeout(value = 100, unit = TimeUnit.MILLISECONDS) @Order(1) 
	@Graded(description="NumerCrossWord_Stage1:canGet()", marks=4)
	public void testCanGetStage1() {
		String s1t1 = stage1.canGet(target1);
		assertNotNull(s1t1);
		s1t1 = s1t1.replaceAll("\n","").trim();
		assertEquals("[0,0] Down:((0)+3)+6[2,0] Down:((0)+6)+3[3,1] Right:(0)+9[3,3] Right:(0)+9[4,0] Right:((0)+4)+5", s1t1);
		String s1t2 = stage1.canGet(target2);
		assertNotNull(s1t2);
		s1t2 = s1t2.replaceAll("\n","").trim();;
		assertEquals("[0,0] Right:((((0)+3)+5)+7)+5[0,2] Down:((((0)+7)+5)+5)+3[1,1] Down:(((0)+5)+6)+9[1,2] Down:((((0)+5)+5)+3)+7[1,3] Down:((((0)+2)+6)+9)+3[2,1] Down:(((0)+6)+9)+5", s1t2);
		String s1t3 = stage1.canGet(target3);
		assertNull(s1t3);
		String s1t4 = stage1.canGet(target4);
		assertNull(s1t4);
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Timeout(value = 150, unit = TimeUnit.MILLISECONDS) @Order(2) 
	@Graded(description="NumerCrossWord_Stage2:canGet()", marks=4)
	public void testCanGetStage2() {
		String s2t1 = stage2.canGet(target1);
		assertNotNull(s2t1);
		s2t1 = s2t1.replaceAll("\n","").trim();
		assertEquals("[0,0] Right:(((0)-3)+5)+7[0,2] Right:(((0)+7)-5)+7[0,3] Down:(((0)+5)-2)+6[0,4] Down:((((0)+7)-6)+1)+7[1,0] Down:(((0)+6)+6)-3[1,2] Right:(((0)+5)-2)+6[1,4] Down:((((0)+6)-1)+7)-3[2,0] Down:((0)+6)+3[2,2] Down:(((0)+5)-3)+7[2,4] Down:(((0)-1)+7)+3[3,0] Right:(((0)+3)+9)-3[3,1] Right:(0)+9[3,3] Right:(0)+9[4,0] Right:((0)+4)+5[4,1] Right:(((0)+5)+7)-3", s2t1);
		String s2t2 = stage2.canGet(target2);
		assertNotNull(s2t2);
		s2t2 = s2t2.replaceAll("\n","").trim();
		assertEquals("[0,0] Right:((((0)+3)+5)+7)+5[0,1] Down:(((((0)+5)+5)+6)+9)-5[0,2] Down:((((0)+7)+5)+5)+3[1,0] Right:(((((0)+6)+5)+5)-2)+6[1,1] Down:(((0)+5)+6)+9[1,2] Down:((((0)+5)+5)+3)+7[1,3] Down:((((0)+2)+6)+9)+3[2,1] Down:(((0)+6)+9)+5", s2t2);
		String s2t3 = stage2.canGet(target3);
		assertNull(s2t3);
		String s2t4 = stage2.canGet(target4);
		assertNull(s2t4);
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Timeout(value = 200, unit = TimeUnit.MILLISECONDS) @Order(3) 
	@Graded(description="NumerCrossWord_Stage3:canGet()", marks=4)
	public void testCanGetStage3() {
		String s3t1 = stage3.canGet(target1);
		assertNotNull(s3t1);
		s3t1 = s3t1.replaceAll("\n","").trim(); 
		assertEquals("[0,0] Right:(((0)-3)+5)+7[0,1] Down:(((((0)+5)/5)-6)+9)+5[0,2] Right:(((0)+7)-5)+7[0,3] Down:((((0)+5)+2)-6)*9[0,4] Down:(((((0)+7)+6)*1)-7)+3[1,0] Right:(((((0)+6)+5)-5)/2)+6[1,1] Right:((((0)+5)/5)+2)+6[1,2] Right:(((0)+5)-2)+6[1,3] Down:((((0)+2)*6)-9)*3[1,4] Down:((((0)+6)-1)+7)-3[2,0] Right:(((((0)+6)+6)*5)/6)-1[2,2] Down:(((0)+5)-3)+7[2,3] Down:(((0)-6)+9)*3[2,4] Down:(((0)-1)+7)+3[3,0] Right:(((0)+3)+9)-3[3,1] Right:(0)+9[3,3] Right:(0)+9[4,0] Right:((0)+4)+5[4,1] Right:(((0)+5)+7)-3[4,3] Right:((0)+3)*3", s3t1);
		String s3t2 = stage3.canGet(target2);
		assertNotNull(s3t2);
		s3t2 = s3t2.replaceAll("\n","").trim();
		assertEquals("[0,0] Right:((((0)+3)+5)+7)+5[0,1] Down:(((((0)+5)+5)+6)+9)-5[0,2] Down:((((0)+7)+5)+5)+3[0,4] Down:((((0)+7)+6)*1)+7[1,0] Right:(((((0)+6)+5)+5)-2)+6[1,1] Right:(((0)+5)+5)*2[1,2] Down:((((0)+5)+5)+3)+7[1,3] Down:((((0)+2)+6)+9)+3[2,1] Down:(((0)+6)+9)+5[3,0] Right:(((((0)+3)+9)*3)-9)-7[3,1] Right:((((0)+9)/3)*9)-7[3,2] Right:(((0)+3)*9)-7[4,0] Right:(((((0)+4)+5)*7)-3)/3", s3t2);
		String s3t3 = stage3.canGet(target3);
		assertNotNull(s3t3);
		s3t3 = s3t3.replaceAll("\n","").trim();
		assertEquals("[0,1] Down:(((((0)+5)*5)+6)+9)*5", s3t3);
		String s3t4 = stage3.canGet(target4);
		assertNull(s3t4);
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Timeout(value = 400, unit = TimeUnit.MILLISECONDS) @Order(4) 
	@Graded(description="NumerCrossWord_Stage4:canGet()", marks=4)
	public void testCanGetStage4() {
		String s4t1 = stage4.canGet(target1);
		assertNotNull(s4t1);
		s4t1 = s4t1.replaceAll("\n","").trim();
		assertEquals("[0,0] Right:(((0)-3)+5)+7((((0)-3)+5)*7)-5[0,0] Down:((0)+3)+6((((0)+3)-6)+6)*3((((0)+3)*6)-6)-3(((((0)+3)*6)-6)*3)/4(((((0)+3)*6)*6)/3)/4((((0)+3)*6)/6)*3(((0)-3)+6)+6[0,1] Down:(((((0)+5)/5)-6)+9)+5(((((0)-5)/5)+6)+9)-5(((((0)-5)/5)+6)*9)/5[0,2] Right:(((0)+7)-5)+7[0,2] Down:(((((0)+7)+5)*5)+3)/7((((0)-7)+5)+5)*3[0,3] Down:((((0)+5)+2)-6)*9(((0)+5)-2)+6(((((0)+5)-2)-6)+9)+3(((((0)+5)-2)*6)+9)/3((((0)+5)-2)*6)-9(((((0)-5)+2)+6)+9)-3(((((0)-5)+2)+6)*9)/3[0,4] Down:(((((0)+7)+6)*1)-7)+3(((((0)+7)+6)/1)-7)+3((((0)+7)-6)+1)+7(((((0)+7)*6)*1)/7)+3(((((0)+7)*6)/1)/7)+3(((((0)-7)+6)*1)+7)+3(((((0)-7)+6)/1)+7)+3[1,0] Right:(((((0)+6)+5)-5)/2)+6(((((0)+6)-5)+5)/2)+6(((((0)+6)-5)*5)-2)+6(((((0)+6)*5)/5)/2)+6[1,0] Down:(((0)+6)+6)-3((((0)+6)+6)*3)/4[1,1] Right:((((0)+5)/5)+2)+6[1,1] Down:(((0)-5)+6)*9[1,2] Right:(((0)+5)-2)+6[1,2] Down:((((0)-5)/5)+3)+7[1,3] Down:((((0)+2)*6)-9)*3[1,4] Down:((((0)+6)-1)+7)-3[2,0] Right:(((((0)+6)+6)*5)/6)-1(((((0)-6)/6)+5)+6)-1[2,0] Down:((0)+6)+3[2,2] Down:(((0)+5)-3)+7[2,3] Down:(((0)-6)+9)*3[2,4] Down:(((0)-1)+7)+3[3,0] Right:(((0)+3)+9)-3((((0)+3)*9)*3)/9(((0)+3)*9)/3(((0)-3)+9)+3((((0)-3)+9)*3)-9(((((0)-3)+9)*3)/9)+7[3,1] Right:(0)+9[3,1] Down:(0)+9[3,3] Right:(0)+9[3,3] Down:(0)+9[4,0] Right:((0)+4)+5((((0)+4)-5)+7)+3(((((0)+4)-5)+7)-3)*3((((0)+4)*5)+7)/3[4,1] Right:(((0)+5)+7)-3((((0)-5)+7)*3)+3[4,3] Right:((0)+3)*3", s4t1);
		String s4t2 = stage4.canGet(target2);
		assertNotNull(s4t2);
		s4t2 = s4t2.replaceAll("\n","").trim();
		assertEquals("[0,0] Right:((((0)+3)+5)+7)+5(((((0)+3)*5)+7)+5)-7(((((0)+3)*5)-7)+5)+7[0,0] Down:(((((0)+3)+6)+6)/3)*4[0,1] Down:(((((0)+5)+5)+6)+9)-5(((((0)+5)-5)+6)+9)+5(((((0)+5)/5)-6)+9)*5(((((0)+5)/5)*6)+9)+5(((((0)-5)+5)+6)+9)+5[0,2] Down:((((0)+7)+5)+5)+3((((0)+7)+5)*5)/3(((((0)+7)-5)*5)+3)+7(((((0)+7)*5)-5)-3)-7[0,4] Down:((((0)+7)+6)*1)+7((((0)+7)+6)/1)+7[1,0] Right:(((((0)+6)+5)+5)-2)+6[1,1] Right:(((0)+5)+5)*2[1,1] Down:(((0)+5)+6)+9[1,2] Down:((((0)+5)+5)+3)+7[1,3] Down:((((0)+2)+6)+9)+3[2,1] Down:(((0)+6)+9)+5[3,0] Right:(((((0)+3)+9)*3)-9)-7(((((0)+3)+9)/3)+9)+7(((((0)-3)+9)-3)*9)-7(((((0)-3)+9)*3)+9)-7[3,1] Right:((((0)+9)/3)*9)-7[3,2] Right:(((0)+3)*9)-7[4,0] Right:(((((0)+4)+5)*7)-3)/3((0)+4)*5", s4t2);
		String s4t3 = stage4.canGet(target3);
		assertNotNull(s4t3);
		s4t3 = s4t3.replaceAll("\n","").trim();
		assertEquals("[0,1] Down:(((((0)+5)*5)+6)+9)*5", s4t3);
		String s4t4 = stage4.canGet(target4);
		assertNull(s4t4);
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
