package com.gmail.shatskiy.leha.library.controller.command.impl;

import com.gmail.shatskiy.leha.library.controller.command.Command;

public class WrongCommand implements Command {

	@Override
	public String execute(String request) {
		// TODO Auto-generated method stub
		return "WRONG_REQUEST";
	}
}
