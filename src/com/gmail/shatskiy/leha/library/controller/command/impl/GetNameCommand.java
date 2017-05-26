package com.gmail.shatskiy.leha.library.controller.command.impl;

import java.util.ArrayList;

import com.gmail.shatskiy.leha.library.beans.Book;
import com.gmail.shatskiy.leha.library.controller.command.Command;
import com.gmail.shatskiy.leha.library.service.ServicesBooksInterface;
import com.gmail.shatskiy.leha.library.service.exception.ServicesException;
import com.gmail.shatskiy.leha.library.service.factory.ServiceFactory;

public class GetNameCommand implements Command {

	private final String PARAM_DELIMITER = " ";
	private final int POSITION_NAME = 1;
	private final int AMOUNT_PARAM = 2;

	@Override
	public String execute(String request) throws ServicesException {
		String response;
		String name;
		ArrayList<Book> list = null;
		String[] massParam = request.split(PARAM_DELIMITER);

		if (massParam.length < AMOUNT_PARAM) {
			response = "WRONG_REQUEST";
		} else {
			name = request.split(PARAM_DELIMITER)[POSITION_NAME];

			ServiceFactory serviceFactory = ServiceFactory.getInstance();
			ServicesBooksInterface servicesBooks = serviceFactory.getServicesBooks();

			list = servicesBooks.getBooksName(name);
			response = FormattingList.formatting(list);
		}

		return response;
	}
}
