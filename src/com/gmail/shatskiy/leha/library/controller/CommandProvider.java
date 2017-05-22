package com.gmail.shatskiy.leha.library.controller;

import java.util.HashMap;
import java.util.Map;

import com.gmail.shatskiy.leha.library.controller.command.Command;
import com.gmail.shatskiy.leha.library.controller.command.CommandName;
import com.gmail.shatskiy.leha.library.controller.command.impl.GetCommand;
import com.gmail.shatskiy.leha.library.controller.command.impl.WrongCommand;

final class CommandProvider {

	private final Map<CommandName, Command> repository = new HashMap<>();

	CommandProvider() {
		repository.put(CommandName.GET, new GetCommand());
		repository.put(CommandName.WRONG_REQUEST, new WrongCommand());
	}

	Command getCommand(String name) {
		CommandName commandName = null;
		Command command = null;

		try {
			commandName = CommandName.valueOf(name.toUpperCase());
			command = repository.get(commandName);
		} catch (IllegalArgumentException | NullPointerException e) {
			command = repository.get(CommandName.WRONG_REQUEST);
		}
		return command;
	}
}
