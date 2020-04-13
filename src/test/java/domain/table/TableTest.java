package domain.table;

import static org.assertj.core.api.AssertionsForClassTypes.*;
import static org.junit.jupiter.api.Assertions.*;

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
	private Menu chicken1;
	private Menu chicken2;
	private Quantity quantity1;
	private Quantity quantity2;

	@BeforeEach
	void setUp() {
		tables = new Tables();
		chicken1 = MenuRepository.menus().get(0);
		quantity1 = Quantity.of(10);

		chicken2 = MenuRepository.menus().get(1);
		quantity2 = Quantity.of(5);
	}

	@DisplayName("테이블에 수량이 잘 더해지는지 테스트")
	@Test
	void addQuantityTest() {
		Table table = tables.getSelectTable(1);

		table.addQuantity(chicken1, quantity1);
		assertThat(table.getBill().getOrders().get(chicken1).getQuantity()).isEqualTo(10);
	}

	@Test
	void sumChickenCategoryTest() {
		Table table = tables.getSelectTable(2);

		table.addQuantity(chicken1, quantity1);
		table.addQuantity(chicken2, quantity2);

		assertThat(table.sumChickenCategory()).isEqualTo(15);
	}

	@Test
	void isPaidTableTest() {
		Table orderedTable = tables.getSelectTable(3);
		Table paidTable = tables.getSelectTable(5);

		orderedTable.addQuantity(MenuRepository.menus().get(0), Quantity.of(2));

		assertThat(orderedTable.isPaidTable()).isFalse();
		assertThat(paidTable.isPaidTable()).isTrue();
	}

	@Test
	void sumBillTest() {
		Table table = tables.getSelectTable(6);
		table.addQuantity(chicken1, quantity1);
		table.addQuantity(chicken2, quantity2);

		double billSum =
			(chicken1.getPrice() * quantity1.getQuantity()) + (chicken2.getPrice() * quantity2.getQuantity());
		assertThat(table.sumBill()).isEqualTo(billSum);
	}

	@Test
	void initializeBillTest() {
		Table table = tables.getSelectTable(6);
		table.addQuantity(chicken1, quantity1);
		table.addQuantity(chicken2, quantity2);

		assertTrue(table.getBill().calculateTotal() > 0);

		table.initializeBill();

		assertEquals(0, table.getBill().calculateTotal());
	}
}
