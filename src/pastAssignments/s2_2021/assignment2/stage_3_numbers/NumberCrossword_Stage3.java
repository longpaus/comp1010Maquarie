package pastAssignments.s2_2021.assignment2.stage_3_numbers;

//Complete this (successfully) before moving to NumberCrossword_Stage4
public class NumberCrossword_Stage3 {
	public int[][] board;

	/**
	 * 
	 * @param n assume n > 0
	 */
	public NumberCrossword_Stage3(int n) {
		board = new int[n][n];
		for(int i=0; i < board.length; i++) {
			for(int k=0; k < board.length; k++) {
				board[i][k] = (int)((Math.random()*9))+1;
			}
		}
	}

	/**
	 * 
	 * @param data assume it represents a square matrix with at least one row
	 */
	public NumberCrossword_Stage3(int[][] data) {
		board = new int[data.length][data.length];
		for(int i=0; i < board.length; i++) {
			for(int k=0; k < board.length; k++) {
				board[i][k] = data[i][k];
			}
		}
	}

	public String toString() {
		String result = "";
		for(int i=0; i < board.length; i++) {
			for(int k=0; k < board.length; k++) {
				result+=board[i][k]+" ";
			}
			result+="\n";
		}
		return result;
	}

	/**
	 * 
	 * @param target
	 * @return same as stage 2, except you can use addition, subtraction,
	 * multiplication and division (in that order). 
	 * 
	 * with division there must not be any remainder.
	 * 
	 * so (3+9)/4 is allowed
	 * (3+9)/5 is NOT allowed
	 */
	public String canGet(int target) {
		String result = "";
		for(int row=0; row < board.length; row++) {
			for(int column=0; column < board.length; column++) {
				String temp = canGetRow(target, 0, row, column, "0");
				if(temp!=null) {
					result = result + "["+row+","+column+"] Right:\n"+temp + "\n";
				}
				else {
					temp = canGetColumn(target, 0, row, column, "0");
					if(temp!=null) {
						result = result + "["+row+","+column+"] Down:\n"+temp + "\n";
					}
				}
			}
		}
		if(result.isEmpty())
			return null;
		return result;
	}

	private String canGetRow(int target, int soFar, int row, int col, String result) {
		if(soFar == target) {
			return result+"\n";
		}
		if(col >= board.length) {
			return null;
		}
		String status = canGetRow(target, soFar + board[row][col], row, col+1, "("+result+")+"+board[row][col]);
		if(status != null) {
			return status;
		}
		status = canGetRow(target, soFar - board[row][col], row, col+1, "("+result+")-"+board[row][col]);
		if(status != null) {
			return status;
		}
		if(soFar == 0) { //no need to multiply/divide when current answer is 0
			return null;
		}
		status = canGetRow(target, soFar * board[row][col], row, col+1, "("+result+")*"+board[row][col]);
		if(status != null) {
			return status;
		}
		if(soFar%board[row][col] == 0) {
			status = canGetRow(target, soFar / board[row][col], row, col+1, "("+result+")/"+board[row][col]);
			if(status != null) {
				return status;
			}
		}
		return null;
	}

	private String canGetColumn(int target, int soFar, int row, int col, String result) {
		if(soFar == target) {
			return result+"\n";
		}
		if(row >= board.length) {
			return null;
		}
		String status = canGetColumn(target, soFar + board[row][col], row+1, col, "("+result+")+"+board[row][col]);
		if(status != null) {
			return status;
		}
		status = canGetColumn(target, soFar - board[row][col], row+1, col, "("+result+")-"+board[row][col]);
		if(status != null) {
			return status;
		}
		if(soFar == 0) { //no need to multiply/divide when current answer is 0
			return null;
		}
		status = canGetColumn(target, soFar * board[row][col], row+1, col, "("+result+")*"+board[row][col]);
		if(status != null) {
			return status;

		}
		if(soFar%board[row][col] == 0) {
			status = canGetColumn(target, soFar / board[row][col], row+1, col, "("+result+")/"+board[row][col]);
			if(status != null) {
				return status;
			}
		}
		return null;
	}

	public static void main(String[] args) {
		//we will use other tests too!
		int[][] data = {{3, 5, 7, 5, 7}, 
				{6, 5, 5, 2, 6},
				{6, 6, 5, 6, 1},
				{3, 9, 3, 9, 7},
				{4, 5, 7, 3, 3}};
		NumberCrossword_Stage3 c = new NumberCrossword_Stage3(data);
		//NumberCrossword_Stage2 c = new NumberCrossword_Stage2(8);
		System.out.println(c);
		int target = 9;
		//int target = (int)(Math.random() * 100);
		String result = c.canGet(target);
		if(result != null) {
			System.out.println("Target "+target+"\n\n"+result);
		}
		else {
			System.out.println("Target "+target+" could not be constructed");	
		}
	}
}
