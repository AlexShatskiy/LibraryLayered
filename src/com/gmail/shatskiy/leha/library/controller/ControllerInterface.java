package com.gmail.shatskiy.leha.library.controller;

import com.gmail.shatskiy.leha.library.controller.exception.ControllerException;

public interface ControllerInterface {
	public String executeTask(String request) throws ControllerException;

}
