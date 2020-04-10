package domain.table;

import static org.assertj.core.api.AssertionsForInterfaceTypes.*;

import org.junit.jupiter.api.Test;

/**
 *   class description
 *
 *   @author ParkDooWon
 */
public class BillTest {
	@Test
	void addQuantityTest() {
		Quantity quantity = Quantity.of(10);

		assertThat(quantity.addedQuantity(10).getQuantity()).isEqualTo(20);
	}
}
