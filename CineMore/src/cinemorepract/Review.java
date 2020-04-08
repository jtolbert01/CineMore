package cinemorepract;

import java.util.ArrayList;
import java.util.Scanner;

public class Review {
	private int starRating;
	private String writtenReview;
	Scanner keyboard = new Scanner(System.in);
	
	public Review() {
		this.starRating = 1;
		this.writtenReview = "No Review Available";
	}
	
	public Review(int star, String review) {
		if(star <= 5 || star >= 1) {
			this.starRating = star;
		} else {
			this.starRating = 1;
		}
		this.writtenReview = review;
	}
	
	public Review(int star) {
		if(star <= 5 || star >= 1) {
			this.starRating = star;
		} else {
			this.starRating = 1;
		}
		this.writtenReview ="No written review left";
	}
	public int getStarRating() {
		return this.starRating;
	}
	public String getWrittenReview() {
		return this.writtenReview;
	}
	public String toString() {
		return "**********\n Star Rating: " + this.starRating
				+ "\nWritten Review: " + this.writtenReview;
	}
	//Reviewing a Movie
	public void reviewMovie() {
		Movies movies = Movies.getInstance();
        ArrayList<Movie> movieList = movies.getMovies();
        int currentMovie = 1;
        System.out.println("****MOVIES****");
        for (Movie m : movieList) {
            System.out.print(currentMovie  + ").  \n" + m.toString());
            System.out.println("");
            ++currentMovie;
        }
        System.out.println("Which movie would you like to review? Enter its number: ");
        int reviewChoice = keyboard.nextInt();
        keyboard.nextLine();
        System.out.println("On a scale of 1-5 stars, how would you rate " + movieList.get(reviewChoice -1).getTitle() +"?");
        int starRating = keyboard.nextInt();
        keyboard.nextLine();
        System.out.println("Would you like to leave a written review with your rating?");
        String yesNo = keyboard.nextLine();
        if(yesNo.equalsIgnoreCase("y")) {
        	System.out.println("Please enter your written review for " + movieList.get(reviewChoice - 1).getTitle() + ":");
        	String writtenReview = keyboard.nextLine();
        	movieList.get(reviewChoice - 1).newReview(starRating, writtenReview);
        	System.out.println("Review made!");
        } else {
        	movieList.get(reviewChoice - 1).newReview(starRating);
        	System.out.println("Review made!");
        }
        
	}
	//Reviewing a Play
	public void reviewPlay() {
	    System.out.println("****PLAYS****");
        Plays plays = Plays.getInstance();
        int currentPlay = 1;
        ArrayList<Play> playList = plays.getPlays();
        for (Play p : playList) {
            System.out.print(currentPlay  + ").  \n" + p.toString());
            System.out.println("");
            ++currentPlay;
        }
        System.out.println("Which play would you like to review? Enter its number: ");
        int reviewChoice = keyboard.nextInt();
        keyboard.nextLine();
        System.out.println("On a scale of 1-5 stars, how would you rate " + playList.get(reviewChoice -1).getTitle() +"?");
        int starRating = keyboard.nextInt();
        keyboard.nextLine();
        System.out.println("Would you like to leave a written review with your rating?");
        String yesNo = keyboard.nextLine();
        if(yesNo.equalsIgnoreCase("y")) {
        	System.out.println("Please enter your written review for " + playList.get(reviewChoice - 1).getTitle() + ":");
        	String writtenReview = keyboard.nextLine();
        	playList.get(reviewChoice - 1).newReview(starRating, writtenReview);
        	System.out.println("Review made!");
        } else {
        	playList.get(reviewChoice - 1).newReview(starRating);
        	System.out.println("Review made!");
        }
        
	}
	//Reviewing a concert
		public void reviewConcert() {
			Concerts concerts = Concerts.getInstance();
	        int currentConcert = 1;
	        ArrayList<Concert> concertList = concerts.getConcerts();
	        System.out.println("****CONCERTS****");
	        for (Concert c : concertList) {
	            System.out.print(currentConcert  + ").  \n" + c.toString());
	            System.out.println("");
	            ++currentConcert;
	        }
	        System.out.println("Which concert would you like to review? Enter its number: ");
	        int reviewChoice = keyboard.nextInt();
	        keyboard.nextLine();
	        System.out.println("On a scale of 1-5 stars, how would you rate " + concertList.get(reviewChoice -1).getTitle() +"?");
	        int starRating = keyboard.nextInt();
	        keyboard.nextLine();
	        System.out.println("Would you like to leave a written review with your rating?");
	        String yesNo = keyboard.nextLine();
	        if(yesNo.equalsIgnoreCase("y")) {
	        	System.out.println("Please enter your written review for " + concertList.get(reviewChoice - 1).getTitle() + ":");
	        	String writtenReview = keyboard.nextLine();
	        	concertList.get(reviewChoice - 1).newReview(starRating, writtenReview);
	        	System.out.println("Review made!");
	        } else {
	        	concertList.get(reviewChoice - 1).newReview(starRating);
	        	System.out.println("Review made!");
	        }
	        
		}

}
