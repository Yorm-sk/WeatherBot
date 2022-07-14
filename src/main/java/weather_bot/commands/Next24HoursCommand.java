package weather_bot.commands;

import org.telegram.telegrambots.meta.api.methods.send.SendMediaGroup;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.commands.BotCommand;
import org.telegram.telegrambots.meta.api.objects.media.InputMedia;
import org.telegram.telegrambots.meta.api.objects.media.InputMediaPhoto;
import weather_bot.utils.Constant;
import weather_bot.utils.json.JsonExecutor;
import weather_bot.utils.json.User;
import weather_bot.utils.json.next24hours.WeatherFor24Hours;
import weather_bot.utils.json.next24hours.WeatherForCurrentHour;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 * Contain methods that refer to /next24hours command
 * **/
public class Next24HoursCommand extends BotCommand {
    public Next24HoursCommand(String lang) {
        setCommand("next24hours");
        if (lang.equals("ru")) setDescription(Constant.NEXT_COMMAND_DESCRIPTION_RU);
        else setDescription(Constant.NEXT_COMMAND_DESCRIPTION_EN);
    }

    /**
     * Method send group of photos with weather description
     * **/
    public static SendMediaGroup sendDayForecast(Message message, boolean isRu){
        SendMediaGroup sendMediaGroup = new SendMediaGroup();
        sendMediaGroup.setChatId(Long.toString(message.getChatId()));
        sendMediaGroup.setMedias(getListFromResponse(message.getFrom().getId(), isRu));
        return sendMediaGroup;
    }

    /**
     * Make request to openWeather parse it java classes and return list of photos with description
     * **/
    private static List<InputMedia> getListFromResponse(long userId, boolean isRu){
        User user = JsonExecutor.readUser(userId);
        WeatherFor24Hours weather = JsonExecutor.getWeatherForNext24Hours(user.getLat(), user.getLon(), isRu);
        List<InputMedia> result = new ArrayList<>();
        String city = weather.getCity().getName();
        for (WeatherForCurrentHour currentHour : weather.getWeatherForCurrentHours()){
            InputMediaPhoto mediaPhoto = new InputMediaPhoto();
            mediaPhoto.setMedia("http://openweathermap.org/img/wn/" +
                    currentHour.getWeather().get(0).getIcon() + "@4x.png");
            mediaPhoto.setCaption(description(isRu, currentHour, city));
            result.add(mediaPhoto);
        }
        return result;
    }

    /**
     * Return needed description for photo
     * **/
    private static String description(boolean isRu, WeatherForCurrentHour weather, String city){
        String result;
        SimpleDateFormat formatter = new SimpleDateFormat("MM-dd HH:mm");
        Date date = new Date(weather.getDt()*1000);
        if (isRu && city != null){
            result = String.format(
                    "Время и дата - %s\n" +
                            "Температура - %.1f\n" +
                            "Чуствуется как - %.1f\n" +
                            "%s\n" +
                            "Влажность - %d проц\n" +
                            "Скорость ветра - %.2f км/час\n" +
                            "Месторасположение: %s",
                    formatter.format(date), weather.getMain().getTemp(), weather.getMain().getFeelsLike(),
                    weather.getWeather().get(0).getDescription(), weather.getMain().getHumidity(),
                    weather.getWind().getSpeed(), city
            );
        }
        else if (isRu){
            result = String.format(
                    "Время и дата - %s\n" +
                            "Температура - %.1f\n" +
                            "Чуствуется как - %.1f\n" +
                            "%s\n" +
                            "Влажность - %d проц\n" +
                            "Скорость ветра - %.2f км/час",
                    formatter.format(date), weather.getMain().getTemp(), weather.getMain().getFeelsLike(),
                    weather.getWeather().get(0).getDescription(), weather.getMain().getHumidity(),
                    weather.getWind().getSpeed()
            );
        }
        else if (city != null) {
            result = String.format(
                    "Date - %s\n" +
                            "Temperature - %.1f\n" +
                            "Feels like - %.1f\n" +
                            "%s\n" +
                            "Humidity - %d percents\n" +
                            "wind speed - %.2f кm/hour\n" +
                            "Location: %s",
                    formatter.format(date), weather.getMain().getTemp(), weather.getMain().getFeelsLike(),
                    weather.getWeather().get(0).getDescription(), weather.getMain().getHumidity(),
                    weather.getWind().getSpeed(), city
            );
        }
        else {
            result = String.format(
                    "Date - %s\n" +
                            "Temperature - %.1f\n" +
                            "Feels like - %.1f\n" +
                            "%s\n" +
                            "Humidity - %d percents\n" +
                            "wind speed - %.2f кm/hour",
                    formatter.format(date), weather.getMain().getTemp(), weather.getMain().getFeelsLike(),
                    weather.getWeather().get(0).getDescription(), weather.getMain().getHumidity(),
                    weather.getWind().getSpeed()
            );
        }
        return result;
    }
}
