package com.gmail.shatskiy.leha.library.dao.command.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

import com.gmail.shatskiy.leha.library.beans.Book;
import com.gmail.shatskiy.leha.library.beans.FantasyBook;
import com.gmail.shatskiy.leha.library.dao.IdentifyBooks;
import com.gmail.shatskiy.leha.library.dao.LoaderBooks;
import com.gmail.shatskiy.leha.library.dao.command.CommandDAO;

public class GetNameAutorCommand implements CommandDAO {

	@Override
	public ArrayList<Book> execute(String request) throws IOException {
		// get Name_Autor name3 autor1
		String searchName;
		String searchAutor;
		String[] req = request.split(" ");
		searchName = req[2];
		searchAutor = req[3];

		IdentifyBooks identifyBooks = new IdentifyBooks();

		ArrayList<Book> list = null;
		list = new ArrayList<Book>();

		LoaderBooks loaderBooks = new LoaderBooks();
		BufferedReader reader = loaderBooks.giveReader();
		String line;
		while ((line = reader.readLine()) != null) {
			String[] mass = line.split("<>");
			String name = mass[0];
			String autor = mass[1];
			if (searchName.equals(name) && searchAutor.equals(autor)) {
				String desc = mass[2];
				String type = mass[3];
				list.add(identifyBooks.identify(name, autor, desc, type));
			}
		}
		reader.close();

		return list;
	}

}
