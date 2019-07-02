package com.test.exception;

public class TestPrint {

    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public static void main(String[] args) {

        System.out.println("13121939122".substring(5, 11));
        try {
//            int i = 1/0;
            TestPrint testPrint = new TestPrint();
            System.out.println(testPrint.getUsername().equals(""));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(e.toString());
//            e.printStackTrace();

        }
    }
}
