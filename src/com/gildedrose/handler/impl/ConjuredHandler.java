package com.gildedrose.handler.impl;

import com.gildedrose.Item;
import com.gildedrose.handler.ItemHandler;
import com.gildedrose.utility.ItemCare;

public class ConjuredHandler implements ItemHandler {

	@Override
	public void handleItem(final Item item) {
		this.handleConjured(item);
	}

	private void handleConjured(final Item item) {
		ItemCare itemCare = ItemCare.getIntance();

		itemCare.decreaseSellIn(item);

		if (item.quality > 0) {
			itemCare.decreaseQuality(item);

			if (item.quality > 0)
				itemCare.decreaseQuality(item); // decreasing for the second time

			itemCare.handleQualityBySellDate(item);
		}
	}
}
