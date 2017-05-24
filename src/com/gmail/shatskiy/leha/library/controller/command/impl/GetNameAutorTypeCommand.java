package com.gmail.shatskiy.leha.library.controller.command.impl;

import com.gmail.shatskiy.leha.library.controller.command.Command;
import com.gmail.shatskiy.leha.library.service.ServicesBooksInterface;
import com.gmail.shatskiy.leha.library.service.exception.ServicesException;
import com.gmail.shatskiy.leha.library.service.factory.ServiceFactory;

public class GetNameAutorTypeCommand implements Command {

	private final String PARAM_DELIMITER = " ";
	private final int POSITION_NAME = 1;
	private final int POSITION_AUTOR = 2;
	private final int POSITION_TYPE = 3;
	private final int AMOUNT_PARAM = 4;

	@Override
	public String execute(String request) throws ServicesException {
		String response;
		String name;
		String autor;
		String type;
		String[] massParam = request.split(PARAM_DELIMITER);

		if (massParam.length < AMOUNT_PARAM) {
			response = new WrongCommand().execute(request);
		} else {
			name = request.split(PARAM_DELIMITER)[POSITION_NAME];
			autor = request.split(PARAM_DELIMITER)[POSITION_AUTOR];
			type = request.split(PARAM_DELIMITER)[POSITION_TYPE];

			ServiceFactory serviceFactory = ServiceFactory.getInstance();
			ServicesBooksInterface servicesBooks = serviceFactory.getServicesBooks();

			response = servicesBooks.getBooksNameAutorType(name, autor, type);
		}

		return response;
	}
}
