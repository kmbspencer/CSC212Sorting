package edu.smith.cs.csc212.sorting;
import me.jjfoley.adt.ListADT;
import me.jjfoley.adt.impl.JavaList;



public class SelectionSort {
	
	public ListADT<Integer> sort(ListADT<Integer> input){
		//makes an empty list to copy sorted list into
		ListADT<Integer> output = new JavaList<>();
		int smallIndex;
		int size =input.size();
		//loops through input list for as many times as items in it
		for(int k=0; k<size;k++) {
			//starts by looking at first item
			smallIndex = 0;
			//loops through remaining list, finds smallest item
			
			for(int i =1; i<input.size(); i++) {
				if(input.getIndex(i)<input.getIndex(smallIndex)) {
					smallIndex = i;
					
				}
				
			}
			//removes smallest item, then adds it to the back of the output
			output.addBack(input.getIndex(smallIndex));
			input.removeIndex(smallIndex);
			
		}
		return output;
	}
	//tests sorting method
	public static void main(String[] args) {
		SelectionSort test = new SelectionSort();
		ListADT<Integer> input = new JavaList<>();
		input.addBack(6);
		input.addBack(2);
		input.addBack(9);
		input.addBack(70);
		input.addBack(1);
		input.addBack(24);
		
		System.out.println(input);
		ListADT<Integer> output = test.sort(input);
		System.out.println(output);

	}

}
