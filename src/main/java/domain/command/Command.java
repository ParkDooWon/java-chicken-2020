package domain.command;

import java.util.Arrays;
import java.util.function.BiConsumer;

import controller.ExitController;
import controller.PayController;
import controller.RegisterController;
import domain.exception.InvalidCommandException;
import domain.menu.Menus;
import domain.table.Tables;

/**
 *   class description
 *
 *   @author ParkDooWon
 */
public enum Command {
	REGISTER("1", (tables, menus) -> new RegisterController()),
	PAY("2", (tables, menus) -> new PayController()),
	EXIT_POS("3", (tables, menus) -> new ExitController());

	private String number;
	private BiConsumer<Tables, Menus> controller;

	Command(String number, BiConsumer<Tables, Menus> controller) {
		this.number = number;
		this.controller = controller;
	}

	public static Command of(String inputCommand) {
		return Arrays.stream(Command.values())
			.filter(c -> c.number.equals(inputCommand))
			.findFirst()
			.orElseThrow(() -> new InvalidCommandException(InvalidCommandException.INVALID_COMMAND_NUMBER));
	}
}
