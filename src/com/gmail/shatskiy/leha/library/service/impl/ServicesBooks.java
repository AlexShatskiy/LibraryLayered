package com.gmail.shatskiy.leha.library.service.impl;

import java.util.ArrayList;
import java.util.Collections;

import com.gmail.shatskiy.leha.library.beans.Book;
import com.gmail.shatskiy.leha.library.dao.BookDAO;
import com.gmail.shatskiy.leha.library.dao.exception.DAOException;
import com.gmail.shatskiy.leha.library.dao.factory.DAOFactory;
import com.gmail.shatskiy.leha.library.service.ServicesBooksInterface;
import com.gmail.shatskiy.leha.library.service.exception.ServicesException;

public class ServicesBooks implements ServicesBooksInterface {

	private final DAOFactory daoFactory = DAOFactory.getInstanse();
	private final BookDAO bookDAO = daoFactory.getBookDAO();

	@Override
	public ArrayList<Book> getBooksAutor(String autor) throws ServicesException {

		if (autor == null) {
			throw new ServicesException();
		}

		ArrayList<Book> list = null;

		try {
			list = bookDAO.loadBooksAutor(autor);
		} catch (DAOException e) {
			throw new ServicesException(e);
		}

		Collections.sort(list, new BookNameComparator());

		return list;
	}

	@Override
	public ArrayList<Book> getBooksName(String name) throws ServicesException {
		
		if (name == null) {
			throw new ServicesException();
		}

		ArrayList<Book> list = null;

		try {
			list = bookDAO.loadBooksName(name);
		} catch (DAOException e) {
			throw new ServicesException(e);
		}

		Collections.sort(list, new BookNameComparator());

		return list;
	}

	@Override
	public ArrayList<Book> getBooksNameAutor(String name, String autor) throws ServicesException {
		
		if (name == null || autor == null) {
			throw new ServicesException();
		}
		
		ArrayList<Book> list = null;

		try {
			list = bookDAO.loadBooksNameAutor(name, autor);
		} catch (DAOException e) {
			throw new ServicesException(e);
		}

		Collections.sort(list, new BookNameComparator());

		return list;
	}

	@Override
	public ArrayList<Book> getBooksNameAutorType(String name, String autor, String type) throws ServicesException {
		
		if (name == null || autor == null || type == null) {
			throw new ServicesException();
		}
		
		String response;

		ArrayList<Book> list = null;

		try {
			list = bookDAO.loadBooksNameAutorType(name, autor, type);
		} catch (DAOException e) {
			throw new ServicesException(e);
		}

		Collections.sort(list, new BookNameComparator());

		return list;
	}
}
