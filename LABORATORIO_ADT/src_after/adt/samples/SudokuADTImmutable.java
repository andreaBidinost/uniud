package adt.samples;

/**
 * This class represents a sudoku game field that is immutable
 * @author AndreaBidinost
 *
 */
public class SudokuADTImmutable {
	//Tutti gli attributi sono private
	private final Integer[][] gameField = new Integer[9][9];
	private final int difficulty;
	private boolean isSolveable;
	private boolean isSolved;
	
	/**
	 * Creates a standard sudoku game field with 25 numbers
	 */
	public SudokuADTImmutable() {
		//creates a sudoku field with standard difficulty
		//the filed will not be changed (here)
		difficulty = 1;
		isSolveable = checkIfSolveable();
		isSolved = checkIfSolved();
		
		//isSolveable e isSolved non vengono più modificati
	}
	
	/**
	 * Creates a sudocu game field based on given difficulty
	 * @param diff difficulty of the game
	 */
	public SudokuADTImmutable(int diff) {
		//creates a sudoku field with specified difficulty
		//the filed will not be changed (here)
		difficulty = diff;
		isSolveable = checkIfSolveable();
		isSolved = checkIfSolved();
	}
	
	/**
	 * OBSERVER
	 * @return true if actual game field is resolveable, false otherwise
	 */
	public boolean isSolveable() {
		
		return isSolveable;
	}
	
	/**
	 * OBSERVER
	 * @return true if actual game field is totally filled with right numbers, false otherwise
	 */
	public boolean isSolved() {
		return isSolved;
	}
	
	private boolean checkIfSolveable() {
		//controllo se il sudoku è risolvibile
	}
	
	private boolean checkIfSolved() {
		//controllo se il sudoku è risolto
	}
	
	/**
	 * PRODUCER
	 * Classe immutable --> il modificatore (mutuator) restituisce ora un nuovo oggetto della
	 * stessa classe. Diventa un produttore (producer)
	 */
	public SudokuADTImmutable insertNumber(int i, int j, int newValue) {
		
		//devo controllare che 1 < newValue < =9
		//devo controllare che 0 < i,j < 9
		//controllo che nella posizione i,j ci sia null
		
		//Meglio delegare la creazione del nuovo oggetto ad un costruttore dedicato
		//(riceve il vecchio oggetto e ne crea una copia)
		SudokuADTImmutable newSudoku = new SudokuADTImmutable();
		newSudoku.difficulty = this.difficulty;
		newSudoku.isSolveable = this.isSolveable;
		newSudoku.isSolved = this.isSolved;
		
		//Questa istruzione NON copia la matrice, ma solo il valore del puntatore
		//newSudoku.gameField = gameField;
		
		//Questo è il modo corretto di copiare una matrice		
		for(int r=0; r<9; r++) {
			for(int c=0; c<9; c++) {
				newSudoku.gameField[r][c] = gameField[r][c];
			}
		}
		
		newSudoku.gameField[i][j] = newValue;
		return newSudoku;
		
		
	}
}





