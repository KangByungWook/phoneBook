package Phonebook;

import java.util.Date;


public class Info
{
	String PhoneNum;
	Date date;
	String time;
	public Info(String num, Date dateInput, String timeInput)
	{
		PhoneNum = num;
		date = dateInput;
		time = timeInput;
	}
	public String getNum()
	{
		return PhoneNum;
	}
	public Date getDate()
	{
		return date;
	}
	public String getTime()
	{
		return time;
	}
}
