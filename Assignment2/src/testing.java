//testing class
public class testing {
	public static void main (String [] args){
		Sudoku s = new Sudoku();
		String [] lines = new String [9];
		lines[0] = "248395716";
		lines[1] = "571 6|-283-49";
		lines[2] = "936 7|41-582";
		lines[3] = "682 5-|3 9174";
		lines[4] = "35- 917 4628";
		lines[5] = "71----48-6-2 953";
		lines[6] = "86-3 -41-7295";
		lines[7] = "1-952- 86-4-37";
		lines[8] = "420000000";
		s.fancyFill(lines);
		s = s.solve(s);
		s.show();
	}
}
