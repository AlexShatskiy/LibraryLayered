package com.gmail.shatskiy.leha.library.dao.impl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class LoaderBooks {
	public BufferedReader giveReader() throws IOException{

		BufferedReader reader = new BufferedReader(
				new FileReader(PathBooks.pass));
		return reader;
	}
}
