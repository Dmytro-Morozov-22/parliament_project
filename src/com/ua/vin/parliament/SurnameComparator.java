package com.ua.vin.parliament;

import java.util.Comparator;

public class SurnameComparator implements Comparator<Deputy> {

	@Override
	public int compare(Deputy o1, Deputy o2) {
		return o1.getSurname().compareTo(o2.getSurname());
	}

}
