package weather_bot.commands;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.commands.BotCommand;
import weather_bot.utils.Constant;

public class HelpCommand extends BotCommand {

    public HelpCommand(String lang) {
        setCommand("help");
        if (lang.equals("ru")) setDescription(Constant.HELP_COMMAND_DESCRIPTION_RU);
        else setDescription(Constant.HELP_COMMAND_DESCRIPTION_EN);
    }

    public static SendMessage showMessage(Message message, boolean isRu) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(Long.toString(message.getChatId()));
        if (isRu) sendMessage.setText(Constant.HELP_MESSAGE_RU);
        else sendMessage.setText(Constant.HELP_MESSAGE_EN);
        return sendMessage;
    }
}
