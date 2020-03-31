/*
 * Joshua S Tolbert
 */

package cinemorepract;
import java.util.Scanner;
import java.util.ArrayList;

public class MainDriver {

  public static final String WELCOME_MESSAGE = " ~~ Welcome to CineMore ~~ ";
  public static String[] options = {"Search for Event", "Search for Theaters",
                                    "Browse Events", "Create Account", "Log In"};
  public static final String[] eventTypes = {"Movie", "Play", "Concert"};
  public static final String[] searchMovieOptions = {"Title", "Year", "Genre", "Cast", 
         "Rating (Will look for any movies rated at least this good, 1 - 10)",
         "Runtime (Will look for any movies with a runtime less than x)",
         "MPAA Rating (G, PG, PG-13, R)"};

  private Scanner keyboard;
  private Movies movies;
  private Plays plays;
  private Concerts concerts;

  MainDriver() {
    keyboard = new Scanner(System.in);
    movies = movies.getInstance();
    plays = plays.getInstance();
    concerts = concerts.getInstance();
  }

  public void run() {
    System.out.println(WELCOME_MESSAGE);

    while(true) {
      displayOptions();
      
      String input = keyboard.nextLine();
      int choice = Integer.parseInt(input) - 1;
      keyboard.nextLine();
      switch(choice) {
          case 0:
              searchEvent();
              break;
          case 1:
              //searchTheaters
          case 2:
              displayEvents();
              break;
          case 3:
              //create Account
          case 4:
              //login
          default:
              System.out.println("Sorry, that was not a valid choice.");
              break;
      }
    }

  }

  private void displayOptions() {
    System.out.println(" * * * * Main Menu * * * * ");
    for (int i = 0; i < options.length; i++) {
      System.out.println("  " +(i + 1) + ". " + options[i]);
    }
    System.out.println(" * * * * * * * * * * * * * * ");
  }
  //Search databse for an Event
  private void searchEvent() {
    System.out.println("What would you like to search for? ");
    for (int i = 0; i < eventTypes.length; i++) {
      System.out.println((i + 1) + ". " + eventTypes[i]);
    }
    String input = keyboard.nextLine();
    int choice = Integer.parseInt(input) - 1;
    keyboard.nextLine();
    switch(choice) {
      case 0:
        searchMovie();
        break;
      case 1:
        //searchPlay
      case 2:
        //searchConcert
      default:
        System.out.println("Sorry, that was not a valid choice.");
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
      keyboard.nextLine();
      System.out.print("Search: ");
      String searchTarget = keyboard.next();
      ArrayList<Movie> searchMovie = Search.returnMovie(movieList, searchTarget, 
                                                        searchType);
      if (!searchMovie.isEmpty()) {
	        for(Movie m : searchMovie) {
	        	System.out.println(m.toString());
	        	System.out.println(" ");
	        }
        } else {
        	System.out.println("Movie not found");
        }
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
  
  public static void main(String[] args) {
      MainDriver drive = new MainDriver();
      drive.run();
  }
}
