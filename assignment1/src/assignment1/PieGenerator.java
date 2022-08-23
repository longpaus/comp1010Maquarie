package assignment1;

import processing.core.*; 

public class PieGenerator extends PApplet {
	//Your job is to complete the following five functions (sum, highestIndex, smallestIndex, mySort, removeItem)
	//You cannot use functions from outside the class (so no functions from Arrays).
	//You can add other functions in this class if you want, and call them from your functions.
	
	/**
	 * 
	 * @param data
	 * @return the sum of all the items in the array passed
	 * return 0 if the array passed is null
	 * See the unit tests for further clarification.
	 */
	public int sum(int[] data) {
		if(data == null) {
			return 0;
		}
		int sum = 0;
		for(int num : data) {
			sum += num;
		}
		return sum; //to be completed
	}

	/**
	 * 
	 * @param data
	 * @return the first index of the highest item in the array passed
	 * For example, if the array is {50, 70, 20, 90, 30, 90, 20}, return 3
	 * as the highest item (90) is first at index 3
	 * return -1 if the array passed is null or empty.
	 * See the unit tests for further clarification.
	 */
	public int highestIndex(int[] data) {
		return 0; //to be completed
	}

	/**
	 * 
	 * @param data
	 * @return the first index of the smallest item in the array passed
	 * For example, if the array is {50, 70, 20, 90, 30, 90, 20}, return 2
	 * as the smallest item (20) is first at index 2
	 * return -1 if the array passed is null or empty
	 * See the unit tests for further clarification.
	 */
	
	public static int findSmallestValue(int[] data) {
		int smallestValue = data[0];
		for(int num : data){
			if(num < smallestValue){
				smallestValue = num;
			}
		}
		return smallestValue;
	}
	
	public int smallestIndex(int[] data) {
		if(data == null||data.length == 0){
			return -1;
		}
		int smallestValue = findSmallestValue(data);
		for(int i = 0; i < data.length; i++){
			if(data[i] == smallestValue){
				return i;
			}
		}
		return 0; //to be completed
	}

	/**
	 * sort the array passed in ascending order
	 * @param data
	 * ensure the array is not null before performing any operation.
	 * if the array is null, return without doing anything.
	 * See the unit tests for further clarification.
	 */
	public void mySort(int[] data) {
		if(data == null) {
			return;
		}
		for(int i = 0; i + 1< data.length; i++){
			if(data[i] > data[i + 1]){
				int tmp = data[i];
				data[i] = data[i +1];
				data[i + 1] = tmp;
				i = -1;
			}
		}
	}

	/**
	 * 
	 * @param data
	 * @param idx
	 * @return the array with item at index idx removed.
	 * Note that if the index is out of bounds, the original array should be returned.
	 * return null if the array passed is null.
	 * See the unit tests for further clarification.
	 */
	public int[] removeItem(int[] data, int idx) {
		if(data == null) {
			return null;
		}
		if(idx > data.length - 1 || data.length <= 0|| idx < 0){
			return data;
		}
		int[] newArr = new int[data.length - 1];
		for(int i = 0,index = 0; i < data.length; i++){
			if(i == idx){
				continue;

			}
			newArr[index++] = data[i];
		}
		return newArr; //to be completed
	}
	
	//FEEL FREE TO UPDATE THE VALUES OF THIS ARRAY :)
	int[] sales = {50, 70, 20, 90, 30, 80, 10, 60};

	
	//DO NOT CHANGE ANY CODE BELOW THIS COMMENT	
	
	int[] colours = new int[sales.length];
	int selected = -1;

	public void drawPie(int[] data, int[] colours) {
		int total = sum(data);
		int minIndex = smallestIndex(data);
		int maxIndex = highestIndex(data);
		float factor = 2*PI/total;
		float angle = 0;
		for (int i=0; i < data.length; i++) {
			noStroke();
			if (i != minIndex && i != maxIndex) {
				fill(colours[i]);
				textSize(16);
			} else {
				if (i == minIndex) {
					fill(0, 255, 0);
					stroke(0);
					strokeWeight(3);
					textSize(12);
				}
				if (i == maxIndex) {
					fill(0, 0, 255);
					stroke(0);
					strokeWeight(3);
					textSize(24);
				}
			}
			if (i == selected) {
				fill(255, 0, 0);
				strokeWeight(3);
				textSize(20);
			}
			if (i == maxIndex || i == minIndex) {
				arc(width/2, height/2, width/2, height/2, angle, angle + data[i]*factor, PIE);
			} else {
				arc(width/2, height/2, width/2, height/2, angle, angle + data[i]*factor);
			}
			float x = width/2 + (width/4+40)*cos(angle + data[i]*factor/2);
			float y = width/2 + (width/4+40)*sin(angle + data[i]*factor/2);
			fill(0);
			text(data[i], x, y);
			angle+=data[i]*factor;
		}
	}

	public void setColours(int[] c) {
		for (int i=0; i < c.length; i++) {
			c[i] = color(random(100, 255), random(100, 255), random(100, 255));
		}
	}

	public void setup() {

		setColours(colours);
		reset();
	}

	public void reset() {
		background(255);
		checkSelectedSlice(sales);
		drawPie(sales, colours);
	}

	public void checkSelectedSlice(int[] data) {
		selected = -1;
		if (dist(mouseX, mouseY, width/2, height/2) < width/4) {
			int total = sum(data);
			float factor = 2*PI/total;
			float dx = mouseX - width/2;
			float dy = mouseY - height/2;
			float theta = atan2(-dy, -dx);
			float angle = -PI;
			for (int i=0; i < data.length; i++) {
				float angle2 = angle+data[i]*factor;
				if (theta >= angle && theta < angle2) {
					selected = i;
					break;
				}
				angle = angle2;
			}
		}
	}

	public void draw() {
		selected = -1;
		reset();
	}

	public void keyPressed() {
		mySort(sales);
	}

	public void mouseClicked() {
		if (selected != -1) {
			sales = removeItem(sales, selected);
			selected = -1;
		}
	}
	public void settings() {  size(500, 500); }
	static public void main(String[] passedArgs) {
		String[] appletArgs = new String[] { "assignment1.PieGenerator" };
		if (passedArgs != null) {
			PApplet.main(concat(appletArgs, passedArgs));
		} else {
			PApplet.main(appletArgs);
		}
	}
}
