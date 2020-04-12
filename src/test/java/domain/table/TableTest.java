package domain.table;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import domain.menu.Menu;
import domain.menu.MenuRepository;

/**
 *   class description
 *
 *   @author ParkDooWon
 */
public class TableTest {
	private Tables tables;

	@BeforeEach
	void setUp() {
		tables = new Tables();
	}

	@DisplayName("테이블에 수량이 잘 더해지는지 테스트")
	@Test
	void addQuantityTest() {
		Table table = tables.getSelectTable(1);
		Menu menu = MenuRepository.menus().get(0);
		Quantity quantity = Quantity.of(10);

		table.addQuantity(menu, quantity);
		assertThat(table.getBill().getOrders().get(menu).getQuantity()).isEqualTo(10);
	}

	@Test
	void sumChickenCategoryTest() {
		Table table = tables.getSelectTable(1);
		Menu chicken1 = MenuRepository.menus().get(0);
		Quantity quantity1 = Quantity.of(10);

		Menu chicken2 = MenuRepository.menus().get(1);
		Quantity quantity2 = Quantity.of(5);

		table.addQuantity(chicken1, quantity1);
		table.addQuantity(chicken2, quantity2);

		assertThat(table.sumChickenCategory()).isEqualTo(15);
	}

	@Test
	void calculateTotalMoneyTest() {

	}
}
