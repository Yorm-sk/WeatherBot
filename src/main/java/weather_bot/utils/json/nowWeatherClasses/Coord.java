package weather_bot.utils.json.nowWeatherClasses;

public class Coord {
    private double lon; //for latitude
    private double lat; //for longitude

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    @Override
    public String toString() {
        return "CooId{" +
                "lon=" + lon +
                ", lat=" + lat +
                '}';
    }
}
