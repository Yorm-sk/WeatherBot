package weather_bot.commands;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.commands.BotCommand;
import weather_bot.utils.Constant;
import weather_bot.utils.json.JsonExecutor;
import weather_bot.utils.json.User;

public class SetCoordinates extends BotCommand {
    public SetCoordinates(String lang) {
        setCommand("coordinates");
        if (lang.equals("ru")) setDescription(Constant.COORD_COMMAND_DESCRIPTION_RU);
        else setDescription(Constant.COORD_COMMAND_DESCRIPTION_EN);
    }

    public static SendMessage setCoordinates(Message message, boolean isRu) {
        String[] command = message.getText().split(",");
        SendMessage sendMessage = new SendMessage();
        User user = new User(message.getFrom().getUserName(), message.getFrom().getId(), message.getFrom().getFirstName(),
                message.getFrom().getLastName(), Double.parseDouble(command[0]), Double.parseDouble(command[1]),
                message.getFrom().getLanguageCode());
        JsonExecutor.saveUser(user);
        sendMessage.setChatId(Long.toString(message.getChatId()));
        if (!isRu) sendMessage.setText(Constant.COORDINATES_WAS_SAVE_EN);
        else sendMessage.setText(Constant.COORDINATES_WAS_SAVE_RU);
        return sendMessage;
    }

    public static SendMessage setCoordinatesByCity(Message message, boolean isRu) {
        String city = message.getText().toLowerCase();
        city = city.replace(Character.toString(city.charAt(0)), Character.toString(city.charAt(0)).toUpperCase());
        String coord;
        if (isRu) coord = Constant.CITIES_RU.get(city);
        else coord = Constant.CITIES_EN.get(city);
        String[] command = coord.split(",");
        SendMessage sendMessage = new SendMessage();
        User user = new User(message.getFrom().getUserName(), message.getFrom().getId(), message.getFrom().getFirstName(),
                message.getFrom().getLastName(), Double.parseDouble(command[0]), Double.parseDouble(command[1]),
                message.getFrom().getLanguageCode());
        JsonExecutor.saveUser(user);
        sendMessage.setChatId(Long.toString(message.getChatId()));
        if (!isRu) sendMessage.setText(Constant.COORDINATES_WAS_SAVE_EN);
        else sendMessage.setText(Constant.COORDINATES_WAS_SAVE_RU);
        return sendMessage;
    }

    public static SendMessage setKyivCoordinates(Message message, boolean isRu) {
        SendMessage sendMessage = new SendMessage();
        User user = new User(message.getFrom().getUserName(), message.getFrom().getId(), message.getFrom().getFirstName(),
                message.getFrom().getLastName(), 50.450001, 30.523333, message.getFrom().getLanguageCode());
        JsonExecutor.saveUser(user);
        sendMessage.setChatId(Long.toString(message.getChatId()));
        if (!isRu)sendMessage.setText(Constant.KYIV_COORDINATES_WAS_SAVE_EN);
        else sendMessage.setText(Constant.KYIV_COORDINATES_WAS_SAVE_RU);
        return sendMessage;
    }

    public static SendMessage setLocationCoordinate(Message message, boolean isRu){
        SendMessage sendMessage = new SendMessage();
        User user = new User(message.getFrom().getUserName(), message.getFrom().getId(), message.getFrom().getFirstName(),
                message.getFrom().getLastName(), message.getLocation().getLatitude(), message.getLocation().getLongitude(),
                message.getFrom().getLanguageCode());
        JsonExecutor.saveUser(user);
        sendMessage.setChatId(Long.toString(message.getChatId()));
        if (!isRu) sendMessage.setText(Constant.COORDINATES_WAS_SAVE_EN);
        else sendMessage.setText(Constant.COORDINATES_WAS_SAVE_RU);
        return sendMessage;
    }
}
