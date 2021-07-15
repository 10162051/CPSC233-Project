/**
 * 
 * @author himarajesh
 *
 */

public class Party {
	private String name;
	private float projectedNumberOfSeats;
	private float projectedPercentageOfVotes;
	public Party(String partyName) {
		name = partyName;
	}
	public Party(String partyName, float projectedNumberOfSeats, float projectedPercentageOfVotes) {
		name = partyName;
		// code below restricts the projectedNumberOfSeats to being above zero( non negative value). If so, the entered value can equal the variable.
		if (projectedNumberOfSeats > 0) {
			this.projectedNumberOfSeats = projectedNumberOfSeats;
		}
		// code below restricts the projectedPercentageofVotes to being above  or equal to zero and less than or equal to one. If so, the entered value can equal the variable.
		if (projectedPercentageOfVotes >= 0 && projectedPercentageOfVotes <= 1){
			this.projectedPercentageOfVotes = projectedPercentageOfVotes;
		}
	
	}
	
	public float getProjectedPercentageOfVotes() {
		return projectedPercentageOfVotes;
	}
	
	public String getName() {
		return name;
	}
	
	public void setProjectedPercentageOfVotes(float projectedPercentageOfVotes) {
		// ensures the value falls between and including zero and one.
		if (projectedPercentageOfVotes >= 0 && projectedPercentageOfVotes <= 1) {
			this.projectedPercentageOfVotes = projectedPercentageOfVotes;
		}
	}

	public float getProjectedNumberOfSeats() {
		return projectedNumberOfSeats;
	}

	public void setProjectedNumberOfSeats(float projectedNumberOfSeats) {
		if (projectedNumberOfSeats >= 0) {
			this.projectedNumberOfSeats = projectedNumberOfSeats;
		}
	}

	@Override
	public String toString() {
		int percentage = (int) (projectedPercentageOfVotes * 100);
		return name +  " (" + percentage + "% of votes, " + projectedNumberOfSeats + " seats)";
	}

	public double projectedPercentOfSeats(int totalNumberOfSeats) {
		double percentOfSeats = projectedNumberOfSeats / totalNumberOfSeats;
		if ( totalNumberOfSeats <= 0) {
			return 0.0;
		}
		return percentOfSeats;
	}
	
	public String textVisualizationBySeats(int maxStars, int starsNeededForMajority, double numOfSeatsPerStar) {
	// converts the projectedPercentageOfVotes to a percentage.
	    int percentage = (int) (projectedPercentageOfVotes * 100);
	// determines the amount of stars based on the projectedNumberOfSeats.
	    int percentageRatio = (int)(projectedNumberOfSeats/numOfSeatsPerStar);
	 //Utilizes the byBoth method to execute the printing of stars based on their percentageRatio(which are different for both methods)
	    String space = byBoth (maxStars,starsNeededForMajority,percentageRatio);
		return space + " " + name +  " (" + percentage + "% of votes, " + projectedNumberOfSeats + " seats)";	}

	public String textVisualizationByVotes(int maxStars, int starsNeededForMajority, double percentOfVotesPerStar) {
	    int percentage = (int) (projectedPercentageOfVotes * 100);
	// determines the amount stars that needs to be printed based on the percentage of votes received and how many of those votes go in one star.
	    int percentageRatio = (int)(percentage/percentOfVotesPerStar);
	    String space = byBoth (maxStars,starsNeededForMajority,percentageRatio);;
		return space + " " + name +  " (" + percentage + "% of votes, " + projectedNumberOfSeats + " seats)";	}
	
	public String byBoth (int maxStars, int starsNeededForMajority, int percentageRatio) {
		 String space = "";
		    for (int i = 0; i <= maxStars; i++) {
		    	 if (i == starsNeededForMajority) {
		 	    	space+= "|";	
		    }
		    	 else if (percentageRatio > 0) {
		    		 space+="*";
		    		 percentageRatio -= 1;
		    	 }
		    	 else if (percentageRatio <= 0) {
		    		 space+=" ";
		    	 }
		    }
			return space;
	}
	}
	
