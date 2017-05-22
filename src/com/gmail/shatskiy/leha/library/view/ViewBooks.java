package com.gmail.shatskiy.leha.library.view;

import java.util.ArrayList;

import com.gmail.shatskiy.leha.library.beans.Book;
import com.gmail.shatskiy.leha.library.controller.Controller;
import com.gmail.shatskiy.leha.library.controller.ControllerInterface;
import com.gmail.shatskiy.leha.library.controller.exception.ControllerException;
import com.gmail.shatskiy.leha.library.dao.BookDAO;

public class ViewBooks {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ControllerInterface controller = new Controller();
		String resp1;
		try {
			resp1 = controller.executeTask("get Name name3");
			System.out.println(resp1);
			String resp2 = controller.executeTask("get Autor autor1");
			System.out.println(resp2);
			String resp3 = controller.executeTask("get Name_Autor name1 autor1");
			System.out.println(resp3);
			String resp4 = controller.executeTask("get Name_Autor_Type name2 autor1 SCIENCE");
			System.out.println(resp4);
			String resp5 = controller.executeTask("getg Name_Autor_Type name3 autor1 SCIENCE");
			System.out.println(resp5);
			String resp6 = controller.executeTask("getg Name_Autor_Type name3 autor1");
			System.out.println(resp6);
			String resp7 = controller.executeTask("get Autor1");
			System.out.println(resp7);
		} catch (ControllerException e) {
	
			e.printStackTrace();
			
		}

	}

}
