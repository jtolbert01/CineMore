package cinemorepract;

public class Ticket {
	//Attributes 
	private String title;
	private String time;
	private MovieTheater movieTheater;
	private Ampitheater amp;
	private Theater theater;
	
	//Getters, needed for ticket searches
	public String getTitle() {
		return this.title;
	}
	public String getTime() {
		return this.time;
	}
	public MovieTheater getMovieTheater() {
		return this.movieTheater;
	}
	public Ampitheater getAmp() {
		return this.amp;
	}
	public Theater getTheater() {
		return this.theater;
	}
	
	//Default Constructor 
	public Ticket() {
		this.title = "No Title";
		this.time = "00:00";
		this.movieTheater = null;
		this.amp = null;
		this.theater = null;
	}
	
	//Might be unneeded**
	public Ticket(String titleX, String timeX, MovieTheater movieTheaterX,
			Ampitheater ampX, Theater theaterX) {
		this.title = titleX;
		this.time = timeX;
		this.movieTheater = movieTheaterX;
		this.amp = ampX;
		this.theater = theaterX;
	}
	//Constructor for movie ticket
	public Ticket(String titleX, String timeX, MovieTheater movieTheaterX) {
		this.title = titleX;
		this.time = timeX;
		this.movieTheater = movieTheaterX;
		this.amp = null;
		this.theater = null;
	}
	//Constructor for concert ticket
	public Ticket(String titleX, String timeX, Ampitheater ampX) {
		this.title = titleX;
		this.time = timeX;
		this.movieTheater = null;
		this.amp = ampX;
		this.theater = null;
	}
	//Constructor for play ticket
	public Ticket(String titleX, String timeX, Theater theaterX) {
		this.title = titleX;
		this.time = timeX;
		this.movieTheater = null;
		this.amp = null;
		this.theater = theaterX;
	}
	
	//Print ticket based on ticket type
	public String printTicket() {
		//Movie ticket
		if(this.movieTheater != null) {
			return "*********** \nTitle: " + this.title + " @ " + this.time +"\nMovie Theater: " + movieTheater.getName();
		}
		//Concert ticket
		else if(this.amp != null) {
			return "*********** \nTitle: " + this.title + " @ " + this.time +"\nAmpitheater: " + amp.getName();
		}
		//Play ticket
		else if(this.theater != null) {
			return "*********** \nTitle: " + this.title + " @ " + this.time +"\nTheater: " + theater.getName();
		}
		//No ticket
		else {
			return "No ticket found!";
		}
	}
	
	
	
	

}
