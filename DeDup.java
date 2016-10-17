package com.duplicates;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class DeDup {
    public  int[] randomIntegers = {1,2,34,34,25,1,45,3,26,85,4,34,86,25,43,2,1,10000,11,16,19,1,18,4,9,3,
                                   20,17,8,15,6,2,5,10,14,12,13,7,8,9,1,2,15,12,18,10,14,20,17,16,3,6,19,
                                   13,5,11,4,7,19,16,5,9,12,3,20,7,15,17,10,6,1,8,18,4,14,13,2,11};   
    public static void main(String [] args) {

    	try{
	    	int[] rIntegers = new DeDup().randomIntegers;
	    	System.out.println("Original randonIntegers list="+Arrays.toString(rIntegers));
	    	int [] result =removeDuplicatesMethod_1(rIntegers);//removeDuplicatesMethod_1
	    	printresults(result,"removeDuplicatesMethod_1");
	       	
	    	result =removeDuplicatesMethod_2(rIntegers);//removeDuplicatesMethod_2
	       	System.out.println("Result of removeDuplicatesMethod_2 (rIntegers) method = "+Arrays.toString(result));
	   	 
	    	result =removeDuplicatesMethod_3(rIntegers);//removeDuplicatesMethod_3
	    	printresults(result,"removeDuplicatesMethod_3");
    	}catch(Exception ex){
		   ex.printStackTrace();
	   }
    }

    
    //This method will add all the int array to the HashSet<Integer> ,Adds the specified element to this set if it is not already present .
    //returns unique elements in the array 
    public static int [] removeDuplicatesMethod_1(int[] array) {
        // add the int array to the a set
    	
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < array.length; i++) {
            set.add(array[i]);
        }

        int[] result = toPrimitive(toInteger(set.toArray()));
   		return result;
    	
    }

    //This method checks int arr data with the filtered Set and dynamically increase the arraysize of whitelist and adds only the filtered 
    //returns unique elements in the array
	public static int [] removeDuplicatesMethod_2(int[] arr) {
  	  Set<Integer> exists = new HashSet<Integer>();
  	  int[] whitelist = new int[0];

  	  for (int nextElem : arr) {
  	    if (!exists.contains(nextElem)) {
  	      whitelist = Arrays.copyOf(whitelist, whitelist.length + 1);
  	      whitelist[whitelist.length - 1] = nextElem;
  	      exists.add(nextElem);
  	    }
  	  }

  	  return whitelist;
  	}
    //Nested loop to filter the duplicates and add the results to the Set
	//  returns unique elements in the array
    public static int [] removeDuplicatesMethod_3(int numbers[]){
    	  int[] newArray= new int[numbers.length];
    	  Set<Integer> set = new HashSet<Integer>();
    	  for(int i = 0; i <numbers.length; i++ ){
    		  for(int j = 0; j < newArray.length; j++ ){
		    	  if(newArray[j] == numbers[i]) {
		    	          break;
		    	      }
		    	  }
    		  	set.add(numbers[i]);
    	  }
    	  
       int[] result = toPrimitive(toInteger(set.toArray()));    	  
       return result;
    }
   
    	
    public static void printresults(int [] array, String methodName){
    	Arrays.sort(array); // Can be used if the array need to sorted.
    	System.out.println("Result of "+methodName+"(rIntegers) method = "+Arrays.toString(array));
    }

	// Convert int[] to Integer[]
	public static Integer[] toObject(int[] intArray) {

		Integer[] result = new Integer[intArray.length];
		for (int i = 0; i < intArray.length; i++) {
			result[i] = Integer.valueOf(intArray[i]);
		}
		return result;

	}

	// Convert Integer[] to int[]
	public static int[] toPrimitive(Integer[] IntegerArray) {

		int[] result = new int[IntegerArray.length];
		for (int i = 0; i < IntegerArray.length; i++) {
			result[i] = IntegerArray[i].intValue();
		}
		return result;
	}
	
	// Convert Object[] to Integer[]
	public static Integer[] toInteger(Object[] objectArray) {

		Integer[] result = new Integer[objectArray.length];
		for (int i = 0; i < objectArray.length; i++) {
			result[i] = (Integer)objectArray[i];
		}
		return result;
	}

}
