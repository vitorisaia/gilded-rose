package com.gildedrose;

import com.gildedrose.handler.ItemHandlerFactory;

public class GildedRose {
	Item[] items;

	public GildedRose(final Item[] items) {
		this.items = items;
	}

	public void updateQuality() {
		for (int i = 0; i < this.items.length; i++) {
			Item item = this.items[i];
			ItemHandlerFactory.fetchHandlerFor(item).handleItem(item);
		}
	}
}
