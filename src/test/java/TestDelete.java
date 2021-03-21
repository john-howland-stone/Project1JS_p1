import com.Project1JS.util.XMLDao;
import org.junit.Test;

public class TestDelete {
    //@Test
    public void TestDeleteHit() {
        XMLDao.getInstance().remove("heroes",0,"Uther");
    }
    public void TestDeleteMiss() {
        XMLDao.getInstance().remove("heroes",1,"Uther");
    }
}
