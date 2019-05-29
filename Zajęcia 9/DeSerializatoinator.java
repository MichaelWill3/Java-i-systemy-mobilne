import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class DeSerializatoinator {

    public Vector<Actor> deserializeActorData(String actorData)
    {
        // 0: id
        // 1: name
        Vector<Actor> OutputVector= new Vector();
        String actorDataCopy = actorData.substring(1,actorData.length()-1);
        while(!actorDataCopy.isEmpty()) {
            JSONObject json = new JSONObject(actorDataCopy);
            String name = json.get("name").toString();
            String id = json.get("id").toString();
            Actor actor = new Actor(id,name);
            OutputVector.add(actor);

            //delete the chunk already added
            try {
                actorDataCopy = actorDataCopy.substring(name.length() + actorDataCopy.indexOf(name) + 3, actorDataCopy.length());
            } catch (Exception e) {
                break;
            }
        }
        return OutputVector;
    }

    public Movie deserializeMovieData(String movieData)
    {
        // 0: id
        // 1: title
        // 3: actors
        String movieDataCopy = new String(movieData);//movieData.substring(1,movieData.length()-1);

        //String movieDataCopy = movieData.substring(1,movieData.length()-1);
        JSONObject json = new JSONObject(movieDataCopy);

        String id = json.get("id").toString();
        String title = json.get("title").toString();
        String actorsString = json.get("id").toString();
        Vector<Actor> actors = deserializeActorData(actorsString);
        Movie m = new Movie(id, title, actors);
        return m;
    }
}
