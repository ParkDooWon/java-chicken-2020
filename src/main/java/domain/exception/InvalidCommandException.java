package domain.exception;

/**
 *   class description
 *
 *   @author ParkDooWon
 */
public class InvalidCommandException extends IllegalArgumentException {
	public static final String INVALID_COMMAND_NUMBER = "선택한 명령은 없는 명령입니다.";

	public InvalidCommandException(String s) {
		super(s);
	}
}
