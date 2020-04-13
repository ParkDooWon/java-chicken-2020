package controller;

import domain.command.Command;
import domain.menu.Menus;
import domain.table.Tables;
import view.InputView;
import view.OutputView;

/**
 *   class description
 *
 *   @author ParkDooWon
 */
public class Pos {
	public void run() {
		final Tables tables = new Tables();
		final Menus menus = new Menus();

		try {
			runPos(tables, menus);
		} catch (IllegalArgumentException e) {
			OutputView.printError(e);
			run();
		}
	}

	private void runPos(Tables tables, Menus menus) {
		Command command;
		do {
			OutputView.printMain();
			command = inputCommand();
			command.getController().run(tables, menus);
		} while (!command.isExit());
	}

	private Command inputCommand() {
		try {
			OutputView.printInputCommand();
			return Command.of(InputView.input());
		} catch (IllegalArgumentException e) {
			OutputView.printError(e);
			return inputCommand();
		}
	}
}
