package edu.smith.cs.csc212.sorting;

import me.jjfoley.adt.ListADT;
import me.jjfoley.adt.impl.JavaList;

public class InsertionSort {

	public ListADT<Integer> sort(ListADT<Integer> input){
		ListADT<Integer> output = new JavaList<>();
		//puts the first item from the input in the output list
		output.addBack(input.getFront());
		//loops through every item of the input
		for(int i = 0;i<input.size();i++) {
			//loops through each element in the output
			//either sticks in the front if it is the smallest,
			//it its ordered position in the list,
			//or on the back if it is largest
			//breaks after done so that the loop moves onto the next element in the list
			for(int k = 0;k<output.size();k++) {
				if(input.getIndex(i)<output.getIndex(0)) {
					output.addFront(input.getIndex(i));
					break;
				}else if(input.getIndex(i)<output.getIndex(k)) {
					output.addIndex(k, input.getIndex(i));
					break;
				}else if(input.getIndex(i)>output.getBack()){
					output.addBack(input.getIndex(i));
					break;
				}
	
			}
			
		}
		
		return output;
	}


}
