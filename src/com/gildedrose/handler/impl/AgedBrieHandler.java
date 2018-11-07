package com.gildedrose.handler.impl;

import com.gildedrose.Item;
import com.gildedrose.handler.ItemHandler;
import com.gildedrose.utility.ItemCare;

public class AgedBrieHandler implements ItemHandler {

	@Override
	public void handleItem(final Item item) {
		this.handleAgedBrie(item);
	}

	private void handleAgedBrie(final Item item) {
		ItemCare itemCare = ItemCare.getIntance();

		itemCare.decreaseSellIn(item);

		if (itemCare.canIncreaseQuality(item))
			item.quality++;
	}

}
