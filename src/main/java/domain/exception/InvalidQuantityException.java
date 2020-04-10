package domain.exception;

/**
 *   class description
 *
 *   @author ParkDooWon
 */
public class InvalidQuantityException extends IllegalArgumentException {
	public static final String LESS_THAN_MIN_QUANTITY = "1개 이상의 수량을 입력해야 합니다.";
	public static final String MORE_THAN_MAX_QUANTITY = "99개를 넘어가는 수량을 주문할 수 없습니다.";

	public InvalidQuantityException(String message) {
		super(message);
	}
}
