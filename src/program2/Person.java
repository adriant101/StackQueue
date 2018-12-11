package program2;

import java.util.Date;

public class Person {
private String name;
private String occupation;
private Date date;


Person(String name, String occupation, Date date){
	this.name = name;
	this.occupation = occupation;
	this.date = date;
	
}


public String toString() {
	return name + " "+ occupation + " " + date;
}

}
