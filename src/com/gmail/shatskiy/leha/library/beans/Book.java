package com.gmail.shatskiy.leha.library.beans;

public class Book {

	private String name;
	private String autor;
	private String description;

	public Book() {
		name = "no name";
		autor = "no autor";
		description = "no description";
	}

	public Book(String name, String autor, String description) {
		this.name = name;
		this.autor = autor;
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Book book = (Book) obj;
		if (name == null) {
			if (book.getName() != null) {
				return false;
			}
		} else if (!name.equals(book.getName())) {
			return false;
		}
		if (autor == null) {
			if (book.getAutor() != null) {
				return false;
			}
		} else if (!autor.equals(book.getAutor())) {
			return false;
		}
		if (description == null) {
			if (book.getDescription() != null) {
				return false;
			}
		} else if (!description.equals(book.getDescription())) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int result = 1;
		final int prime = 31;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((autor == null) ? 0 : autor.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return "Book [name=" + name + ", autor=" + autor + ", description=" + description + "]";
	}
	
	

}
