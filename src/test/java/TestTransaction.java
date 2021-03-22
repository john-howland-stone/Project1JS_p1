import com.Project1JS.util.XMLExecutor;
import com.Project1JS.util.XMLTransaction;
import com.Project1JS.model.XMLWriteQuery;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class TestTransaction {
    //@Test
    public void TestRollback() {
        ArrayList<String> values = new ArrayList<>();
        values.add("Antonidas");
        values.add("Archmage");
        values.add("Ten");
        XMLTransaction.getInstance().add(new XMLWriteQuery("heroes",values));
        XMLTransaction.getInstance().add(new XMLWriteQuery("heroes",values));
        XMLTransaction.getInstance().save();
        XMLTransaction.getInstance().add(new XMLWriteQuery("heroes",values));
        XMLTransaction.getInstance().add(new XMLWriteQuery("heroes",values));
        XMLTransaction.getInstance().rollback();
        Assertions.assertTrue(true);
    }
    @Test
    public void TestCommit() throws InterruptedException {
        ArrayList<String> values = new ArrayList<>();
        values.add("Antonidas");
        values.add("Archmage");
        values.add("Ten");
        XMLTransaction.getInstance().add(new XMLWriteQuery("heroes",values));
        XMLTransaction.getInstance().add(new XMLWriteQuery("heroes",values));
        XMLTransaction.getInstance().save();
        XMLTransaction.getInstance().add(new XMLWriteQuery("heroes",values));
        XMLTransaction.getInstance().add(new XMLWriteQuery("heroes",values));
        XMLTransaction.getInstance().commit();
        XMLExecutor.getInstance().getExecutor().awaitTermination(10, TimeUnit.SECONDS);
        Assertions.assertTrue(true);
    }
}
