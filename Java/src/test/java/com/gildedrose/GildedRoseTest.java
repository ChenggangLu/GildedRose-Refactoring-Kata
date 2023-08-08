package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void updateNormalItem() {
        Item[] items = new Item[]{new Item("normal", 5, 10), new Item("normal", 0, 10)};

        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(9, app.items[0].quality);
        assertEquals(8, app.items[1].quality);
    }

    @Test
    void updateNormalItemWhenQualityDecreaseToZero() {
        Item[] items = new Item[]{new Item("normal", 5, 0), new Item("normal", 0, 1)};

        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(0, app.items[0].quality);
        assertEquals(0, app.items[1].quality);
    }

    @Test
    void updateAgedBrie() {
        Item[] items = new Item[]{new Item("Aged Brie", 5, 10), new Item("Aged Brie", 0, 10)};

        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(11, app.items[0].quality);
        assertEquals(12, app.items[1].quality);
    }

    @Test
    void updateAgedBrieWhenIncreaseToFifty() {
        Item[] items = new Item[]{new Item("Aged Brie", 5, 50), new Item("Aged Brie", 0, 49)};

        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(50, app.items[0].quality);
        assertEquals(50, app.items[1].quality);
    }

    @Test
    void updateSulfuras() {
        Item[] items =
            new Item[]{new Item("Sulfuras, Hand of Ragnaros", 5, 80), new Item("Sulfuras, Hand of Ragnaros", 0, 80)};

        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(80, app.items[0].quality);
        assertEquals(80, app.items[1].quality);
    }

    @Test
    void updateBackstagePasses() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 15, 10),
            new Item("Backstage passes to a TAFKAL80ETC concert", 10, 10),
            new Item("Backstage passes to a TAFKAL80ETC concert", 5, 10)};

        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(11, app.items[0].quality);
        assertEquals(12, app.items[1].quality);
        assertEquals(13, app.items[2].quality);
    }

    @Test
    void updateBackstagePassesWhenIncreaseToFifty() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 15, 50),
            new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
            new Item("Backstage passes to a TAFKAL80ETC concert", 5, 48)};

        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(50, app.items[0].quality);
        assertEquals(50, app.items[1].quality);
        assertEquals(50, app.items[2].quality);
    }

    @Test
    void updateBackstagePassesWhenExpired() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 0, 10)};

        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(0, app.items[0].quality);
    }

    @Test
    void updateConjured() {
        Item[] items = new Item[]{new Item("Conjured", 5, 10),new Item("Conjured", 0, 10)};

        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(8, app.items[0].quality);
        assertEquals(6, app.items[1].quality);
    }

    @Test
    void updateConjuredWhenDecreaseToZero() {
        Item[] items = new Item[]{new Item("Conjured", 5, 1),new Item("Conjured", 0, 3)};

        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(0, app.items[0].quality);
        assertEquals(0, app.items[1].quality);
    }

}
