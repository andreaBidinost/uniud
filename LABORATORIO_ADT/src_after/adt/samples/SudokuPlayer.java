package adt.samples;

public class SudokuPlayer {

	public static void main(String[] args) {
		SudokuNotADT sudokuNotAdt = new SudokuNotADT(5);
		
		//rischio enorme: lascio il controllo e la modifica nelle mani dell'utilizzatore
		sudokuNotAdt.gameField[0][0] = 9;
		
		sudokuNotAdt.difficulty = 100;
		
		SudokuADT sudokuAdt = new SudokuADT();
		//stessa cosa ma passo per un metodo pubblico
		sudokuAdt.insertNumber(0, 0, 9);
		
		
		SudokuADTImmutable sudokuImmutable = new SudokuADTImmutable();
		sudokuImmutable= sudokuImmutable.insertNumber(0, 0,9);
		sudokuImmutable = sudokuImmutable.insertNumber(0, 1, 5);
		
		//vantaggio di una classe immutable: il codice è più leggibile
		sudokuImmutable = sudokuImmutable.insertNumber(5, 5, 5).insertNumber(7, 7, 8);
		
	}
}
