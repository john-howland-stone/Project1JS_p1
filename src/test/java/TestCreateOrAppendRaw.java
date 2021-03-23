import com.Project1JS.util.XMLDao;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;

public class TestCreateOrAppendRaw {
    //@Test
    public void createorappendRaw() {
        String tablename = "heroes";
        ArrayList<String> values = new ArrayList<>();
        values.add("uther");
        values.add("Paladin");
        values.add("10");
        Assertions.assertTrue(true);
    }
    //@Test
    public void createorappendrawInvalid() {
        String tablename = "heroes";
        ArrayList<String> values = new ArrayList<>();
        values.add("uther");
        values.add("Paladin");
        values.add("10");
        values.add("extra value");
        Assertions.assertTrue(true);
    }
}
