package com.gildedrose.handler;

import com.gildedrose.Item;

public class GildedKernel {

	private static final GildedKernel instance = new GildedKernel();

	private GildedKernel() {

	}

	public void handleItem(final Item item) {
		ItemHandler handler = ItemHandlerFactory.fetchHandlerFor(item);
		handler.handleItem(item);
	}

	public static GildedKernel getInstance() {
		return instance;
	}

}
