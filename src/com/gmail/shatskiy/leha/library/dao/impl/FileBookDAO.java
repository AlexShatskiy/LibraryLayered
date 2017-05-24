package com.gmail.shatskiy.leha.library.dao.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

import com.gmail.shatskiy.leha.library.beans.Book;
import com.gmail.shatskiy.leha.library.dao.BookDAO;
import com.gmail.shatskiy.leha.library.dao.exception.DAOException;

public class FileBookDAO implements BookDAO {

	IdentifyBooks identifyBooks = new IdentifyBooks();

	@Override
	public ArrayList<Book> loadBooksName(String name) throws DAOException {

		LoaderBooks loaderBooks = new LoaderBooks();
		ArrayList<Book> list = new ArrayList<Book>();

		try (BufferedReader reader = loaderBooks.giveReader();) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] mass = line.split("<>");
				String nameFile = mass[0];
				if (name.equals(nameFile)) {
					String autorFile = mass[1];
					String descFile = mass[2];
					String typeFile = mass[3];
					list.add(identifyBooks.identify(nameFile, autorFile, descFile, typeFile));
				}
			}
		} catch (IOException e) {
			throw new DAOException(e);
		}
		return list;
	}

	@Override
	public ArrayList<Book> loadBooksNameAutor(String name, String autor) throws DAOException {

		LoaderBooks loaderBooks = new LoaderBooks();
		ArrayList<Book> list = new ArrayList<Book>();

		try (BufferedReader reader = loaderBooks.giveReader();) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] mass = line.split("<>");
				String nameFile = mass[0];
				String autorFile = mass[1];
				if (name.equals(nameFile) && autor.equals(autorFile)) {
					String descFile = mass[2];
					String typeFile = mass[3];
					list.add(identifyBooks.identify(nameFile, autorFile, descFile, typeFile));
				}
			}
		} catch (IOException e) {
			throw new DAOException(e);
		}
		return list;
	}

	@Override
	public ArrayList<Book> loadBooksNameAutorType(String name, String autor, String type) throws DAOException {

		LoaderBooks loaderBooks = new LoaderBooks();
		ArrayList<Book> list = new ArrayList<Book>();

		try (BufferedReader reader = loaderBooks.giveReader();) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] mass = line.split("<>");
				String nameFile = mass[0];
				String autorFile = mass[1];
				String typeFile = mass[3];
				if (name.equals(nameFile) && autor.equals(autorFile) && type.equals(typeFile)) {
					String descFile = mass[2];
					list.add(identifyBooks.identify(nameFile, autorFile, descFile, typeFile));
				}
			}
		} catch (IOException e) {
			throw new DAOException(e);
		}
		return list;
	}

	@Override
	public ArrayList<Book> loadBooksAutor(String autor) throws DAOException {

		LoaderBooks loaderBooks = new LoaderBooks();
		ArrayList<Book> list = new ArrayList<Book>();

		try (BufferedReader reader = loaderBooks.giveReader();) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] mass = line.split("<>");
				String autorFile = mass[1];
				if (autor.equals(autorFile)) {
					String nameFile = mass[0];
					String descFile = mass[2];
					String typeFile = mass[3];
					list.add(identifyBooks.identify(nameFile, autorFile, descFile, typeFile));
				}
			}
		} catch (IOException e) {
			throw new DAOException(e);
		}
		return list;
	}
}
