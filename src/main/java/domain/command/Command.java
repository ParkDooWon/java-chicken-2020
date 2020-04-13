package domain.command;

import java.util.Arrays;

import controller.Controller;
import controller.ExitController;
import controller.PayController;
import controller.RegisterController;
import domain.exception.InvalidCommandException;

/**
 *   class description
 *
 *   @author ParkDooWon
 */
public enum Command {
	REGISTER("1", new RegisterController()),
	PAY("2", new PayController()),
	EXIT_POS("3", new ExitController());

	private String number;
	private Controller controller;

	Command(String number, Controller controller) {
		this.number = number;
		this.controller = controller;
	}

	public static Command of(String inputCommand) {
		return Arrays.stream(Command.values())
			.filter(c -> c.number.equals(inputCommand))
			.findFirst()
			.orElseThrow(() -> new InvalidCommandException(InvalidCommandException.INVALID_COMMAND_NUMBER));
	}

	public boolean isExit() {
		return this == EXIT_POS;
	}

	public Controller getController() {
		return controller;
	}
}
