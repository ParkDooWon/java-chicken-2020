package domain.table;

import static org.assertj.core.api.AssertionsForInterfaceTypes.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import domain.exception.InvalidQuantityException;

/**
 *   class description
 *
 *   @author ParkDooWon
 */
public class QuantityTest {
	private Quantity quantity;

	@BeforeEach
	void setUp() {
		quantity = Quantity.zero();
	}

	@Test
	void createZeroQuantityTest() {
		assertThat(Quantity.zero()).isEqualTo(Quantity.of(0));
	}

	@DisplayName("수량이 0 이상이 아니면 예외 발생")
	@Test
	void validateMinInputQuantityTest() {
		assertThatThrownBy(() -> quantity.add("0"))
			.isInstanceOf(InvalidQuantityException.class)
			.hasMessage(InvalidQuantityException.LESS_THAN_MIN_QUANTITY);
	}

	@DisplayName("주문된 수량이 99를 초과하는 경우 예외 발생")
	@ParameterizedTest
	@CsvSource({"1, 99", "99, 1"})
	void validateMaxTotalQuantityTest(String beforeQuantity, String afterQuantity) {
		quantity = quantity.add(beforeQuantity);
		assertThatThrownBy(() -> quantity.add(afterQuantity))
			.isInstanceOf(InvalidQuantityException.class)
			.hasMessage(InvalidQuantityException.MORE_THAN_MAX_QUANTITY);
	}
}
