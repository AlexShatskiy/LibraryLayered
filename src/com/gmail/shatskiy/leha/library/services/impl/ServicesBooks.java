package com.gmail.shatskiy.leha.library.services.impl;

import java.util.ArrayList;
import java.util.Collections;

import com.gmail.shatskiy.leha.library.beans.Book;
import com.gmail.shatskiy.leha.library.beans.FantasyBook;
import com.gmail.shatskiy.leha.library.beans.ScienceBook;
import com.gmail.shatskiy.leha.library.controller.command.CommandName;
import com.gmail.shatskiy.leha.library.dao.BookDAO;
import com.gmail.shatskiy.leha.library.dao.BookDAOInterface;
import com.gmail.shatskiy.leha.library.dao.exception.DAOException;

import com.gmail.shatskiy.leha.library.services.ServicesBooksInterface;
import com.gmail.shatskiy.leha.library.services.exception.ServicesException;

public class ServicesBooks implements ServicesBooksInterface {

	@Override
	public String getBooks(String request) throws ServicesException {

		String response;

		BookDAOInterface bookDAO = new BookDAO();

		ArrayList<Book> list = null;

		StringBuilder builder = new StringBuilder();

		try {
			list = bookDAO.loadBooks(request);
		} catch (DAOException e) {
			throw new ServicesException(e);
		} catch (IllegalArgumentException | NullPointerException e) {
			response = "WRONG_REQUEST_services";
		}

		Collections.sort(list, new BookNameComparator());

		for (Book book : list) {
			builder.append(book.getName() + " " + book.getAutor() + " " + book.getDescription() + " ");
			if (book.getClass() == FantasyBook.class) {
				FantasyBook fbook = (FantasyBook) book;
				builder.append(fbook.getTypeBook());
			} else if (book.getClass() == ScienceBook.class) {
				ScienceBook sbook = (ScienceBook) book;
				builder.append(sbook.getTypeBook());
			}
			builder.append("\n");
		}

		response = builder.toString();

		if (response.length() == 0) {
			response = "Not found";
		}

		return response;
	}

}
