package model;
/**
 * 
 * @author Shaohuan Xia
 *
 */


public class PollList {
	private Poll[] polls;
	private int numOfSeats;
	
	//This is the method using if statement to verdict 
	//if the arguments are within the limit.
	public PollList(int numOfPolls, int numOfSeats) {
		
		if(numOfPolls < 1) {
			polls = new Poll[5];
			
		}
		else {
			polls = new Poll[numOfPolls];
		}
		if(numOfSeats < 1) {
			this.numOfSeats = 10;
		}
		else {
			this.numOfSeats = numOfSeats;
		}
	}
	
	
	
	// Getter and setter.
	public int getNumOfSeats() {
		return numOfSeats;
	}
	
	
	
	public Poll[] getPolls() {
		return polls;
	}
    
	
	
	//This method using if statement and for loop to add a poll to the list.
	/*The first for loop is used to go through the array and check if there is an existing
	 * name inside of it, if so then replace it with the poll which used as an argument.
	 * If the index exceeding the limit then print an error message,else replace the poll
	 * with the first null value which means the end of the elements in the list.
	 */
	public void addPoll(Poll aPoll) {
	    int index = 0;
	    if(aPoll != null) {
		    for (index = 0; index < polls.length && polls[index] != null; index++) {	
			    if(aPoll.getPollName().equalsIgnoreCase(polls[index].getPollName())) {
				    polls[index] = aPoll;
			    }
		    }
		    if(index >= polls.length) {
			    System.out.println("Exceeding the limit");
		    }
		    else {
		    	for (index = 0; index < polls.length; index++) {
		    		if(polls[index] == null) {
		    			polls[index] = aPoll;
		    			break;
		    		}
		    	}
		    }
	    }
	    else {
	    	System.out.println("Invalid Poll");
	    }
	}
	
	
	
	// This method using a for loop. 
	public Poll getAggregatePoll(String[] partyNames) {
		Poll Aggregate = new Poll("Aggregate",partyNames.length);
		for(String partyname:partyNames) {
			int count = 0;
			int index = 0;
			float Totalnumberofseats = 0f;
			float Totalpercentageofvotes = 0f;
			Party NewParty = new Party(partyname);			
	        for(index = 0; index <polls.length && polls[index].getParty(partyname) != null;index++) {
	        	Party party = polls[index].getParty(partyname);
	        	if(party == null) {
				    Totalnumberofseats += 0;
	        	}
	        	else {
	        		Totalnumberofseats += party.getProjectedNumberOfSeats();
				    count++;
	        	}

	        }
	        if(count > 0) {
	            NewParty.setProjectedNumberOfSeats((float)(Totalnumberofseats / count));
	            count = 0;
	        }
	        
	        
	        
	        for(Poll aPoll:polls) {

	            if(aPoll.getParty(partyname) != null) {
	            	Party party = aPoll.getParty(partyname);
	            	    if(party == null) {
	            		    Totalpercentageofvotes += 0;
	    	        	}
	    	        	else {
	    	        		Totalpercentageofvotes += party.getProjectedPercentageOfVotes();
	    				    count++;
	    	        	}
	    			
		        		
	            }
	        }
	        
	        if(count > 0) {
	            NewParty.setProjectedPercentageOfVotes((float)(Totalpercentageofvotes / count));
	            count = 0;
	        }
	        
            Aggregate.addParty(NewParty);
            
		}
		return Aggregate;
	}
	
	
	
	/*This method using nested loop to check if the party is in each poll.
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
	 */
	public Party getAveragePartyData(String partyName) {
		int count = 0;
		int index = 0;
		float Totalnumberofseats = 0f;
		float Totalpercentageofvotes = 0f;
		Party NewParty = new Party(partyName);
        for(index = 0; index <polls.length && polls[index].getParty(partyName) != null;index++) {
        	Party party = polls[index].getParty(partyName);
        	if(party == null) {
			    Totalnumberofseats += 0;
        	}
        	else {
        		Totalnumberofseats += party.getProjectedNumberOfSeats();
			    count++;
        	}	        		

        }
        if(count > 0) {
            NewParty.setProjectedNumberOfSeats((float)(Totalnumberofseats / count));
            count = 0;
        }
        
        
        
        for(Poll aPoll:polls) {

            if(aPoll.getParty(partyName) != null) {
            	Party party = aPoll.getParty(partyName);
            	if(party == null) {
        		    Totalpercentageofvotes += 0;
	        	}
	        	else {
	        		Totalpercentageofvotes += party.getProjectedPercentageOfVotes();
				    count++;
	        	}
    			
	        		
            }
        }
        
        if(count > 0) {
            NewParty.setProjectedPercentageOfVotes((float)(Totalpercentageofvotes / count));
            count = 0;
        }
		return NewParty;
	}
	
	
	
	public Poll adjustPollToMaximums(Poll aPoll) {
		return aPoll;
	}
	
	
	
	@Override
	public String toString() {
		return "Number of seats: " + numOfSeats;
	}

	
	
    // This is a custom private method used to check is a party is in the Party list.
    // The check returns true if the name of the party is equal to the party name we provided.
    private boolean Ifapartyisin(String partyName,Party[] p) {
    	boolean check = false;
    	int index = 0;
    	for(; index < p.length;index++) {
    		if(p[index] != null && partyName == p[index].getName()) {
    			check = true;
    		}
    		
    	}
    	return check;
    }
}
