import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main22
{
    static String actorID1;
    static String actorID2;
    static private String path;
    static List<String> checkedActors = new ArrayList<>();
    static List<String> checkedMovies = new ArrayList<>();

    static Actor getName() throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();
        String json = HTTPClient.searchForActor(name);
        JSONArray names = new JSONArray(json);
        if(names.length()>1)
        {
            System.out.println("Choose one: \n");
            for(int i = 0; i < names.length(); i++)
            {
                System.out.println((i) + ": " + names.get(i));
            }

        }
        int index = Integer.parseInt(br.readLine());
        JSONObject o = new JSONObject(names.get(index).toString());
        System.out.println(o.get("id"));
        Actor actor = new Actor(o.get("id").toString(), o.get("name").toString());
        return actor;
    }

    static private boolean searchActor(String actorID, int level)
    {
        //if search depth is too high just quit
        if(level > 3)
            return false;
        //get movies that actor played in
        String moviesString = HTTPClient.requestMoviesWithActor(actorID);
        JSONArray movieArray = new JSONArray(moviesString);
        //now for each movie...
        for(Object o : movieArray)
        {
            //...initialize it
            JSONObject movie = new JSONObject(o.toString());
            //get movie id
            System.out.println(o);
            String movieID = movie.get("id").toString();
            //check if the movie appeared already. there is no point checking it twice
            if(checkedMovies.contains(movieID))
                continue;
            else
                checkedMovies.add(movieID);

            //now we want to know which actors played in this movie
            String movieDetailsString = HTTPClient.requestMovieInfo(movieID);
            JSONObject movieDetails = new JSONObject(movieDetailsString);
            Object actorsInMovieObject = movieDetails.get("actors");
            JSONArray actorsInMovieArray = new JSONArray(actorsInMovieObject.toString());

            for(Object actorObject : actorsInMovieArray)
            {
                System.out.println(actorObject);
                JSONObject actor = new JSONObject(actorObject.toString());
                System.out.println(actorObject);
                Object theActorID = actor.get("id");
                if(checkedActors.contains(theActorID.toString()))
                    continue;
                else
                    checkedActors.add(theActorID.toString());

                if(theActorID.toString() == actorID2 || searchActor(theActorID.toString(), level+1))
                {
                    path = path + " - " + movie.get("title") + " - " + actor.get("name");
                    return true;
                }
            }

        }
        return false;
    }
    public static void main(String[] args) throws IOException
    {
        System.out.println("Link from: \n");
        Actor actor1 = getName();
        actorID1 = actor1.getId();
        System.out.println("Link to: \n");
        Actor actor2 = getName();
        actorID2 = actor1.getId();

        path = (new JSONObject(HTTPClient.requestActorInfo(actorID2))).get("name").toString();
        searchActor(actorID2,1);

        System.out.println(path);
    }
}
