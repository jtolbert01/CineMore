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
                                    "Browse Events", "Create Account", "Log In/Out", "Employee Portal","Review a Movie"};
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
  public static final String[] employeeOptions = {"Add Event", "Add Venue", "Add Showtime for Event"};
  public static final String[] cMovie = {"Title", "Year", "Genres", "Cast", "Rating",
                                         "Runtime", "MPAA"};
  public static final String[] cPlay = {"Title", "Author", "Characters", "Year", "Runtime", "Rating"};
  public static final String[] cConcert = {"Title", "Headliner", "Bands", "Rating"};

  private Scanner keyboard;
  private Movies movies;
  private Plays plays;
  private Concerts concerts;
  private User user;
  private Users users;
  private Venues venues;  
  public Purchasing purchase = new Purchasing();
  private Review review = new Review();
  private ArrayList<Movie> movieList;
  private ArrayList<Play> playList;
  private ArrayList<Concert> concertList;
  private ArrayList<Venue> venueList;

  MainDriver() {
    keyboard = new Scanner(System.in);
    movies = movies.getInstance();
    plays = plays.getInstance();
    concerts = concerts.getInstance();
    user = null;
    users = users.getInstance();
    venues = venues.getInstance();
    CoreShowtimes.loadShowtimes();
    movieList = movies.getMovies();
    playList = plays.getPlays();
    concertList = concerts.getConcerts();
    venueList = venues.getVenues();
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
        	  employeePortal();
              break;
          case 6:
              review.reviewMovie();
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
      
      //Printing the movie results
      int movieNumber = 1;
      System.out.println("\n*** Results: ");
      if (searchMovie != null) {
    	  //print the results of the search
          for (Movie m : searchMovie) {
              System.out.println(movieNumber + ").  \n" + m.toString());
              System.out.println("");
              ++movieNumber;
          }
	   //Purchasing ticket
       purchase.purchaseMovieTicket(searchMovie);
	   
	   //If the search returns no movies
       } else {
        	System.out.println("No Movies Found\n");
       }
  }
  
  private void searchPlay() {
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
         purchase.purchasePlayTicket(searchPlay);
         
      //If the search returns no plays
      } else {
          System.out.println("No Plays Found\n");
      }
  }
  
  private void searchConcert() {
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
        purchase.purchaseConcertTicket(searchConcert);
      } else {
          System.out.println("No Concerts Found\n");
      }
  }
  
  private void searchTheaters() {
      System.out.println("Displaying all theaters near you: ");
      for(Venue v : venueList) {
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
  
  private void employeePortal() {
      if (user == null || !this.user.getType().equals("Employee")) {
          System.out.println("Please log in to an employee account to access this page");
          return;
      }
      for (int i = 0; i < employeeOptions.length; i++) {
          System.out.println((i + 1) + ". " + employeeOptions[i]);
      }
      String input = keyboard.nextLine();
      int choice = Integer.parseInt(input);
      switch(choice) {
          case 1:
              System.out.println("What type of event would you like to add?");
              System.out.println("1. Movie\n2. Play\n3. Concert");
              String input2 = keyboard.nextLine();
              int choice2 = Integer.parseInt(input2);
              switch(choice2) {
                  case 1:
                      System.out.println("Please enter all of the following information:");
                      ArrayList<String> responses = new ArrayList<>();
                      ArrayList<String> genres = new ArrayList<>();
                      ArrayList<String> cast = new ArrayList<>();
                      for (int i = 0; i < cMovie.length; i++) {
                          if(i == 2) {
                              System.out.println("Enter 3 genres, each on a seperate line");
                              String g1 = keyboard.nextLine();
                              String g2 = keyboard.nextLine();
                              String g3 = keyboard.nextLine();
                              genres.add(g1);
                              genres.add(g2);
                              genres.add(g3);
                          }
                          else if(i == 3) {
                              System.out.println("Enter the top 3 billed cast members, "
                                      + "each on a seperate line");
                              String c1 = keyboard.nextLine();
                              String c2 = keyboard.nextLine();
                              String c3 = keyboard.nextLine();
                              cast.add(c1);
                              cast.add(c2);
                              cast.add(c3);
                          }
                          else {
                            System.out.println(cMovie[i]);
                            String in = keyboard.nextLine();
                            responses.add(in);
                          }
                      }
                      String title = responses.get(0);
                      long year = Long.parseLong(responses.get(1));
                      String[] genreArr = new String[genres.size()];
                      for(int i = 0; i < genreArr.length; i++) {
                          genreArr[i] = genres.get(i);
                      }
                      String[] castArr = new String[cast.size()];
                      for(int i = 0; i < castArr.length; i++) {
                          castArr[i] = cast.get(i);
                      }
                      double rating = Double.parseDouble(responses.get(2));
                      long runtime = Long.parseLong(responses.get(3));
                      String mpaa = responses.get(4);
                      movieList.add(new Movie(title, year, genreArr, castArr, rating,
                                              runtime, mpaa));
                      System.out.println("Movie added");
                      break;
                  case 2:
                      System.out.println("Please enter all of the following information");
                      ArrayList<String> responses2 = new ArrayList<>();
                      ArrayList<String> characters = new ArrayList<>();
                      for (int i = 0; i < cPlay.length; i++) {
                          if (i == 2) {
                              System.out.println("Enter the 3 main characters, "
                                      + "each on a seperate line");
                              String c1 = keyboard.nextLine();
                              String c2 = keyboard.nextLine();
                              String c3 = keyboard.nextLine();
                              characters.add(c1);
                              characters.add(c2);
                              characters.add(c3);
                          }
                          else {
                            System.out.println(cPlay[i]);
                            String in = keyboard.nextLine();
                            responses2.add(in);
                          }
                      }
                      String pTitle = responses2.get(0);
                      String author = responses2.get(1);
                      String[] chars = new String[characters.size()];
                      for(int i = 0; i < chars.length; i++) {
                          chars[i] = characters.get(i);
                      }
                      long pYear = Long.parseLong(responses2.get(2));
                      long pRuntime = Long.parseLong(responses2.get(3));
                      double pRating = Double.parseDouble(responses2.get(4));
                      playList.add(new Play(pTitle, author, chars, pYear, pRuntime, pRating));
                      System.out.println("Play added");
                      break;
                  case 3:
                      System.out.println("Please enter all of the following information");
                      ArrayList<String> responses3 = new ArrayList<>();
                      ArrayList<String> bands = new ArrayList<>();
                      for (int i = 0; i < cConcert.length; i++) {
                          if (i == 2) {
                              System.out.println("Please enter all bands, each on "
                                      + "a seperate line");
                              String band1 = keyboard.nextLine();
                              String band2 = keyboard.nextLine();
                              bands.add(band1);
                              bands.add(band2);
                          } else {
                              String in = keyboard.nextLine();
                              responses3.add(in);
                          }
                      }
                      String cTitle = responses3.get(0);
                      String headliner = responses3.get(1);
                      String[] bandArr = new String[bands.size()];
                      for (int i = 0; i < bandArr.length; i++) {
                          bandArr[i] = bands.get(i);
                      }
                      double cRating = Double.parseDouble(responses3.get(2));
                      concertList.add(new Concert(cTitle, headliner, bandArr, cRating));
                      System.out.println("Concert added");
                      break;
                  default:
                      System.out.println("Invalid choice");
                      break;
              }
              break;
          case 2:
              System.out.println("Would you like to add\n 1. Movie theater or \n"
                      + "2. Ampitheater");
              String in = keyboard.nextLine();
              int ch = Integer.parseInt(in);
              if (ch == 1) {
                  System.out.println("Enter the theater name: ");
                  String tName = keyboard.nextLine();
                  System.out.println("Enter the theater contact number: ");
                  String tContact = keyboard.nextLine();
                  System.out.println("Enter the theater address: ");
                  String tAdd = keyboard.nextLine();
                  System.out.println("Enter the number of individual theaters: ");
                  String num = keyboard.nextLine();
                  int tNum = Integer.parseInt(num);
                  venueList.add(new MovieTheater(tName, tContact, tAdd, tNum));
                  System.out.println("Movie Theater Added");
              }
              else if (ch == 2) {
                  System.out.println("Enter the ampitheater name: ");
                  String aName = keyboard.nextLine();
                  System.out.println("Enter the theater contact number: ");
                  String aContact = keyboard.nextLine();
                  System.out.println("Enter the theater address: ");
                  String aAdd = keyboard.nextLine();
                  System.out.println("Enter the number of seat rows: ");
                  String rows = keyboard.nextLine();
                  int row = Integer.parseInt(rows);
                  System.out.println("Enter the number of seat columns: ");
                  String cols = keyboard.nextLine();
                  int col = Integer.parseInt(cols);
                  venueList.add(new Ampitheater(aName, aContact, aAdd, row, col));
                  System.out.println("Ampitheater Added");
              }
              break;
          case 3:
              System.out.println("What type of Event are you searching for? "
                      + "\n1. Movie\n2. Play\n3. Concert");
              String input1 = keyboard.nextLine();
              int choice1 = Integer.parseInt(input1);
              switch(choice1) {
                  case 1:
                      System.out.println("Enter the Movie Title: ");
                      String mTitle = keyboard.nextLine();
                      for (Movie m : movieList) {
                          if (mTitle.equals(m.getTitle())) {
                              System.out.println("Enter the Venue name: ");
                              String vName = keyboard.nextLine();
                              for (Venue v : venueList) {
                                  if (vName.equals(v.getName())) {
                                      System.out.println("Enter the time: ");
                                      String time = keyboard.nextLine();
                                      m.setShowing(v, time);
                                      System.out.println("Showing Added");
                                      break;
                                  }
                              }
                              System.out.println("Venue not found");
                              break;
                          }
                      }
                      System.out.println("Movie not found");
                      break;
                  case 2:
                      System.out.println("Enter the Play title: ");
                      String pTitle = keyboard.nextLine();
                      for (Play p : playList) {
                          if (pTitle.equals(p.getTitle())) {
                              System.out.println("Enter the Venue name: ");
                              String vName = keyboard.nextLine();
                              for (Venue v : venueList) {
                                  if (vName.equals(v.getName())) {
                                      System.out.println("Enter the time: ");
                                      String time = keyboard.nextLine();
                                      p.setShowing(v, time);
                                      System.out.println("Showing Added");
                                      break;
                                  }
                              }
                              System.out.println("Venue not found");
                              break;
                          }
                      }
                      System.out.println("Play not found");
                      break;
                  case 3:
                      System.out.println("Enter the Concert title: ");
                      String cTitle = keyboard.nextLine();
                      for (Concert c : concertList) {
                          if (cTitle.equals(c.getTitle())) {
                              System.out.println("Enter the Venue name: ");
                              String vName = keyboard.nextLine();
                              for (Venue v : venueList) {
                                  if (vName.equals(v.getName())) {
                                      System.out.println("Enter the time: ");
                                      String time = keyboard.nextLine();
                                      c.setShowing(v, time);
                                      System.out.println("Showing Added");
                                      break;
                                  }
                              }
                              System.out.println("Venue not found");
                              break;
                          }
                      }
                      System.out.println("Concert not found");
                      break;
                  default:
                      System.out.println("Invalid Choice");
                      break;
              }
          default:
              System.out.println("Invalid Choice");
              break;
                      
      }
  }
  
  public static void main(String[] args) {
      MainDriver drive = new MainDriver();
      drive.run();
  }
}
