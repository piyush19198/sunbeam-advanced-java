package com.sunbeam;

import java.util.List;

public interface BookDao {

	Book findById(int id);

	void save(Book b);

	void update(Book b);

	void deleteById(int id);

	List<Book> findAll();
}