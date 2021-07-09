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
		hi
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
		this.projectedPercentageOfVotes = projectedPercentageOfVotes;
	}

	public float getProjectedNumberOfSeats() {
		return projectedNumberOfSeats;
	}

	public void setProjectedNumberOfSeats(float projectedNumberOfSeats) {
		this.projectedNumberOfSeats = projectedNumberOfSeats;
	}

	@Override
	public String toString() {
		return "";
	}

	public double projectedPercentOfSeats(int totalNumberOfSeats) {
		return 0.0;
	}
	
	public String textVisualizationBySeats(int maxStars, int starsNeededForMajority, double numOfSeatsPerStar) {
		return name + "(" + projectedNumberOfSeats + ", " + projectedPercentageOfVotes + "%)";
	}

	public String textVisualizationByVotes(int maxStars, int starsNeededForMajority, double percentOfVotesPerStar) {
		return name + "(" + projectedNumberOfSeats + ", " + projectedPercentageOfVotes + "%)";
	}
} 
