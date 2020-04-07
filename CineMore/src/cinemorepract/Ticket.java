package cinemorepract;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.util.Date;


public class Ticket {
	//Attributes 
	private String title;
	private String time;
	private String theater;
	private String theaterAddress;
	
	//Getters, needed for ticket searches
	public String getTitle() {
		return this.title;
	}
	public String getTime() {
		return this.time;
	}
	//Default Constructor 
	public Ticket() {
		this.title = "No Title";
		this.time = "00:00";
		this.theater = "No theater";
		this.theaterAddress = "0000 Theater Lane";

	}
	//Parameter Constructor
	public Ticket(String titleX, String timeX, Venue theater) {
		this.title = titleX;
		this.time = timeX;
		this.theater = theater.getName();
		this.theaterAddress = theater.getAddress();
	}
	//Print ticket based on ticket type
	public void printTicket() {
		Date date = new Date();
		if(this.title != "No Title") {
			try {
				long currentTime = date.getTime();
				String fileName = "ticket(" + this.title + currentTime +").txt";
				File ticketFile = new File(fileName);
				FileWriter ticketWriter = new FileWriter(fileName);
				ticketFile.createNewFile();
				ticketWriter.write("**********Ticket**********\n\nEvent: " + this.title + "\nTime: " + this.time +
					"\nShowing at: " + this.theater + "\nAddress: " + this.theaterAddress + 
					"\n\n*****Enjoy Your Show*****");
				ticketWriter.close();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}
	
	
	
	

}
