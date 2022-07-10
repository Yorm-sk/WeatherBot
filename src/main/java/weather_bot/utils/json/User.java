package weather_bot.utils.json;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {
    private String username;
    private long id;
    @JsonProperty("first_name")
    private String firstName;
    @JsonProperty("last_name")
    private String lastName;
    private double lat;
    private double lon;
    @JsonProperty("language_code")
    private String languageCode;
    private String standardLanguage;

    public User() {
    }

    public User(String username, long id, String firstName, String lastName, double lat, double lon, String languageCode) {
        this.username = username;
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.lat = lat;
        this.lon = lon;
        this.languageCode = languageCode;
    }

    public User(String username, long id, String firstName, String lastName, double lat, double lon) {
        this.username = username;
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.lon = lon;
        this.lat = lat;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

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

    public String getLanguageCode() {
        return languageCode;
    }

    public void setLanguageCode(String languageCode) {
        this.languageCode = languageCode;
    }

    public String getStandardLanguage() {
        return standardLanguage;
    }

    public void setStandardLanguage(String standardLanguage) {
        this.standardLanguage = standardLanguage;
    }
}
