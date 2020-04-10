package domain.menu;

import java.util.List;

import domain.exception.InvalidMenuException;

/**
 *   class description
 *
 *   @author ParkDooWon
 */
public class Menus {
	private List<Menu> menus;

	public Menus() {
		menus = MenuRepository.menus();
	}

	public Menu getSelectMenu(int menuNumber) {
		return menus.stream()
			.filter(m -> m.getNumber() == menuNumber)
			.findFirst()
			.orElseThrow(() -> new InvalidMenuException(InvalidMenuException.INVALID_MENU_NUMBER));
	}

	public List<Menu> getMenus() {
		return menus;
	}
}
