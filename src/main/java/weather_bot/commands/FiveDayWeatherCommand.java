package weather_bot.commands;

import org.telegram.telegrambots.meta.api.objects.commands.BotCommand;

public class FiveDayWeatherCommand extends BotCommand {

    public FiveDayWeatherCommand() {
        setCommand("five_days");
        setDescription("shows weather for five days");
    }
}
