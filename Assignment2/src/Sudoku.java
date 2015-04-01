import java.util.*;

public class Sudoku {
	int n = 3;
	int [] [] board;
	int size = 0;
	int subsize = 0;
	
	//default constructor makes a 9x9 sudoku and initializes each square to 0
	public Sudoku(){
		size = n*n;
		subsize = n;
		board = new int [n*n] [n*n];
		
		for(int i = 0; i < size; i++){
			for(int j = 0; j < size; j++){
				board [i] [j] = 0;
			}
		}
	}
	
	//sets the value of board [i] [j] equal to the parameter 'val'
	public void setSquare(int i, int j, int val){
		board[i][j] = val;
	}
	
	//returns the value of the square at row 'i' and column 'j'
	public int getSquare(int i, int j){
		return board[i][j];
	}
	
	//method that takes an array of strings containing the numbers for the sudoku and filling in the board
	public void fill(String[] lines){
		size = lines[0].length();
		subsize = (int) Math.sqrt(size);
		board = new int [size][size];
		
		for(int i = 0; i < size; i++){
			for(int k = 0; k < size; k++){
				board[i][k] = Integer.parseInt(lines[i].substring(k, k + 1));
			}
		}
	}
	
	//same as the fill method above, except it ignores the following characters: "-+| "
	public void fancyFill(String[] lines){
		String [] stlines = new String [lines.length];
		int blanks = 0;
		
		for(int i = 0; i < stlines.length; i++){
			stlines[i] = "";
		}
		
		//gets rid of the unwanted characters
		StringTokenizer st;		
		for(int i = 0; i < lines.length; i++){
			String input = "";
			
			st = new StringTokenizer(lines[i], "-+| ");
			while(st.hasMoreElements()){
				input += st.nextToken();
			}
			if(input.equals("")){
				blanks++;
			}
			else{
				stlines[i-blanks] = input;
			}
		}
		
		size = stlines[0].length();
		subsize = (int) Math.sqrt(size);
		board = new int [size][size];
		
		//assigns the values to the board
		for(int i = 0; i < size; i++){
			for(int k = 0; k < size; k++){	
				board[i][k] = Integer.parseInt(stlines[i].substring(k, k + 1));
			}
		}
	}
	
	
	//prints out the sudoku
	public void show(){
		for(int r = 0; r < size; r++){
			for(int c = 0; c < size; c++){
				//checks if a | needs to be printed
				if(c % subsize == 0 && c != 0){
					System.out.print("| ");
				}
				//checks if the value is 0, if so prints ". "
				if(board[r][c] == 0){
					System.out.print(". ");
				}
				//prints out the value if board [r][c] != 0
				else{
					System.out.print(board[r][c] + " ");
				}
			}
			System.out.println();
			
			//prints the row divider if needed
			if((r+1) % subsize == 0 && r != size - 1){
				for(int k = 0; k < subsize; k++){
					if(k == 0 || k == subsize - 1){
						for(int i = 0; i < subsize; i++){
							System.out.print("--");
						}
					}
					else{
						for(int i = 0; i < subsize; i++){
							System.out.print("--");
						}
						System.out.print("-");
					}
					//prints the plus sign if needed
					if(k < subsize-1){
						System.out.print("+");
					}
				}
				System.out.println();
			}
		}
	}
	
	public boolean isFilled(){
		//checks if the sudoku is filled
		for(int r = 0; r < size; r++){
			for(int c = 0; c < size; c++){
				if(board[r][c] == 0 || board[r][c] > size){
					return false;
				}
			}
		}
		return true;
	}
	
	//determines if the sudoku given is a valid solution
	//returns true if it is, false otherwise
	public boolean isSolution(){
		int [] list = new int [size];
		boolean check = false;
		if(!isFilled()){
			return false;
		}
		
		
		//checks rows
		for(int r = 0; r < size; r++){
			for(int c = 0; c < size; c++){
				list[c] = board[r][c];
			}
			check = checkArray(list);
			if(!check){
				return false;
			}
		}
		
		//checks columns
		for(int r = 0; r < size; r++){
			for(int c = 0; c < size; c++){
				list[c] = board[c][r];
			}
			check = checkArray(list);
			if(!check){
				return false;
			}
		}
		
		//checks squares
		for(int s = 0; s < size; s++){
			int index = 0;
			for(int r = (s/subsize)*subsize; r < (s/subsize)*subsize + subsize; r++){
				for(int c = (s % subsize)*subsize; c < (s % subsize)*subsize + subsize; c++){
					list[index] = board[c][r];
					index++;
				}
			}
			check = checkArray(list);
			if(!check){
				return false;
			}
		}
		return true;
	}
	
	//takes an array of integers and checks if the numbers [1,size] are all in it
	//if they are, returns true
	//if not, returns false
	public boolean checkArray(int [] list){
		
		for(int i = 1; i <= list.length; i++){
			boolean found = false;
			
			for(int k = 0; k < list.length && !found; k++){
				if(list[k] == i){
					found = true;
				}
			}

			if(!found){
				return false;
			}
		}
		return true;
	}
	
	//given a input sudoku, it solves it, and returns the solved sudoku or returns null if it cannot be solved
	//note: very inefficient
	public Sudoku solve(Sudoku s){
		//find empty cell
		int row = blankrow(s);
		int column = blankcolumn(s);
		
		//if no empty cells, checks if it is a solution
		if(row == -1 && !s.isSolution()){
			return null;
		}
		
		//inputs a value into the empty cells then recursively calls the method while the blank filled
		for(int num = 1; num <= size; num++){
			s.board[row][column] = num;
			if(!s.isSolution()){
				solve(s);
				//check if it's been solved again
				if(s.isSolution() == true){
					return s;
				}
				//set the blank back to zero if all the values from 1 to size do not work
				s.board[row][column] = 0;
			}
			else{
				return s;
			}
			
		}
		
		return null;
	}
	
	//finds the row value of the first blank in the sudoku
	//written to make the solve() method simpler
	public int blankrow(Sudoku s){
		for(int r = 0; r < size; r++){
			for(int c = 0; c < size; c++){
				if(s.board[r][c] == 0){
					return r;
				}
			}
		}
		return -1;
	}

	//finds the column value of the first blank in the sudoku
	//written to make the solve() method simpler
	public int blankcolumn(Sudoku s){
		for(int r = 0; r < size; r++){
			for(int c = 0; c < size; c++){
				if(s.board[r][c] == 0){
					return c;
				}
			}
		}
		return -1;
	}
}
