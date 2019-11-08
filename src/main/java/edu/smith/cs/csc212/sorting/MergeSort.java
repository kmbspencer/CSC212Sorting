package edu.smith.cs.csc212.sorting;

import me.jjfoley.adt.ListADT;
import me.jjfoley.adt.impl.JavaList;


public class MergeSort {
	
	public ListADT<Integer> recursort(ListADT<Integer> input){
		if (input.size() == 1) {
			return input;
		} else {
			return combine(recursort(
								input.slice(0,input.size()/2)
																),
							recursort(
										input.slice(input.size()/2,input.size())
																					)
																					);
		}
		
	}
	
	public ListADT<Integer> itersort(ListADT<Integer> input){
		ListADT<Integer> output = new JavaList<>();
		ListADT<ListADT<Integer>> listolists = new DoublyLinkedList<>();		
		for(int i =0; i<input.size();i++) {
			ListADT<Integer> temp = new JavaList<>();
			temp.addFront(input.getIndex(i));
			
			listolists.addBack(temp);
			
		}
		
		
		while(listolists.size()>1) {
			
			listolists.addBack(combine(listolists.getIndex(0),listolists.getIndex(1)));
			
			listolists.removeFront();
			listolists.removeFront();
			
		}
		
		output = listolists.getIndex(0);
		
		return output;
	}
	//NOTE! Lists are passed by VALUE so any list entered into combine will be rendered UNUSEABLE
	public ListADT<Integer> combine(ListADT<Integer> in1,ListADT<Integer> in2){
		ListADT<Integer> output = new JavaList<>();
		ListADT<Integer> input1 = in1;
		ListADT<Integer> input2 = in2;
		int front1;
		int front2;
		while(input1.size()!= 0 && input2.size() != 0) {
			front1 = input1.getFront();
			front2 = input2.getFront();
			if(front1<front2) {
				output.addBack(front1);
				input1.removeFront();
			}
			if(front2<front1) {
				output.addBack(front2);
				input2.removeFront();
			}
			if(front1==front2) {
				output.addBack(front2);
				input2.removeFront();
			}
		}
		if(input1.size()>0) {
			output.addAll(input1);
		}
		if(input2.size()>0) {
			output.addAll(input2);
		}
		
		return output;
	}



}


