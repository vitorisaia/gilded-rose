package com.gildedrose;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class OriginalGildedRoseTest {

	@Test
	/**
	 * "Aged Brie" actually increases in Quality the older it gets. The Quality of
	 * an item is never more than 50.
	 */
	public void agedBrie() {
		Item[] items = new Item[] { new Item("Aged Brie", 7, 47) };
		OriginalGildedRose app = new OriginalGildedRose(items);

		assertEquals(7, items[0].sellIn);
		assertEquals(47, items[0].quality);

		app.updateQuality();
		assertEquals(6, items[0].sellIn);
		assertEquals(48, items[0].quality);

		app.updateQuality();
		assertEquals(5, items[0].sellIn);
		assertEquals(49, items[0].quality);

		app.updateQuality();
		assertEquals(4, items[0].sellIn);
		assertEquals(50, items[0].quality);

		app.updateQuality();
		assertEquals(3, items[0].sellIn);
		assertEquals(50, items[0].quality);

		app.updateQuality();
		assertEquals(2, items[0].sellIn);
		assertEquals(50, items[0].quality);

		app.updateQuality();
		assertEquals(1, items[0].sellIn);
		assertEquals(50, items[0].quality);

		app.updateQuality();
		assertEquals(0, items[0].sellIn);
		assertEquals(50, items[0].quality);

		app.updateQuality();
		assertEquals(-1, items[0].sellIn);
		assertEquals(50, items[0].quality);
	}

	// @Test
	/**
	 * - "Conjured" items degrade in Quality twice as fast as normal items
	 */
	public void conjured() {
		Item[] items = new Item[] { new Item("Conjured DREAM THEATER SHIRT OF THE NEW ALBUUUM", 2, 7) };
		OriginalGildedRose app = new OriginalGildedRose(items);

		assertEquals(2, items[0].sellIn);
		assertEquals(7, items[0].quality);

		app.updateQuality();

		assertEquals(1, items[0].sellIn);
		assertEquals(5, items[0].quality);

		app.updateQuality();

		assertEquals(0, items[0].sellIn);
		assertEquals(3, items[0].quality);

		app.updateQuality();

		assertEquals(-1, items[0].sellIn);
		assertEquals(0, items[0].quality);
	}

	@Test
	/**
	 * - "Backstage passes", like aged brie, increases in Quality as its SellIn
	 * value approaches; Quality increases by 2 when there are 10 days or less and
	 * by 3 when there are 5 days or less but Quality drops to 0 after the concert
	 */
	public void backstagePasses() {
		Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 12, 20) };
		OriginalGildedRose app = new OriginalGildedRose(items);

		assertEquals(12, items[0].sellIn);
		assertEquals(20, items[0].quality);

		app.updateQuality();

		assertEquals(11, items[0].sellIn);
		assertEquals(21, items[0].quality);

		app.updateQuality();

		assertEquals(10, items[0].sellIn);
		assertEquals(22, items[0].quality);

		app.updateQuality();

		assertEquals(9, items[0].sellIn);
		assertEquals(24, items[0].quality);

		app.updateQuality();

		assertEquals(8, items[0].sellIn);
		assertEquals(26, items[0].quality);

		app.updateQuality();

		assertEquals(7, items[0].sellIn);
		assertEquals(28, items[0].quality);

		app.updateQuality();

		assertEquals(6, items[0].sellIn);
		assertEquals(30, items[0].quality);

		app.updateQuality();

		assertEquals(5, items[0].sellIn);
		assertEquals(32, items[0].quality);

		app.updateQuality();

		assertEquals(4, items[0].sellIn);
		assertEquals(35, items[0].quality);

		app.updateQuality();

		assertEquals(3, items[0].sellIn);
		assertEquals(38, items[0].quality);

		app.updateQuality();

		assertEquals(2, items[0].sellIn);
		assertEquals(41, items[0].quality);

		app.updateQuality();

		assertEquals(1, items[0].sellIn);
		assertEquals(44, items[0].quality);

		app.updateQuality();

		assertEquals(0, items[0].sellIn);
		assertEquals(47, items[0].quality);

		app.updateQuality();

		assertEquals(-1, items[0].sellIn);
		assertEquals(0, items[0].quality);
	}

	@Test
	/**
	 * - "Sulfuras", being a legendary item, never has to be sold or decreases in
	 * Quality
	 */
	public void sulfuras() {
		Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 0, 80) };
		OriginalGildedRose app = new OriginalGildedRose(items);

		assertEquals(0, items[0].sellIn);
		assertEquals(80, items[0].quality);

		for (int i = 0; i < 360; i++) {
			app.updateQuality();
		}

		assertEquals(0, items[0].sellIn);
		assertEquals(80, items[0].quality);
	}

	@Test
	/**
	 * - Once the sell by date has passed, Quality degrades twice as fast
	 */
	public void regular() {
		Item[] items = new Item[] { new Item("Milk chocolate bar", 2, 7) };
		OriginalGildedRose app = new OriginalGildedRose(items);

		assertEquals(2, items[0].sellIn);
		assertEquals(7, items[0].quality);

		app.updateQuality();

		assertEquals(1, items[0].sellIn);
		assertEquals(6, items[0].quality);

		app.updateQuality();

		assertEquals(0, items[0].sellIn);
		assertEquals(5, items[0].quality);

		app.updateQuality();

		assertEquals(-1, items[0].sellIn);
		assertEquals(3, items[0].quality);

		app.updateQuality();

		assertEquals(-2, items[0].sellIn);
		assertEquals(1, items[0].quality);

		app.updateQuality();

		assertEquals(-3, items[0].sellIn);
		assertEquals(0, items[0].quality);

		app.updateQuality();

		assertEquals(-4, items[0].sellIn);
		assertEquals(0, items[0].quality);

		app.updateQuality();

		assertEquals(-5, items[0].sellIn);
		assertEquals(0, items[0].quality);

		app.updateQuality();

		assertEquals(-6, items[0].sellIn);
		assertEquals(0, items[0].quality);
	}

	@Test
	public void oneCaseOfEachOne() {
		Item[] items = new Item[] { new Item("+5 Dexterity Vest", 10, 20), new Item("Aged Brie", 2, 0),
				new Item("Elixir of the Mongoose", 5, 7), new Item("Sulfuras, Hand of Ragnaros", 0, 80),
				new Item("Sulfuras, Hand of Ragnaros", -1, 80),
				new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20), new Item("Conjured Mana Cake", 3, 6) };
		OriginalGildedRose app = new OriginalGildedRose(items);

		assertEquals(10, items[0].sellIn);
		assertEquals(20, items[0].quality);
		assertEquals(2, items[1].sellIn);
		assertEquals(0, items[1].quality);
		assertEquals(5, items[2].sellIn);
		assertEquals(7, items[2].quality);
		assertEquals(0, items[3].sellIn);
		assertEquals(80, items[3].quality);
		assertEquals(-1, items[4].sellIn);
		assertEquals(80, items[4].quality);
		assertEquals(15, items[5].sellIn);
		assertEquals(20, items[5].quality);
		assertEquals(3, items[6].sellIn);
		assertEquals(6, items[6].quality);

		app.updateQuality();

		assertEquals(9, items[0].sellIn);
		assertEquals(19, items[0].quality);
		assertEquals(1, items[1].sellIn);
		assertEquals(1, items[1].quality);
		assertEquals(4, items[2].sellIn);
		assertEquals(6, items[2].quality);
		assertEquals(0, items[3].sellIn);
		assertEquals(80, items[3].quality);
		assertEquals(-1, items[4].sellIn);
		assertEquals(80, items[4].quality);
		assertEquals(14, items[5].sellIn);
		assertEquals(21, items[5].quality);
		assertEquals(2, items[6].sellIn);
		assertEquals(5, items[6].quality);
	}

	@Test
	public void oneCaseOfEachOneReloaded() {
		Item[] items = new Item[] { new Item("+5 Dexterity Vest", 10, 20), new Item("Aged Brie", 2, 0),
				new Item("Elixir of the Mongoose", 5, 7), new Item("Sulfuras, Hand of Ragnaros", 0, 80),
				new Item("Sulfuras, Hand of Ragnaros", -1, 80),
				new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20), new Item("Conjured Mana Cake", 3, 6) };

		OriginalGildedRose app = new OriginalGildedRose(items);

		assertEquals(10, items[0].sellIn);
		assertEquals(20, items[0].quality);
		assertEquals(2, items[1].sellIn);
		assertEquals(0, items[1].quality);
		assertEquals(5, items[2].sellIn);
		assertEquals(7, items[2].quality);
		assertEquals(0, items[3].sellIn);
		assertEquals(80, items[3].quality);
		assertEquals(-1, items[4].sellIn);
		assertEquals(80, items[4].quality);
		assertEquals(15, items[5].sellIn);
		assertEquals(20, items[5].quality);
		assertEquals(3, items[6].sellIn);
		assertEquals(6, items[6].quality);

		app.updateQuality();

		assertEquals(9, items[0].sellIn);
		assertEquals(19, items[0].quality);
		assertEquals(1, items[1].sellIn);
		assertEquals(1, items[1].quality);
		assertEquals(4, items[2].sellIn);
		assertEquals(6, items[2].quality);
		assertEquals(0, items[3].sellIn);
		assertEquals(80, items[3].quality);
		assertEquals(-1, items[4].sellIn);
		assertEquals(80, items[4].quality);
		assertEquals(14, items[5].sellIn);
		assertEquals(21, items[5].quality);
		assertEquals(2, items[6].sellIn);
		// assertEquals("CONJURED FAILED", 4, items[6].quality);
	}

	@Test
	public void onlySpecifc() {
		Item[] items = new Item[] { new Item("+5 Dexterity Vest", 1, 30), new Item("Mana Cake", 1, 25) };

		OriginalGildedRose app = new OriginalGildedRose(items);

		assertEquals(1, items[0].sellIn);
		assertEquals(30, items[0].quality);
		assertEquals(1, items[1].sellIn);
		assertEquals(25, items[1].quality);

		app.updateQuality();

		assertEquals(0, items[0].sellIn);
		assertEquals(29, items[0].quality);
		assertEquals(0, items[1].sellIn);
		assertEquals(24, items[1].quality);

		app.updateQuality();

		assertEquals(-1, items[0].sellIn);
		assertEquals(27, items[0].quality);
		assertEquals(-1, items[1].sellIn);
		assertEquals(22, items[1].quality);

		app.updateQuality();

		assertEquals(-2, items[0].sellIn);
		assertEquals(25, items[0].quality);
		assertEquals(-2, items[1].sellIn);
		assertEquals(20, items[1].quality);
	}

}
