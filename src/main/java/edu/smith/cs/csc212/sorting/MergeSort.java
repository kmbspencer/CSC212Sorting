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
		ListADT<ListADT<Integer>> listolists = new JavaList<>();		
		for(int i =0; i<input.size();i++) {
			ListADT<Integer> temp = new JavaList<>();
			temp.addFront(input.getIndex(i));
			//System.out.println(temp);
			listolists.addBack(temp);
			//System.out.println("lists of lists "+listolists.toString());
		}
		//System.out.println("lists of lists "+listolists.toString());
		
		while(listolists.size()>1) {
			//System.out.println(listolists.toString());
			listolists.addBack(combine(listolists.getIndex(0),listolists.getIndex(1)));
			//System.out.println(listolists.toString());
			listolists.removeFront();
			listolists.removeFront();
			//System.out.println(listolists.toString());
		}
		/**for(int i = 0; i<listolists.size();i+=2) {
			listolists.addBack(this.combine(listolists.getIndex(i),listolists.getIndex(i+1)));
			System.out.println(" i is "+i+"list o lists "+listolists.toString());
			listolists.removeFront();
			listolists.removeFront();
			if(listolists.size()==1) {
				break;
			}
		}**/
		output = listolists.getIndex(0);
		
		return output;
	}
	//NOTE! Lists are passed by VALUE so any list entered into combine will be rendered UNUSEABLE
	public ListADT<Integer> combine(ListADT<Integer> in1,ListADT<Integer> in2){
		ListADT<Integer> output = new JavaList<>();
		ListADT<Integer> input1 = in1;
		ListADT<Integer> input2 = in2;
		//int front1 = input1.getFront();
		//int front2 = input2.getFront();
		int front1;
		int front2;
		//for(int i =0; i<input1.size();i++) {
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

	public static void main(String[] args) {
		MergeSort test = new MergeSort();
		ListADT<Integer> input = new JavaList<>();
		input.addBack(24);
		input.addBack(3);
		input.addBack(1000);
		
		input.addBack(270);
		input.addBack(1);
		input.addBack(24);
		System.out.println(input);
		ListADT<Integer> output = test.recursort(input);
		System.out.println(output);
		
		
		
	}

}
