package domain.table;

import static org.assertj.core.api.AssertionsForInterfaceTypes.*;

import org.junit.jupiter.api.Test;

import domain.menu.Menu;
import domain.menu.MenuRepository;

/**
 *   class description
 *
 *   @author ParkDooWon
 */
public class BillTest {
	@Test
	void addQuantityTest() {
		Bill bill = new Bill();
		Menu menu = MenuRepository.menus().get(0);
		Quantity quantity = Quantity.of(10);

		bill.addQuantity(menu, quantity);

		assertThat(bill.getOrders().get(menu).getQuantity()).isEqualTo(10);
	}

	@Test
	void sumChickenCategoryTest() {
		Bill bill = new Bill();
		Menu chicken1 = MenuRepository.menus().get(0);
		Quantity quantity1 = Quantity.of(10);

		Menu chicken2 = MenuRepository.menus().get(1);
		Quantity quantity2 = Quantity.of(5);

		bill.addQuantity(chicken1, quantity1);
		bill.addQuantity(chicken2, quantity2);

		assertThat(bill.sumChickenCategory()).isEqualTo(15);
	}

	@Test
	void calculateTotalTest() {
		Bill bill = new Bill();
		Menu chicken1 = MenuRepository.menus().get(0);
		Quantity quantity1 = Quantity.of(10);

		Menu chicken2 = MenuRepository.menus().get(1);
		Quantity quantity2 = Quantity.of(5);

		bill.addQuantity(chicken1, quantity1);
		bill.addQuantity(chicken2, quantity2);

		int totalMoney = 16000 * 10 + 16000 * 5;

		assertThat(bill.calculateTotal()).isEqualTo(totalMoney);
	}
}
