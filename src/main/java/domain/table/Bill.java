package domain.table;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import domain.menu.Menu;
import domain.menu.MenuRepository;

/**
 *   class description
 *
 *   @author ParkDooWon
 */
public class Bill {
	private final Map<Menu, Quantity> orders = new HashMap<>();

	public Bill() {
		initializeBill();
	}

	public void initializeBill() {
		for (Menu menu : MenuRepository.menus()) {
			orders.put(menu, Quantity.zero());
		}
	}

	public void addQuantity(Menu menu, Quantity quantity) {
		orders.put(menu, orders.get(menu).addedQuantity(quantity.getQuantity()));
	}

	public Map<Menu, Quantity> getOrders() {
		return orders;
	}

	public int sumChickenCategory() {
		return orders.entrySet().stream()
			.filter(bill -> bill.getKey().isChicken())
			.mapToInt(bill -> bill.getValue().getQuantity())
			.sum();
	}

	public double calculateTotal() {
		return orders.entrySet().stream()
			.mapToDouble(bill -> calculateMenuPrice(bill.getKey(), bill.getValue()))
			.sum();
	}

	private int calculateMenuPrice(Menu menu, Quantity quantity) {
		return menu.getPrice() * quantity.getQuantity();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Bill bill = (Bill)o;
		return Objects.equals(orders, bill.orders);
	}

	@Override
	public int hashCode() {
		return Objects.hash(orders);
	}
}
