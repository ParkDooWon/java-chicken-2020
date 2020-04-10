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
public class POS {
	public void run() {
		final Tables tables = new Tables();
		final Menus menus = new Menus();
		Command command = inputCommand();
		command.getController().run(tables, menus);
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
