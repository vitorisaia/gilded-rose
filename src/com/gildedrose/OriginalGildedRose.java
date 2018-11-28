package com.gildedrose;

class OriginalGildedRose {
	Item[] items;

	public OriginalGildedRose(final Item[] items) {
		this.items = items;
	}

	// remove noise
	// remove duplicate calls

	public void updateQuality() {
		for (int i = 0; i < this.items.length; i++) {
			this.updateQuality(this.items[i]);
		}
	}

	private void updateQuality(final Item item) {

		// HANDLING QUALITY BY TYPE
		if (this.doesntGetBetter(item)) {
			if (item.quality > 0) {
				if (!this.isSulfuras(item)) {
					this.decreaseQuality(item);
				}
			}
		} else {
			if (item.quality < 50) {
				this.handleQuality(item);
			}
		}

		// HANDLING SELLIN
		if (!this.isSulfuras(item)) {
			this.decreaseSellIn(item);
		}

		// HANDLING QUALITY BY SELLIN
		if (item.sellIn < 0) {
			if (!this.isBrie(item)) {
				if (!this.isBackstage(item)) {
					if (item.quality > 0) {
						if (!this.isSulfuras(item)) {
							this.decreaseQuality(item);
						}
					}
				} else {
					item.quality = item.quality - item.quality;
				}
			} else {
				if (item.quality < 50) {
					this.increaseQuality(item);
				}
			}
		}
	}

	private boolean isBrie(final Item item) {
		return item.name.equals("Aged Brie");
	}

	private boolean isBackstage(final Item item) {
		return item.name.equals("Backstage passes to a TAFKAL80ETC concert");
	}

	private boolean isSulfuras(final Item item) {
		return item.name.equals("Sulfuras, Hand of Ragnaros");
	}

	private void handleQuality(final Item item) {
		this.increaseQuality(item);

		if (this.isBackstage(item)) {
			this.handleBackstageQuality(item);
		}
	}

	private void handleBackstageQuality(final Item item) {
		if (item.sellIn < 11) {
			if (item.quality < 50) {
				this.increaseQuality(item);
			}
		}

		if (item.sellIn < 6) {
			if (item.quality < 50) {
				this.increaseQuality(item);
			}
		}
	}

	private boolean doesntGetBetter(final Item item) {
		return !this.isBrie(item) && !this.isBackstage(item);
	}

	private void decreaseSellIn(final Item item) {
		item.sellIn = item.sellIn - 1;
	}

	private void increaseQuality(final Item item) {
		item.quality = item.quality + 1;
	}

	private void decreaseQuality(final Item item) {
		item.quality = item.quality - 1;
	}
}