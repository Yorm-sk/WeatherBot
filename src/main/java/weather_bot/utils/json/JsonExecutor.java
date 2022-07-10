package weather_bot.utils.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import weather_bot.WeatherBot;
import weather_bot.utils.json.next24hours.WeatherFor24Hours;
import weather_bot.utils.json.nowWeatherClasses.WeatherInfo;
import weather_bot.utils.requests.RequestSender;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;

public class JsonExecutor {
    private static final Logger LOGGER = LogManager.getLogger(JsonExecutor.class);
    public static void saveUser(User user){
        ObjectMapper objectMapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
        File file = new File(WeatherBot.getPath() +"\\users");
        String path = WeatherBot.getPath() + "\\users\\" + user.getId() +".json";
        file.mkdirs();
        try {
            objectMapper.writeValue(new File(path), user);
        } catch (IOException e) {
            LOGGER.error("File was not written");
        }
    }

    public static User readUser(long userId){
        ObjectMapper objectMapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
        String path = WeatherBot.getPath() + "\\users\\" + userId +".json";
        User user = null;
        try {
            user = objectMapper.readValue(new File(path), User.class);
        } catch (IOException e) {
            LOGGER.error("No such user");
        }
        return user;
    }

    public static WeatherInfo getWeatherForItsCoordinate(double lat, double lon, boolean isRu){
        ObjectMapper objectMapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
        WeatherInfo weatherInfo = null;
        try {
            String result = RequestSender.getStringFromCurrentWeatherResponse(lat, lon, isRu);
            StringReader reader = new StringReader(result);
            weatherInfo = objectMapper.readValue(reader, WeatherInfo.class);
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
        }
        return weatherInfo;
    }

    public static WeatherFor24Hours getWeatherForNext24Hours(double lat, double lon, boolean isRu){
        ObjectMapper objectMapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
        WeatherFor24Hours weather = null;
        try {
            String result = RequestSender.getStringFromNext24WeatherResponse(lat, lon, isRu);
            StringReader reader = new StringReader(result);
            weather = objectMapper.readValue(reader, WeatherFor24Hours.class);
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
        }
        return weather;
    }
}
