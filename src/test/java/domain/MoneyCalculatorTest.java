package domain;

import static org.assertj.core.api.AssertionsForInterfaceTypes.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 *   class description
 *
 *   @author ParkDooWon
 */
public class MoneyCalculatorTest {
	private static Stream<Arguments> inputMoney() {
		return Stream.of(
			Arguments.of(100_000, 0, PaymentWay.CARD, 100_000),
			Arguments.of(100_000, 0, PaymentWay.CASH, 100_000 * 0.95),
			Arguments.of(100_000, 20, PaymentWay.CARD, 100_000 - 20_000),
			Arguments.of(100_000, 20, PaymentWay.CASH, (100_000 - 20_000) * 0.95),
			Arguments.of(100_000, 15, PaymentWay.CARD, 100_000 - 10_000),
			Arguments.of(100_000, 15, PaymentWay.CASH, (100_000 - 10_000) * 0.95)
		);
	}

	@DisplayName("각 상황에 따른 할인 적용한 금액 확인")
	@ParameterizedTest
	@MethodSource("inputMoney")
	void calculateFinalMoneyTest(double sumBill, int chickenCount, PaymentWay paymentWay, double totalMoney) {
		assertThat(MoneyCalculator.calculateTotalMoney(sumBill, chickenCount, paymentWay)).isEqualTo(totalMoney);
	}
}
