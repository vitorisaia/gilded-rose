package com.gildedrose;

public class GildedRose {
	Item[] items;

	public GildedRose(final Item[] items) {
		this.items = items;
	}

	public void updateQuality() {
		for (int i = 0; i < this.items.length; i++) {
			Item item = this.items[i];

			if (this.isSulfuras(item)) {
				// nothing to do here
				continue;
			}

			if (this.isConjured(item)) {
				this.handleConjured(item);
				continue;
			}

			if (this.isAgedBrie(item)) {
				this.handleAgedBrie(item);
				continue;
			}

			if (this.isBackstagePasses(item)) {
				this.handleBackstagePasses(item);
				continue;
			}

			if (this.isRegularItem(item)) {
				this.handleRegular(item);
				continue;
			}
		}
	}

	private void handleBackstagePasses(final Item item) {
		this.decreaseSellIn(item);

		// the concert is over
		if (this.sellDateHasPassed(item)) {
			item.quality = 0;
			return;
		}

		if (item.sellIn > 10) {
			if (this.canIncreaseQuality(item))
				item.quality++;
			return;
		}

		// quality increases by 2 when there are 10 days or less
		if (item.sellIn > 5 && item.sellIn <= 10) {
			if (this.canIncreaseQuality(item)) {
				item.quality += 2;
				return;
			}
		}

		// quality increases by 3 when there are 5 days or less
		if (item.sellIn <= 5) {
			if (this.canIncreaseQuality(item)) {
				item.quality += 3;
				return;
			}
		}
	}

	private void handleAgedBrie(final Item item) {
		this.decreaseSellIn(item);

		if (this.canIncreaseQuality(item))
			item.quality++;
	}

	private boolean canIncreaseQuality(final Item item) {
		return item.quality < 50;
	}

	private void handleRegular(final Item item) {
		this.decreaseSellIn(item);

		if (item.quality > 0) {
			this.decreaseQuality(item);

			this.handleQualityBySellDate(item);
		}
	}

	private void handleQualityBySellDate(final Item item) {
		if (this.sellDateHasPassed(item)) {
			if (item.quality > 0)
				this.decreaseQuality(item);
		}
	}

	private void handleConjured(final Item item) {
		this.decreaseSellIn(item);

		if (item.quality > 0) {
			this.decreaseQuality(item);

			if (item.quality > 0)
				this.decreaseQuality(item); // decreasing for the second time

			this.handleQualityBySellDate(item);
		}
	}

	private void decreaseQuality(final Item item) {
		item.quality--;
	}

	private boolean sellDateHasPassed(final Item item) {
		return item.sellIn < 0;
	}

	private boolean isRegularItem(final Item item) {
		return !this.isAgedBrie(item) && !this.isSulfuras(item) && !this.isBackstagePasses(item)
				&& !this.isConjured(item);
	}

	private boolean isBackstagePasses(final Item item) {
		return item.name.startsWith("Backstage passes");
	}

	private boolean isSulfuras(final Item item) {
		return item.name.startsWith("Sulfuras");
	}

	private boolean isAgedBrie(final Item item) {
		return item.name.startsWith("Aged Brie");
	}

	private boolean isConjured(final Item item) {
		return item.name.startsWith("Conjured ");
	}

	private void decreaseSellIn(final Item item) {
		item.sellIn--;
	}
}
