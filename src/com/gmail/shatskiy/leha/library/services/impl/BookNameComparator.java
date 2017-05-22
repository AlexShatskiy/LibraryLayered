package com.gmail.shatskiy.leha.library.services.impl;

import java.util.Comparator;

import com.gmail.shatskiy.leha.library.beans.Book;

class BookNameComparator implements Comparator<Book> {

	@Override
	public int compare(Book arg0, Book arg1) {
		int result;
		int CompName = arg0.getName().compareTo(arg1.getName());
		int CompAutor = arg0.getAutor().compareTo(arg1.getAutor());
		int CompDesc = arg0.getDescription().compareTo(arg1.getDescription());

		result = CompName;
		if (CompName == 0) {
			result = CompAutor;
			if (CompAutor == 0) {
				result = CompDesc;
			}
		}
		return result;
	}
}
