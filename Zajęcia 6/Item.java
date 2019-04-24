import java.time.LocalDate;
import java.util.Date;

public class Item {
    private String Title;
    private String Description;
    private Priority Priority;
    private LocalDate Deadline;

    Item(String _Title, String _Description, Priority _Priority, LocalDate _Deadline){Title = _Title; Description = _Description; Priority = _Priority; Deadline = _Deadline;}

    public String getTitle(){return Title;}
    public String getDescription(){return Description;}
    public Priority getPriority(){return Priority;}
    public LocalDate getDeadline(){return Deadline;}
}
