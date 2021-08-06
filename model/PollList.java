package model;
/**
 * 
 * @author Shaohuan Xia
 *
 */


public class PollList {
	private Poll[] polls;
	private int numOfSeats;
	
	/**This is the method using if statement to verdict 
	/*if the arguments are within the limit.
	 * 
	 * @param numOfPolls
	 * @param numOfSeats
	 */
	public PollList(int numOfPolls, int numOfSeats) {
		//if number < 1 then use default.
		if(numOfPolls < 1) {
			polls = new Poll[5];
			
		}
		else {
			polls = new Poll[numOfPolls];
		}
		//if number < 1 then use default.
		if(numOfSeats < 1) {
			this.numOfSeats = 10;
		}
		else {
			this.numOfSeats = numOfSeats;
		}
	}
	
	
	
	/** Getter and setter.
	 * 
	 * @return numOfSeats
	 */
	public int getNumOfSeats() {
		return numOfSeats;
	}
	
	
	
	public Poll[] getPolls() {
		return polls;
	}
    
	
	
	/**This method using if statement and for loop to add a poll to the list.
	 *The first for loop is used to go through the array and check if there is an existing
	 * name inside of it, if so then replace it with the poll which used as an argument.
	 * If the index exceeding the limit then print an error message,else replace the poll
	 * with the first null value which means the end of the elements in the list.
	 * 
	 */
	public void addPoll(Poll aPoll) {
	    int index = 0;
	    // if the poll is null then do not do anything
	    if(aPoll != null) {
	    	//get the poll in the end of the position.
		    for (index = 0; index < polls.length && polls[index] != null; index++) {	
			    if(aPoll.getPollName().equalsIgnoreCase(polls[index].getPollName())) {
				    polls[index] = aPoll;
			    }
		    }
		    //if exceeds the length then print error message.
		    if(index >= polls.length) {
			    System.out.println("Exceeding the limit");
		    }
		    else {
		    	//find the poll
		    	for (index = 0; index < polls.length; index++) {
		    		if(polls[index] == null) {
		    			polls[index] = aPoll;
		    			break;
		    		}
		    	}
		    }
	    }
	    else {
	    	//error message.
	    	System.out.println("Invalid Poll");
	    }
	}
	
	
	
	/**This method using a for loop to get the aggregate data of parties and assign it into the
	 * poll.
	 * @param partyNames
	 * @return The aggregate poll.
	 */
	public Poll getAggregatePoll(String[] partyNames) {
		Poll Aggregate = new Poll("Aggregate",partyNames.length);
		// use for loop to put each new party into the poll. 
		for(String partyname:partyNames) {
			Party NewParty = new Party(partyname);			
			NewParty = getAveragePartyData(partyname);
			Aggregate.addParty(NewParty);
		}
		return Aggregate;
	}
	
	
	
	/**This method using nested loop to check if the party is in each poll.
	 * Both number of seats and percentage of votes will use the same nested loop.
	 * The first for loop is used to go through the poll list to check each poll, and 
	 * the second loop is used to go through the Party list inside the poll to check if
	 * there is a party in party list have the same name of party name inputed as an argument.
	 * If the name is same, it means the party we want to get data is inside the poll thus
	 * denominator + 1 and the corresponding number of seat or percentage of votes will be 
	 * added to the numerator.
	 * The expected average number of seats is equal to the numerator divided by denominator
	 * which we obtained above.
	 * The expected average percentage of votes is equal to the numerator divided by denominator
	 * which we obtained above.
	 * 
	 * @param partyname
	 * @return the party that contains average data.
	 */
	public Party getAveragePartyData(String partyName) {
		int count = 0;
		int index = 0;
		float Totalnumberofseats = 0f;
		float Totalpercentageofvotes = 0f;
		Party NewParty = new Party(partyName);
		//use for loop to get the parties in the poll
        for(index = 0; index <polls.length && polls[index].getParty(partyName) != null;index++) {
        	Party party = polls[index].getParty(partyName);
        	if(party == null) {
        		//if it is null then ignore it.
			    Totalnumberofseats += 0;
        	}
        	else {
        		Totalnumberofseats += party.getProjectedNumberOfSeats();
			    count++;
        	}	        		

        }
        //if there is more than one party that we want.
        if(count > 0) {
        	//count as a denominator.
            NewParty.setProjectedNumberOfSeats((float)(Totalnumberofseats / count));
            count = 0;
        }
        
        
      //use for loop to get the parties in the poll
        for(Poll aPoll:polls) {

            if(aPoll.getParty(partyName) != null) {
            	Party party = aPoll.getParty(partyName);
            	//if it is null then ignore it.
            	if(party == null) {
        		    Totalpercentageofvotes += 0;
	        	}
	        	else {
	        		Totalpercentageofvotes += party.getProjectedPercentageOfVotes();
				    count++;
	        	}
    			
	        		
            }
        }
      //if there is more than one party that we want.
        if(count > 0) {
        	//count as a denominator.
            NewParty.setProjectedPercentageOfVotes((float)(Totalpercentageofvotes / count));
            count = 0;
        }
		return NewParty;
	}
	
	/**
	 * to fetch the poll
	 * @param aPoll
	 * @return
	 */
	
	public Poll adjustPollToMaximums(Poll aPoll) {
		return aPoll;
	}
	
	/**to change the data to String so that is can be understood by
	 * user.
	 */
	
	@Override
	public String toString() {
		return "Number of seats: " + numOfSeats;
	}

	
	
    /** This is a custom private method used to check is a party is in the Party list.
    /*The check returns true if the name of the party is equal to the party name we provided.
     * 
     * @param partyName
     * @param p
     * @return a boolean to see if it is true or not.
     */
    private boolean Ifapartyisin(String partyName,Party[] p) {
    	//default is false
    	boolean check = false;
    	int index = 0;
    	//The check becomes true when there is a party with same name in poll.
    	for(; index < p.length;index++) {
    		if(p[index] != null && partyName == p[index].getName()) {
    			check = true;
    		}
    		
    	}
    	return check;
    }
}
