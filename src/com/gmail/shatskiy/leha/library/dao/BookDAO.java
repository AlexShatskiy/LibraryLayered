package com.gmail.shatskiy.leha.library.dao;

import java.io.IOException;
import java.util.ArrayList;

import com.gmail.shatskiy.leha.library.beans.Book;
import com.gmail.shatskiy.leha.library.dao.BookDAOInterface;
import com.gmail.shatskiy.leha.library.dao.CommandProviderDAO;
import com.gmail.shatskiy.leha.library.dao.command.CommandDAO;
import com.gmail.shatskiy.leha.library.dao.exception.DAOException;

public class BookDAO implements BookDAOInterface {

	private final CommandProviderDAO provider = new CommandProviderDAO();

	private final String paramDelimeter = " ";

	@Override
	public ArrayList<Book> loadBooks(String request) throws DAOException {
		
		String commandNameDAO;
		CommandDAO executionCommandDAO = null;
		ArrayList<Book> response = null;

		String[] mass = request.split(paramDelimeter);

		commandNameDAO = mass[0] + "_" + mass[1];
		try {
			executionCommandDAO = provider.getCommandDAO(commandNameDAO);

			response = executionCommandDAO.execute(request);
		} catch (IOException e) {
			throw new DAOException(e);
		}

		return response;
	}

}
