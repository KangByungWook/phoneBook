package Phonebook;

import java.util.Date;


public class Call extends Info
{
	int elapsedTime;
	public Call(int a, String num, Date dateInput,String timeInput)
	{
		super(num, dateInput, timeInput);
		elapsedTime = a;
	}
}
