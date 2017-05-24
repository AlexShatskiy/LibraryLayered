package com.gmail.shatskiy.leha.library.controller.command;

import com.gmail.shatskiy.leha.library.service.exception.ServicesException;

public interface Command {
	
	public String execute(String request) throws ServicesException;
	
}
