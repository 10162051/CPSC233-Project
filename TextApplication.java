import java.util.ArrayList;

public class TextApplication {
	//Constant
	public static final int MAX_NUMBER_OF_STARS = 25;
	//Instance variable
	private PollList polls;
	
	
	//Default constructor
	public TextApplication() {
	}
	//Second constructor. Uses PollList to initialize the polls instance variable.
	public TextApplication(PollList polls) {
		this.polls = polls;
	}
	

	//returns nothing. Array of strings are the names of parties. Pass each Poll in the polls instance
	//variable as an arg to displayPollDataBySeat.
	//Call getAggregatedPoll (in PollList) of the polls instance variable and display it too
	public void displayPollsBySeat(String[] partyNames) {
		//? PollList.getAggregatedPoll.poll();
	}
	
	
	public PollList getPolls() {
		return polls;
	}
	
	
	//Doesn't return anything. Should visualize the data in the poll 
	//provided to allow the user to compare the parties.
	//Invoke the textVisualizationBySeat method for each Party object in the Poll and 
	//display the string returned by that method.
	//Get the list of sorted parties from Poll. Loop through the parties in the list to make
	//the visualization.
	public static void displayPollDataBySeat(Poll aPoll) {
		
		int index = 0;
		System.out.println(aPoll.getPollName());
		for(; index < aPoll.getPartiesSortedBySeats().length ; index ++) {
			System.out.println(aPoll.getPartiesSortedBySeats()[index].textVisualizationBySeats(MAX_NUMBER_OF_STARS,(int)(MAX_NUMBER_OF_STARS/2) , 10.0));
		}
		//? Party.textVisualizationBySeats(int maxStars, int starsNeededForMajority, double numOfSeatsPerStar);
		// ? Poll.Party[] getPartiesSortedBySeats(); 
	}
	
	
	//returns nothing and takes no args. Runs the entire application.
	//To test, run the application. Application should prompt for number of seats,
	//the parties that are running, and number of polls to track.
	//Ask user if they want to enter data for all polls or if they want generated polls. Make
	//sure to call appropriate method from Factory.
	//Ask user which visualization they want or they can quit any time.
	public void run() {
		//Factory.PollList createRandomPollList(int numOfPolls);
	}
	
	//Getter for polls
	public void setPolls(PollList polls) {
		this.polls = polls;
	}
	
	public static void main(String[] args) {
	//Instance :)
		TextApplication app = new TextApplication(null);
		app.run();
		Party party1 = new Party("one");
		Party party2 = new Party("two");
		Party party3 = new Party("three");
		Poll poll1 = new Poll("poll one",3);
		poll1.addParty(party1);
		poll1.addParty(party2);
		poll1.addParty(party3);
		PollList polllist1 = new PollList(1,10);
		app.polls = polllist1;
		displayPollDataBySeat(app.getPolls().getPolls()[0]);
	}
}
