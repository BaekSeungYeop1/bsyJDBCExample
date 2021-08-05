package kr.ac.daegu.bsy;

import kr.ac.daegu.bsy.db.DbProcess;
import kr.ac.daegu.bsy.input.InputUtil;

public class Main {

    public static void main(String[] args) throws Exception {
        // 사용자의 입력을 Scanner로 받아 (clear)
        // "1" 이외 데이터가 입력될 경우 "다시 입력해 주세요" 하고 다시 입력받을 수 있도록 한다. (clear)
        // "1" 을 입력받을 경우 mariadb 에서 정의한 Student 테이블의 데이터를 모두 조회하여 출력 한다.
        // "2" 를 입력 받을 경우 새로운 학생을 추가 한다.
        String selectedNumber = new InputUtil().validateUserInput(); // 메소드 체이닝. // 사용자의 입력을 받는다, "1" 이외의 입력이 들어오면 계속 반복하여 메뉴를 보여준다. , "1"의 입력이 들어오면 해당 값을 반환(return)한다.
        System.out.println("선택된 번호 : " + selectedNumber);

        // selectedNumber에 따라 학생 테이블을 전체 조회 한다.
        DbProcess dp = new DbProcess(selectedNumber);
        dp.startProcessing();
    }
}
