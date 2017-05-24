package com.gmail.shatskiy.leha.library.controller.command.impl;

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
		String[] massParam = request.split(PARAM_DELIMITER);

		if (massParam.length < AMOUNT_PARAM) {
			response = new WrongCommand().execute(request);
		} else {
			autor = request.split(PARAM_DELIMITER)[POSITION_AUTOR];

			ServiceFactory serviceFactory = ServiceFactory.getInstance();
			ServicesBooksInterface servicesBooks = serviceFactory.getServicesBooks();

			response = servicesBooks.getBooksAutor(autor);
		}

		return response;
	}
}
