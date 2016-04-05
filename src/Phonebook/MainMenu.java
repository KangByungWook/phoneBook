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
			System.out.println("*******�޴�*******");
			System.out.println("1. �ּҷ� �߰�");
			System.out.println("2. �ּҷ� ����");
			System.out.println("3. �ּҷ� ����");
			System.out.println("4. �̸����� �ּҷ� �˻�");
			System.out.println("5. ��ȭ��ȣ�� �ּҷ� �˻�");
			System.out.println("6. �޽��� ������");
			System.out.println("7. �޽��� ����Ʈ ����");
			System.out.println("8. ���α׷� ����");
			System.out.println("*****************");
			try
			{
				System.out.print("�޴��� �Է��ϼ��� : ");
				choice = sc.nextInt();
			}
			catch (Exception e)
			{
				System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �����ϼ���.");
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
				System.out.print("��ȭ��ȣ�� ������� 1��, �̸����� ������� 2���� �Է��ϼ���: ");
				int menu = sc.nextInt();
				sc.nextLine();
				while (menu != 1 && menu != 2)
				{
					System.out.println("�߸� �Է��ϼ̽��ϴ�.");
					System.out.print("��ȭ��ȣ�� ������� 1��, �̸����� ������� 2���� �Է��ϼ���: ");
					menu = sc.nextInt();
					sc.nextLine();
				}
				if (menu == 1)
				{
					System.out.print("��ȭ��ȣ�� �Է��ϼ���: ");
					tempLine = sc.nextLine();
					DeleteAddressByNum(tempLine);
				}
				if (menu == 2)
				{
					System.out.print("�̸��� �Է��ϼ���: ");
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
				System.out.print("��ȭ��ȣ�� �Է��ϼ���: ");
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
				System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �����ϼ���.");
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
		System.out.println("----------[�ּҷ� ����]----------");
		for (int i = 0; i < AddressBook.data.size(); i++)
		{
			System.out.println(AddressBook.Get(i).name + '\t' + AddressBook.Get(i).numbers);
		}
	}
	
	private static void GetAddress()
	{
		System.out.println("----------[�ּҷ� ���]----------");
		System.out.print("�̸��� �Է��ϼ��� : ");
		String strName;
		strName = sc.next();// �̸��� �Է¹޴´�
		sc.nextLine();
		Person temp = new Person();
		temp.name = strName;
		String num;
		if (AddressBook.contains(strName) != -1)
		{
			System.out.println("�̹� �����ϴ� �̸��Դϴ� ó������ �ٽ� �����ϼ���");
			return;
		}
		boolean yOrN = true;
		while (yOrN)
		{
			System.out.print("��ȭ��ȣ�� �Է��ϼ��� : ");
			num = sc.nextLine();
			temp.numbers.add(num);
			boolean a = false;
			while (!a)
			{
				System.out.println("����ұ��? (true/false)");
				try
				{
					yOrN = sc.nextBoolean();
					sc.nextLine();
				}
				catch (InputMismatchException e)
				{
					System.out.println("�߸��Է��ϼ̽��ϴ�");
					sc.nextLine();
					continue;
				}
				a = true;
			}
			
		}
		AddressBook.Add(temp);
		
	}
}
