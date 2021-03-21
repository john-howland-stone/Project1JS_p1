import jdk.internal.org.xml.sax.SAXException;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class TestJunit {
    //@Test
    public void testJUnitExists() {
        String str = "Junit is working fine";
        Assertions.assertEquals("Junit is working fine",str);
    }
}