package domain.command;

import static org.assertj.core.api.AssertionsForInterfaceTypes.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import domain.exception.InvalidCommandException;

/**
 *   class description
 *
 *   @author ParkDooWon
 */
public class CommandTest {
	@DisplayName("선택한 명령에 해당하는 Command Enum 반환")
	@ParameterizedTest
	@CsvSource({"1, REGISTER", "2, PAY", "3, EXIT_POS"})
	void getSelectControllerTest(String inputCommand, Command command) {
		assertThat(Command.of(inputCommand)).isEqualTo(command);
	}

	@DisplayName("없는 명령을 입력하면 예외 발생")
	@ParameterizedTest
	@ValueSource(strings = {"0", "4", "5"})
	void inputNotExistCommandTest(String inputCommand) {
		assertThatThrownBy(() -> Command.of(inputCommand))
			.isInstanceOf(InvalidCommandException.class)
			.hasMessage(InvalidCommandException.INVALID_COMMAND_NUMBER);
	}

	@DisplayName("EXIT 명령을 선택했는지 확인")
	@ParameterizedTest
	@CsvSource({"REGISTER, false", "PAY, false", "EXIT_POS, true"})
	void isExitTest(Command command, boolean expected) {
		assertThat(command.isExit()).isEqualTo(expected);
	}
}
