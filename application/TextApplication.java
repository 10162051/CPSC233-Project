package application;
import model.*;
/**
 * @author Shaohuan Xia
 * @author Hima Rajesh
 * @author Carlene Kalin
 */


import java.util.ArrayList;
import java.util.Scanner;

public class TextApplication {
	//Constant
	public static final int MAX_NUMBER_OF_STARS = 25;
	//Instance variable
	private PollList polls;
	
	
	/**Default constructor
	 * 
	 */
	public TextApplication() {
	}
	/**Second constructor. Uses PollList to initialize the polls instance variable.
	 * 
	 * @param polls
	 */
	public TextApplication(PollList polls) {
		this.polls = polls;
	}
	

	/**returns nothing. Array of strings are the names of parties. Pass each Poll in the polls instance
	 * Call displayPollsBySeat(String[] partyNames) of the polls and display it too
	 * 
	 * @param partyNames
	 */
	public void displayPollsBySeat(String[] partyNames) {
		for(Poll aPoll:polls.getPolls()) {
			displayPollDataBySeat(aPoll);
		}
		displayPollDataBySeat(polls.getAggregatePoll(partyNames));
	}
	
	/**
	 * a getter
	 * @return polls
	 */
	public PollList getPolls() {
		return polls;
	}
	
	
	/**Doesn't return anything. Should visualize the data in the poll 
	/*provided to allow the user to compare the parties.
	/*Invoke the textVisualizationBySeat method for each Party object in the Poll and 
	/*display the string returned by that method.
	/*Get the list of sorted parties from Poll. Loop through the parties in the list to make
	/*the visualization.
	 * 
	 * @param aPoll
	 */
	public void displayPollDataBySeat(Poll aPoll) {
		
		int index = 0;
		System.out.println(aPoll.getPollName());
		for(; index < aPoll.getPartiesSortedBySeats().length ; index ++) {
			System.out.println(aPoll.getPartiesSortedBySeats()[index].textVisualizationBySeats(MAX_NUMBER_OF_STARS,(int)(MAX_NUMBER_OF_STARS/2) , 10.0));
		}

	}
	
	
	/**returns nothing and takes no args. Runs the entire application.
	/*To test, run the application. Application should prompt for number of seats,
	/*the parties that are running, and number of polls to track.
	/*Ask user if they want to enter data for all polls or if they want generated polls. Make
	/*sure to call appropriate method from Factory.
	/*Ask user which visualization they want or they can quit any time.
	 * 
	 */
	public void run() {
		//Factory.PollList createRandomPollList(int numOfPolls);
		Scanner kb = new Scanner(System.in);
		int infinite = 0;
		//visualization
		System.out.println("Welcome to the poll tracker");
		System.out.println("**********Group5 presents**********");
		System.out.print("How many seats are available in the election?");
		//get the text from user.
		int NumberOfSeats = kb.nextInt();
		//updates Factory object.
		Factory f = null;
		f.getInstance();
		f.createEmptyPolls();
		System.out.print("Which parties are in the election (provide names, comma separated):");
		kb = new Scanner(System.in);
		String parties = kb.nextLine();
		// use split to fetch each string.
		String[] Parties = parties.split(",");
		f.setPartyNames(Parties);
		System.out.print("How many polls do you want to track with this application?");
		kb = new Scanner(System.in);
		int NumberOfPolls = kb.nextInt();
		System.out.print("Would you like me to create a random setof polls?");
		kb = new Scanner(System.in);
		String YesOrNo = kb.next();
		String Yes = "yes";
		//if the string is "yes", then generate a new poll list and provide a feedback.
		if(YesOrNo.equalsIgnoreCase(Yes)) {
			f.createRandomPollList(NumberOfPolls);
			System.out.println("Added!");
		}
		// the program won't end if the user did not type quit to set infinite to 1
		while(infinite == 0) {
			//CLI
			System.out.println("----------Options----------\nall (show result of all polls)\naggregate (show aggregate result)\nquit (end application)");
			System.out.print("Choose an option:");
			kb = new Scanner(System.in);
			String TheOption = kb.nextLine();
			// to see what user inputed
			if(TheOption.equalsIgnoreCase("all")) {
				polls = f.promptForPollList(NumberOfPolls);
				displayPollsBySeat(Parties);
			}
			else if(TheOption.equalsIgnoreCase("aggregate")) {
				displayPollDataBySeat(polls.getAggregatePoll(Parties));
			}
			//set the infinite to 1 to break the while loop.
			else if(TheOption.equalsIgnoreCase("quit")) {
				System.out.println("Thanks to:Shaohuan, Carlene and Hima. ");
				System.out.println("Thanks for using this software designed by Group5, see you soon!");
				infinite = 1;
			}
			//if the input is invalid then print error message.
			else {
				System.out.println("That is not the correct keyword, please type again!");
			}
		}
		
		
	}
	
	/**Getter for polls
	 * 
	 * @param polls
	 */
	public void setPolls(PollList polls) {
		this.polls = polls;
	}
	
	
	/**used to run the program.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
	//Instance :)
		TextApplication app = new TextApplication(null);
		app.run();
	}
}
