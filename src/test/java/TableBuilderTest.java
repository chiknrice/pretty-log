import org.chiknrice.log.Table;
import org.chiknrice.log.TableBuilder;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author <a href="mailto:chiknrice@gmail.com">Ian Bondoc</a>
 */
public class TableBuilderTest {

    @Test
    public void testBuildZeroColumns() {
        Table table = TableBuilder.newTable(120, 2).build();
        assertThat(table.getColumns().size(), is(0));
    }

    @Test
    public void testBuildWithThreeColumns() {
        Table table = TableBuilder.newTable(120, 2).withColumns("a", "b", "c").build();
        assertThat(table.getColumns().size(), is(3));
        assertThat(table.getColumns().get(1).getName(), is("b"));
        assertThat(table.getColumns().get(1).getMaxLength(), is(0));
    }



}
