package my.main;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
        Menu.first();
		switch (num) {
		case 1:
			dao.getShowAll();
			menu.mainMenu();
			break;
		case 2:
			dao.insert();
			menu.mainMenu();
			break;
		default:
			break;
		}
	}
}
