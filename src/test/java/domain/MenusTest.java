package domain;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import domain.exception.InvalidMenuException;
import domain.menu.Menu;
import domain.menu.MenuRepository;
import domain.menu.Menus;

/**
 *   class description
 *
 *   @author ParkDooWon
 */
public class MenusTest {
	private Menus menus;

	private static Stream<Arguments> inputMenus() {
		return Stream.of(
			Arguments.of(1, MenuRepository.menus().get(0)),
			Arguments.of(6, MenuRepository.menus().get(5)),
			Arguments.of(21, MenuRepository.menus().get(6)),
			Arguments.of(22, MenuRepository.menus().get(7))
		);
	}

	@BeforeEach
	void setUp() {
		menus = new Menus();
	}

	@DisplayName("선택한 메뉴가 존재하지 않으면 예외 발생")
	@ParameterizedTest
	@ValueSource(strings = {"0", "7", "20", "23"})
	void isPresentMenuTest(int menuNumber) {
		assertThatThrownBy(() -> Menus.getSelectMenu(menuNumber))
			.isInstanceOf(InvalidMenuException.class)
			.hasMessage(InvalidMenuException.INVALID_MENU_NUMBER);
	}

	@DisplayName("선택한 메뉴를 반환")
	@ParameterizedTest
	@MethodSource("inputMenus")
	void getSelectMenuTest(int menuNumber, Menu menu) {
		assertThat(Menus.getSelectMenu(menuNumber)).isEqualTo(menu);
	}
}
