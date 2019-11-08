package edu.smith.cs.csc212.sorting;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.junit.Assert;
import org.junit.Test;

import edu.smith.cs.csc212.sorting.MergeSort;
import me.jjfoley.adt.ListADT;
import me.jjfoley.adt.impl.JavaList;

public class MergeSortTest {

	@Test
	public void testMergeIterSort() {
		// See if the data can be reversed:
		ListADT<Integer> sortMe = new JavaList<>();
		for (int y : SortTestingHelpers.data) {
			sortMe.addBack(y);
		}
		MergeSort m = new MergeSort();
		ListADT<Integer> itersorted = m.itersort(sortMe);
		Assert.assertTrue(SortTestingHelpers.checkSorted(itersorted, SortTestingHelpers.data.length));
		
		Random rand = new Random(13);
		// For good measure, let's shuffle it and sort it again to see if that works, too.
		sortMe.shuffle(rand);
		itersorted = m.itersort(sortMe);
		Assert.assertTrue(SortTestingHelpers.checkSorted(itersorted, SortTestingHelpers.data.length));
		
		// check it is the original size
		Assert.assertEquals(itersorted.size(), SortTestingHelpers.data.length);
	}
	@Test
	public void testMergeRecurSort() {
		// See if the data can be reversed:
		ListADT<Integer> sortMe = new JavaList<>();
		for (int y : SortTestingHelpers.data) {
			sortMe.addBack(y);
		}
		MergeSort m = new MergeSort();
		ListADT<Integer> recursorted = m.recursort(sortMe);
		Assert.assertTrue(SortTestingHelpers.checkSorted(recursorted, SortTestingHelpers.data.length));
		
		Random rand = new Random(13);
		// For good measure, let's shuffle it and sort it again to see if that works, too.
		sortMe.shuffle(rand);
		recursorted = m.recursort(sortMe);
		Assert.assertTrue(SortTestingHelpers.checkSorted(recursorted, SortTestingHelpers.data.length));
		
		// check it is the original size
		Assert.assertEquals(recursorted.size(), SortTestingHelpers.data.length);
	}
	@Test
	public void testCombine() {
		MergeSort m = new MergeSort();
		ListADT<Integer> input1 = new JavaList<>();
		ListADT<Integer> input2 = new JavaList<>();
		input1.addBack(1);
		input1.addBack(15);
		input2.addBack(7);
		input2.addBack(42);
		ListADT<Integer> answer = new JavaList<>();
		answer.addBack(1);
		answer.addBack(7);
		answer.addBack(15);
		answer.addBack(42);
		Assert.assertEquals(m.combine(input1, input2), answer);

	}
}
