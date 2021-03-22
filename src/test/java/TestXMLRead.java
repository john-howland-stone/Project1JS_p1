import com.Project1JS.model.XMLRead;
import com.Project1JS.model.XMLReadCache;
import org.junit.jupiter.api.Assertions;

public class TestXMLRead {
    //@Test
    public void testXMLReadOnce() {
        String result = XMLReadCache.getInstance().runQuery(new XMLRead("heroes"));
        Assertions.assertTrue(result.equals("| uther | paladin | 10 | \r\n"));
    }
    //@Test
    public void testXMLReadTwice() {
        XMLReadCache.getInstance().runQuery(new XMLRead("heroes"));
        Assertions.assertTrue(XMLReadCache.getInstance().runQuery(new XMLRead("heroes")).equals("| uther | paladin | 10 | \r\n"));
    }
}
