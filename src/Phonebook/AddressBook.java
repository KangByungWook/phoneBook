package Phonebook;

import java.util.ArrayList;
import java.util.Iterator;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class AddressBook implements Iterable<Person> // 항목 13에서 설명
{
	public static ArrayList<Person> data = new ArrayList<Person>(); // 항목 14에서
																	// 설명
	
	// public AddressBook()
	// {
	// data = new ArrayList<Person>();
	// }
	public static int contains(String name)
	{
		for (int i = 0; i < data.size(); ++i)
		{
			if (data.get(i).name.equals(name)||data.get(i).numbers.contains(name))
			{
				return i;
			}
			
		}
		return -1;
		
	}
	
	public static boolean Add(Person person)
	{
		return data.add(person);
	}
	
	public static Person Get(int index)
	{
		return (Person) data.toArray()[index];
		
	}
	
	@Override
	public Iterator<Person> iterator() // 항목 15에서 설명
	{
		return data.iterator();
	}
}
