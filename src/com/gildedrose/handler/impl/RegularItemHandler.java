package com.gildedrose.handler.impl;

import com.gildedrose.Item;
import com.gildedrose.handler.ItemHandler;
import com.gildedrose.utility.ItemCare;

public class RegularItemHandler implements ItemHandler {

	@Override
	public void handleItem(final Item item) {
		this.handleRegular(item);
	}

	private void handleRegular(final Item item) {
		ItemCare itemCare = ItemCare.getIntance();

		itemCare.decreaseSellIn(item);

		if (item.quality > 0) {
			itemCare.decreaseQuality(item);

			itemCare.handleQualityBySellDate(item);
		}
	}

}
