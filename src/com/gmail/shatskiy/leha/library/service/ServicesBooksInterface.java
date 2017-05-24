package com.gmail.shatskiy.leha.library.service;

import com.gmail.shatskiy.leha.library.service.exception.ServicesException;

public interface ServicesBooksInterface {
	
	public String getBooksAutor(String autor) throws ServicesException;
	
	public String getBooksName(String name) throws ServicesException;
	
	public String getBooksNameAutor(String name, String autor) throws ServicesException;
	
	public String getBooksNameAutorType(String name, String autor, String type) throws ServicesException;

}
