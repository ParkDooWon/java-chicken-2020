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

		assertThat(bill.getBill().get(menu).getQuantity()).isEqualTo(10);
	}
}
