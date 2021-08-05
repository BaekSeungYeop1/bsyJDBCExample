package kr.ac.daegu.bsy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        /*
        * 사용자의 입력을 Scanner로 받아
        * 1을 입력받을 경우
        * 어제 mariadb에서 Student 테이블의 데이터를 모두 조회하여
        * 출력
         */
        //Scanner sc = new Scanner(System.in); // in:멤버변수
        //System.out.println("번호를 입력하시오"); //// println(녹색):메소드
        //int selectedNumber  = sc.nextInt();

        //System.out.println("선택된 번호 : " + selectedNumber);

        // Connetction, PreparedStatement, ResultSet은 interface 객체이다
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        // try .. catch : try에서 수행한 코드가 '실패'하면 catch를 수행한다
        try{
            /*
             * 1. db(mariadb)를 접속하기 위한 객체를 가져오고
             * 2. db 접속 정보를 가지고 db에 접속하고
             * 3. 쿼리를 날려서
             * 4. 결과를 메모리에 저장시킨다.
             * .jar(Java ARchive) :  java 라이브러리 파일
             */
            Class.forName("org.mariadb.jdbc.Driver"); // org.mariadb.jdbc.Driver 패키지 안에 Driver라는 클래스를 참조하시오
            // db 접속 수집
            conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/DGD","root", "0000");
            // 쿼리를 준비(PrepareStatement 객체의 특징 : sql injection이라는 취약점
            pstmt = conn.prepareStatement("select * from Student");
            // pstmt에서 설정한 쿼리를 날린 결과를 메모리에 저장.
            rs = pstmt.executeQuery();

            /* 쿼리날리 결과를 가지고 콘솔에 출력한다 */
            while(rs.next()){ // next() :Set의 다른 데이터도 있는지 없는지?를 감지하는 메소드
                System.out.println(rs.getInt(1) + " | " + rs.getString(2) + " | " + rs.getInt( 3) +  " | " + rs.getString(4)  +  " | " + rs.getString(5));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
