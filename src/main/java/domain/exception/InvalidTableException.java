package domain.exception;

/**
 *   class description
 *
 *   @author ParkDooWon
 */
public class InvalidTableException extends IllegalArgumentException {
	public static final String INVALID_TABLE_NUMBER = "선택한 테이블은 없는 테이블입니다.";

	public InvalidTableException(String s) {
		super(s);
	}
}
