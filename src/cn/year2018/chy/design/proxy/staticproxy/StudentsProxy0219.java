package cn.year2018.chy.design.proxy.staticproxy;


/**
 * 学生代理类，也实现了Person接口，保存一个学生实体，这样既可以代理学生产生行为
 *
 * @author Gonjan
 */
public class StudentsProxy0219 implements Person0219 {
    //被代理的学生
    Student0219 stu;

    public StudentsProxy0219(Person0219 stu) {
        // 只代理学生对象
        if (stu.getClass() == Student0219.class) {
            this.stu = (Student0219) stu;
        }
    }

    //代理上交班费，调用被代理学生的上交班费行为
    public void giveMoney() {
        stu.giveMoney();
    }
}
