package com.gildedrose;

class GildedRose {

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            updateItemQuality(items[i]);
        }
    }

    private void updateItemQuality(Item item) {
        if ("Aged Brie".equals(item.name)) {
            updateAgedBrie(item);
        } else if ("Sulfuras, Hand of Ragnaros".equals(item.name)) {
            updateSulfuras(item);
        } else if ("Backstage passes to a TAFKAL80ETC concert".equals(item.name)) {
            updateBackstagePasses(item);
        } else if ("Conjured".equals(item.name)){
            updateConjured(item);
        } else {
            updateNormal(item);
        }
    }

    private void updateNormal(Item item) {
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }
        item.sellIn = item.sellIn - 1;
        if (item.sellIn < 0&& item.quality > 0) {
            item.quality = item.quality - 1;
        }
    }

    private void updateConjured(Item item) {
        if (item.quality > 0) {
            item.quality = Integer.max(item.quality - 2,0);
        }
        item.sellIn = item.sellIn - 1;
        if (item.sellIn < 0&& item.quality > 0) {
            item.quality = Integer.max(item.quality - 2,0);
        }
    }

    private void updateBackstagePasses(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
            if (item.sellIn < 11 && item.quality < 50) {
                item.quality = item.quality + 1;
            }
            if (item.sellIn < 6 && item.quality < 50) {
                item.quality = item.quality + 1;
            }
        }
        item.sellIn = item.sellIn - 1;
        if (item.sellIn < 0) {
            item.quality = 0;
        }
    }

    private void updateSulfuras(Item item){

    }

    private void updateAgedBrie(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
        item.sellIn = item.sellIn - 1;
        if (item.sellIn < 0 && item.quality < 50) {
            item.quality = item.quality + 1;
        }
    }
}
