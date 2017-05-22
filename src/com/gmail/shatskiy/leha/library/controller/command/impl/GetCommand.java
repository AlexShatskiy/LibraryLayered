package com.gmail.shatskiy.leha.library.controller.command.impl;

import com.gmail.shatskiy.leha.library.controller.command.Command;
import com.gmail.shatskiy.leha.library.services.ServicesBooksInterface;
import com.gmail.shatskiy.leha.library.services.exception.ServicesException;
import com.gmail.shatskiy.leha.library.services.factory.ServiceFactory;

public class GetCommand implements Command {

	@Override
	public String execute(String request) throws ServicesException {

		String response;
		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		ServicesBooksInterface servicesBooks = serviceFactory.getServicesBooks();
		
		response = servicesBooks.getBooks(request);
		
		return response;
	}

}
