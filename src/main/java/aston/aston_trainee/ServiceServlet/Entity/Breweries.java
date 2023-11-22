package aston.aston_trainee.ServiceServlet.Entity;

public class Breweries {
    long id;
    String breweryName;
    String location;

    public Breweries(long id, String breweryName, String location) {
        this.id = id;
        this.breweryName = breweryName;
        this.location = location;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
        return "Breweries{" +
                "id=" + id +
                ", breweryName='" + breweryName + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
