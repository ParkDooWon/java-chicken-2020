package domain.exception;

/**
 *   class description
 *
 *   @author ParkDooWon
 */
public class InvalidMenuException extends IllegalArgumentException {
	public static final String INVALID_MENU_NUMBER = "선택한 메뉴는 없는 메뉴입니다.";

	public InvalidMenuException(String s) {
		super(s);
	}
}
