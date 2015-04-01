//seperate class for the members
//has integer values for the xy coordinates of the member and a function getDistance which returns the distance the member is from a specific location
class Members {
	private int x;
	private int y;
	
	//normal constructor
	public Members(int _x, int _y){
		x = _x;
		y = _y;
	}
	
	//returns the distance the member is from a location with coordinates (meetX, meetY)
	public int getDistance(int meetX, int meetY){
		return(Math.abs(x - meetX) + Math.abs(y - meetY));
	}
	
	//returns x and y values
	public int returnX(){ return x; }
	public int returnY(){ return y; }
}
