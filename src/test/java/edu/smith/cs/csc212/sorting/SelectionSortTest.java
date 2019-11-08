package edu.smith.cs.csc212.sorting;

import java.util.Random;

import org.junit.Assert;
import org.junit.Test;

import me.jjfoley.adt.ListADT;
import me.jjfoley.adt.impl.JavaList;

public class SelectionSortTest {
	@Test
	public void testSelectionSort() {
		// See if the data can be reversed:
		ListADT<Integer> sortMe = new JavaList<>();
		for (int y : SortTestingHelpers.data) {
			sortMe.addBack(y);
		}
		ListADT<Integer> sorted = new JavaList<>();
		SelectionSort test = new SelectionSort();
		sorted = test.sort(sortMe);
		Assert.assertTrue(SortTestingHelpers.checkSorted(sorted, SortTestingHelpers.data.length));
		
		Random rand = new Random(13);
		// For good measure, let's shuffle it and sort it again to see if that works, too.
		sortMe.shuffle(rand);
		sorted = test.sort(sortMe);
		Assert.assertTrue(SortTestingHelpers.checkSorted(sorted, SortTestingHelpers.data.length));
		
		// check it is the original size
		Assert.assertEquals(sortMe.size(), SortTestingHelpers.data.length);
	}
}
