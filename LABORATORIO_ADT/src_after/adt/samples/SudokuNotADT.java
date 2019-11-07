package adt.samples;

/*
 * This class is not an ADT.
 * Why?
 */
public class SudokuNotADT {
	
	Integer[][] gameField = new Integer[9][9];
	int difficulty = 1;
	boolean isSolveable;
	boolean isSolved;
	
	/**
	 * Creates a standard sudoku game field with 25 numbers
	 */
	public SudokuNotADT() {
		//creates a sudoku field with standard difficulty
		isSolveable = true;
		isSolved = false;
	}
	
	/**
	 * Creates a sudocu game field based on given difficulty
	 * @param diff difficulty of the game
	 */
	public SudokuNotADT(int diff) {
		//creates a sudoku field with specified difficulty
		difficulty = diff;
		isSolveable = true;
		isSolved = false;
	}
	
	/**
	 * 
	 * @return true if actual game field is resolveable, false otherwise
	 */
	public boolean isSolveable() {
		//evaluate if is solveable and, change isSolveable value and...
		return isSolveable;
	}
	
	/**
	 * 
	 * @return true if actual game field is totally filled with right numbers, false otherwise
	 */
	public boolean isSolved() {
		//evaluate if is the gamefield is totally field and if the solution is the right one and...
		return isSolved;
	}
}
