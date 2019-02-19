package com.jdk18.lambda;

import java.util.Arrays;
import java.util.Comparator;

public class Test4 {
	public static void main(String[] args) {
		String[] players = { "Rafael Nadal", "Novak Djokovic", "Stanislas Wawrinka", "David Ferrer", "Roger Federer",
				"Andy Murray", "Tomas Berdych", "Juan Martin Del Potro", "Richard Gasquet", "John Isner" };

		// 1.1 使用匿名内部类根据 name 排序 players
		Arrays.sort(players, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				return (s1.compareTo(s2));
			}
		});
		// 用于输出
		// for (String string : players) {
		// System.out.println(string);
		// }

		// 1.2 使用 lambda expression 排序 players
		Comparator<String> sortByName = (String s1, String s2) -> (s1.compareTo(s2));
		Arrays.sort(players, sortByName);
		// 1.3 也可以采用如下形式:
		Arrays.sort(players, (String s1, String s2) -> (s1.compareTo(s2)));
	}
}
