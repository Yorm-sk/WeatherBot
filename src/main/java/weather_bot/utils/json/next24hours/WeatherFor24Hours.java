package weather_bot.utils.json.next24hours;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class WeatherFor24Hours {
    private int cod;
    private int message;
    private int cnt;
    @JsonProperty("list")
    List<WeatherForCurrentHour> weatherForCurrentHours;
    private City city;

    public WeatherFor24Hours() {
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public int getMessage() {
        return message;
    }

    public void setMessage(int message) {
        this.message = message;
    }

    public int getCnt() {
        return cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }

    public List<WeatherForCurrentHour> getWeatherForCurrentHours() {
        return weatherForCurrentHours;
    }

    public void setWeatherForCurrentHours(List<WeatherForCurrentHour> weatherForCurrentHours) {
        this.weatherForCurrentHours = weatherForCurrentHours;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}
