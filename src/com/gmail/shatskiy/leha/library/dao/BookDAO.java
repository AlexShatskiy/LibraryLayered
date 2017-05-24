package com.gmail.shatskiy.leha.library.dao;


import java.util.ArrayList;

import com.gmail.shatskiy.leha.library.beans.Book;
import com.gmail.shatskiy.leha.library.dao.exception.DAOException;

public interface BookDAO {
	
	public ArrayList<Book> loadBooksAutor(String autor) throws DAOException;
	
	public ArrayList<Book> loadBooksName(String name) throws DAOException;
	
	public ArrayList<Book> loadBooksNameAutor(String name, String autor) throws DAOException;
	
	public ArrayList<Book> loadBooksNameAutorType(String name, String autor, String type) throws DAOException;

}
