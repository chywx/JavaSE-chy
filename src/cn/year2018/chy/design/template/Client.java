package cn.year2018.chy.design.template;

/**
 * https://www.cnblogs.com/V1haoge/p/9558825.html
 * 基本方法又可以分为三种：抽象方法(Abstract Method)、具体方法(Concrete Method)和钩子方法(Hook Method)。
 * 　　●　　抽象方法：一个抽象方法由抽象类声明，由具体子类实现。在Java语言里抽象方法以abstract关键字标示。
 * 　　●　　具体方法：一个具体方法由抽象类声明并实现，而子类并不实现或置换。
 * 　　●　　钩子方法：一个钩子方法由抽象类声明并实现，而子类会加以扩展。通常抽象类给出的实现是一个空实现，作为方法的默认实现。
 */

/**
 * 模板模式的关键点：
 * 　　　　1、使用抽象类定义模板类，并在其中定义所有的基本方法、模板方法，钩子方法，不限数量，以实现功能逻辑为主。其中基本方法使用final修饰，其中要调用基本方法和钩子方法，基本方法和钩子方法可以使用protected修饰，表明可被子类修改。
 * 　　　　2、定义实现抽象类的子类，重写其中的模板方法，甚至钩子方法，完善具体的逻辑。
 * 　　使用场景：
 * 　　　　1、在多个子类中拥有相同的方法，而且逻辑相同时，可以将这些方法抽出来放到一个模板抽象类中。
 * 　　　　2、程序主框架相同，细节不同的情况下，也可以使用模板方法。
 */
public class Client {
    public static void main(String[] args) {
        HouseTemplate houseOne = new HouseOne("房子1", false);
        HouseTemplate houseTwo = new HouseTwo("房子2");
        houseOne.buildHouse();
        houseTwo.buildHouse();
    }
}
