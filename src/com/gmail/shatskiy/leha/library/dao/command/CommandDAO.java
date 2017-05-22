package com.gmail.shatskiy.leha.library.dao.command;




import java.io.IOException;
import java.util.ArrayList;

import com.gmail.shatskiy.leha.library.beans.Book;

public interface CommandDAO {
	
	public ArrayList<Book> execute(String request) throws IOException;
	
}
