package Phonebook;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class Person
{
	@XmlAttribute
	public String name;
	
	@XmlElement
	public ArrayList<String> numbers;
	
	public Person()
	{
		numbers = new ArrayList<>();
	}
	
}
