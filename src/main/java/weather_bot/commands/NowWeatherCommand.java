package weather_bot.commands;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.commands.BotCommand;
import weather_bot.utils.Constant;
import weather_bot.utils.json.JsonExecutor;
import weather_bot.utils.json.User;
import weather_bot.utils.json.nowWeatherClasses.WeatherInfo;

public class NowWeatherCommand extends BotCommand {
    public NowWeatherCommand(String lang) {
        setCommand("now");
        if (lang.equals("ru")) setDescription(Constant.NOW_COMMAND_DESCRIPTION_RU);
        else setDescription(Constant.NOW_COMMAND_DESCRIPTION_EN);
    }

    public static SendPhoto sendWeatherPhoto(Message message, boolean isRu) {
        long userId = message.getFrom().getId();
        SendPhoto sendPhoto = new SendPhoto();
        User user = JsonExecutor.readUser(userId);
        WeatherInfo weatherInfo = JsonExecutor.getWeatherForItsCoordinate(user.getLat(), user.getLon(), isRu);
        InputFile inputFile = new InputFile("http://openweathermap.org/img/wn/" +
                weatherInfo.getWeather().get(0).getIcon() + "@4x.png");
        sendPhoto.setPhoto(inputFile);
        sendPhoto.setChatId(Long.toString(message.getChatId()));
        sendPhoto.setCaption(setCaption(isRu, weatherInfo));
        return sendPhoto;
    }

    public static SendMessage sendErrorMessage(Message message, boolean isRu) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(Long.toString(message.getChatId()));
        if (isRu) sendMessage.setText(Constant.NO_COORDINATES_SET_RU);
        else sendMessage.setText(Constant.NO_COORDINATES_SET_EN);
        return sendMessage;
    }

    private static String setCaption(boolean isRu, WeatherInfo weatherInfo) {
        String result;
        if (isRu && weatherInfo.getName() != null)
            result = String.format(
                    "Сейчас температура составляет  - %.1f\n" +
                            "Чуствуется как - %.1f\n" +
                            "%s\n" +
                            "Сейчас влажность составляет - %d проц\n" +
                            "Скорость ветра - %.2f км/час\n" +
                            "Ваши текущие местоположение: %s",
                    weatherInfo.getMain().getTemp(), weatherInfo.getMain().getFeelsLike(),
                    weatherInfo.getWeather().get(0).getDescription(), weatherInfo.getMain().getHumidity(),
                    mpsToKmph(weatherInfo.getWind().getSpeed()), weatherInfo.getName());
        else if (!isRu && weatherInfo.getName() == null)
            result = String.format(
                    "Now temperature is  - %.1f\n" +
                            "But it feels like - %.1f\n" +
                            "%s\n" +
                            "Your current coordinates is:\n" +
                            "Humidity - %d percent\n" +
                            "Wind speed - %.2f km per hour\n" +
                            "latitude - %.6f\n" +
                            "longitude - %.6f",
                    weatherInfo.getMain().getTemp(), weatherInfo.getMain().getFeelsLike(),
                    weatherInfo.getWeather().get(0).getDescription(), weatherInfo.getMain().getHumidity(),
                    mpsToKmph(weatherInfo.getWind().getSpeed()), weatherInfo.getCoord().getLat(),
                    weatherInfo.getCoord().getLon());
        else if (isRu && weatherInfo.getName() == null)
            result = String.format(
                    "Сейчас температура составляет  - %.1f\n" +
                            "Чуствуется как - %.1f\n" +
                            "%s\n" +
                            "Сейчас влажность составляет - %d проц\n" +
                            "Скорость ветра - %.2f км/час\n" +
                            "Ваши текущие координаты:\n" +
                            "широта - %.6f\n" +
                            "долгота - %.6f",
                    weatherInfo.getMain().getTemp(), weatherInfo.getMain().getFeelsLike(),
                    weatherInfo.getWeather().get(0).getDescription(), weatherInfo.getMain().getHumidity(),
                    mpsToKmph(weatherInfo.getWind().getSpeed()),weatherInfo.getCoord().getLat(),
                    weatherInfo.getCoord().getLon());
        else result = String.format(
                    "Now temperature is  - %.1f\n" +
                            "But it feels like - %.1f\n" +
                            "%s\n" +
                            "Humidity - %d percent\n" +
                            "Wind speed - %.2f km per hour\n" +
                            "Your now in: %s",
                    weatherInfo.getMain().getTemp(), weatherInfo.getMain().getFeelsLike(),
                    weatherInfo.getWeather().get(0).getDescription(), weatherInfo.getMain().getHumidity(),
                    mpsToKmph(weatherInfo.getWind().getSpeed()),weatherInfo.getName());
        return result;
    }

    static double mpsToKmph(double mps)
    {
        return (3.6 * mps);
    }
}
