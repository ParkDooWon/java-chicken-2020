package controller;

import domain.menu.Menu;
import domain.menu.Menus;
import domain.table.Quantity;
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
		try {
			Table table = inputTable(tables);
			Menu menu = inputMenu(menus);
			Quantity inputQuantity = inputQuantity();
			table.addQuantity(menu, inputQuantity);
		} catch (IllegalArgumentException e) {
			OutputView.printError(e);
			run(tables, menus);
		}
	}

	private Quantity inputQuantity() {
		OutputView.printInputQuantity();
		int inputQuantity = Integer.parseInt(InputView.input());
		return Quantity.of(inputQuantity);
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
