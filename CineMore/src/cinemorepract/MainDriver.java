/*
 * Joshua S Tolbert
 */

package cinemorepract;
import java.util.Scanner;
import java.util.ArrayList;
import org.json.simple.JSONObject;

public class MainDriver {

  public static final String WELCOME_MESSAGE = " ~~ Welcome to CineMore ~~ ";
  public static String[] options = {"Search for Event", "Search for Theaters",
                                    "Browse Events", "Create Account", "Log In/Out"};
  public static final String[] eventTypes = {"Movie", "Play", "Concert"};
  public static final String[] searchMovieOptions = {"Title", "Year", "Genre", "Cast", 
         "Rating (Will look for any movies rated at least this good, 1 - 10)",
         "Runtime (Will look for any movies with a runtime less than x)",
         "MPAA Rating (G, PG, PG-13, R)"};
  public static final String[] searchPlayOptions = {"Title", "Year", "Character",
                                                    "Rating", "Runtime", "Author"};
  public static final String[] searchConcertOptions = {"Title", "Headliner", "Band",
                                                       "Rating"};
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
  

  MainDriver() {
    keyboard = new Scanner(System.in);
    movies = movies.getInstance();
    plays = plays.getInstance();
    concerts = concerts.getInstance();
    user = null;
    users = users.getInstance();
    venues = venues.getInstance();
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
              //create Account
          case 4:
              logIn();
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
    System.out.println("What would you like to search by?");
    for (int i = 0; i < searchMovieOptions.length; i++) {
      System.out.println((i + 1) + ". " + searchMovieOptions[i]);
    }
      String input = keyboard.nextLine();
      int searchType = Integer.parseInt(input);
      System.out.print("Input Search: ");
      String searchTarget = keyboard.nextLine();
      ArrayList<Movie> searchMovie = SearchMovies.returnMovie(movieList, searchTarget, 
                                                        searchType);
      System.out.println("\n*** Results: ");
      if (searchMovie != null) {
          for (Movie m : searchMovie) {
              System.out.println(m.toString());
              System.out.println("");
          }
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
      System.out.println("Input Search: ");
      String searchTarget = keyboard.nextLine();
      ArrayList<Play> searchPlay = SearchPlays.returnPlay(playList, searchTarget,
                                                          searchType);
      System.out.println("\n*** Results: ");
      if(searchPlay != null) {
          for(Play p : searchPlay) {
              System.out.println(p.toString());
              System.out.println(" ");
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
      System.out.println("Input Search: ");
      String searchTarget = keyboard.nextLine();
      ArrayList<Concert> searchConcert = SearchConcerts.returnConcert(concertList, searchTarget,
                                                          searchType);
      System.out.println("\n*** Results: ");
      if(searchConcert != null) {
          for(Concert c : searchConcert) {
              System.out.println(c.toString());
              System.out.println(" ");
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
                  //DataWriter.saveAccount(json);
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
