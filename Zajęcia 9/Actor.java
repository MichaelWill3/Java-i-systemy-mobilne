public class Actor{
    private String name;
    private String id;

    Actor(String _id,String _name){name = _name; id = _id;}

    String getName(){return name;}
    String getId(){return id;}

    public boolean equals(Actor a) {
        if(a.id == id) return true;
        else return false;
    }
}
