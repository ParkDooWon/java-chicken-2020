package domain;

import java.util.Arrays;

import domain.exception.InvalidPaymentException;

/**
 *   class description
 *
 *   @author ParkDooWon
 */
public enum PaymentWay {
	CARD("1", 1),
	CASH("2", 0.95);

	private String paymentWay;
	private double discountRatio;

	PaymentWay(String paymentWay, double discountRatio) {
		this.paymentWay = paymentWay;
		this.discountRatio = discountRatio;
	}

	public static PaymentWay of(String paymentWay) {
		return Arrays.stream(PaymentWay.values())
			.filter(p -> p.paymentWay.equals(paymentWay))
			.findFirst()
			.orElseThrow(() -> new InvalidPaymentException(InvalidPaymentException.INVALID_PAYMENTWAY));
	}

	public double applyPaymentWayDiscount(double totalMoney) {
		return totalMoney * this.discountRatio;
	}

	public boolean isCash() {
		return this == CASH;
	}
}