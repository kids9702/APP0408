package com.example.membersystem;

import java.io.Serializable;

// 객체 데이터를 통신으로 다른 곳에 전달 할 경우
// Reference 변수의 실제 값을 담아서 보내기 위해서 사용
// => 직렬화 (Serializable)

// App에서 사용되는 상수 클래스
public class Member implements Serializable {
    //    public static final String NAME = "name";
//    public static final String EMAIL = "email";
//    public static final String ID = "id";
//    public static final String PW = "pw";
    private static  final long serialVersionUID = 1L;
    private String name;
    private String email;
    private String id;
    private String pw;

    public Member(String name, String email, String id, String pw) {
        this.name = name;
        this.email = email;
        this.id = id;
        this.pw = pw;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }
}