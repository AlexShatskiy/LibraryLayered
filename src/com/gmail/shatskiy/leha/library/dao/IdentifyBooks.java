package com.gmail.shatskiy.leha.library.dao;

import com.gmail.shatskiy.leha.library.beans.Book;
import com.gmail.shatskiy.leha.library.beans.FantasyBook;
import com.gmail.shatskiy.leha.library.beans.ScienceBook;
import com.gmail.shatskiy.leha.library.beans.TypesBook;

public class IdentifyBooks {
	public Book identify(String name, String autor, String desc, String type) {
		Book book = null;
		if ((TypesBook.FANTASY.toString()).equals(type)) {
			book = new FantasyBook(name, autor, desc);
		} else if ((TypesBook.SCIENCE.toString()).equals(type)) {
			book = new ScienceBook(name, autor, desc);
		}
		return book;
	}
}
