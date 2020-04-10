package domain.menu;

import static org.assertj.core.api.AssertionsForInterfaceTypes.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 *   class description
 *
 *   @author ParkDooWon
 */
public class MenuTest {
	@ParameterizedTest
	@CsvSource({"0, true", "7, false"})
	void isChickenTest(int menuNumber, boolean expected) {
		Menu menu = MenuRepository.menus().get(menuNumber);
		assertThat(menu.isChicken()).isEqualTo(expected);
	}
}
