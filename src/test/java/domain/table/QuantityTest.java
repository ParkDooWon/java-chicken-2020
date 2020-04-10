package domain.table;

import static org.assertj.core.api.AssertionsForInterfaceTypes.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

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
		assertThatThrownBy(() -> quantity.addedQuantity(0))
			.isInstanceOf(InvalidQuantityException.class)
			.hasMessage(InvalidQuantityException.LESS_THAN_MIN_QUANTITY);
	}

	@DisplayName("주문된 수량이 99를 초과하는 경우 예외 발생")
	@ParameterizedTest
	@CsvSource({"1, 99", "99, 1"})
	void validateMaxTotalQuantityTest(int beforeQuantity, int afterQuantity) {
		quantity = quantity.addedQuantity(beforeQuantity);
		assertThatThrownBy(() -> quantity.addedQuantity(afterQuantity))
			.isInstanceOf(InvalidQuantityException.class)
			.hasMessage(InvalidQuantityException.MORE_THAN_MAX_QUANTITY);
	}

	@DisplayName("초기에 들어온 수량이 99를 넘으면 예외 발생")
	@Test
	void validateInitialQuantityTest() {
		assertThatThrownBy(() -> Quantity.of(100))
			.isInstanceOf(InvalidQuantityException.class)
			.hasMessage(InvalidQuantityException.MORE_THAN_MAX_QUANTITY);
	}

	@DisplayName("수량이 더해지는지 확인")
	@ParameterizedTest
	@ValueSource(ints = {1, 50, 99})
	void addTest(int inputQuantity) {
		assertThat(quantity.addedQuantity(inputQuantity).getQuantity()).isEqualTo(inputQuantity);
	}
}
