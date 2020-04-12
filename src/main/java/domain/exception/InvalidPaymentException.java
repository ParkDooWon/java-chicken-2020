package domain.exception;

/**
 *   class description
 *
 *   @author ParkDooWon
 */
public class InvalidPaymentException extends IllegalArgumentException {
	public static final String INVALID_PAYMENTWAY = "선택한 결제수단은 없는 결제수단입니다.";

	public InvalidPaymentException(String s) {
		super(s);
	}
}
