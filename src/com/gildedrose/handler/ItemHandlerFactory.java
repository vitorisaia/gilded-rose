package com.gildedrose.handler;

import com.gildedrose.Item;
import com.gildedrose.handler.impl.AgedBrieHandler;
import com.gildedrose.handler.impl.BackstagePassesHandler;
import com.gildedrose.handler.impl.ConjuredHandler;
import com.gildedrose.handler.impl.RegularItemHandler;
import com.gildedrose.utility.ItemCare;

public class ItemHandlerFactory {

	public static ItemHandler fetchHandlerFor(final Item item) {
		ItemCare itemCare = ItemCare.getIntance();

		if (itemCare.isConjured(item)) {
			return new ConjuredHandler();
		}

		if (itemCare.isAgedBrie(item)) {
			return new AgedBrieHandler();
		}

		if (itemCare.isBackstagePasses(item)) {
			return new BackstagePassesHandler();
		}

		if (itemCare.isRegularItem(item)) {
			return new RegularItemHandler();
		}

		return new ItemHandler() {
			@Override
			public void handleItem(final Item item) {
				// this will handle Sulfuras
			}
		};
	}

}
