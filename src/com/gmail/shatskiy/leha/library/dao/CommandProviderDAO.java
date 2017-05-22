package com.gmail.shatskiy.leha.library.dao;

import java.util.HashMap;
import java.util.Map;


import com.gmail.shatskiy.leha.library.dao.command.CommandDAO;
import com.gmail.shatskiy.leha.library.dao.command.CommandNameDAO;
import com.gmail.shatskiy.leha.library.dao.command.impl.GetAutorCommand;
import com.gmail.shatskiy.leha.library.dao.command.impl.GetNameAutorCommand;
import com.gmail.shatskiy.leha.library.dao.command.impl.GetNameAutorTupeCommand;
import com.gmail.shatskiy.leha.library.dao.command.impl.GetNameCommand;
import com.gmail.shatskiy.leha.library.dao.exception.DAOException;

public final class CommandProviderDAO {
	private final Map<CommandNameDAO, CommandDAO> repository = new HashMap<>();

	public CommandProviderDAO() {
		repository.put(CommandNameDAO.GET_AUTOR, new GetAutorCommand());
		repository.put(CommandNameDAO.GET_NAME, new GetNameCommand());
		repository.put(CommandNameDAO.GET_NAME_AUTOR, new GetNameAutorCommand());
		repository.put(CommandNameDAO.GET_NAME_AUTOR_TYPE, new GetNameAutorTupeCommand());
	}

	public CommandDAO getCommandDAO(String name) throws DAOException {
		CommandNameDAO commandNameDAO = null;
		CommandDAO commandDAO = null;
		try {
			commandNameDAO = CommandNameDAO.valueOf(name.toUpperCase());
			commandDAO = repository.get(commandNameDAO);
		} catch (IllegalArgumentException | NullPointerException e) {
			throw new DAOException(e);
		}
		return commandDAO;
	}

}
