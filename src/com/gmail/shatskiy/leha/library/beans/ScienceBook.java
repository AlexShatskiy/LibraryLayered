package com.gmail.shatskiy.leha.library.beans;

public class ScienceBook extends Book {
	private final TypesBook typeBook = TypesBook.SCIENCE;

	public ScienceBook() {
		super();
	}

	public ScienceBook(String name, String autor, String description) {
		super(name, autor, description);
	}

	public TypesBook getTypeBook() {
		return typeBook;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		ScienceBook sBook = (ScienceBook) obj;
		if (getTypeBook() != (sBook.getTypeBook())) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + typeBook.hashCode();
		return result;
	}
}
