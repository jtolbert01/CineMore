/*
 * Joshua S Tolbert
 */

package cinemorepract;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.simple.JSONObject;

public class MainDriver {

  public static final String WELCOME_MESSAGE = " ~~ Welcome to CineMore ~~ ";
  public static String[] options = {"Search for Event", "Search for Theaters",
                                    "Browse Events", "Create Account", "Log In/Out", "Print Ticket (Testing)", "Showtimes (Testing)"};
  public static final String[] eventTypes = {"Movie", "Play", "Concert"};
  public static final String[] searchMovieOptions = {"Title", "Year", "Genre", "Cast", 
         "Rating (Will look for any movies rated at least this good, 1 - 10)",
         "Runtime (Will look for any movies with a runtime less than x)",
         "MPAA Rating (G, PG, PG-13, R)", "Sort Alphabetically (A First)", "Sort by Rating (Descending)",
         "Sort Alphabetically (Z first)", "Sort by Rating (Increasing)"};
  public static final String[] searchPlayOptions = {"Title", "Year", "Character",
                                                    "Rating", "Runtime", "Author","Sort Alphabetically (A First)", "Sort by Rating (Descending)",
                                                    "Sort Alphabetically (Z first)", "Sort by Rating (Increasing)"};
  public static final String[] searchConcertOptions = {"Title", "Headliner", "Band",
                                                       "Rating","Sort Alphabetically (A First)", "Sort by Rating (Descending)",
                                                       "Sort Alphabetically (Z first)", "Sort by Rating (Increasing)"};
  public static final String[] accountTypes = {"User Acccount", "Employee Account",
                                               "Administrator Account"};
  public static final String[] employeeIDs = {"0013214", "0042134", "0081623", "0010657"};
  private static final String adminCode = "00ADMIN00";

  private Scanner keyboard;
  private Movies movies;
  private Plays plays;
  private Concerts concerts;
  private User user;
  private Users users;
  private Venues venues;  
  private Event event;

  MainDriver() {
    keyboard = new Scanner(System.in);
    movies = movies.getInstance();
    plays = plays.getInstance();
    concerts = concerts.getInstance();
    user = null;
    users = users.getInstance();
    venues = venues.getInstance();
    CoreShowtimes.loadShowtimes();
  }

  public void run() {
    System.out.println(WELCOME_MESSAGE);

    while(true) {
      displayOptions();
      
      String input = keyboard.nextLine();
      int choice = Integer.parseInt(input) - 1;
      switch(choice) {
          case 0:
              searchEvent();
              break;
          case 1:
              searchTheaters();
              break;
          case 2:
              displayEvents();
              break;
          case 3:
              createAccount();
              break;
          case 4:
              logIn();
              break;
          case 5:
        	  ArrayList<Venue> list = venues.getVenues();        	  
        	  Ticket ticket = new Ticket("Aquaman","1:00 PM", list.get(0));
        	  ticket.printTicket();
        	  break;
          case 6:
              ArrayList<Movie> mList = movies.getMovies();
              Movie searchResult = mList.get(4);
              searchResult.printShowings();
              break;
          default:
              System.out.println("Sorry, that was not a valid choice.");
              break;
      }
    }

  }

  private void displayOptions() {
    System.out.println(" * * * * Main Menu * * * * ");
    System.out.println("  Status: " + getStatus());
    for (int i = 0; i < options.length; i++) {
      System.out.println("  " +(i + 1) + ". " + options[i]);
    }
    System.out.println(" * * * * * * * * * * * * * * ");
  }
  
  private String getStatus() {
      if (this.user == null) {
          return "Not Logged In";
      } else {
          return "Logged In";
      }
  }
  
  //Search databse for an Event
  private void searchEvent() {
    System.out.println("What would you like to search for? ");
    for (int i = 0; i < eventTypes.length; i++) {
      System.out.println((i + 1) + ". " + eventTypes[i]);
    }
    String input = keyboard.nextLine();
    int choice = Integer.parseInt(input) - 1;
    switch(choice) {
      case 0:
        searchMovie();
        break;
      case 1:
        searchPlay();
        break;
      case 2:
        searchConcert();
        break;
      default:
        System.out.println("Sorry, that was not a valid choice.");
        break;
    }
  }

  private void searchMovie() {
      ArrayList<Movie> movieList = movies.getMovies();
      
      //Figure out how the user wants the movies searched/sorted
      System.out.println("What would you like to search by?");
      for (int i = 0; i < searchMovieOptions.length; i++) {
    	System.out.println((i + 1) + ". " + searchMovieOptions[i]);
      }
      String input = keyboard.nextLine();
      int searchType = Integer.parseInt(input);
      ArrayList<Movie> searchMovie = new ArrayList<Movie>();
      
      //Perform the search/sort
      //For Sorts
      if(searchType >= 8) {
    	  searchMovie = SearchMovies.returnMovie(movieList, "none", searchType);
      //For Searches
      } else { 
	      System.out.print("Input Search: ");
	      String searchTarget = keyboard.nextLine();
	      searchMovie = SearchMovies.returnMovie(movieList, searchTarget, 
	                                                        searchType);
      }
      
      //Printing the movie results and purchasing a movie ticket
      int movieNumber = 1;
      System.out.println("\n*** Results: ");
      if (searchMovie != null) {
    	  //print the results of the search999
          for (Movie m : searchMovie) {
              System.out.println(movieNumber + ").  \n" + m.toString());
              System.out.println("");
              ++movieNumber;
          }
	      //Purchasing ticket
		  ArrayList<Venue> list = venues.getVenues();
		  System.out.println("Would you like to purchase a ticket? y/n");
		  String purchaseYN = keyboard.next();
		  
              //If the user chooses to buy a ticket		  
			  if(purchaseYN.equalsIgnoreCase("y")) {
				  //User selects movie they would like to see
				  System.out.println("Please enter the number of the movie you would like to purchase a ticket to: ");
				  int movieChoice = keyboard.nextInt();
				  keyboard.nextLine();
				  if(movieChoice > searchMovie.size()) {
					  System.out.println("Invalid selection");
				  } else {
					  //User requests to purchase x copies of the tickets
					  System.out.println("How many tickets would you like to purchase?");
					  int numTickets = keyboard.nextInt();
					  keyboard.nextLine();
					  for(int x = 1; x <= numTickets; ++x) {
						  for(int i = 0; i < searchMovie.size(); ++i) {
							  if((i + 1) == movieChoice) { //Finds the movie the user selected then performs ticket purchase
								  //Get a list of venues that the selected movie is showing at
								  HashMap<Venue,String> map = searchMovie.get(i).getShowings();
								  ArrayList<Venue> theaterList = new ArrayList<Venue>();
								  for(Venue v : map.keySet()) {
									  theaterList.add(v);
								  }
								  System.out.println(theaterList.size());
								  for(int y = 0; y < theaterList.size(); ++y) {
									  System.out.println((y+1) + "). \n Venue: " + theaterList.get(y).getName());
								  }
								  //Find out where the user will attend the event
								  System.out.println("Please enter the number of the venue you would like to attend: ");
								  int venueChoice = keyboard.nextInt();
								  keyboard.nextLine();		
								  //Print ticket
								  Ticket ticket = new Ticket(searchMovie.get(i).getTitle(), "12:00 PM", theaterList.get(venueChoice - 1));
								  ticket.printTicket();
								  System.out.println("Ticket Purchased & Printed");
					 		  }
					 	  }
					  }
				  }
			  //If they do not purchase a ticket	  
			  } else {
				  keyboard.nextLine();
				  System.out.println("No ticket purchased");
		   }
	   //If the search returns no movies
       } else {
        	System.out.println("No Movies Found\n");
       }
  }
  
  private void searchPlay() {
      ArrayList<Play> playList = plays.getPlays();
      System.out.println("What would you like to search by?");
      for (int i = 0; i < searchPlayOptions.length; i++) {
          System.out.println((i + 1) + ". " + searchPlayOptions[i]);
      }
      String input = keyboard.nextLine();
      int searchType = Integer.parseInt(input);
      ArrayList<Play> searchPlay = new ArrayList<Play>();
      //For sorts
      if (searchType >= 7) {
    	  searchPlay = SearchPlays.returnPlay(playList, "none", searchType);
      //For searches
      } else {
	      System.out.println("Input Search: ");
	      String searchTarget = keyboard.nextLine();
	      searchPlay = SearchPlays.returnPlay(playList, searchTarget,
	                                                          searchType);
      }
      //Printing the play results
      int playNumber = 1;
      System.out.println("\n*** Results: ");
      if(searchPlay != null) {
          for(Play p : searchPlay) {
              System.out.println(playNumber + ").  \n" + p.toString());
              System.out.println(" ");
              ++playNumber;
          }
          //Purchasing Tickets
          ArrayList<Venue> list = venues.getVenues();
	 	  System.out.println("Would you like to purchase a ticket? y/n");
	 	  String purchaseYN = keyboard.next();
	 	  
	 	  //If the use chooses to purchase a ticket
	 	  if(purchaseYN.equalsIgnoreCase("y")) {
	 		  //User selects the play they would like to see
	 		  System.out.println("Please enter the number of the play you would like to purchase a ticket to: ");
	 		  int playChoice = keyboard.nextInt();
	 	      keyboard.nextLine();
	 	      if(playChoice > searchPlay.size()) {
	 	    	  System.out.println("Invalid Selection");
	 	      } else {
	 	    	  //User enters how many tickets to purchase
	 	    	  System.out.println("How many tickets would you like to purchase?");
	 	    	  int numTickets = keyboard.nextInt();
	 	    	  keyboard.nextLine();
	 	    	  for(int x = 1; x <= numTickets; ++x) {
			 		  for(int i = 0; i < searchPlay.size(); ++i) {
			 			  if((i + 1) == playChoice) {
			 				  //Give a list of venues the event is playing at
			 				  HashMap<Venue,String> map = searchPlay.get(i).getShowings();
							  ArrayList<Venue> theaterList = new ArrayList<Venue>();
							  for(Venue v : map.keySet()) {
								  theaterList.add(v);
							  }
							  System.out.println(theaterList.size());
							  for(int y = 0; y < theaterList.size(); ++y) {
								  System.out.println((y+1) + "). \n Venue: " + theaterList.get(y).getName());
							  }
							  //Find what venue the user wants to attend
							  System.out.println("Please enter the number of the venue you would like to attend: ");
							  int venueChoice = keyboard.nextInt();
							  keyboard.nextLine();							
							  //Print tickets
			 				  Ticket ticket = new Ticket(searchPlay.get(i).getTitle(), "12:00 PM", theaterList.get(venueChoice - 1));
			 				  ticket.printTicket();
			 				  System.out.println("Ticket Purchased & Printed");
			 			  }
			 		  }
	 	    	  }
	 	      }
	 	   //If they do not want to purchase a ticket
	 	   } else {
	 		   keyboard.nextLine();
	 		   System.out.println("No ticket purchased");
	 	   }
      } else {
          System.out.println("No Plays Found\n");
      }
  }
  
  private void searchConcert() {
      ArrayList<Concert> concertList = concerts.getConcerts();
      System.out.println("What would you like to search by?");
      for (int i = 0; i < searchConcertOptions.length; i++) {
          System.out.println((i + 1) + ". " + searchConcertOptions[i]);
      }
      String input = keyboard.nextLine();
      int searchType = Integer.parseInt(input);
      ArrayList<Concert> searchConcert = new ArrayList<Concert>();
      //For sorts
      if( searchType >= 5) {
    	  searchConcert = SearchConcerts.returnConcert(concertList, "none", searchType);
      //For searches
      } else {
	      System.out.println("Input Search: ");
	      String searchTarget = keyboard.nextLine();
	      searchConcert = SearchConcerts.returnConcert(concertList, searchTarget,
	                                                          searchType);
      }
      //Printing concert results
      int concertNumber = 1;
      System.out.println("\n*** Results: ");
      if(searchConcert != null) {
          for(Concert c : searchConcert) {
              System.out.println(concertNumber + ").  \n" + c.toString());
              System.out.println(" ");
              ++concertNumber;
          }
        //Purchasing Tickets
        ArrayList<Venue> list = venues.getVenues();
	    System.out.println("Would you like to purchase a ticket? y/n");
	 	String purchaseYN = keyboard.next();
	 	
	 	//User wants to purchase a ticket
	 	if(purchaseYN.equalsIgnoreCase("y")) {
	 		//Find out what concert the user wants to attend
	 		System.out.println("Please enter the number of the play you would like to purchase a ticket to: ");
	 		int concertChoice = keyboard.nextInt();
	 		keyboard.nextLine();
	 		if(concertChoice > searchConcert.size()) {
	 			System.out.println("Invalid selection");
	 		} else {
	 			//Find out how many tickets the user wants
	 			System.out.println("How many tickets would you like to purchase?");
	 			int numTickets = keyboard.nextInt();
	 			keyboard.nextLine();
	 			for (int x = 1; x <= numTickets; ++x) {
			 		for(int i = 0; i < searchConcert.size(); ++i) {
			 			if((i + 1) == concertChoice) {
			 				  //Give a list of venues where the concert will be
			 				  HashMap<Venue,String> map = searchConcert.get(i).getShowings();
							  ArrayList<Venue> theaterList = new ArrayList<Venue>();
							  for(Venue v : map.keySet()) {
								  theaterList.add(v);
							  }
							  System.out.println(theaterList.size());
							  for(int y = 0; y < theaterList.size(); ++y) {
								  System.out.println((y+1) + "). \n Venue: " + theaterList.get(y).getName());
							  }
							  //find out what venue the user wants to attend
							  System.out.println("Please enter the number of the venue you would like to attend: ");
							  int venueChoice = keyboard.nextInt();
							  keyboard.nextLine();		
							//print tickets
			 				Ticket ticket = new Ticket(searchConcert.get(i).getTitle(), "12:00 PM", theaterList.get(venueChoice - 1));
			 				ticket.printTicket();
			 				System.out.println("Ticket Purchased & Printed");
			 			}
			 		}
	 			}
	 		}
	 	//User does not want to purchase a ticket
	 	} else {
	 		keyboard.nextLine();
	 		System.out.println("No ticket purchased");
	 	}
      } else {
          System.out.println("No Concerts Found\n");
      }
  }
  
  private void searchTheaters() {
      System.out.println("Displaying all theaters near you: ");
      ArrayList<Venue> list = venues.getVenues();
      for(Venue v : list) {
          System.out.println(v.toString());
      }
      System.out.println("");
  }
  
  private void displayEvents() {
    System.out.println("What type of event would you like to browse?");
    for (int i = 0; i < eventTypes.length; i++) {
      System.out.println((i + 1) + ". " + eventTypes[i]);
    }
    String input = keyboard.nextLine();
    int choice = Integer.parseInt(input) - 1;
    switch(choice) {
      case 0:
        LoadDriver.displayMovies();
        break;
      case 1:
        LoadDriver.displayPlays();
        break;
      case 2:
        LoadDriver.displayConcerts();
        break;
      default:
        System.out.println("Sorry, that was not a valid choice.");
        break;
    }
  }
  
  private void createAccount() {
      System.out.println("\nWhat type of account would you like to create?");
      for (int i = 0; i < accountTypes.length; i++) {
          System.out.println((i + 1) + ". " + accountTypes[i]);
      }
      String input = keyboard.nextLine();
      int choice = Integer.parseInt(input);
      switch(choice) {
          case 1:
              System.out.println("Enter your name: ");
              String name = keyboard.nextLine();
              System.out.println("Enter your email address: ");
              String email = keyboard.nextLine();
              System.out.println("Enter a password: ");
              String password = keyboard.nextLine();
              for (User u : users.getUsers()) {
                  if (u.getEmail().equalsIgnoreCase(email)) {
                      System.out.println("That email address is already associated "
                              + "with an account.");
                      break;
                  }
              }
              AccountHolder newUser = new AccountHolder(name, email, password);
              JSONObject uJSON = newUser.toJSON();
              DataWriter.saveAccount(uJSON);
              System.out.println("Account Created\n ");
              this.user = newUser;
              break;
          case 2:
              System.out.println("Enter your employee ID: ");
              String id = keyboard.nextLine();
              boolean cont = false;
              for (int i = 0; i < employeeIDs.length; i++) {
                  if (id.equalsIgnoreCase(employeeIDs[i])) {
                      cont = true;
                  }
              }
              if(cont) {
                  System.out.println("Enter your name: ");
                  String eName = keyboard.nextLine();
                  System.out.println("Enter your email address: ");
                  String eEmail = keyboard.nextLine();
                  System.out.println("Enter a password: ");
                  String ePassword = keyboard.nextLine();
                  for (User u : users.getUsers()) {
                    if (u.getEmail().equalsIgnoreCase(eEmail)) {
                        System.out.println("That email address is already associated "
                                         + "with an account.");
                        break;
                    }
                  }
                  Employee newEmp = new Employee(eName, eEmail, ePassword,
                                             Long.parseLong(id));
                  JSONObject eJSON = newEmp.toJSON();
                  DataWriter.saveAccount(eJSON);
                  System.out.println("Account Created\n ");
                  this.user = newEmp;
              }
              else {
                  System.out.println("Invalid Employee ID");
              }
              break;
          case 3:
              System.out.println("Enter Admin Code: ");
              String code = keyboard.nextLine();
              if (!code.equals(adminCode)) {
                  System.out.println("Invalid Administrator Code");
                  break;
              }
              System.out.println("Enter your name: ");
              String aName = keyboard.nextLine();
              System.out.println("Enter your email address: ");
              String aEmail = keyboard.nextLine();
              System.out.println("Enter a password: ");
              String aPassword = keyboard.nextLine();
              Administrator newAdmin = new Administrator(aName, aEmail, aPassword);
              JSONObject aJSON = newAdmin.toJSON();
              DataWriter.saveAccount(aJSON);
              System.out.println("Account Created\n ");
              this.user = newAdmin;
              break;
      }
  }
  
  private void logIn() {
      if (this.user != null) {
          System.out.println("Logged In As:\n" + this.user.toString());
          System.out.println("Would you like to log out? y/n");
          String input = keyboard.nextLine();
          if (input.equalsIgnoreCase("y")) {
              this.user = null;
              System.out.println("Logged Out\n");
          } else {
              return;
          }
      } else {
          System.out.println("\nEmail: ");
          String email = keyboard.nextLine();
          System.out.println("Password: ");
          String pass = keyboard.nextLine();
          Users users = Users.getInstance();
          ArrayList<User> userList = users.getUsers();
          for (int i = 0; i < userList.size(); i++) {
              if (userList.get(i).getEmail().equalsIgnoreCase(email) && 
                  userList.get(i).getPassword().equals(pass)) {
                  System.out.println("Logged In\n");
                  this.user = userList.get(i);
                  return;
              }
          }
          System.out.println("Invalid Login Credentials\n");
      }
  }
  
  public static void main(String[] args) {
      MainDriver drive = new MainDriver();
      drive.run();
  }
}
