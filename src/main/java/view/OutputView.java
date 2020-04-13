package view;

import java.util.List;

import domain.menu.Menu;
import domain.table.Table;

public class OutputView {
    public static final String ORDERED_TABLE = "└ w ┘";
    private static final String TOP_LINE = "┌ ─ ┐";
    private static final String TABLE_FORMAT = "| %s |";
    private static final String BOTTOM_LINE = "└ ─ ┘";
    private static final String NEW_LINE = System.lineSeparator();

    public static void printTables(final List<Table> tables) {
        System.out.println("## 테이블 목록");
        final int size = tables.size();
        printTopLine(size);
        printTableNumbers(tables);
        printBottomLine(tables, size);
    }

    public static void printMenus(final List<Menu> menus) {
        for (final Menu menu : menus) {
            System.out.println(menu);
        }
    }

    private static void printTopLine(int size) {
        for (int i = 0; i < size; i++) {
            System.out.print(TOP_LINE);
        }
        System.out.println();
    }

    private static void printBottomLine(List<Table> tables, final int count) {
        for (int index = 0; index < count; index++) {
            if (tables.get(index).isPaidTable()) {
                System.out.print(BOTTOM_LINE);
            }
            if (!tables.get(index).isPaidTable()) {
                System.out.print(ORDERED_TABLE);
            }
        }
        System.out.println();
    }

    private static void printTableNumbers(final List<Table> tables) {
        for (final Table table : tables) {
            System.out.printf(TABLE_FORMAT, table);
        }
        System.out.println();
    }

    public static void printInputCommand() {
        System.out.println("## 원하는 기능을 선택하세요.");
    }

    public static void printError(IllegalArgumentException e) {
        System.err.println(e.getMessage());
    }

    public static void printinputTable() {
        System.out.println("## 테이블을 선택하세요.");
    }

    public static void printInputMenu() {
        System.out.println("## 메뉴를 선택하세요.");
    }

    public static void printInputQuantity() {
        System.out.println("## 수량을 입력하세요.");
    }

    public static void printMain() {
        System.out.println("## 메인화면" + NEW_LINE + "1 - 주문등록" + NEW_LINE + "2 - 결제하기" + NEW_LINE + "3 - 프로그램 종료");
    }
}
