package com.gildedrose

class GildedRose(var items: List<Item>) {

    fun updateQuality() {
        for (i in items.indices) {
            when(items[i].name) {
                "Aged Brie" -> agedBrie(items[i])
                "Backstage passes to a TAFKAL80ETC concert" -> backstagePasses(items[i])
                "Sulfuras, Hand of Ragnaros" -> continue
                else -> {
                    regularItem(items[i])
                }
            }
        }
    }

    fun regularItem(item: Item) {
        item.sellIn--
        if (item.sellIn < 0) {
            qualityMoreThan0(item)
        }
        qualityMoreThan0(item)
    }

    fun agedBrie(item: Item) {
        item.sellIn--
        if (item.sellIn < 0) {
            qualityLessThan50(item)
        }
        qualityLessThan50(item)
    }

    fun backstagePasses(item: Item) {
        item.sellIn--
        if(item.sellIn < 0) {
            item.quality = 0
            return
        }
        if(item.sellIn < 5) {
            qualityLessThan50(item)
        }
        if(item.sellIn < 10) {
            qualityLessThan50(item)
        }
        qualityLessThan50(item)
    }

    fun qualityLessThan50(item: Item) {
        if(item.quality < 50) {
            item.quality++
        }
    }

    fun qualityMoreThan0(item: Item) {
        if(item.quality > 0) {
            item.quality--
        }
    }

}

