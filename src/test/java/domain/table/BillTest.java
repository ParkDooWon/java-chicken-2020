package domain.table;

import static org.assertj.core.api.AssertionsForInterfaceTypes.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import domain.menu.Menu;
import domain.menu.MenuRepository;

/**
 *   class description
 *
 *   @author ParkDooWon
 */
public class BillTest {
	private Bill bill;
	private Menu chicken1;
	private Menu chicken2;
	private Quantity quantity1;
	private Quantity quantity2;

	@BeforeEach
	void setUP() {
		bill = new Bill();
		chicken1 = MenuRepository.menus().get(0);
		quantity1 = Quantity.of(10);

		chicken2 = MenuRepository.menus().get(1);
		quantity2 = Quantity.of(5);

		bill.addQuantity(chicken1, quantity1);
		bill.addQuantity(chicken2, quantity2);
	}

	@Test
	void addQuantityTest() {
		assertThat(bill.getOrders().get(chicken1).getQuantity()).isEqualTo(10);
		assertThat(bill.getOrders().get(chicken2).getQuantity()).isEqualTo(5);
	}

	@Test
	void sumChickenCategoryTest() {
		assertThat(bill.sumChickenCategory()).isEqualTo(15);
	}

	@Test
	void calculateTotalTest() {
		double totalMoney = 16000 * 10 + 16000 * 5;

		assertThat(bill.calculateTotal()).isEqualTo(totalMoney);
	}

	@Test
	void initializeBillTest() {
		assertThat(bill.calculateTotal()).isEqualTo(16000 * 10 + 16000 * 5);
		bill.initializeBill();
		assertThat(bill.calculateTotal()).isEqualTo(0);
	}
}
