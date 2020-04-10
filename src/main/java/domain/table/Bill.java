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
	private final Map<Menu, Quantity> bill = new HashMap<>();

	public Bill() {
		for (Menu menu : MenuRepository.menus()) {
			bill.put(menu, Quantity.zero());
		}
	}

	public void addQuantity(Menu menu, Quantity quantity) {
		bill.get(menu).addedQuantity(quantity.getQuantity());
	}
}
