package weather_bot;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.commands.SetMyCommands;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import weather_bot.commands.*;
import weather_bot.utils.CheckUpdateMethods;
import weather_bot.utils.Constant;

import java.util.List;
import java.util.ResourceBundle;

public class WeatherBot extends TelegramLongPollingBot {
    private static final Logger LOGGER = LogManager.getLogger(WeatherBot.class);
    private static String path;
    private final ResourceBundle resource = ResourceBundle.getBundle("bot");
    private final String botName = resource.getString("bot.name");
    private final String botToken = resource.getString("bot.token");

    @Override
    public String getBotUsername() {
        return botName;
    }

    @Override
    public String getBotToken() {
        return botToken;
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String message = update.getMessage().getText();
            String messageToUser;
            boolean isRu = update.getMessage().getFrom().getLanguageCode().equals("ru") ||
                    update.getMessage().getFrom().getLanguageCode().equals("uk");
            if (isRu) setCommands("ru");
            else setCommands("en");
            if (!CheckUpdateMethods.isMessageCommand(message)) {
                if (CheckUpdateMethods.isThisCoordinates(message)) {
                    messageToUser = null;
                    try {
                        execute(SetCoordinates.setCoordinates(update.getMessage(), isRu));
                    } catch (TelegramApiException e) {
                        LOGGER.error(e.getMessage());
                    }
                } else if (CheckUpdateMethods.isCity(message, isRu)){
                    messageToUser = null;
                    try {
                        execute(SetCoordinates.setCoordinatesByCity(update.getMessage(), isRu));
                    } catch (TelegramApiException e) {
                        LOGGER.error(e.getMessage());
                    }
                } else {
                    if (isRu) messageToUser = Constant.NOT_COMMAND_MESSAGE_RU;
                    else messageToUser = Constant.NOT_COMMAND_MESSAGE_EN;
                }
            } else {
                if (!CheckUpdateMethods.checkCommands(message)) {
                    if (isRu) messageToUser = Constant.NOT_ALLOWED_COMMAND_RU;
                    else messageToUser = Constant.NOT_ALLOWED_COMMAND_EN;
                } else {
                    messageToUser = null;
                    try {
                        execute(message, update, isRu);
                    } catch (TelegramApiException e) {
                        LOGGER.warn(e.getMessage());
                    }
                }
            }
            if (messageToUser != null) {
                SendMessage sendMessage = new SendMessage();
                long chatId = update.getMessage().getChatId();
                sendMessage.setText(messageToUser);
                sendMessage.setChatId(Long.toString(chatId));
                try {
                    execute(sendMessage);
                } catch (TelegramApiException e) {
                    LOGGER.error(e.getMessage());
                }
            }
        } else if (update.hasMessage() && update.getMessage().hasLocation()){
            boolean isRu = update.getMessage().getFrom().getLanguageCode().equals("ru") ||
                    update.getMessage().getFrom().getLanguageCode().equals("uk");
            try {
                execute(SetCoordinates.setLocationCoordinate(update.getMessage(), isRu));
            } catch (TelegramApiException e) {
                LOGGER.warn(e.getMessage());
            }
        }
    }

    public void setCommands(String lang) {
        SetMyCommands commands = new SetMyCommands();
        commands.setCommands(List.of(new StartCommand(lang), new HelpCommand(lang), new NowWeatherCommand(lang),
                new SetCoordinates(lang), new CitiesCommand(lang), new Next24HoursCommand(lang)));
        try {
            execute(commands);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    public void execute(String command, Update update, boolean isRu) throws TelegramApiException {
        switch (command) {
            case "/start":
                execute(StartCommand.showMessage(update.getMessage().getChatId(), isRu));
                break;
            case "/help":
                execute(HelpCommand.showMessage(update.getMessage(), isRu));
                break;
            case "/coordinates":
                execute(SetCoordinates.setKyivCoordinates(update.getMessage(), isRu));
                break;
            case "/now":
                if (CheckUpdateMethods.isUserInfoInDataBase(update.getMessage().getFrom().getId()))
                    execute(NowWeatherCommand.sendWeatherPhoto(update.getMessage(), isRu));
                else execute(NowWeatherCommand.sendErrorMessage(update.getMessage(), isRu));
                break;
            case "/cities":
                execute(CitiesCommand.showCities(update.getMessage(), isRu));
                break;
            case "/next24hours":
                if (CheckUpdateMethods.isUserInfoInDataBase(update.getMessage().getFrom().getId()))
                    execute(Next24HoursCommand.sendDayForecast(update.getMessage(), isRu));
                else execute(NowWeatherCommand.sendErrorMessage(update.getMessage(), isRu));
                break;
        }
    }

    public static String getPath() {
        return path;
    }

    public static void setPath(String path) {
        WeatherBot.path = path;
    }
}