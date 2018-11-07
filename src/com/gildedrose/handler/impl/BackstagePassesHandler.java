package com.gildedrose.handler.impl;

import com.gildedrose.Item;
import com.gildedrose.handler.ItemHandler;
import com.gildedrose.utility.ItemCare;

public class BackstagePassesHandler implements ItemHandler {

	@Override
	public void handleItem(final Item item) {
		this.handleBackstagePasses(item);
	}

	private void handleBackstagePasses(final Item item) {
		ItemCare itemCare = ItemCare.getIntance();

		itemCare.decreaseSellIn(item);

		// the concert is over
		if (itemCare.sellDateHasPassed(item)) {
			item.quality = 0;
			return;
		}

		if (item.sellIn > 10) {
			if (itemCare.canIncreaseQuality(item))
				item.quality++;
			return;
		}

		// quality increases by 2 when there are 10 days or less
		if (item.sellIn > 5 && item.sellIn <= 10) {
			if (itemCare.canIncreaseQuality(item)) {
				item.quality += 2;
				return;
			}
		}

		// quality increases by 3 when there are 5 days or less
		if (item.sellIn <= 5) {
			if (itemCare.canIncreaseQuality(item)) {
				item.quality += 3;
				return;
			}
		}
	}
}
