//this is a class which I use for working with a single case
class SingleCase {
	int numMembers;
	Members [] value;
	int biggestX = 0;
	int biggestY = 0;
	int meetX = 0;
	int meetY = 0;
	int shortDistance = 0;
	
	//contructor which basically initializes all the members' locations
	public SingleCase(String input){
		//finding out how many members there are
		numMembers = Integer.parseInt(input.substring(0,input.indexOf(" ")));
		value = new Members [numMembers];
		
		//working with the string to extract the locations of each member
		int num = 0;
		input = input.substring(input.indexOf(" ") + 1);
		while(num < numMembers){
			int pos = input.indexOf(" ");
			if(pos == -1){
				pos = input.length();
			}
			
			//x value of the member
			int xval = Integer.parseInt(input.substring(0,pos));
			
			//checks for a smaller x value
			if(xval > biggestX){
				biggestX = xval;
			}
			
			input = input.substring(input.indexOf(" ") + 1);
			pos = input.indexOf(" ");
			if(pos == -1){
				pos = input.length();
			}
			
			//y value of the member
			int yval = Integer.parseInt(input.substring(0,pos));
			
			//checks for a smaller y value
			if(yval > biggestY){
				biggestY = yval;
			}
			
			//initializes a member with the corresponding xy coordinates
			value[num] = new Members(xval, yval);
			input = input.substring(input.indexOf(" ") + 1);
			num++;
		}
		FindMeetingPoint();
	}
	
	//finds the meeting point by comparing all the distances each member has to travel
	public void FindMeetingPoint(){
		int distance = 999999999;
		//x value
		int totalDistance = 0;	
		for(int x = 0; x <= biggestX; x++){
			//y value
			for(int y = 0; y <= biggestY; y++){
				//each member
				for(int num = 0; num < value.length; num++){
					totalDistance += value[num].getDistance(x, y);
				}
				//if the total distance for all the members is smaller than the previous smallest distance, changes the smallest distance and xy coordinates
				if(totalDistance < distance){
					distance = totalDistance;
					meetX = x;
					meetY = y;
				}
				totalDistance = 0;
			}
		}
		shortDistance = distance;
	}
}
