package cinemorepract;

public class Ticket {
	private String title;
	private String time;
	private MovieTheater movieTheater;
	private Ampitheater amp;
	private Theater theater;
	
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
	
	public Ticket(String titleX, String timeX, MovieTheater movieTheaterX,
			Ampitheater ampX, Theater theaterX) {
		this.title = titleX;
		this.time = timeX;
		this.movieTheater = movieTheaterX;
		this.amp = ampX;
		this.theater = theaterX;
	}
	
	public Ticket(String titleX, String timeX, MovieTheater movieTheaterX) {
		this.title = titleX;
		this.time = timeX;
		this.movieTheater = movieTheaterX;
		this.amp = null;
		this.theater = null;
	}
	public Ticket(String titleX, String timeX, Ampitheater ampX) {
		this.title = titleX;
		this.time = timeX;
		this.movieTheater = null;
		this.amp = ampX;
		this.theater = null;
	}
	public Ticket(String titleX, String timeX, Theater theaterX) {
		this.title = titleX;
		this.time = timeX;
		this.movieTheater = null;
		this.amp = null;
		this.theater = theaterX;
	}
	
	public String printTicket() {
		if(this.movieTheater != null) {
			return "*********** \nTitle: " + this.title + " @ " + this.time +"\nMovie Theater: " + movieTheater.getName();
		} else if(this.amp != null) {
			return "*********** \nTitle: " + this.title + " @ " + this.time +"\nAmpitheater: " + amp.getName();
		} else if(this.theater != null) {
			return "*********** \nTitle: " + this.title + " @ " + this.time +"\nTheater: " + theater.getName();
		} else {
			return "No ticket found!";
		}
	}
	
	
	
	

}
