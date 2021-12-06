package tester;

import java.util.Scanner;

import dao.TopicDaoImpl;
import dao.TutorialDaoImpl;
import dao.UserDaoImpl;

public class TestLayeredApp {
	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in)) {
			UserDaoImpl dao = new UserDaoImpl();
			TopicDaoImpl tdao = new TopicDaoImpl();
			TutorialDaoImpl tutdao = new TutorialDaoImpl();
			
			boolean exit = false;
			
			while(!exit) {
				System.out.println("\nSelect Operation\n"
						+"1. Login\n"
						+"2. Update password\n"
						+"3. Get All Available Topic Names\n"
						+"4. Get All tutorial titles under selected topic , ordered in desc manner of visits\n"
						+"10. EXIT");
				try {
					switch(sc.nextInt()) {
					case 1:
						System.out.println("Enter email and password : ");
						System.out.println(dao.authenticateUser(sc.next(), sc.next()));
						break;
					case 2:
						System.out.println("Enter email and password and new password : ");
						System.out.println(dao.updatePassword(sc.next(), sc.next(),sc.next()));
						break;
					case 3:
						tdao.getAllTopics().forEach(System.out::println);
						break;
					case 4:
						System.out.println("Enter Topic Name: ");
						tutdao.getTutorialsByTopicName(sc.nextLine()).forEach(System.out::println);
						break;
					case 10:
						exit = true;
						dao.cleanUp();
						tdao.cleanUp();
						tutdao.cleanUp();
						break;
					default:
						System.out.println("Please select valid operation.");
						break;
					}
				}catch(Exception e) {
					e.printStackTrace();
				}
				sc.nextLine();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
