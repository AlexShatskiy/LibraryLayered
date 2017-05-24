package com.gmail.shatskiy.leha.library.service.impl;

import java.util.ArrayList;

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
	public String getBooksAutor(String autor) throws ServicesException {

		String response;

		ArrayList<Book> list = null;

		try {
			list = bookDAO.loadBooksAutor(autor);
		} catch (IllegalArgumentException | NullPointerException e) {
			return response = "WRONG_REQUEST_services";
		} catch (DAOException e) {
			throw new ServicesException(e);
		}
		
		response = FormattingList.formatting(list);

		return response;
	}

	@Override
	public String getBooksName(String name) throws ServicesException {

		String response;

		ArrayList<Book> list = null;

		try {
			list = bookDAO.loadBooksName(name);
		} catch (IllegalArgumentException | NullPointerException e) {
			return response = "WRONG_REQUEST_services";
		} catch (DAOException e) {
			throw new ServicesException(e);
		}
		
		response = FormattingList.formatting(list);

		return response;
	}

	@Override
	public String getBooksNameAutor(String name, String autor) throws ServicesException {

		String response;

		ArrayList<Book> list = null;

		try {
			list = bookDAO.loadBooksNameAutor(name, autor);
		} catch (IllegalArgumentException | NullPointerException e) {
			return response = "WRONG_REQUEST_services";
		} catch (DAOException e) {
			throw new ServicesException(e);
		}
		
		response = FormattingList.formatting(list);

		return response;
	}

	@Override
	public String getBooksNameAutorType(String name, String autor, String type) throws ServicesException {

		String response;

		ArrayList<Book> list = null;

		try {
			list = bookDAO.loadBooksNameAutorType(name, autor, type);
		} catch (IllegalArgumentException | NullPointerException e) {
			return response = "WRONG_REQUEST_services";
		} catch (DAOException e) {
			throw new ServicesException(e);
		}
		
		response = FormattingList.formatting(list);

		return response;
	}
}
