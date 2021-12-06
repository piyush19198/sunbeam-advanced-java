package com.sunbeam;

public class Demo11Main {
	public static void main(String[] args) {
		try (BookDaoImpl dao = new BookDaoImpl()) {
			Book b = dao.findById(11);
			System.out.println("Found: " + b);
			System.out.println("Final Cost : " + b.getFinalCost());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		HbUtil.shutdown();
	}
}




