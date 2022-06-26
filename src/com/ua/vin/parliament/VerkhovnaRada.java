package com.ua.vin.parliament;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class VerkhovnaRada {

	private static volatile VerkhovnaRada instance;

	public static VerkhovnaRada getInstance() {
		VerkhovnaRada localInstance = instance;
		if (localInstance == null) {
			synchronized (VerkhovnaRada.class) {
				localInstance = instance;
				if (localInstance == null) {
					instance = localInstance = new VerkhovnaRada();
				}
			}
		}
		return localInstance;
	}

	LinkedList<Faction> facList = new LinkedList<>();

//додати фракцію
	@SuppressWarnings("resource")
	public void addFaction() {
		System.out.println("Введіть назву фракції");
		Scanner sc = new Scanner(System.in);
		String facName = sc.next().toUpperCase();
		facList.add(new Faction(facName));
	}

	public void con() {
		System.out.println(facList);
	}

//видалити фракцію
	@SuppressWarnings("resource")
	public void delFraction() {
		System.out.println("Введіть назву необхідної фракції");
		Scanner sc = new Scanner(System.in);
		Iterator<Faction> iterator = facList.iterator();
		String spesificFaction = sc.next().toUpperCase();
		int i = 0;
		while (iterator.hasNext()) {
			Faction next = iterator.next();
			if (next.getName().equalsIgnoreCase(spesificFaction)) {
				iterator.remove();
				System.out.println("Фракцію " + next.getName() + " видалено");
				i--;
			} else {
				i++;
			}
		}
		if (i == facList.size()) {
			System.err.println("Такої фракції немає у Верховній раді");
		}
	}

//вивести всі фракції	
	public void getAllFaction() {

		if (facList.isEmpty()) {
			System.err.println("Немає жодної фракції у Верховній раді");
		} else {
			Iterator<Faction> iterator = facList.iterator();
			System.out.println("Список усіх фракцій:");
			while (iterator.hasNext()) {
				Faction next = iterator.next();
				System.out.println("Фракція - " + next.getName());
			}
		}
	}

//вивести конкретну фракцію
	@SuppressWarnings("resource")
	public void getSpecificFraction() {
		System.out.println("Введіть назву необхідної фракції");
		Scanner sc = new Scanner(System.in);
		Iterator<Faction> iterator = facList.iterator();
		String spesificFaction = sc.next().toUpperCase();
		int i = 0;
		while (iterator.hasNext()) {
			Faction next = iterator.next();
			if (next.getName().equalsIgnoreCase(spesificFaction)) {
				System.out.println(next);
			} else {
				i++;
			}
		}
		if (i == facList.size()) {
			System.err.println("Такої фракції немає у Верховній раді");
		}
	}

//додати депутата до конкретної фракції
	@SuppressWarnings("resource")
	public void addDeputyToFaction() {
		System.out.println(
				"Введіть назву фракції, до якої потрібно додати депутата");
		Scanner sc = new Scanner(System.in);
		Iterator<Faction> iterator = facList.iterator();
		String spesificFaction = sc.next().toUpperCase();
		int i = 0;
		while (iterator.hasNext()) {
			Faction next = iterator.next();
			if (next.getName().equalsIgnoreCase(spesificFaction)) {
				next.addDeputy();
			} else {
				i++;
			}
		}
		if (i == facList.size()) {
			System.err.println("Такої фракції немає у Верховній раді");
		}
	}

//видалити депутата(вводимо з консолі)
	@SuppressWarnings("resource")
	public void removeDeputyFromFaction() {
		System.out.println(
				"Введіть назву фракції,з якої потрібно видалити депутата");
		Scanner sc = new Scanner(System.in);
		Iterator<Faction> iterator = facList.iterator();
		String spesificFaction = sc.next().toUpperCase();
		int i = 0;
		while (iterator.hasNext()) {
			Faction next = iterator.next();
			if (next.getName().equalsIgnoreCase(spesificFaction)) {
				next.removeDeputy();
			} else {
				i++;
			}
		}
		if (i == facList.size()) {
			System.err.println("Такої фракції немає у Верховній раді");
		}
	}

//вивести всіх хабарників у фракції
	@SuppressWarnings("resource")
	public void getAllGrafters() {
		System.out.println("Введіть назву фракції, щоб дізнатися хто хабарник");
		Scanner sc = new Scanner(System.in);
		Iterator<Faction> iterator = facList.iterator();
		String spesificFaction = sc.next().toUpperCase();
		int i = 0;
		while (iterator.hasNext()) {
			Faction next = iterator.next();
			if (next.getName().equalsIgnoreCase(spesificFaction)) {
				next.getAllGrafters();
			} else {
				i++;
			}
		}
		if (i == facList.size()) {
			System.err.println("Такої фракції немає у Верховній раді");
		}
	}

//вивести найбільшого хабарника у фракції
	@SuppressWarnings("resource")
	public void getBiggestGrafter() {
		System.out.println(
				"Введіть назву фракції, щоб дізнатися хто найбільший хабарник");
		Scanner sc = new Scanner(System.in);
		Iterator<Faction> iterator = facList.iterator();
		String spesificFaction = sc.next().toUpperCase();
		int i = 0;
		while (iterator.hasNext()) {
			Faction next = iterator.next();
			if (next.getName().equalsIgnoreCase(spesificFaction)) {
				next.theBiggestGrafter();
			} else {
				i++;
			}
		}
		if (i == facList.size()) {
			System.err.println("Такої фракції немає у Верховній раді");
		}
	}

//вивести всіх депутатів фракції
	@SuppressWarnings("resource")
	public void getAllDeputies() {
		System.out.println(
				"Введіть назву фракції, щоб отримати список усіх депутатів");
		Scanner sc = new Scanner(System.in);
		Iterator<Faction> iterator = facList.iterator();
		String spesificFaction = sc.next().toUpperCase();
		int i = 0;
		while (iterator.hasNext()) {
			Faction next = iterator.next();
			if (next.getName().equalsIgnoreCase(spesificFaction)) {
				next.getDeputies();
			} else {
				i++;
			}
		}
		if (i == facList.size()) {
			System.err.println("Такої фракції немає у Верховній раді");
		}
	}

	@SuppressWarnings("resource")
	public void cleanFromDeputies() {
		System.out.println(
				"Введіть назву фракції, яку потрібно очистити від депутатів");
		Scanner sc = new Scanner(System.in);
		Iterator<Faction> iterator = facList.iterator();
		String spesificFaction = sc.next().toUpperCase();
		int i = 0;
		while (iterator.hasNext()) {
			Faction next = iterator.next();
			if (next.getName().equalsIgnoreCase(spesificFaction)) {
				next.removeAllFaction();
				System.out.println("Фракцію " + next.getName() + " очищено ");
			} else {
				i++;
			}
		}
		if (i == facList.size()) {
			System.err.println("Такої фракції немає у Верховній раді");
		}
	}

}// VerkhovnaRada
