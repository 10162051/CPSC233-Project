package model;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * 
 * @author Carlene Kalin (10162051)
 *
 */

public class Poll {
	private String name = "Unnamed Poll";
	private Party[] parties;
	private int numberOfParties = 1;
	
	//Create one constructor for the class that takes the name of the poll and the maximum number of 
	//Parties this poll will take as an argument. The maximum number of parties should be at least 1. If an 
	//invalid number is provided, set the maximum number of parties this poll can contain to 10
	public Poll(String name, int numberOfParties) {
		this.name = name;
		if(numberOfParties < 1)
			this.numberOfParties = 10;
		else 
			this.numberOfParties = numberOfParties;
		this.parties = new Party[this.numberOfParties];
	}
	public Poll() {
	}
	

	// addParty which does not return anything and takes an object of type Party as an argument. If 
	//the argument is null, print an error message. Parties are uniquely identified by their name. Only 
	//one party by a given name (not case sensitive) can be in a poll at a time. If the party to add has 
	//the same name as another party already in the parties array, the existing party should be 
	//replaced by the party provided as an argument. If no party with the same name exists in the 
	//poll, this party should be added at the end of the list and the partiesInPoll instance variable 
	//should be incremented by one. If there is no room left in the parties array, print an error 
	//message that the poll is full and no further parties can be added. Do NOT increment 
	//partiesInPoll in this case.
	public void addParty(Party aParty) {
		if (aParty == null) 
			System.out.println("Error");
		else
			this.parties[this.numberOfParties - 1] = aParty;
			this.numberOfParties--;
	}

	
	//Getter Method for name (No Setter)
	public String getPollName() {
		return name;
	}
	//Getter Method for numberOfParties
	public int getNumberOfParties() {
		return numberOfParties;
	}
	
	//getParty which takes the name of the party to find and returns the party in the poll with that 
	//name. If no party of that name exists in the poll this method should return null.
	//?parties[i].getName()==nameParty
	//?return parties[i].getName()
	/**
	 * 
	 * @author This method is edited by Shaohuan Xia
	 * 
	 */
	public Party getParty(String name) {
		Party TheParty = new Party("default");
        for(Party party:parties) {
        	if(party.getName() == name) {
        		TheParty = party;
        	}
        }
        return TheParty;
	}
	
	
	//getPartiesSortedBySeat does not take any arguments and returns an array of Party objects. It 
	//should return all the parties in the poll in sorted order from the party with the most projected 
	//seats to the least projected seats. You may implement your own sort if you wish or use the 
	//static method Array.sort provided by Java. To ensure it sorts the Parties by seat, you will have 
	//to provide as an argument a Comparator that compares Parties by number of projected seats
	public Party[] getPartiesSortedBySeats() {
		ArrayList<String> parties = new ArrayList<String>();
		for (int i = 0; i < parties.size(); i++)
			parties.get(numberOfParties);
			Collections.sort(parties, Collections.reverseOrder());
			return this.parties;
	}

	
	//getPartiesSortedByVote is like the previous method but the list of parties returned is sorted by 
	//projected percentage of votes with the party with the most votes first in the list
	public Party[] getPartiesSortedByVotes() {
		Arrays.sort(parties, Collections.reverseOrder());
		return parties;
	}
	
	//  toString which does not take any arguments and returns something of type String. The string 
	//returned should have multiple lines. The first line is the name of the poll. This is followed by 
	//one line per party in the poll which contains the string representation of the party (retrieved by 
	//called toString on each party).
	//Note that anything between the angle brackets (<>) describes information that should be placed 
	//there. Everything else is the literal character that should be placed there.
	@Override
	public String toString() {
		return String.format( name + ".%n " + parties + ".%n ");
					//‘<name> <newline> 
				   //<string representation of first party> <newline>
				   //<string representation of second party><newline>...’
	}


//Recall that the creation of an array of objects will fill the array with null values. When looping through 
//the array of Party objects, make sure you check if the party is null or not. Make sure to handle null 
//values appropriately. Sometimes a null value means ‘do nothing’. Other times it means an error. If an 
//error is encountered, print an error message. Do NOT end the program. Instead allow the program to 
//continue running as if no error had occurred. A later iteration will manage errors better

    public void setPollName(String PollName) {
    	this.name = PollName;
    }
    
}
