import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import org.json.JSONObject;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class HTTPClient {

    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    public static String searchForActor(String name)
    {
        name = name.replaceAll(" ", "%20");
        String jsonText;
        try{
            InputStream input = new URL("https://java.kisim.eu.org/actors/search/" + name).openStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(input, Charset.forName("UTF-8")));
            jsonText = readAll(rd);
            return jsonText;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    static public String requestMoviesWithActor(String imdbID)
    {
        String jsonText;
        try{
            InputStream input = new URL("https://java.kisim.eu.org/actors/" + imdbID +"/movies").openStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(input, Charset.forName("UTF-8")));
            jsonText = readAll(rd);
            return jsonText;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    static public String requestMovieInfo(String imdbID)
    {
        String jsonText;
        try{
            InputStream input = new URL("https://java.kisim.eu.org/movies/" + imdbID ).openStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(input, Charset.forName("UTF-8")));
            jsonText = readAll(rd);
            return jsonText;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    static public String requestActorInfo(String imdbID)
    {
        String jsonText;
        try{
            InputStream input = new URL("https://java.kisim.eu.org/actors/" + imdbID ).openStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(input, Charset.forName("UTF-8")));
            jsonText = readAll(rd);
            return jsonText;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
