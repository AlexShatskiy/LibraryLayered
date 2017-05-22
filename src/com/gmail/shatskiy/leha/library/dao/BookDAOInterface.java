package com.gmail.shatskiy.leha.library.dao;


import java.util.ArrayList;

import com.gmail.shatskiy.leha.library.beans.Book;
import com.gmail.shatskiy.leha.library.dao.exception.DAOException;

public interface BookDAOInterface {
	
	public ArrayList<Book> loadBooks(String request) throws DAOException;

}
