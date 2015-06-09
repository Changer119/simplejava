package com.changer.ej;

public class ChairManApp {
	public static void main(String[] args){
		ChairMan chairMan = ChairMan.INSTANCE;
		chairMan.setAge(100);
		chairMan.setName("习近平");
		System.out.println(chairMan);
		
		ChairMan chairMan2 = ChairMan.INSTANCE;
		System.out.println(chairMan2);
	}
}
