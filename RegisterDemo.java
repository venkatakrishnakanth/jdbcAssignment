//done by Krishna Kanth.

package com.bell.jdbc;

import java.util.Scanner;

public class RegisterDemo {
	static RegistrationRespository rr = new RegistrationRespository();

	public static void main(String[] args) {

		CustInfo info = new CustInfo("Krishna", "Musunuru", "MALE", 23, "krishna123@gmail.com");

		rr.createRegistration();

		int statusResult = rr.insertCustInfo(info);

		System.out.println("Status Report - inserted:" + statusResult);
		System.out.println("Try inserting an user into Database from console");
		System.out.println("if you try to enter same details, then those will not be entered.");
		System.out.println(
				"\t try inserting name as Krishna and email as krishna123@gmail.com, You will get duplicate user exception");
		info = askinputs();
		int statusResult1 = rr.insertCustInfo(info);

		System.out.println("Status Report - inserted:" + statusResult1+"\n\n");
		System.out.println("***********************DATA IN REGISTER TABLE******************\n");
		rr.getAllInfo();
		System.out.println("\n\n********DELETE USER INFO*************************************\n");
		deleteinfo();
		System.out.println("\n\n***********************LOGIN PAGE********************************\n");
		Login();
		System.out.println("\n\n***********************UPDATE EMAIL OF AN USER*******************\n");
		updateEmail();
		System.out.println("\n\n***********************UPDATE PASSWORD OF AN USER*******************\n");
		updatePassword();
		System.out.println("\n\n***********************UPDATE GENDER OF AN USER*******************\n");
		updateGender();
		System.out.println("\n\n***********************UPDATE AGE OF AN USER*******************\n");
		updateAge();
		System.out.println("\n\n***********************UPDATE NAME OF AN USER*******************\n");
		updateName();

	}

	public static CustInfo askinputs() {
		Scanner s = new Scanner(System.in);
		CustInfo user = new CustInfo();
		System.out.println("Enter Name:");
		user.setName(s.nextLine());
		System.out.println("Enter password:");
		user.setPassword(s.next());
		System.out.println("Enter Gender:");
		user.setGender(s.next());
		System.out.println("Enter Age:");
		user.setAge(s.nextInt());
		s.nextLine();
		System.out.println("Enter email:");
		user.setEmail(s.next());
		return user;

	}

	public static void deleteinfo() {

		System.out.println("*************Enter the name and email of the user to be deleted****************\n");
		System.out.println("Name:");
		Scanner s = new Scanner(System.in);
		String name = s.nextLine();
		System.out.println("\nEmail:");
		String email = s.next();
		rr.deleteuser(name, email);
	}

	public static boolean Login() {
		System.out.println("****************** Enter Username and Password to Login: ******************");
		System.out.println("UserName:");
		Scanner s = new Scanner(System.in);
		String name = s.nextLine();
		System.out.println("\nPassword:");
		String password = s.next();
		boolean success = rr.login(name, password);
		if (success) {
			System.out.println("Login Sucessfull\n\nWelcome " + name);
		} else {
			System.err.println(
					"Did you forget password??\nIf YES please enter YES to delete the account (or)\nIf you want to try again enter NO");
			if (s.next().equalsIgnoreCase("YES")) {
				System.out.println("Enter email to delete account");
				rr.deleteuser(name, s.next());
			} else {
				Login();
			}
		}
		return success;

	}

	public static void updateEmail() {

		System.out.println("****************** Enter Username and Password to reset your Email: ******************");
		System.out.println("UserName:");
		Scanner s = new Scanner(System.in);
		String name = s.nextLine();
		System.out.println("\nPassword:");
		String password = s.next();
		boolean success = rr.login(name, password);
		if (success) {

			System.out.println("Enter email id to be changed");
			String email = s.next();
			if (rr.resetEmail(name, email)) {
				System.out.println("Email reset successfull for " + name);
			} else {
				System.err.println("Error while resetting your email. Please check what you are doing");
			}

		}

	}

	public static void updatePassword() {

		System.out.println("****************** Enter Username and email to reset your password: ******************");
		System.out.println("UserName:");
		Scanner s = new Scanner(System.in);
		String name = s.nextLine();
		System.out.println("\nemail:");
		String email = s.next();
		System.out.println("Enter new password");
		String password = s.next();
		if (rr.resetpassword(name, password)) {
			System.out.println("password reset successfull for " + name);
		} else {
			System.err.println("Error while resetting your password. Please check what you are doing");
		}

	}

	public static void updateGender() {

		System.out
				.println("****************** Enter Username and Password to update your Gender: ******************");
		System.out.println("UserName:");
		Scanner s = new Scanner(System.in);
		String name = s.nextLine();
		System.out.println("\nPassword:");
		String password = s.next();
		boolean success = rr.login(name, password);
		if (success) {

			System.out.println("Enter Gender to be changed");
			String gender = s.next();
			if (rr.resetGender(name, gender)) {
				System.out.println("Gender change successfull for " + name);
			} else {
				System.err.println("Error while resetting your Gender. Please check what you are doing");
			}

		}

	}

	public static void updateAge() {

		System.out.println("****************** Enter Username and Password to update your Age: ******************");
		System.out.println("UserName:");
		Scanner s = new Scanner(System.in);
		String name = s.nextLine();
		System.out.println("\nPassword:");
		String password = s.next();
		boolean success = rr.login(name, password);
		if (success) {

			System.out.println("Enter new Age ");
			String age = s.next();
			if (rr.resetAge(name, age)) {
				System.out.println("Age change successfull for " + name);
			} else {
				System.err.println("Error while resetting your Age. Please check what you are doing");
			}

		}

	}

	public static void updateName() {

		System.out.println("****************** Enter Username and Password to update your Age: ******************");
		System.out.println("UserName:");
		Scanner s = new Scanner(System.in);
		String name = s.nextLine();
		System.out.println("\nPassword:");
		String password = s.next();
		boolean success = rr.login(name, password);
		if (success) {

			System.out.println("Enter new Name ");
			String newname = s.next();
			if (rr.resetName(name, newname)) {
				System.out.println("Name change successfull for " + name);
			} else {
				System.err.println("Error while resetting your Name. Please check what you are doing");
			}

		}

	}

}