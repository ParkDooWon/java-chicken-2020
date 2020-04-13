package domain.table;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TableRepository {
    public static List<Table> createTables() {
        return Collections.unmodifiableList(initializeTables());
    }

    public static List<Table> initializeTables() {
        List<Table> tables = new ArrayList<>();
        tables.add(new Table(1, new Bill()));
        tables.add(new Table(2, new Bill()));
        tables.add(new Table(3, new Bill()));
        tables.add(new Table(5, new Bill()));
        tables.add(new Table(6, new Bill()));
        tables.add(new Table(8, new Bill()));
        return tables;
    }
}
