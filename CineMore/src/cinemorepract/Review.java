package cinemorepract;

public class Review {
	private int starRating;
	private String writtenReview;
	
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

}
