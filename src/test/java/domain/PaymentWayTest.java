package domain;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import domain.exception.InvalidPaymentException;

/**
 *   class description
 *
 *   @author ParkDooWon
 */
public class PaymentWayTest {
	@DisplayName("번호에 따른 결제 수단 Enum을 반환")
	@ParameterizedTest
	@CsvSource({"1, CARD", "2, CASH"})
	void ofTest(String input, PaymentWay paymentWay) {
		assertThat(PaymentWay.of(input)).isEqualTo(paymentWay);
	}

	@DisplayName("잘못된 결제 수단 번호 입력시 예외 발생")
	@ParameterizedTest
	@ValueSource(strings = {"0", "4"})
	void invalidInput(String input) {
		assertThatThrownBy(() -> PaymentWay.of(input))
			.isInstanceOf(InvalidPaymentException.class)
			.hasMessage(InvalidPaymentException.INVALID_PAYMENTWAY);
	}

	@DisplayName("결제 수단에 따른 총 가격 계산")
	@ParameterizedTest
	@ValueSource(doubles = {10000, 20000, 555000})
	void applyPaymentWayDiscountTest(double totalMoney) {
		PaymentWay cash = PaymentWay.CASH;
		PaymentWay card = PaymentWay.CARD;

		double cashTotalMoney = totalMoney * 0.95;
		assertThat(cash.applyPaymentWayDiscount(totalMoney)).isEqualTo(cashTotalMoney);
		assertThat(card.applyPaymentWayDiscount(totalMoney)).isEqualTo(totalMoney);
	}

	@DisplayName("선택한 결제수단이 현금인지 확인")
	@ParameterizedTest
	@CsvSource({"CASH, true", "CARD, false"})
	void isCashTest(PaymentWay paymentWay, boolean expected) {
		assertThat(paymentWay.isCash()).isEqualTo(expected);
	}
}
