package com.gmail.shatskiy.leha.library.service.impl;

import java.util.Collections;
import java.util.List;

import com.gmail.shatskiy.leha.library.beans.Book;
import com.gmail.shatskiy.leha.library.beans.FantasyBook;
import com.gmail.shatskiy.leha.library.beans.ScienceBook;

class FormattingList {
	
	public static String formatting (List<Book> list){
		
		String response;
		
		StringBuilder builder = new StringBuilder();
		
		Collections.sort(list, new BookNameComparator());

		for (Book book : list) {
			builder.append(book.getName() + " " + book.getAutor() + " " + book.getDescription() + " ");
			if (book.getClass() == FantasyBook.class) {
				FantasyBook fbook = (FantasyBook) book;
				builder.append(fbook.getTypeBook());
			} else if (book.getClass() == ScienceBook.class) {
				ScienceBook sbook = (ScienceBook) book;
				builder.append(sbook.getTypeBook());
			}
			builder.append("\n");
		}

		response = builder.toString();

		if (response.length() == 0) {
			response = "Not found";
		}
		return response;
		
	}
}
