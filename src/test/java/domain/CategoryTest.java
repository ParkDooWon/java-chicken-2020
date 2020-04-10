package domain;

import static org.assertj.core.api.AssertionsForInterfaceTypes.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 *   class description
 *
 *   @author ParkDooWon
 */
public class CategoryTest {
	@ParameterizedTest
	@CsvSource({"CHICKEN, true", "BEVERAGE, false"})
	void isChickenTest(Category category, boolean expected) {
		assertThat(category.isChicken()).isEqualTo(expected);
	}
}
