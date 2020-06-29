package cn.year2019.basic.test1.son;

public class B {
    public void f() {
        /*
        继承情况下，p3,p4都会报错
         */
//        String a = p1;
//        String b = p2;
//        String c = p3;
//        String d = p4;


        /*
        非继承情况下，并且不是同一包下，除了public全部报错
         */
//        String p1 = new A().p1;
//        String p2 = new A().p2;
//        String p3 = new A().p3;
//        String p4 = new A().p4;


        /*
        非继承情况下，只有private报错
         */
//        String p1 = new C().p1;
//        String p2 = new C().p2;
//        String p3 = new C().p3;
//        String p4 = new C().p4;
    }
}
