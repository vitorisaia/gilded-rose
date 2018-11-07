package com.gildedrose.utility;

import com.gildedrose.Item;

public class ItemCare {

	private static final ItemCare instance = new ItemCare();

	private ItemCare() {
	};

	public static ItemCare getIntance() {
		return instance;
	}

	public void decreaseQuality(final Item item) {
		item.quality--;
	}

	public boolean sellDateHasPassed(final Item item) {
		return item.sellIn < 0;
	}

	public boolean isRegularItem(final Item item) {
		return !this.isAgedBrie(item) && !this.isSulfuras(item) && !this.isBackstagePasses(item)
				&& !this.isConjured(item);
	}

	public void handleQualityBySellDate(final Item item) {
		if (this.sellDateHasPassed(item)) {
			if (item.quality > 0)
				this.decreaseQuality(item);
		}
	}

	public boolean isBackstagePasses(final Item item) {
		return item.name.startsWith("Backstage passes");
	}

	public boolean isSulfuras(final Item item) {
		return item.name.startsWith("Sulfuras");
	}

	public boolean isAgedBrie(final Item item) {
		return item.name.startsWith("Aged Brie");
	}

	public boolean isConjured(final Item item) {
		return item.name.startsWith("Conjured ");
	}

	public void decreaseSellIn(final Item item) {
		item.sellIn--;
	}

	public boolean canIncreaseQuality(final Item item) {
		return item.quality < 50;
	}
}
