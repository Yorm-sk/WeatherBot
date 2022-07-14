package weather_bot.commands;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.commands.BotCommand;
import weather_bot.utils.Constant;
/**
 * Contain methods that refer to /start command
 * **/
public class StartCommand extends BotCommand {

    public StartCommand(String lang){
        setCommand("start");
        if (lang.equals("ru")) setDescription(Constant.START_COMMAND_DESCRIPTION_RU);
        else setDescription(Constant.START_COMMAND_DESCRIPTION_EN);
    }

    public static SendMessage showMessage(long chatId, boolean isRu){
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(Long.toString(chatId));
        if (!isRu) sendMessage.setText(Constant.START_MESSAGE_EN);
        else sendMessage.setText(Constant.START_MESSAGE_RU);
        return sendMessage;
    }
}
