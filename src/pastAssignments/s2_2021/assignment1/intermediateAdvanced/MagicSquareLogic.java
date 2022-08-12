//NAME
//STUDENT ID
//[] I declare that I haven't seen another person's code, and the submission is entirely your work.
//(put an x inside the square brackets to provide declaration)

//Example:
//Gaurav Gupta
//44040404
//[x] I declare that I haven't seen another person's code, and the submission is entirely your work.

package pastAssignments.s2_2021.assignment1.intermediateAdvanced;

public class MagicSquareLogic {

	// the board variable needs to be public so that
	// it can be accessed by the JUnit test. Please
	// do not modify its visibility.
	public int[][] data;
	public int n;

	/**
	 * @param size - number of rows/columns of the magic squares.
	 * if size is less than 3, set it to 3 before continuing.
	 * if size is more than 7, set it to 7 before continuing.
	 * 
	 * copy (moderated) size into n.
	 * 
	 * instantiate the array to contain size sub-arrays, each containing size items.
	 * populate the array such that it contains each item from 1 to n*n exactly once.
	 * 
	 * items in the array should be sufficiently randomized. for example, if n = 3,
	 * the array should not be {{1,2,3},{4,5,6},{7,8,9}} EVERY TIME.
	 * our tests have a check for that. if the test passes, you are ok. 
	 */
	public MagicSquareLogic(int size) {
		if(size < 3) {
			size = 3;
		}
		if(size > 7) {
			size = 7;
		}
		n = size;
		int val = 1;
		data = new int[n][n];
		for(int i = 0; i < n; i++) {
			for(int k = 0; k < n; k++) {
				data[i][k] = val++;
			}
		}
		for(int i=0; i < n*n; i++) {
			swap((int)(Math.random()*n),(int)(Math.random()*n),(int)(Math.random()*n),(int)(Math.random()*n));
		}
	}

	/**
	 * 
	 * @param i
	 * @param k
	 * @return true if the indices i and k are valid (and false otherwise), 
	 * in that,
	 * the item, data[i][k], if accessed, would not generate ArrayIndexOutOfBoundsException
	 */
	public boolean isValid(int i, int k) {
		return !(i<0 || k<0 || i>=n || k>=n);
	}

	/**
	 * swap 
	 * item at index k1 inside sub-array at index i1,
	 * with
	 * item at index k2 inside sub-array at index i2,
	 * @return true if the indices were valid, and items were swapped,
	 * and false otherwise
	 */
	public boolean swap(int i1, int k1, int i2, int k2) {
		if(isValid(i1,k1) && isValid(i2,k2)) {
			int temp = data[i1][k1];
			data[i1][k1] = data[i2][k2];
			data[i2][k2] = temp;
			return true;
		}
		return false;
	}

	/**
	 * 
	 * @return true if the array data contains each value from 1 to n*n EXACTLY ONCE,
	 * false otherwise
	 */
	public boolean completeSet() {
		boolean[] found = new boolean[n*n];
		for(int i = 0; i < data.length; i++) {
			for(int k = 0; k < data[i].length; k++) {
				if(data[i][k] < 1 || data[i][k] > n*n || found[data[i][k]-1]) {
					return false;
				}
				else { 
					found[data[i][k]-1] = true;
				}
			}
		}
		return true;
	}
	
	/**
	 * 
	 * @return true if the array represents a "completed" magic square.
	 * a magic square is complete if,
	 * the sum of values in first row =
	 * the sum of values in second row =
	 * ...
	 * the sum of values in the last row = 
	 * the sum of values in first column =
	 * the sum of values in second column =
	 * ...
	 * the sum of values in the last column = 	 
	 * the sum of values in the first diagonal = 
	 * the sum of values in the second diagonal
	 *  
	 * this will need some research on your part.
	 * assumption: data represents a square matrix between 3x3 and 7x7.
	 */
	public boolean finished() {
		int magicConstant = n*(n*n+1)/2;

		int totalD1 = 0;
		int totalD2 = 0;

		for(int i=0; i < n; i++) {
			int totalR = 0;
			int totalC = 0;

			for(int k=0; k < n; k++) {
				totalR+=data[i][k];
				totalC+=data[k][i];
			}
			//System.out.println("ROW, COLUMN, TARGET: "+totalR+" "+totalC+" "+magicConstant);


			if(totalR!=magicConstant || totalC!=magicConstant) {
				return false;
			}

			totalD1+=data[i][i];
			totalD2+=data[i][n-i-1];
		}
		//sSystem.out.println(totalD1+" "+totalD2);
		return (totalD1 == magicConstant && totalD2 == magicConstant);
	}
}
