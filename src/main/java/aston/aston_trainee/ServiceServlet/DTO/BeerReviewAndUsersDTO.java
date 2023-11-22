package aston.aston_trainee.ServiceServlet.DTO;

public class BeerReviewAndUsersDTO {
    String beerName;
    String breweryName;
    String location;
    String userName;
    String reviewText;

    int rating;

    public BeerReviewAndUsersDTO(String beerName, String breweryName, String location,
                                 String userName, String reviewText,int rating) {
        this.beerName = beerName;
        this.breweryName = breweryName;
        this.location = location;
        this.userName = userName;
        this.reviewText = reviewText;
        this.rating = rating;
    }

    public String getBeerName() {
        return beerName;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setBeerName(String beerName) {
        this.beerName = beerName;
    }

    public String getBreweryName() {
        return breweryName;
    }

    public void setBreweryName(String breweryName) {
        this.breweryName = breweryName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getReviewText() {
        return reviewText;
    }

    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }

    @Override
    public String toString() {
        return "BeerReviewAndUsersDTO{" +
                "beerName='" + beerName + '\'' +
                ", breweryName='" + breweryName + '\'' +
                ", location='" + location + '\'' +
                ", userName='" + userName + '\'' +
                ", reviewText='" + reviewText + '\'' +
                ", rating=" + rating +
                '}';
    }
}
