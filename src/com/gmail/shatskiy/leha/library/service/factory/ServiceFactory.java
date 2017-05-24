package com.gmail.shatskiy.leha.library.service.factory;

import com.gmail.shatskiy.leha.library.service.ServicesBooksInterface;
import com.gmail.shatskiy.leha.library.service.impl.ServicesBooks;

public final class ServiceFactory {
	
	private static final ServiceFactory instance = new ServiceFactory();
	
	private final ServicesBooksInterface servicesBooks = new ServicesBooks();
	
	private ServiceFactory(){}
	
	public static ServiceFactory getInstance(){
		return instance;
	}
	
	public ServicesBooksInterface getServicesBooks(){
		return servicesBooks;
	}
	
}
