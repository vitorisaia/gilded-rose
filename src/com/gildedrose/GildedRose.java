package com.gildedrose;

import com.gildedrose.handler.ItemHandler;
import com.gildedrose.handler.impl.AgedBrieHandler;
import com.gildedrose.handler.impl.BackstagePassesHandler;
import com.gildedrose.handler.impl.ConjuredHandler;
import com.gildedrose.handler.impl.RegularItemHandler;
import com.gildedrose.utility.ItemCare;

public class GildedRose {
	Item[] items;

	private ItemCare itemCare = ItemCare.getIntance();

	public GildedRose(final Item[] items) {
		this.items = items;
	}

	public void updateQuality() {
		for (int i = 0; i < this.items.length; i++) {
			Item item = this.items[i];

			if (this.itemCare.isSulfuras(item)) {
				// nothing to do here
				continue;
			}

			if (this.itemCare.isConjured(item)) {
				this.handleConjured(item);
				continue;
			}

			if (this.itemCare.isAgedBrie(item)) {
				this.handleAgedBrie(item);
				continue;
			}

			if (this.itemCare.isBackstagePasses(item)) {
				this.handleBackstagePasses(item);
				continue;
			}

			if (this.itemCare.isRegularItem(item)) {
				this.handleRegular(item);
				continue;
			}
		}
	}

	private void handleBackstagePasses(final Item item) {
		ItemHandler handler = new BackstagePassesHandler();
		handler.handleItem(item);
	}

	private void handleAgedBrie(final Item item) {
		ItemHandler handler = new AgedBrieHandler();
		handler.handleItem(item);
	}

	private void handleRegular(final Item item) {
		ItemHandler handler = new RegularItemHandler();
		handler.handleItem(item);
	}

	private void handleConjured(final Item item) {
		ItemHandler handler = new ConjuredHandler();
		handler.handleItem(item);
	}
}
