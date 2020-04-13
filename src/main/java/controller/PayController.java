package controller;

import domain.MoneyCalculator;
import domain.PaymentWay;
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
public class PayController implements Controller {
	@Override
	public void run(Tables tables, Menus menus) {
		Table table = inputTable(tables);
		OutputView.printBill(table);
		PaymentWay paymentWay = inputPaymentWay(table.getNumber());
		double totalMoney = MoneyCalculator.calculateTotalMoney(table.sumBill(), table.sumChickenCategory(),
			paymentWay);
		OutputView.printTotalMoney(totalMoney);
		table.initializeBill();
	}

	private Table inputTable(Tables tables) {
		OutputView.printTables(tables.getTables());
		OutputView.printinputTable();
		int inputTableNumber = Integer.parseInt(InputView.input());
		return tables.getSelectTable(inputTableNumber);
	}

	private PaymentWay inputPaymentWay(int tableNumber) {
		OutputView.printInputPaymentWay(tableNumber);
		return PaymentWay.of(InputView.input());
	}
}
