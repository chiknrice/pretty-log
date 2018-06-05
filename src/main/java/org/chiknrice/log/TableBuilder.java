package org.chiknrice.log;

import java.util.*;

/**
 * @author <a href="mailto:chiknrice@gmail.com">Ian Bondoc</a>
 */
public class TableBuilder {

    private final int maxWidth;
    private final int cellPadding;
    private List<Column> columns;

    public static TableBuilder newTable(int maxWidth, int cellPadding) {
        return new TableBuilder(maxWidth, cellPadding);
    }

    private TableBuilder(int maxWidth, int cellPadding) {
        this.maxWidth = maxWidth;
        this.cellPadding = cellPadding;
        this.columns = new ArrayList<>();
    }

    public TableBuilder withColumns(String... columnNames) {
        for (String columnName : columnNames) {
            withColumn(columnName);
        }
        return this;
    }

    public TableBuilder withColumn(String columnName) {
        return withColumn(columnName, 0);
    }

    public TableBuilder withColumn(final String columnName, final int maxLength) {
        columns.add(new Column() {

            @Override
            public String getName() {
                return columnName;
            }

            @Override
            public int getMaxLength() {
                return maxLength;
            }

            @Override
            public boolean equals(Object obj) {
                if (obj == null) {
                    return false;
                } else if (!(obj instanceof Column)) {
                    return false;
                } else {
                    Column other = (Column) obj;
                    return other.getName().equals(getName()) || other.getMaxLength() == getMaxLength();
                }
            }
        });
        return this;
    }

    public Table build() {

        return new Table() {

            private final List<Column> columns = TableBuilder.this.columns;
            private final List<Row> rows = new ArrayList<>();

            @Override
            public Iterator<Row> iterator() {
                return null;
            }

            @Override
            public List<Column> getColumns() {
                return columns;
            }

            @Override
            public void sort(String columnName) {

            }

            @Override
            public void addRow(String... cellValues) {
                final Map<Column, Cell> tempCells = new HashMap<>();
                for (int i = 0; i < cellValues.length; i++) {
                    final String data = cellValues[i];
                    tempCells.put(columns.get(i), new Cell() {

                        int pos = 0;

                        @Override
                        public boolean hasMoreData() {
                            return pos < data.length();
                        }

                        @Override
                        public String readData(int maxLenght) {
                            return null;
                        }

                    });
                }
                rows.add(new Row() {

                    private final Map<Column, Cell> cells = tempCells;

                    @Override
                    public void setCell(int index, String data) {

                    }

                });
            }

        };
    }

}
