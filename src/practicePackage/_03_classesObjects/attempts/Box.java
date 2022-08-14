package practicePackage._03_classesObjects.attempts;

/**
 * 
 * @author gauravgupta
 * Box represents a three dimensional cuboid. We use the front perspective
 * such that 
 * the side from front to back is depth
 * the side from top to bottom is height
 * the side from left to right is width
 * 
 * IMPORTANT: Do NOT override equals()
 */
public class Box {
	public int depth, height, width;
	
	


	/**
	 * May be helpful for other methods
	 * 
	 * NOTE: if any of the values are less than 1, they should be made 1 before copying into 
	 * corresponding instance variable
	 * @param d (for depth)
	 * @param h (for height)
	 * @param w (for width)
	 */
	public Box(int d, int h, int w) {
		depth = (d < 1) ? 1 : d;
		height = (h < 1) ? 1 : h;
		width = (w < 1) ? 1 : w;
	}

	/**
	 * May be helpful for other methods
	 * 
	 * copy constructor to create an instance copy of the passed object
	 * @param original
	 */
	public Box(Box original) {
		depth = original.depth;
		height = original.height;
		width = original.width;
	}

	/**
	 * May be helpful for other methods
	 * 
	 * @return the volume of the box
	 */
	public int volume() {
		return height*width*depth;
	}

	
	/**
	 * May be helpful for other methods
	 * 
	 * @param other
	 * @return 1 if calling object is "more than" parameter object
	 * -1 if calling object is "less than" parameter object
	 * 0 if calling object is "equal to" parameter object
	 * comparison criteria: volume -> surface area
	 *
	 */
	
	public int compareTo(Box other) { //volume -> surface area
		if(volume() > other.volume()){
			return 1;
		}
		else if(volume() < other.volume()){
			return -1;
		}
		else{
			return (surfaceArea() > other.surfaceArea()) ? 1 : (surfaceArea() < other.surfaceArea()) ? -1 : 0;
		}
	}

	/**
	 * May be helpful for other methods
	 * 
	 * HD
	 * @param other
	 * @return 1 if calling object is "more than" parameter object
	 * -1 if calling object is "less than" parameter object
	 * 0 if calling object is "equal to" parameter object
	 * comparison criteria: volume -> surface area -> longest sides -> second longest sides -> shortest side
	 */
	public int compareToAdvanced(Box other) { 
		if(compareTo(other) == 1){
			return 1;
		}
		else if (compareTo(other) == -1){
			return -1;
		}
		if(longestSide() > other.longestSide()){
			return 1;
		}
		if(longestSide() < other.longestSide()){
			return -1;
		}
		if(secondLongestSide() > other.secondLongestSide()){
			return 1;
		}
		if(secondLongestSide() < other.secondLongestSide()){
			return -1;
		}
		return (shortestSide() > other.shortestSide()) ? 1 : (shortestSide() < other.shortestSide()) ? -1 : 0;
		
	}

	/**
	 * 
	 * @return the longest side of the box
	 */
	public int longestSide() {
		int[] tmp = {height,width,depth};
		int longest = 1;
		for(int side : tmp){
			if(side > longest){
				longest = side;
			}
		}
		return longest;
	}
	public int secondLongestSide(){
		int[] tmp = {height,width,depth};
		int secondLongest = 1;
		for(int side : tmp){
			if(side > secondLongest && side != longestSide()){
				secondLongest = side;
			}
		}
		return secondLongest;
	}

	public int shortestSide(){
		int[] tmp = {height,width,depth};
		for(int side : tmp){
			if(side != longestSide() && side != secondLongestSide()){
				return side;
			}
		}
		return height;
	} 

	/**
	 * 
	 * @return area of the front (or the back face)
	 */
	public int frontArea() {
		return height*width;
	}

	/**
	 * 
	 * @return the surface area of the box
	 */
	public int surfaceArea() {
		return 2*depth*width + 2*depth*height + 2*height*width; 
	}

	/**
	 * D
	 * @param b
	 * @return true if the box represented by the calling object
	 * can fit inside the box represented by the parameter object, false otherwise.
	 * Note that a box cannot fit inside the box of the same dimension.
	 */
	public boolean canFitInside(Box b) {
		if(height == b.height && width == b.width && depth == b.depth){
			return false;
		}
		if(height <= b.height && width <= b.width && depth <= b.depth){
			return true;
		}
		return false;
	}
}