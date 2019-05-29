import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HTTPClientTest extends HTTPClient {

    @org.junit.jupiter.api.Test
    void searchForActor1() {
        String results = searchForActor("Johnny Depp");
        assertNotNull(results);
        System.out.println(results);
    }
    @Test
    void requestMoviesWithActor1()
    {
        String actorText = searchForActor("Johnny Depp");
        JSONObject actorJSON = new JSONObject(actorText.substring(1,actorText.length()-1));
        String id = actorJSON.get("id").toString();
        String movies = requestMoviesWithActor(id);
        System.out.println(movies);
        assertNotNull(movies);
    }
}