package view;

import java.util.List;

import domain.TotalMoney;
import domain.menu.Menu;
import domain.table.Bill;
import domain.table.Quantity;
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
        System.out.println();
    }

    public static void printBill(Table table) {
        System.out.println("## 주문 내역");
        System.out.println("메뉴 수량 금액");
        Bill bill = table.getBill();
        bill.getOrders().entrySet().stream()
            .filter(order -> !order.getValue().equals(Quantity.zero()))
            .forEach(order -> System.out.println(
                order.getKey().getName() + " " + order.getValue().getQuantity() + " " + (order.getKey().getPrice()
                    * order.getValue().getQuantity())));
        System.out.println();
    }

    public static void printError(IllegalArgumentException e) {
        System.err.println(e.getMessage());
        System.out.println();
    }

    public static void printInputPaymentWay(int tableNumber) {
        System.out.println(String.format("## %d번 테이블의 결제를 진행합니다.", tableNumber));
        System.out.println("## 신용 카드는 1번, 현금은 2번");
    }

    public static void printTotalMoney(TotalMoney totalMoney) {
        System.out.println("## 최종 결제할 금액");
        System.out.println(totalMoney.getTotalMoney() + NEW_LINE);
    }
}
