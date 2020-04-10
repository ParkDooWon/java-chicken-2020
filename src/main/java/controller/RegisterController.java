package controller;

import domain.menu.Menu;
import domain.menu.Menus;
import domain.table.Table;
import domain.table.Tables;
import view.InputView;
import view.OutputView;

/**
 *   class description
 *
 *   @author ParkDooWon
 */
public class RegisterController implements Controller {
	@Override
	public void run(Tables tables, Menus menus) {
		Table table = inputTable(tables);
		Menu menu = inputMenu(menus);
		int quantity = Integer.parseInt(inputQuantity());
	}

	private String inputQuantity() {
		OutputView.printInputQuantity();
		return InputView.input();
	}

	private Table inputTable(Tables tables) {
		OutputView.printTables(tables.getTables());
		OutputView.printinputTable();
		int inputTableNumber = Integer.parseInt(InputView.input());
		return tables.getSelectTable(inputTableNumber);
	}

	private Menu inputMenu(Menus menus) {
		OutputView.printMenus(menus.getMenus());
		OutputView.printInputMenu();
		int inputMenuNumber = Integer.parseInt(InputView.input());
		return menus.getSelectMenu(inputMenuNumber);
	}
}
