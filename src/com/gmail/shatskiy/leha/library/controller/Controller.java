package com.gmail.shatskiy.leha.library.controller;

import com.gmail.shatskiy.leha.library.controller.command.Command;
import com.gmail.shatskiy.leha.library.controller.exception.ControllerException;
import com.gmail.shatskiy.leha.library.services.exception.ServicesException;

public class Controller implements ControllerInterface {
	
	private final CommandProvider provider = new CommandProvider();
	
	private final char paramDelimeter = ' ';

	@Override
	public String executeTask(String request) throws ControllerException {
		String commandName;
		Command executionCommand;
		
		commandName = request.substring(0, request.indexOf(paramDelimeter));
		executionCommand = provider.getCommand(commandName);
		
		String response = null;
		try {
			response = executionCommand.execute(request);
		} catch (ServicesException e) {
			throw new ControllerException(e);
		}
		
		return response;
	}

}
