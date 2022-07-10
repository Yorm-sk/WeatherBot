package weather_bot.utils.json.nowWeatherClasses;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WaterFromHeaven {
    @JsonProperty("1h")
    private int oneHour;
    @JsonProperty("3h")
    private int threeHour;

    public int getOneHour() {
        return oneHour;
    }

    public void setOneHour(int oneHour) {
        this.oneHour = oneHour;
    }

    public int getThreeHour() {
        return threeHour;
    }

    public void setThreeHour(int threeHour) {
        this.threeHour = threeHour;
    }
}
