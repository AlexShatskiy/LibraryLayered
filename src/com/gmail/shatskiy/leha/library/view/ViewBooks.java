package com.gmail.shatskiy.leha.library.view;

import java.util.ArrayList;

import com.gmail.shatskiy.leha.library.beans.Book;
import com.gmail.shatskiy.leha.library.controller.Controller;
import com.gmail.shatskiy.leha.library.controller.ControllerInterface;

public class ViewBooks {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ControllerInterface controller = new Controller();
		String resp1;
		resp1 = controller.executeTask("get_Name name3");
		System.out.println(resp1);
		// name3 autor2 desc3 FANTASY
		String resp2 = controller.executeTask("get_Autor autor1");
		System.out.println(resp2);
		/*
		 * name1 autor1 desc1 FANTASY 
		 * name2 autor1 desc2 SCIENCE
		 * name5 autor1 desc5 SCIENCE
		 */
		String resp3 = controller.executeTask("get_Name_Autor name1 autor1");
		System.out.println(resp3);
		//name1 autor1 desc1 FANTASY
		String resp4 = controller.executeTask("get_Name_Autor_Type name2 autor1 SCIENCE");
		System.out.println(resp4);
		// name2 autor1 desc2 SCIENCE
		String resp5 = controller.executeTask("getg_Name_Autor_Type name3 autor1 SCIENCE");
		System.out.println(resp5);
		// WRONG_REQUEST
		String resp6 = controller.executeTask("getg_Name_Autor_Type name3 autor1");
		System.out.println(resp6);
		// WRONG_REQUEST
		String resp7 = controller.executeTask("get_Autor");
		System.out.println(resp7);
		// WRONG_REQUEST
	}
}
