package com.jdk18.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

public class Test6 {
	List<Employee> list = Arrays.asList(new Employee("张三", "上海", 5000, 22), new Employee("李四", "北京", 4000, 23),
			new Employee("c五", "日本", 6000, 50), new Employee("b七", "香港", 7000, 50), new Employee("赵六", "纽约", 1000, 8));

	/**
	 * 需求1：lambda表达式的使用: 调用COllections.sort方法，通过定制排序比较两个Employee（先按年龄比较，年龄相同按姓名比），使用
	 * Lambda作为参数传递。
	 */
	@Test
	public void test1() {
		Collections.sort(list, (x, y) -> {
			if (x.getAge() != y.getAge())
				return Integer.compare(x.getAge(), y.getAge());
			else
				return x.getName().compareTo(y.getName());

		});

		for (Employee employee : list) {
			System.out.println(employee);
		}
	}

	/**
	 * 需求2： 1.声明函数式接口，接口中声明抽象方法，public String getvalue(String str();
	 * 2.声明类TestLambda，类中编写方法使用接口作为参数，讲一个字符串转换成大写，并作为方法的返回值。
	 */
	@Test
	public void test2() {
		String str = getvalue("hello world", x -> x.toUpperCase());
		System.out.println(str);

		// 不使用lambda
		String getvalue = getvalue("good norning", new MyFunction1() {
			@Override
			public String getValue(String str) {
				return str.toUpperCase();
			}
		});
		System.out.println(getvalue);
	}

	// 这个方法屌啊，传一个接口参数，然后调用接口类传str，再实现类里面写业务
	public String getvalue(String str, MyFunction1 my) {
		return my.getValue(str);
	}

	@FunctionalInterface
	public interface MyFunction1 {
		public String getValue(String str);
	}
	// 好神奇啊，居然接口还可以这么定义
	// interface MyFunction1{
	// public String getValue(String str);
	// }

	/**
	 * 需求3： 1.声明一个带两个泛型的函数式接口，泛型类型是<T,R>,T为参数，R为返回值。 2.接口中声明对应抽象方法
	 * 3.在TestLambda类中声明方法，使用接口作为参数，计算两个long型参数的和 4.在计算两个long型参数的乘积
	 */
	@Test
	public void test3() {
		Long r = getR(25l, 30l, (t1, t2) -> t1 * t2);
		System.out.print(r);

		Long r1 = getR(25l, 23l, (t1, t2) -> t1 + t2);
		System.out.print(r1);

	}

	public <T, R> R getR(T t1, T t2, MyFUnction2<T, R> mf) {
		return mf.method(t1, t2);
	}

	public interface MyFUnction2<T, R> {
		public R method(T t1, T t2);
	}
}
