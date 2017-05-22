package com.gmail.shatskiy.leha.library.services;

import com.gmail.shatskiy.leha.library.services.exception.ServicesException;

public interface ServicesBooksInterface {
	
	public String getBooks(String request) throws ServicesException;

}
