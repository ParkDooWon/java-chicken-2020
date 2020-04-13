package domain.table;

import domain.menu.Menu;

public class Table {
	private static final int FINISH_PAID = 0;

	private final int number;
	private final Bill bill;

	public Table(final int number) {
		this.number = number;
		bill = new Bill();    //강한 결합
	}

	public void addQuantity(Menu menu, Quantity quantity) {
		bill.addQuantity(menu, quantity);
	}

	public int sumChickenCategory() {
		return bill.sumChickenCategory();
	}

	public boolean isPaidTable() {
		return bill.calculateTotal() == FINISH_PAID;
	}

	public double sumBill() {
		return bill.calculateTotal();
	}

	public void initializeBill() {
		bill.initializeBill();
	}

	public int getNumber() {
		return this.number;
	}

	public Bill getBill() {
		return bill;
	}

	@Override
	public String toString() {
		return Integer.toString(number);
	}
}
