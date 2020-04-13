package domain;

/**
 *   class description
 *
 *   @author ParkDooWon
 */
public class TotalMoney {
	private static final int CHICKEN_UNIT = 10;
	private static final int CHICKEN_DISCOUNT_MONEY = 10_000;

	private final double totalMoney;

	private TotalMoney(double totalMoney) {
		this.totalMoney = totalMoney;
	}

	public static TotalMoney calculateTotalMoney(double sumBill, int chickenCount, PaymentWay paymentWay) {
		sumBill -= chickenDiscountMoney(chickenCount);
		return new TotalMoney(paymentWay.applyPaymentWayDiscount(sumBill));
	}

	private static double chickenDiscountMoney(int chickenCount) {
		return (double)(chickenCount / CHICKEN_UNIT) * CHICKEN_DISCOUNT_MONEY;
	}

	public double getTotalMoney() {
		return totalMoney;
	}
}
