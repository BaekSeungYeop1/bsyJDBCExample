package kr.ac.daegu.bsy.input;

import org.apache.commons.lang.StringUtils;

import java.util.Scanner;

public class InputUtil {

    static Scanner strSc = new Scanner(System.in);

    public static String getStringFromConsole(String defaultString) {
        String result = strSc.next().trim();
        if(result.equals("")){
            result = defaultString;
        }
        return result;
    }

    // 콘솔에서 숫자 입력 받음
    // 숫자 아닌 문자일 경우 경고 출력 하여 다시
    public static int getIntFromConsole() {
        String v = strSc.next();
        if (!isNumber(v)) {
            do {
                System.out.println("숫자를 입력해 주세요, 나이는?..");
                v = strSc.next();
            } while (!isNumber(v));
        }
        return Integer.parseInt(v);
    }

    private static boolean isNumber(String v) {
        return StringUtils.isNumeric(v);
    }

    // 사용자의 입력을 받아서 지정된 값 이외에는 "다시 입력해주세요" 라고 반복하여 물어봄.
    public String validateUserInput() {
        String userInputString = null;           // 사용자가 입력한 데이터를 저장 하는 역할
        Scanner sc = new Scanner(System.in);     // 사용자의 입력을 받기 위한 Scanner 객체의 인스턴스를 불러온다. (인스턴스를 불러온다 -> 이 프로그램이 실행될 때 Scanner객체를 쓸 수 있도록 메모리에 적재 해라)
        do {
            printInfo();                         // 사용자의 안내를 출력하는 메소드
            userInputString = inputFromUserFromConsole(sc);
        } while (checkUserInputScope(userInputString)); // do - while 구문 : while 조건이 false 일때까지 do를 무한 반복한다.
        return userInputString;
    }

    // 콘솔로부터 사용자의 입력을 받는 InputProcess에서만 쓸 수 있는 기능. (private)
    private String inputFromUserFromConsole(Scanner sc) {                              // private : 접근 제어자. 접근 : 해당 메소드가 선언된 클래스 이외의 다른 클래스에서 쓸수 있나 없나?
        return sc.next(); // 사용자의 입력을 받은 데이터를 String으로 반환한다.
    }

    // 이 프로그램이 지정한 inputString에 속하는거면 false, 아니면 "다시 입력해 주세요" 하고 true 처리
    private boolean checkUserInputScope(String inputString) {
        switch (inputString) {
            case "1": case "2": return false;
            default :
                System.out.println("잘못 입력 하셨습니다. ");
                System.out.println("주어진 메뉴중 하나를 골라 주세요");
                return true;
        }
    }

    // 사용자가 메뉴를 고를 수 있도록 콘솔로 띄워줌.
    private void printInfo() {
        System.out.println("아래 내용중 선택하세요.");
        System.out.println("1: 전체 학생 조회");
        System.out.println("2: 새로운 학생 추가");
    }
}
