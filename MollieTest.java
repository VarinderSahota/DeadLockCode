package com.practice.hackerrank;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

import com.practice.codility.problems.ArraysUtil;

public class MollieTest {

	public static List<String> fetchItemsToDisplay(List<ArrayList<String>> items, int sortParameter, int sortOrder,
			int itemsPerPage, int pageNumber) {

		Comparator<String> comparator = Comparator.naturalOrder();

		if (sortOrder == 1) {
			comparator = Comparator.reverseOrder();
		}

		SortedMap<String, List<String>> itemMap = new TreeMap<>(comparator);

		for (List<String> itemList : items) {
			itemMap.put(itemList.get(sortParameter), itemList);
		}

		List<String> result = new ArrayList<>();
		int localPageNo = 0;

		for (int index = 0; index < itemMap.size(); index = index + itemsPerPage) {
			if (localPageNo++ == pageNumber) {
				addItems(index, index + itemsPerPage, itemMap.values(), result);
				break;
			}
		}

		return result;
	}

	public static void addItems(int startIndex, int endIndex, Collection<List<String>> collection,
			List<String> result) {

		List<String> allItems = new ArrayList<>();

		for (List<String> itemParams : collection) {
			allItems.add(itemParams.get(0));
		}

		for (int index = startIndex; index < endIndex; index++) {
			result.add(allItems.get(index));
		}
	}

	public static void main(String[] args) {

		List<ArrayList<String>> items = new ArrayList<ArrayList<String>>();

		ArrayList<String> item1 = new ArrayList<String>();
		item1.add("p1");
		item1.add("1");
		item1.add("2");

		ArrayList<String> item2 = new ArrayList<String>();
		item2.add("p2");
		item2.add("2");
		item2.add("1");

		items.add(item1);
		items.add(item2);

		ArraysUtil.display(fetchItemsToDisplay(items, 0, 1, 1, 0));

	}

}
