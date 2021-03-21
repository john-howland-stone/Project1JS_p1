import com.Project1JS.util.XMLDao;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class TestRead {
    //@Test
    public void testReadValid() {
        Assertions.assertFalse(XMLDao.getInstance().getAll("heroes").equals("Table does not exist"));
    }
    //@Test
    public void testReadInValid() {
        Assertions.assertTrue(XMLDao.getInstance().getAll("heroes2").equals("Table does not exist"));
    }
}
