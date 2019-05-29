import java.util.Vector;

public class Movie{
    private String id;
    private String title;

    private Vector<Actor> actorList;


    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Vector<Actor> getActorList() {
        return actorList;
    }

    Movie(String _id, String _title, Vector<Actor> actors){id=_id;title=_title;actorList=actors;}
    Movie(String _id, String _title){id=_id;title=_title;}

    public boolean equals(Movie m) {
        if(m.id == id) return true;
        else return false;
    }
}
