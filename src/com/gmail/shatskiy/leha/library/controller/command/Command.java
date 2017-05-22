package com.gmail.shatskiy.leha.library.controller.command;

import com.gmail.shatskiy.leha.library.services.exception.ServicesException;

public interface Command {
	
	public String execute(String request) throws ServicesException;
	
}
