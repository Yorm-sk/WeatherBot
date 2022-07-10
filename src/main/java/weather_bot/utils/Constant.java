package weather_bot.utils;

import java.util.HashMap;

public interface Constant {
    String NOT_COMMAND_MESSAGE_EN = "enter a command or coordinates property, please";
    String NOT_COMMAND_MESSAGE_RU = "пожалуйста введите команду или координаты правильно";
    String NOT_ALLOWED_COMMAND_EN = "there is no such command";
    String NOT_ALLOWED_COMMAND_RU = "такой команды не существует";

    String HELP_MESSAGE_EN = "This bot can show you current weather for your region\n" +
            "To set up your region you can just send your geolocation\n" +
            "Also you can enter your coordinates separated with coma and send it\n" +
            "Please, enter latitude first and then longitude" +
            "(for Kyiv you should enter: 50.450001,30.523333), if you do so your coordinates will be saved, so you" +
            " don`t need to reenter coordinates each time\n" +
            "To change coordinates again do the same procedure\n" +
            "If you enter just /coordinates command coordinate of Kyiv will be applied\n" +
            "Also you can enter a city name from our list /cities\n" +
            "Now you can enter /now command to see picture, which shows cloudiness and description with temperature" +
            "and some additional information\n" +
            "/next24hours command will show you weather for next 24 hours, date format - month-day hour:minutes " +
            "(to see forecast click or choose photo)";
    String HELP_MESSAGE_RU = "Этот бот показывает текущую погоду в вашем регионе\n" +
            "Вы можете просто отправить ваше текущую геопозицю\n" +
            "Еще один способ установить ваш регион: введите координаты через запятую и отправьте сообщение\n" +
            "Пожалуйста, вводите сначала широту, потом долготу\n" +
            "(для Киева к примеру введите: 50.450001,30.523333), после введения координат они сохраняться для вашего" +
            " пользователя, так что каждый раз вводить координаты не нужно\n" +
            "Для смены текущего региона просто введите координаты снова\n" +
            "Если вы просто введете команду /coordinates - вам будут назначены координаты Киева\n" +
            "Так же вы можете ввести имя города из списка /cities\n" +
            "После введения координат выполните команду /now, " +
            "чтобы увидеть картинку с текущей облачностью и данными о текущей погоде\n" +
            "Команда /next24hours покажет погоду на следующие 24 часа, дата указана в формате месяц-день часы:минуты" +
            "(погода описана под каждой картинкой)";
    String START_MESSAGE_EN = "What can this bot do?\nProvide you with current weather of your region ;)\n" +
            " To know how it work enter /help command";
    String START_MESSAGE_RU = "Для чего нужен этот бот?\nОн может показать вам текущую погоду в вашем регионе ;)\n" +
            "Чтобы подробнее узнать о работе бота введите команду /help";
    String COORDINATES_WAS_SAVE_EN = "Your coordinates was saved";
    String COORDINATES_WAS_SAVE_RU = "Ваши координаты были сохранены";
    String KYIV_COORDINATES_WAS_SAVE_EN = "Your coordinates of Kyiv was saved";
    String KYIV_COORDINATES_WAS_SAVE_RU = "Координаты Киева сохранены";
    String START_COMMAND_DESCRIPTION_EN = "shows information about bots capability";
    String START_COMMAND_DESCRIPTION_RU = "приветсвенное сообщение бота";
    String NOW_COMMAND_DESCRIPTION_EN = "show current weather for your region";
    String NOW_COMMAND_DESCRIPTION_RU = "показывает погоду для текущего региона";
    String HELP_COMMAND_DESCRIPTION_EN = "shows how bots work";
    String HELP_COMMAND_DESCRIPTION_RU = "инструкции по работе с ботом";
    String COORD_COMMAND_DESCRIPTION_EN = "set coordinates for Kiev city";
    String COORD_COMMAND_DESCRIPTION_RU = "устанавливает значения координат Киева";
    String CITIES_COMMAND_DESCRIPTION_EN = "shows cities in our database";
    String CITIES_COMMAND_DESCRIPTION_RU = "показывает доступные города";
    String NO_COORDINATES_SET_EN = "Set your location first";
    String NO_COORDINATES_SET_RU = "Для начала введите ваши координаты";
    String NEXT_COMMAND_DESCRIPTION_EN = "weather for next 24 hour, each 3 hours";
    String NEXT_COMMAND_DESCRIPTION_RU = "погода на следующие сутки, каждые 3 часа";
    HashMap<String, String> CITIES_EN = new HashMap<>(){{
        put("Kyiv", "50.45466,30.5238");
        put("Lviv", "49.842957,24.031111");
        put("Ternopil", "49.553516,25.594767");
        put("Ivano-Frankivsk", "48.92312,24.71248");
        put("Kharkiv", "49.98081,36.25272");
        put("Dnipro", "48.46664,35.04066");
        put("Vinnytsia ", "49.2322,28.46871");
        put("Rivne", "50.62308,26.22743");
        put("Zaporizhia", "47.85167,35.11714");
        put("Odessa", "46.48572,30.74383");
        put("Khmelnytskyy", "49.41835,26.97936");
        put("Lutsk", "50.75932,25.34244");
        put("Poltava", "49.58925,34.55367");
        put("Cherkasy", "49.44452,32.05738");
        put("Zhytomyr", "50.26487,28.67669");
        put("Chernivtsi", "48.29045, 2593241");
        put("Kropyvnytskyy", "48.50834,32.26618");
        put("Chernihiv", "51.50551,31.28487");
        put("Mykolayiv", "46.97625,31.99296");
        put("Sumy", "50.9216,34.80029");
        put("Uzhgorod", "48.6242,22.2947");
        put("Kherson", "46.63695,32.61458");
        put("Donetsk", "48.023,37.80224");
        put("Luhansk", "48.56705,39.31706");
        put("Simferopol", "44.95719,34.11079");
        put("Moscow", "55.75222,37.61556");
        put("Saint Petersburg", "59.93863,30.31413");
        put("Murmansk", "68.97917,33.09251");
        put("Amsterdam", "52.37403,4.88969");
        put("Athens", "37.98376,23.72784");
        put("Belgrade", "44.80401,20.46513");
        put("Berlin", "52.52437,13.41053");
        put("Bern", "46.94809,7.44744");
        put("Copenhagen", "55.67594,12.56553");
        put("Dublin", "53.33306,-6.24889");
        put("Lisbon", "38.71667,-9.13333");
        put("London", "51.50853,-0.12574");
        put("Madrid", "40.4165,-3.70256");
        put("Minsk", "53.9,27.56667");
        put("Oslo", "59.91273,10.74609");
        put("Paris", "48.85341,2.3488");
        put("Reykjavik", "64.13548,-21.89541");
        put("Warsaw", "52.22977,21.01178");
        put("New York", "40.71427,-74.00597");
        put("Prague", "50.08804,14.42076");
    }};
    HashMap<String, String> CITIES_RU = new HashMap<>(){{
        put("Киев", "50.45466,30.5238");
        put("Львов", "49.842957,24.031111");
        put("Тернополь", "49.553516,25.594767");
        put("Ивано-Франковск", "48.92312,24.71248");
        put("Харьков", "49.98081,36.25272");
        put("Днепр", "48.46664,35.04066");
        put("Винница", "49.2322,28.46871");
        put("Ровно", "50.62308,26.22743");
        put("Запорожье", "47.85167,35.11714");
        put("Одесса", "46.48572,30.74383");
        put("Хмельницкий", "49.41835,26.97936");
        put("Луцк", "50.75932,25.34244");
        put("Полтава", "49.58925,34.55367");
        put("Черкассы", "49.44452,32.05738");
        put("Житомир", "50.26487,28.67669");
        put("Черновцы", "48.29045, 2593241");
        put("Кропивницкий", "48.50834,32.26618");
        put("Чернигов", "51.50551,31.28487");
        put("Николаев", "46.97625,31.99296");
        put("Сумы", "50.9216,34.80029");
        put("Ужгород", "48.6242,22.2947");
        put("Херсон", "46.63695,32.61458");
        put("Донецк", "48.023,37.80224");
        put("Луганск", "48.56705,39.31706");
        put("Симферополь", "44.95719,34.11079");
        put("Москва", "55.75222,37.61556");
        put("Санкт-Петербург", "59.93863,30.31413");
        put("Мурманск", "68.97917,33.09251");
        put("Амстердам", "52.37403,4.88969");
        put("Афины", "37.98376,23.72784");
        put("Белград", "44.80401,20.46513");
        put("Берлин", "52.52437,13.41053");
        put("Берн", "46.94809,7.44744");
        put("Копенгаген", "55.67594,12.56553");
        put("Дублин", "53.33306,-6.24889");
        put("Лиссабон", "38.71667,-9.13333");
        put("Лондон", "51.50853,-0.12574");
        put("Мадрид", "40.4165,-3.70256");
        put("Минск", "53.9,27.56667");
        put("Осло", "59.91273,10.74609");
        put("Париж", "48.85341,2.3488");
        put("Рейкьявик", "64.13548,-21.89541");
        put("Варшава", "52.22977,21.01178");
        put("Нью-Йорк", "40.71427,-74.00597");
        put("Прага", "50.08804,14.42076");
    }};
}
