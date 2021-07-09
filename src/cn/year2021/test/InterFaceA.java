package cn.year2021.test;

/**
 * @author chy
 * @date 2021年06月08日 下午 17:18
 */
public interface InterFaceA {

    void aaa();
}

/**
 * 接口B
 *
 * @author admin
 */
interface InterFaceB {

    void bbb();
}

/**
 * 接口C
 *
 * @author admin
 */
interface InterFaceC extends InterFaceA, InterFaceB {

    void ccc();
}

abstract class absClass implements InterFaceC {

    @Override
    public void aaa() {
        System.out.println("abs aaa");
    }
}

class TestClass2 extends absClass {

    @Override
    public void bbb() {

    }

    @Override
    public void ccc() {

    }
}

/**
 * 实现类
 *
 * @author admin
 */
class TestClass implements InterFaceC {

    @Override
    public void aaa() {
        System.out.println("TestClass.aaa()");

    }

    @Override
    public void bbb() {
        System.out.println("TestClass.bbb()");

    }

    @Override
    public void ccc() {
        System.out.println("TestClass.ccc()");

    }

}
