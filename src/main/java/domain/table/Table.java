package domain.table;

import java.util.Objects;

import domain.menu.Menu;

public class Table {
	private static final int FINISH_PAID = 0;

	private final int number;
	private final Bill bill;

	public Table(final int number, final Bill bill) {
		this.number = number;
		this.bill = bill;
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
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Table table = (Table)o;
		return number == table.number &&
			Objects.equals(bill, table.bill);
	}

	@Override
	public int hashCode() {
		return Objects.hash(number, bill);
	}

	@Override
	public String toString() {
		return Integer.toString(number);
	}
}
