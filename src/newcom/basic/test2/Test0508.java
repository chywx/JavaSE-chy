package newcom.basic.test2;

public class Test0508 {
    /*
    1
    3
    2
    4
    sub
    parent
     */
    public static void main(String[] args) {
        Parent p = new Son();
        System.out.println(((Son) p).name);//son
        System.out.println(p.name);//parent
    }
}
