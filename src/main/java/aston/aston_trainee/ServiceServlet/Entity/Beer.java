package aston.aston_trainee.ServiceServlet.Entity;

public class Beer {
    long beerID;
    String beerName;
    long breweryID;

    public Beer(long beerID, String beerName, long breweryID) {
        this.beerID = beerID;
        this.beerName = beerName;
        this.breweryID = breweryID;
    }

    public long getBeerID() {
        return beerID;
    }

    public void setBeerID(long beerID) {
        this.beerID = beerID;
    }

    public String getBeerName() {
        return beerName;
    }

    public void setBeerName(String beerName) {
        this.beerName = beerName;
    }

    public long getBreweryID() {
        return breweryID;
    }

    public void setBreweryID(long breweryID) {
        this.breweryID = breweryID;
    }

    @Override
    public String toString() {
        return "Beer{" +
                "beerID=" + beerID +
                ", beerName='" + beerName + '\'' +
                ", breweryID=" + breweryID +
                '}';
    }
}
