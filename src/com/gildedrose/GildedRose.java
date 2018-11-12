package com.gildedrose;

import com.gildedrose.handler.GildedKernel;

public class GildedRose {
	Item[] items;

	public GildedRose(final Item[] items) {
		this.items = items;
	}

	public void updateQuality() {
		for (int i = 0; i < this.items.length; i++) {
			GildedKernel kernel = GildedKernel.getInstance();
			kernel.handleItem(this.items[i]);
		}
	}
}
