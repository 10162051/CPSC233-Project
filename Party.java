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
		if (projectedNumberOfSeats > 0) {
			this.projectedNumberOfSeats = projectedNumberOfSeats;
		}
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
	    int percentage = (int) (projectedPercentageOfVotes * 100);
	    int percentageRatio = (int)(projectedNumberOfSeats/numOfSeatsPerStar);
	    String space = byBoth (maxStars,starsNeededForMajority,percentageRatio);
		return space + " " + name +  " (" + percentage + "% of votes, " + projectedNumberOfSeats + " seats)";	}

	public String textVisualizationByVotes(int maxStars, int starsNeededForMajority, double percentOfVotesPerStar) {
		int percentage = (int) (projectedPercentageOfVotes * 100);
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
	
