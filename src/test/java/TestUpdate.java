import com.Project1JS.util.XMLDao;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestUpdate {
    @Test
    public void Update() {
        XMLDao.getInstance().update("heroes",0,"Arthas","Lady Nightsorrow");
        Assertions.assertTrue(true);
    }
}
