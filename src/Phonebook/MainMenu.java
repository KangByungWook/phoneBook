package Phonebook;

import java.util.InputMismatchException;
import java.util.Scanner;

import Phonebook.AddressBook;

public class MainMenu
{
	
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args)
	{
		
		int choice;
		boolean end = false;
		while (!end)
		{
			System.out.println("*******메뉴*******");
			System.out.println("1. 주소록 추가");
			System.out.println("2. 주소록 삭제");
			System.out.println("3. 주소록 보기");
			System.out.println("4. 이름으로 주소록 검색");
			System.out.println("5. 전화번호로 주소록 검색");
			System.out.println("6. 메시지 보내기");
			System.out.println("7. 메시지 리스트 보기");
			System.out.println("8. 프로그램 종료");
			System.out.println("*****************");
			try
			{
				System.out.print("메뉴를 입력하세요 : ");
				choice = sc.nextInt();
			}
			catch (Exception e)
			{
				System.out.println("잘못 입력하셨습니다. 다시 선택하세요.");
				sc.nextLine();
				continue;
			}
			
			switch (choice)
			{
			case 1:
				GetAddress();
				break;
			case 2:
				String tempLine;
				System.out.print("전화번호로 지우려면 1번, 이름으로 지우려면 2번을 입력하세요: ");
				int menu = sc.nextInt();
				sc.nextLine();
				while (menu != 1 && menu != 2)
				{
					System.out.println("잘못 입력하셨습니다.");
					System.out.print("전화번호로 지우려면 1번, 이름으로 지우려면 2번을 입력하세요: ");
					menu = sc.nextInt();
					sc.nextLine();
				}
				if (menu == 1)
				{
					System.out.print("전화번호를 입력하세요: ");
					tempLine = sc.nextLine();
					DeleteAddressByNum(tempLine);
				}
				if (menu == 2)
				{
					System.out.print("이름을 입력하세요: ");
					tempLine = sc.nextLine();
					DeleteAddressByName(tempLine);
				}
				break;
			case 3:
				ShowAddressList();
				break;
			case 4:
			case 5:
				FindAddressByNameRenderer();
				break;
			case 6:
				String tempPhoneNum;
				System.out.print("전화번호를 입력하세요: ");
				tempPhoneNum = sc.nextLine();
				SendSMSRenderer(tempPhoneNum);
				break;
			case 7:
				ShowMessage_Renderer();
				break;
			case 8:
				end = true;
				break;
			default:
				System.out.println("잘못 입력하셨습니다. 다시 선택하세요.");
				sc.nextLine();
				continue;
			
			}
			if (end == true)
				break;
		}
	}
	
	private static void DeleteAddressByNum(String text)
	{
		for (int i = 0; i < AddressBook.data.size(); ++i)
		{
			if (AddressBook.Get(i).numbers.contains(text))
				AddressBook.data.remove(i);
		}
		
	}
	
	private static void DeleteAddressByName(String text)
	{
		for (int i = 0; i < AddressBook.data.size(); ++i)
		{
			if (AddressBook.Get(i).name.equals(text))
				AddressBook.data.remove(i);
		}
		
	}
	
	private static void ShowMessage_Renderer()
	{
		// TODO Auto-generated method stub
		
	}
	
	private static void SendSMSRenderer(String tempPhoneNum)
	{
		// TODO Auto-generated method stub
		
	}
	
	private static void FindAddressByNameRenderer()
	{
		
	}
	
	private static void ShowAddressList()
	{
		// TODO Auto-generated method stub
		System.out.println("----------[주소록 보기]----------");
		for (int i = 0; i < AddressBook.data.size(); i++)
		{
			System.out.println(AddressBook.Get(i).name + '\t' + AddressBook.Get(i).numbers);
		}
	}
	
	private static void GetAddress()
	{
		System.out.println("----------[주소록 등록]----------");
		System.out.print("이름을 입력하세요 : ");
		String strName;
		strName = sc.next();// 이름을 입력받는다
		sc.nextLine();
		Person temp = new Person();
		temp.name = strName;
		String num;
		if (AddressBook.contains(strName) != -1)
		{
			System.out.println("이미 존재하는 이름입니다 처음부터 다시 시작하세요");
			return;
		}
		boolean yOrN = true;
		while (yOrN)
		{
			System.out.print("전화번호를 입력하세요 : ");
			num = sc.nextLine();
			temp.numbers.add(num);
			boolean a = false;
			while (!a)
			{
				System.out.println("계속할까요? (true/false)");
				try
				{
					yOrN = sc.nextBoolean();
					sc.nextLine();
				}
				catch (InputMismatchException e)
				{
					System.out.println("잘못입력하셨습니다");
					sc.nextLine();
					continue;
				}
				a = true;
			}
			
		}
		AddressBook.Add(temp);
		
	}
}
