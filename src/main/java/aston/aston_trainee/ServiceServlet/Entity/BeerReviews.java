package aston.aston_trainee.ServiceServlet.Entity;

public class BeerReviews {
    long reviewID;
    String reviewText;
    int rating;
    long beerID;

    public BeerReviews(long reviewID, String reviewText, int rating, long beerID) {
        this.reviewID = reviewID;
        this.reviewText = reviewText;
        this.rating = rating;
        this.beerID = beerID;
    }

    public long getReviewID() {
        return reviewID;
    }

    public void setReviewID(long reviewID) {
        this.reviewID = reviewID;
    }

    public String getReviewText() {
        return reviewText;
    }

    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public long getBeerID() {
        return beerID;
    }

    public void setBeerID(long beerID) {
        this.beerID = beerID;
    }

    @Override
    public String toString() {
        return "BeerReviews{" +
                "reviewID=" + reviewID +
                ", reviewText='" + reviewText + '\'' +
                ", rating=" + rating +
                ", beerID=" + beerID +
                '}';
    }
}
