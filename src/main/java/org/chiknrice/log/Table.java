package org.chiknrice.log;

import java.util.List;

/**
 * @author <a href="mailto:chiknrice@gmail.com">Ian Bondoc</a>
 */
public interface Table extends Iterable<Row> {

    List<Column> getColumns();

    void sort(String columnName);

    void addRow(String... values);

}
