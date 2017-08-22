package com.brainacad.oop.testpredefannotation;

import java.io.File;

public class Main {

    public static void main(String[] args) {
	 User user1 = new User("Pavlo");
	 user1.addPermission(PermissionAction.USER_READ);
	 User user2 = new User("Orest");
	 user2.addPermission(PermissionAction.USER_CHANGE);
	 User user3 = new User("Sasha");
	 user3.addPermission(PermissionAction.USER_DELETE);
	 User user4 = new User("Mykola");
	 user4.addPermission(PermissionAction.USER_READ);
	 user4.addPermission(PermissionAction.USER_CHANGE);

	 User[] users = {user1, user2, user3, user4};
	 File file = new File("file.txt");
	 Action action = new Action();

	 for (User u : users) {
	     action.readToFile(u, file);
	     action.writeToFile(u, file);
     }

    }
}
