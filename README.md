# java-chicken-2020

## 치킨집 POS

### 기능 구현 목록
1. 주문 등록, 결제, 프로그램 종료 중 하나의 기능을 선택한다.
    - [ ] 입력 값이 숫자인지 검증
    - [ ] 입력 값이 1,2,3 중 하나인지 검증
2. 선택에 따른 기능을 수행한다.
#### 1. 주문 등록 선택시
1. 현재 테이블 상태를 출력하여 보여준다.
2. 테이블 번호를 선택한다.
    - [ ] 테이블 번호가 숫자인지 검증
    - [ ] 테이블 번호가 존재하는 테이블 번호인지 검증
3. 치킨집의 메뉴를 출력하여 보여준다.
4. 등록할 메뉴의 번호를 입력받는다
    - [ ] 메뉴 번호가 숫자인지 검증
    - [ ] 메뉴 번호가 존재하는 메뉴 번호인지 검증
5. 메뉴의 수량을 입력받는다.
    - [ ] 수량이 숫자인지 검증
    - [x] 수량이 0이상인지 검증
    - [x] 해당 테이블에 입력한 수량을 넣었을 때, 99를 초과하지 않는지 검증
#### 2. 결제 기능 선택시
1. 현재 테이블 상태를 출력하여 보여준다.
2. 결제를 진행할 테이블 번호를 입력받는다.
    - [ ] 테이블 번호가 숫자인지 검증
    - [ ] 테이블 번호가 존재하는 테이블 번호인지 검증
    - [ ] 선택한 테이블에 주문 내역이 있는지 검증
3. 해당 테이블의 주문 내역을 출력하여 보여준다.
4. 결제 수단을 신용카드와 현금 중 선택한다.
    - [ ] 결제 수단이 숫자인지 검증
    - [ ] 결제 수단이 존재하는 결제 수단(1 또는 2)인지 검증
5. 주문 내역에 따른 할인 진행
    - [ ] 치킨 종류 수량 10개 당 1만원씩 할인한다. ex) 23개 치킨 -> 2만원 할인
    - [ ] 치킨 종류 할인을 한 후, 결제 수단이 현금이면 추가로 5%의 할인을 적용한다.
6. 최종 결제 금액을 출력하여 보여준다.
7. 결제가 완료되었으면 해당 테이블의 주문 내역을 삭제한다.
    
#### 3. 프로그램 종료 선택시
1. 프로그램을 종료한다.