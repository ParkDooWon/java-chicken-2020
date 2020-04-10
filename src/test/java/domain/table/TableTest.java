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

		table.addQunatity(menu, quantity);
		assertThat(table.getBill().getOrders().get(menu).getQuantity()).isEqualTo(10);
	}
}
