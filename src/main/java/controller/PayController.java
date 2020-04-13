package controller;

import domain.PaymentWay;
import domain.TotalMoney;
import domain.exception.InvalidPaymentException;
import domain.exception.InvalidTableException;
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
		validateEmptyTables(tables);
		Table table = inputTable(tables);
		OutputView.printBill(table);
		PaymentWay paymentWay = inputPaymentWay(table.getNumber());
		TotalMoney totalMoney = TotalMoney.calculateTotalMoney(table.sumBill(), table.sumChickenCategory(),
			paymentWay);
		OutputView.printTotalMoney(totalMoney);
		table.initializeBill();
	}

	private void validateEmptyTables(Tables tables) {
		if (tables.isEmptyTables()) {
			throw new InvalidTableException(InvalidTableException.EMPTY_BILL_TABLES);
		}
	}

	private Table inputTable(Tables tables) {
		try {
			OutputView.printTables(tables.getTables());
			OutputView.printinputTable();
			int inputTableNumber = Integer.parseInt(InputView.input());
			Table table = tables.getSelectTable(inputTableNumber);
			validateEmptyBillTable(table);
			return table;
		} catch (InvalidTableException e) {
			OutputView.printError(e);
			return inputTable(tables);
		}
	}

	private void validateEmptyBillTable(Table table) {
		if (table.isPaidTable()) {
			throw new InvalidTableException(InvalidTableException.EMPTY_BILL_TABLE);
		}
	}

	private PaymentWay inputPaymentWay(int tableNumber) {
		try {
			OutputView.printInputPaymentWay(tableNumber);
			return PaymentWay.of(InputView.input());
		} catch (InvalidPaymentException e) {
			OutputView.printError(e);
			return inputPaymentWay(tableNumber);
		}
	}
}
