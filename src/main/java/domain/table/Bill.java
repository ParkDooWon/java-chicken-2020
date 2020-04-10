package domain.table;

import java.util.HashMap;
import java.util.Map;

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
}
