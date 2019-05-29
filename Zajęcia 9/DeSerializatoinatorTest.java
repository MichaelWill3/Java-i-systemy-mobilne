import org.junit.jupiter.api.Test;

import java.util.Vector;

import static org.junit.jupiter.api.Assertions.*;

class DeSerializatoinatorTest extends DeSerializatoinator {
    String string = "{\"id\":\"tt0117571\",\"title\":\"Scream\",\"actors\":[{\"id\":\"nm0000117\",\"name\":\"Neve Campbell\"},{\"id\":\"nm0000274\",\"name\":\"David Arquette\"},{\"id\":\"nm0000240\",\"name\":\"Skeet Ulrich\"},{\"id\":\"nm0001073\",\"name\":\"Courteney Cox\"}]}";

    @Test void test()
    {
        Movie m = deserializeMovieData(string);
        assertNotNull(m);
        System.out.println(m);
    }
}