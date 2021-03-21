import com.Project1JS.util.XMLDao;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;

public class TestCreateOrUpdateRaw {
    //@Test
    public void createOrUpdateRaw() {
        String tablename = "heroes";
        ArrayList<String> values = new ArrayList<>();
        values.add("uther");
        values.add("Paladin");
        values.add("10");
        Assertions.assertEquals("Successfully wrote to database",XMLDao.getInstance().createOrUpdate(tablename,values));
    }
    //@Test
    public void createOrUpdateInvalid() {
        String tablename = "heroes";
        ArrayList<String> values = new ArrayList<>();
        values.add("uther");
        values.add("Paladin");
        values.add("10");
        values.add("extra value");
        Assertions.assertEquals("Number of elements does not match existing definition",XMLDao.getInstance().createOrUpdate(tablename,values));
    }
}
