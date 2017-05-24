package com.gmail.shatskiy.leha.library.controller;

import com.gmail.shatskiy.leha.library.controller.command.Command;
import com.gmail.shatskiy.leha.library.service.exception.ServicesException;

public class Controller implements ControllerInterface {
	
	private final CommandProvider provider = new CommandProvider();
	
	private final String PARAM_DELIMITER = " ";
	private final int POSITION_COMMAND = 0;
	
	@Override
	public String executeTask(String request) {
		String commandName;
		Command executionCommand;

		commandName = request.split(PARAM_DELIMITER)[POSITION_COMMAND];
		executionCommand = provider.getCommand(commandName);
		
		String response = null;
		try {
			response = executionCommand.execute(request);
		} catch (ServicesException e) {
			e.printStackTrace();
		}
		return response;
	}

}
