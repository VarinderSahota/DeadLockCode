package com.practice.hackerrank;

import java.lang.management.ManagementFactory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.management.InstanceAlreadyExistsException;
import javax.management.MBeanException;
import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.NotCompliantMBeanException;
import javax.management.ObjectName;

public class Smoothie implements SmoothieMBean {
	private static Map<String, Set<String>> menu = new HashMap<>();
	private static Set<String> classic = new HashSet<>();
	private static Set<String> freezie = new HashSet<>();
	private static Set<String> greenie = new HashSet<>();
	private static Set<String> justDesserts = new HashSet<>();
	private static String COMMA = ",";
	private static String HYPHEN = "-";
	private static String INVALID_INPUT = "Invalid Input";

	Smoothie() {

	}

	static {
		classic.add("strawberry");
		classic.add("banana");
		classic.add("pineapple");
		classic.add("mango");
		classic.add("peach");
		classic.add("honey");

		freezie.add("blackberry");
		freezie.add("blueberry");
		freezie.add("black currant");
		freezie.add("grape juice");
		freezie.add("frozen yogurt");

		greenie.add("green apple");
		greenie.add("lime");
		greenie.add("avocado");
		greenie.add("spinach");
		greenie.add("ice");
		greenie.add("apple juice");

		justDesserts.add("banana");
		justDesserts.add("ice cream");
		justDesserts.add("chocolate");
		justDesserts.add("peanut");
		justDesserts.add("cherry");

		menu.put("Classic", classic);
		menu.put("Freezie", freezie);
		menu.put("Greenie", greenie);
		menu.put("Just Desserts", justDesserts);

	}

	public static String ingredients(String order) {
		String result = "";

		if (Objects.isNull(order) || "".equals(order) || " ".equals(order) || order.length() == 0) {
			throw new IllegalArgumentException(INVALID_INPUT);
		}

		String[] orderList = order.split(COMMA);
		List<String> orderedItem = new ArrayList<>();
		Set<String> selectedItem = menu.get(orderList[0]);

		if (Objects.isNull(selectedItem)) {
			throw new IllegalArgumentException(INVALID_INPUT);
		}

		orderedItem.addAll(menu.get(orderList[0]));

		for (int index = 1; index < orderList.length; index++) {
			String allergent = orderList[index];
			if (allergent.startsWith(HYPHEN)) {
				orderedItem.remove(allergent.replaceFirst(HYPHEN, ""));
			} else if (!orderedItem.contains(allergent)) {
				throw new IllegalArgumentException(INVALID_INPUT);
			}
		}

		Collections.sort(orderedItem);
		StringBuilder resultIngredients = new StringBuilder();
		orderedItem.stream().forEach(s -> resultIngredients.append(s + COMMA));

		if (resultIngredients.length() > 0) {
			result = resultIngredients.toString().substring(0, resultIngredients.length() - 1);
		}

		return result;
	}

	public static void main(String[] args) {
		
		
		MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
		Smoothie smooth = new Smoothie();
		
		ObjectName mbeanObjectNameStr = null;

		try {
			mbeanObjectNameStr = new ObjectName("com.practice.hackerrank:name=smooth");
		} catch (MalformedObjectNameException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			mbs.registerMBean(smooth, mbeanObjectNameStr);
		} catch (NotCompliantMBeanException | InstanceAlreadyExistsException | MBeanException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		while (true) {
			System.out.println(Smoothie.ingredients("Classic"));
			sleep();

			System.out.println(Smoothie.ingredients("Classic,-strawberry"));
			sleep();
			System.out.println(Smoothie.ingredients("Classic,-strawberry,-peanut"));
			sleep();

			//System.out.println(Smoothie.ingredients("Classic,chocolate"));
			sleep();
			// System.out.println(Smoothie.ingredients("sdhja Classic"));
			sleep();
			sleep();
			sleep();
			sleep();
			sleep();
		}

	}
	
	private static void sleep() {
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public String getMessage() {
		return "Hello Smoothie there";
	}

}
