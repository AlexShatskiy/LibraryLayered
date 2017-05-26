package com.gmail.shatskiy.leha.library.service;

import java.util.ArrayList;

import com.gmail.shatskiy.leha.library.beans.Book;
import com.gmail.shatskiy.leha.library.service.exception.ServicesException;

public interface ServicesBooksInterface {
	
	public ArrayList<Book> getBooksAutor(String autor) throws ServicesException;
	
	public ArrayList<Book> getBooksName(String name) throws ServicesException;
	
	public ArrayList<Book> getBooksNameAutor(String name, String autor) throws ServicesException;
	
	public ArrayList<Book> getBooksNameAutorType(String name, String autor, String type) throws ServicesException;

}
