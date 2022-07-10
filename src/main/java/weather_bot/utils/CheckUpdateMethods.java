package weather_bot.utils;

import org.apache.commons.lang3.StringUtils;
import weather_bot.WeatherBot;
import weather_bot.enums.CommandType;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class CheckUpdateMethods {

    public static boolean isMessageCommand(String message) {
        return Pattern.matches("^/[a-z]+\\d*[a-z]*$", message);
    }

    public static boolean checkCommands(String command) {
        List<CommandType> commandTypes = Arrays.asList(CommandType.values());
        List<String> allowedCommands = commandTypes.stream().map(CommandType::getCommand).collect(Collectors.toList());
        return allowedCommands.contains(command);
    }

    public static boolean isUserInfoInDataBase(long userId) {
        File file = new File(WeatherBot.getPath() + "\\users\\" + userId + ".json");
        return file.exists();
    }

    public static boolean isThisCoordinates(String message) {
        if (Pattern.matches("^\\d+[.]\\d+,\\d+[.]\\d+$", message) ||
                Pattern.matches("^\\d+,\\d+$", message)) {
            String[] coordinates = message.split(",");
            try {
                double lat = Double.parseDouble(coordinates[0]);
                double lon = Double.parseDouble(coordinates[1]);
                return (lat >= -90 && lat <= 90 && lon >= -180 && lon <= 180);
            } catch (NumberFormatException e) {
                return false;
            }
        } else return false;
    }

    public static boolean isCity(String message, boolean isRu){
        Set<String> enCities = Constant.CITIES_EN.keySet().stream().map(String::toLowerCase).collect(Collectors.toSet());
        Set<String> ruCities = Constant.CITIES_RU.keySet().stream().map(String::toLowerCase).collect(Collectors.toSet());
        if (isRu) return ruCities.contains(message.toLowerCase());
        else return enCities.contains(message.toLowerCase());
    }
}
