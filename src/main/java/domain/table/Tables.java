package domain.table;

import java.util.List;

import domain.exception.InvalidTableException;

/**
 *   class description
 *
 *   @author ParkDooWon
 */
public class Tables {
	private List<Table> tables;

	public Tables() {
		this.tables = TableRepository.createTables();
	}

	public Table getSelectTable(int tableNumber) {
		return tables.stream()
			.filter(table -> table.getNumber() == tableNumber)
			.findFirst()
			.orElseThrow(() -> new InvalidTableException(InvalidTableException.INVALID_TABLE_NUMBER));
	}

	public boolean isEmptyTables() {
		return tables.stream()
			.allMatch(Table::isPaidTable);
	}

	public List<Table> getTables() {
		return tables;
	}
}
