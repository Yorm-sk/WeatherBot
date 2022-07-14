package weather_bot.commands;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.commands.BotCommand;
import weather_bot.utils.Constant;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
/**
 * Contain methods that refer to /cities command
 * **/
public class CitiesCommand extends BotCommand {

    public CitiesCommand(String lang) {
        setCommand("cities");
        if (lang.equals("ru")) setDescription(Constant.CITIES_COMMAND_DESCRIPTION_RU);
        else setDescription(Constant.CITIES_COMMAND_DESCRIPTION_EN);
    }

    public static SendMessage showCities(Message message, boolean isRu) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(Long.toString(message.getChatId()));
        Set<String> cities;
        if (isRu) cities = Constant.CITIES_RU.keySet();
        else cities = Constant.CITIES_EN.keySet();
        List<String> sortedCities = cities.stream().sorted().collect(Collectors.toList());
        StringBuilder messageToUser = new StringBuilder();
        sortedCities.forEach(city -> messageToUser.append(city).append(", "));
        messageToUser.replace(messageToUser.lastIndexOf(","), messageToUser.lastIndexOf(" "), ".");
        sendMessage.setText(messageToUser.toString());
        return sendMessage;
    }
}
