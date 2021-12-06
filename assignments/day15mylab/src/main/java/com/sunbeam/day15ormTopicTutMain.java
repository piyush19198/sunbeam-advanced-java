package com.sunbeam;

import java.time.LocalDate;
import java.util.List;
import static java.util.Date.*;
import org.hibernate.Session;
import org.hibernate.Transaction;
public class day15ormTopicTutMain {
	public static void main(String[] args) {
		try(UserDaoImpl userDaoImpl = new UserDaoImpl()){
			Users user = userDaoImpl.findById(1);
			System.out.println(user);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		try(UserDaoImpl userDaoImpl = new UserDaoImpl()){
			List<Users> userList = userDaoImpl.findAll();
			userList.forEach(System.out::println);
		}catch (Exception e) {
			e.printStackTrace();
		}
		try(UserDaoImpl userDaoImpl = new UserDaoImpl()){
			Users user1 = userDaoImpl.findById(5);
			userDaoImpl.update(user1);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
//		try(UserDaoImpl userDaoImpl = new UserDaoImpl()){
//			userDaoImpl.deleteById(5);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
//		try(UserDaoImpl userDaoImpl = new UserDaoImpl()){
//			userDaoImpl.save(new Users(6, "someone", "s@g.com", "somepass", 65465.0, valueOf("2019-03-04"),"customer"));
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		HbUtil.shutdown();
	}
}
