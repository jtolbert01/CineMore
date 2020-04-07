package cinemorepract;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;


public class Ticket {
	//Attributes 
	private String title;
	private String time;
	private String theater;
	private String theaterAddress;
	//private Theater theater;
	
	//Getters, needed for ticket searches
	public String getTitle() {
		return this.title;
	}
	public String getTime() {
		return this.time;
	}
	/*
	public MovieTheater getMovieTheater() {
		return this.movieTheater;
	}
	public Ampitheater getAmp() {
		return this.amp;
	}
	public Theater getTheater() {
		return this.theater;
	}
	*/
	//Default Constructor 
	public Ticket() {
		this.title = "No Title";
		this.time = "00:00";
		this.theater = "No theater";
		this.theaterAddress = "0000 Theater Lane";
		//this.movieTheater = null;
		//this.amp = null;
		//this.theater = null;
	}
	
	public Ticket(String titleX, String timeX, Venue theater) {
		this.title = titleX;
		this.time = timeX;
		this.theater = theater.getName();
		this.theaterAddress = theater.getAddress();
	}

	
	//Print ticket based on ticket type
	public void printTicket() {
		if(this.title != "No Title") {
			try {
				String fileName = "ticket(" + this.title +").txt";
				File ticketFile = new File(fileName);
				FileWriter ticketWriter = new FileWriter(fileName);
				ticketFile.createNewFile();
				ticketWriter.write("**********Ticket**********\n Event: " + this.title + "\nTime: " + this.time +
					"\nShowing at: " + this.theater + "\nAddress: " + this.theaterAddress + 
					"\n*****Enjoy Your Show*****");
				ticketWriter.close();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}
	
	
	
	

}
