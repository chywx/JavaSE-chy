package newcom.basic.test2;

abstract class Parent {
    public String name = "parent";
    static {
        System.out.println(1);
    }
    public Parent(){
        System.out.println(2);
    }
}
public class Son extends  Parent{
    public String name = "son";
    static {
        System.out.println(3);
    }
    public Son(){
        System.out.println(4);
    }

}
