package com.example.membersystem;

import java.util.ArrayList;

// App에서 사용되는 상수 클래스, 공용 데이터 변수 등 관련 클래스
// App에 존재하는 모든 java 파일에서 사용 가능
public class AppConstant {
    // Activity 사이 데이터 송수신에 사용되는 KEY
    public static final String NAME     ="name";
    public static final String EMAIL    ="email";
    public static final String ID       ="id";
    public static final String PW       ="pw";
    public static final String NEW_MEM  ="new_member";

    // APP에 저장되는 데이터를 관리하는 객체
    public static ArrayList<Member>     memList;
}
