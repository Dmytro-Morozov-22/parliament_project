package com.ua.vin.parliament;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class Faction {

	private String name;

	public Faction(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	LinkedList<Deputy> depList = new LinkedList<>();

	public void con() {
		System.out.println(depList);
	}

//додати депутата(вводимо з консолі)
	@SuppressWarnings("resource")
	public void addDeputy() {
		System.out.println("Введіть прізвище депутата");
		Scanner sc = new Scanner(System.in);

		String surname = sc.next().toUpperCase();

		depList.add(new Deputy(getRandRange(150, 210), getRandRange(55, 120),
				surname, getRandRange(25, 65), getRandBoolean()));
		depList.getLast().giveAbribe();
		
		
	}

//видалити депутата(вводимо з консолі)
	@SuppressWarnings("resource")
	public void removeDeputy() {
		System.out.println("Введіть прізвище для видалення");
		Scanner sc = new Scanner(System.in);
		String surname = sc.next().toUpperCase();

		Iterator<Deputy> iterator = depList.iterator();
		int i = 0;
		while (iterator.hasNext()) {
			Deputy next = iterator.next();
			if (next.getSurname().equals(surname)) {
				iterator.remove();
				System.out.println("Депутата успішно видалено");
				i--;
			} else {
				i++;
			}
		}
		if (i == depList.size()) {
			System.err
					.println("Депутата з таким прізвищем немає у цій фракції");
		}
	}

//вивести всіх хабарників у фракції
	public void getAllGrafters() {
		Iterator<Deputy> iterator = depList.iterator();
		int i = 0;
		while (iterator.hasNext()) {
			Deputy next = iterator.next();
			if (next.isGrafter() == true) {
				System.out
						.println(next.getSurname().substring(0, 1).toUpperCase()
								+ next.getSurname().substring(1).toLowerCase()
								+ " - хабарник");
			} else {
				i++;
			}
		}

		if (i == depList.size()) {
			System.out.println("У фракції немає хабарникив");
		}

	}

//вивести найбільшого хабарника у фракції

	public void theBiggestGrafter() {
		Collections.sort(depList, new BribeSizeComparator());

		System.out.println("Найбільший хабарник - "
				+ depList.getLast().getSurname().substring(0, 1).toUpperCase()
				+ depList.getLast().getSurname().substring(1).toLowerCase()
				+ " " + depList.getLast().getBribeSize());
	}

//вивести всіх депутатів фракції

	public void getDeputies() {
		Collections.sort(depList, new SurnameComparator());
		Iterator<Deputy> iterator = depList.iterator();

		while (iterator.hasNext()) {
			Deputy next = iterator.next();
			System.out.println(next.getSurname().substring(0, 1).toUpperCase()
					+ next.getSurname().substring(1).toLowerCase());
		}
	}

//очистити всю фракцію від депутатів

	public void removeAllFaction() {
		Iterator<Deputy> iterator = depList.iterator();
		while (iterator.hasNext()) {
			iterator.next();
			iterator.remove();
		}
	}

	@Override
	public String toString() {
		return "Faction [name=" + name + ", depList=" + depList + "]";
	}

	// Random range
	private static int getRandRange(int min, int max) {

		if (min >= max) {
			throw new IllegalArgumentException(
					"min value must be smaller than max value");
		}

		Random r = new Random();
		return r.nextInt(max - min + 1) + min;
	}

//Random boolean
	private static boolean getRandBoolean() {
		return Math.random() < 0.5;

	}

}
