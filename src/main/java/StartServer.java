import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import weather_bot.WeatherBot;

/**
 * Here bot start working, it is passed registration phase, and also we save a path from where it was deployed,
 * there we will be kept needed information about users, that use this bot
 * **/
public class StartServer {
    public static void main(String[] args) {
        try {
            TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
            WeatherBot weatherBot = new WeatherBot();
            WeatherBot.setPath(System.getProperty("user.dir"));
            telegramBotsApi.registerBot(weatherBot);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }
}
