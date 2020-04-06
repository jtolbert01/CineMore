package cinemorepract;
import java.util.ArrayList;

public class Sort {
	/*
	 * maybe we can use enums
	 */
	
	//Sorts movies alphabetically
	public ArrayList<Movie> sortAlphaMovie(ArrayList<Movie> eventList) {

		for(int i = 0; i < eventList.size() - 1; ++i) {
			for(int j = i + 1; j < eventList.size(); ++j) {
				Movie currentMovie = eventList.get(i);
				Movie compareTo = eventList.get(j);
				
				if(currentMovie.getTitle().charAt(0) > compareTo.getTitle().charAt(0)) {
					Movie temp = currentMovie;
					eventList.set(i, compareTo);
					eventList.set(j,  temp);
					
				}
			}
		}
	
        return eventList;
	}
	//Sorts plays alphabetically
	public ArrayList<Play> sortAlphaPlay(ArrayList<Play> eventList) {

		for(int i = 0; i < eventList.size() - 1; ++i) {
			for(int j = i + 1; j < eventList.size(); ++j) {
				Play currentPlay = eventList.get(i);
				Play compareTo = eventList.get(j);
				
				if(currentPlay.getTitle().charAt(0) > compareTo.getTitle().charAt(0)) {
					Play temp = currentPlay;
					eventList.set(i, compareTo);
					eventList.set(j,  temp);
					
				}
			}
		}
	
        return eventList;
	}
	//Sorts concerts alphabetically
	public ArrayList<Concert> sortAlphaConcert(ArrayList<Concert> eventList) {

		for(int i = 0; i < eventList.size() - 1; ++i) {
			for(int j = i + 1; j < eventList.size(); ++j) {
				Concert currentConcert = eventList.get(i);
				Concert compareTo = eventList.get(j);
				
				if(currentConcert.getTitle().charAt(0) > compareTo.getTitle().charAt(0)) {
					Concert temp = currentConcert;
					eventList.set(i, compareTo);
					eventList.set(j,  temp);
					
				}
			}
		}
	
        return eventList;
	}
	
	//Sorting by rating,  Movie
	public ArrayList<Movie> sortRatingMovie(ArrayList<Movie> eventList){
		
		for(int i = 0; i < eventList.size() - 1; ++i) {
			for(int j = i + 1; j < eventList.size(); ++j) {
				Movie currentMovie = eventList.get(i);
				Movie compareTo = eventList.get(j);
				
				if(currentMovie.getRating() < compareTo.getRating()) {
					Movie temp = currentMovie;
					eventList.set(i, compareTo);
					eventList.set(j,  temp);
					
				}
			}
		}
	
        return eventList;
	}
	//Sorting by rating, Play
		public ArrayList<Play> sortRatingPlay(ArrayList<Play> eventList){
			
			for(int i = 0; i < eventList.size() - 1; ++i) {
				for(int j = i + 1; j < eventList.size(); ++j) {
					Play currentPlay = eventList.get(i);
					Play compareTo = eventList.get(j);
					
					if(currentPlay.getRating() < compareTo.getRating()) {
						Play temp = currentPlay;
						eventList.set(i, compareTo);
						eventList.set(j,  temp);
						
					}
				}
			}
		
	        return eventList;
		}
	//Sorting by rating, Concert
			public ArrayList<Concert> sortRatingConcert(ArrayList<Concert> eventList){					
				for(int i = 0; i < eventList.size() - 1; ++i) {
					for(int j = i + 1; j < eventList.size(); ++j) {
						Concert currentConcert = eventList.get(i);
						Concert compareTo = eventList.get(j);	
						if(currentConcert.getRating() < compareTo.getRating()) {
							Concert temp = currentConcert;
							eventList.set(i, compareTo);
							eventList.set(j,  temp);					
						}
					}
				}
			   return eventList;
			}		
}
	


