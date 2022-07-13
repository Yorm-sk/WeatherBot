package weather_bot.utils.requests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ResourceBundle;

public class RequestSender {
    private static final Logger LOGGER = LogManager.getLogger(RequestSender.class);
    private static final ResourceBundle resource = ResourceBundle.getBundle("weather");
    private static final String appId = resource.getString("appid");

    public static String getStringFromCurrentWeatherResponse(double lat, double lon, boolean isRu) {
        StringBuilder result = new StringBuilder();
        try {
            URL url;
            if (isRu) url =
                    new URL("https://api.openweathermap.org/data/2.5/weather?lat=" + lat +
                            "&lon=" + lon +
                            "&appid="+ appId +
                            "&units=metric&lang=ru");
            else url =
                    new URL("https://api.openweathermap.org/data/2.5/weather?lat=" + lat +
                            "&lon=" + lon +
                            "&appid="+ appId +
                            "&units=metric&lang=en");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            Charset charset = StandardCharsets.UTF_8;

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream(), charset));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                result.append(inputLine);
            }
            in.close();
            con.disconnect();

        } catch (IOException e) {
            LOGGER.error(e.getMessage());
        }
        return result.toString();
    }

    public static String getStringFromNext24WeatherResponse(double lat, double lon, boolean isRu){
        StringBuilder result = new StringBuilder();
        try {
            URL url;
            if (isRu) url =
                    new URL("https://api.openweathermap.org/data/2.5/forecast?" +
                            "lat=" + lat +
                            "&lon=" + lon +
                            "&appid="+ appId +
                            "&units=metric&" +
                            "lang=ru" +
                            "&cnt=9");
            else url =
                    new URL("https://api.openweathermap.org/data/2.5/forecast?lat=" + lat +
                            "&lon=" + lon +
                            "&appid="+ appId +
                            "&units=metric&" +
                            "lang=en" +
                            "&cnt=9");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            Charset charset = StandardCharsets.UTF_8;

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream(), charset));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                result.append(inputLine);
            }
            in.close();
            con.disconnect();

        } catch (IOException e) {
            LOGGER.error(e.getMessage());
        }
        return result.toString();
    }
}
