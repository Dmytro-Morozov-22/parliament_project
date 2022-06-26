package com.ua.vin.parliament;

import java.util.Comparator;

public class BribeSizeComparator implements Comparator <Deputy>{

	@Override
	public int compare(Deputy o1, Deputy o2) {
		return o1.getBribeSize() > o2.getBribeSize() ? 1 : -1;
	}

}
