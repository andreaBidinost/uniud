package adt.samples;

public class SudokuADT {
	//Tutti gli attributi sono private
	private Integer[][] gameField = new Integer[9][9];
	private int difficulty = 1;
	private boolean isSolveable;
	private boolean isSolved;
	
	/**
	 * Creates a standard sudoku game field with 25 numbers
	 */
	public SudokuADT() {
		//creates a sudoku field with standard difficulty
		isSolveable = true;
		isSolved = false;
	}
	
	/**
	 * Creates a sudocu game field based on given difficulty
	 * @param diff difficulty of the game
	 */
	public SudokuADT(int diff) {
		//creates a sudoku field with specified difficulty
		difficulty = diff;
		isSolveable = true;
		isSolved = false;
	}
	
	/**
	 * OBSERVER
	 * @return true if actual game field is resolveable, false otherwise
	 */
	public boolean isSolveable() {
		//evaluate if is solveable and, change isSolveable value and...
		return isSolveable;
	}
	
	/**
	 * OBSERVER
	 * @return true if actual game field is totally filled with right numbers, false otherwise
	 */
	public boolean isSolved() {
		//evaluate if is the gamefield is totally field and if the solution is the right one and...
		return isSolved;
	}
	
	/**
	 * MUTUATOR
	 */
	public void insertNumber(int i, int j, int newValue) {
		
		//devo controllare che 1 < newValue < =9
		//devo controllare che 0 < i,j < 9
		//controllo che nella posizione i,j ci sia null
		gameField[i][j] = newValue;
	}
}









