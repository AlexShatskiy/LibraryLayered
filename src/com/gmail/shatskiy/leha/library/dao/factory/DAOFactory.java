package com.gmail.shatskiy.leha.library.dao.factory;

import com.gmail.shatskiy.leha.library.dao.BookDAO;
import com.gmail.shatskiy.leha.library.dao.impl.FileBookDAO;

public class DAOFactory {
	
	private static final DAOFactory instanse = new DAOFactory();
	
	private static final BookDAO bookDAO = new FileBookDAO();
	
	private DAOFactory(){}
	
	public static DAOFactory getInstanse(){
		return instanse;
	}
	
	public static BookDAO getBookDAO(){
		return bookDAO;
	}
}
