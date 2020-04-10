package domain.table;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import domain.exception.InvalidTableException;

/**
 *   class description
 *
 *   @author ParkDooWon
 */
public class TablesTest {
	private Tables tables;

	private static Stream<Arguments> inputTables() {
		return Stream.of(
			Arguments.of(1, TableRepository.tables().get(0)),
			Arguments.of(5, TableRepository.tables().get(3)),
			Arguments.of(6, TableRepository.tables().get(4)),
			Arguments.of(8, TableRepository.tables().get(5))
		);
	}

	@BeforeEach
	void setUp() {
		tables = new Tables();
	}

	@DisplayName("선택한 테이블이 존재하지 않으면 예외 발생")
	@ParameterizedTest
	@ValueSource(strings = {"0", "4", "7", "9"})
	void isPresentMenuTest(int tableNumber) {
		assertThatThrownBy(() -> tables.getSelectTable(tableNumber))
			.isInstanceOf(InvalidTableException.class)
			.hasMessage(InvalidTableException.INVALID_TABLE_NUMBER);
	}

	@DisplayName("선택한 테이블을 반환")
	@ParameterizedTest
	@MethodSource("inputTables")
	void getSelectMenuTest(int tableNumber, Table table) {
		assertThat(tables.getSelectTable(tableNumber)).isEqualTo(table);
	}
}
