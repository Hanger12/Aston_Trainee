package aston.aston_trainee.ServiceServlet.DTO;

public class BeerAndBreweryDTO {
    String beerName;
    String breweryName;
    String location;

    public BeerAndBreweryDTO(String beerName, String breweryName, String location) {
        this.beerName = beerName;
        this.breweryName = breweryName;
        this.location = location;
    }

    public String getBeerName() {
        return beerName;
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

    @Override
    public String toString() {
        return "BeerAndBreweryDTO{" +
                "beerName='" + beerName + '\'' +
                ", breweryName='" + breweryName + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
