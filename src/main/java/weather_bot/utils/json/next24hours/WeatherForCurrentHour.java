package weather_bot.utils.json.next24hours;

import com.fasterxml.jackson.annotation.JsonProperty;
import weather_bot.utils.json.nowWeatherClasses.*;

import java.util.List;

public class WeatherForCurrentHour {
    private long dt;
    private Main main;
    List<Weather> weather;
    private Clouds clouds;
    private Wind wind;
    private int visibility;
    private int pop;
    private WaterFromHeaven rain;
    private WaterFromHeaven snow;
    private Sys sys;
    @JsonProperty("dt_txt")
    private String dtTxt;

    public long getDt() {
        return dt;
    }

    public void setDt(long dt) {
        this.dt = dt;
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public List<Weather> getWeather() {
        return weather;
    }

    public void setWeather(List<Weather> weather) {
        this.weather = weather;
    }

    public Clouds getClouds() {
        return clouds;
    }

    public void setClouds(Clouds clouds) {
        this.clouds = clouds;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public int getVisibility() {
        return visibility;
    }

    public void setVisibility(int visibility) {
        this.visibility = visibility;
    }

    public int getPop() {
        return pop;
    }

    public void setPop(int pop) {
        this.pop = pop;
    }

    public Sys getSys() {
        return sys;
    }

    public void setSys(Sys sys) {
        this.sys = sys;
    }

    public String getDtTxt() {
        return dtTxt;
    }

    public void setDtTxt(String dtTxt) {
        this.dtTxt = dtTxt;
    }

    public WaterFromHeaven getRain() {
        return rain;
    }

    public void setRain(WaterFromHeaven rain) {
        this.rain = rain;
    }

    public WaterFromHeaven getSnow() {
        return snow;
    }

    public void setSnow(WaterFromHeaven snow) {
        this.snow = snow;
    }
}
