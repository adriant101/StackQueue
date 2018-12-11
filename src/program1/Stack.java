package program1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
//Create by Adrian Ashwah
//Stack implementation that determines if a file has the correct java syntax

public class Stack<T> {


private LinkedList<T> stackList = new LinkedList();
private int count;
private  ArrayList<Character> charArray  = new ArrayList<Character>();


public void push(T data) {
    stackList.addFirst(data);
}

public T pop() {
    return stackList.removeFirst();
}

public boolean isEmpty() {
    return stackList.isEmpty();
}


public String peekTop() {
    return stackList.peek().toString();
}


public int checkSyntax() {

	Iterator<T> iterator = stackList.iterator();
	while (iterator.hasNext()) {
	 String str = iterator.next().toString();
	
	 for (char i : str.toCharArray()) {
		  charArray.add(i);
		}
	}
	String a = "\"";
	String b = "{";
	String c = "}";
	String d = "(";
	String e = ")";
	for(int i = 0; i< charArray.size();i++) {
		if(a.equalsIgnoreCase(charArray.get(i).toString())||b.equalsIgnoreCase(charArray.get(i).toString())||c.equalsIgnoreCase(charArray.get(i).toString())
				|| d.equalsIgnoreCase(charArray.get(i).toString())|| e.equalsIgnoreCase(charArray.get(i).toString())) {
		count +=1;} //increments count if char matches
		
	}

	 
	
	return  count;
	
	}
	
}



