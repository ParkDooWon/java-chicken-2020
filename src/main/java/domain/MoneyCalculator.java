package domain;

/**
 *   class description
 *
 *   @author ParkDooWon
 */
public class MoneyCalculator {
	private static final int CHICKEN_UNIT = 10;
	private static final int CHICKEN_DISCOUNT_MONEY = 10_000;

	public static double calculateTotalMoney(double sumBill, int chickenCount, PaymentWay paymentWay) {
		sumBill -= chickenDiscountMoney(chickenCount);
		return paymentWay.applyPaymentWayDiscount(sumBill);
	}

	private static double chickenDiscountMoney(int chickenCount) {
		return (double)(chickenCount / CHICKEN_UNIT) * CHICKEN_DISCOUNT_MONEY;
	}
}
