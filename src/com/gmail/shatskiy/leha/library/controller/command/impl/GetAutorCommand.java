package com.gmail.shatskiy.leha.library.controller.command.impl;

import java.util.ArrayList;

import com.gmail.shatskiy.leha.library.beans.Book;
import com.gmail.shatskiy.leha.library.controller.command.Command;
import com.gmail.shatskiy.leha.library.service.ServicesBooksInterface;
import com.gmail.shatskiy.leha.library.service.exception.ServicesException;
import com.gmail.shatskiy.leha.library.service.factory.ServiceFactory;

public class GetAutorCommand implements Command {

	private final String PARAM_DELIMITER = " ";
	private final int POSITION_AUTOR = 1;
	private final int AMOUNT_PARAM = 2;

	@Override
	public String execute(String request) throws ServicesException {
		String response;
		String autor;
		ArrayList<Book> list = null;
		String[] massParam = request.split(PARAM_DELIMITER);

		if (massParam.length < AMOUNT_PARAM) {
			response = "WRONG_REQUEST";
		} else {
			autor = request.split(PARAM_DELIMITER)[POSITION_AUTOR];

			ServiceFactory serviceFactory = ServiceFactory.getInstance();
			ServicesBooksInterface servicesBooks = serviceFactory.getServicesBooks();

			list = servicesBooks.getBooksAutor(autor);
			response = FormattingList.formatting(list);
		}

		return response;
	}
}
