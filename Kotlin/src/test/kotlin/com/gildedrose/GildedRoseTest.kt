package com.gildedrose

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class GildedRoseTest {

    @Test
    fun regularItemNotExpiredPositiveQuality() {
        val items = listOf(Item("foo", 2, 10))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(9, app.items[0].quality)
    }

    @Test
    fun regularItemExpiredPositiveQuality1() {
        val items = listOf(Item("foo", 0, 10))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(8, app.items[0].quality)
    }

    @Test
    fun regularItemExpiredPositiveQuality2() {
        val items = listOf(Item("foo", -1, 10))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(8, app.items[0].quality)
    }

    @Test
    fun regularItemNotExpiredZeroQuality() {
        val items = listOf(Item("foo", 5, 0))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(0, app.items[0].quality)
    }

    @Test
    fun regularItemExpiredZeroQuality1() {
        val items = listOf(Item("foo", 0, 0))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(0, app.items[0].quality)
    }

    @Test
    fun regularItemExpiredZeroQuality2() {
        val items = listOf(Item("foo", -1, 0))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(0, app.items[0].quality)
    }

    @Test
    fun agedBrieNotExpiredPositiveQuality() {
        val items = listOf(Item("Aged Brie", 5, 10))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(11, app.items[0].quality)
    }

    @Test
    fun agedBrieExpiredPositiveQuality1() {
        val items = listOf(Item("Aged Brie", 0, 10))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(12, app.items[0].quality)
    }

    @Test
    fun agedBrieExpiredPositiveQuality2() {
        val items = listOf(Item("Aged Brie", -1, 10))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(12, app.items[0].quality)
    }

    @Test
    fun agedBrieNotExpiredZeroQuality() {
        val items = listOf(Item("Aged Brie", 5, 0))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(1, app.items[0].quality)
    }

    @Test
    fun agedBrieExpiredZeroQuality1() {
        val items = listOf(Item("Aged Brie", 0, 0))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(2, app.items[0].quality)
    }

    @Test
    fun agedBrieExpiredZeroQuality2() {
        val items = listOf(Item("Aged Brie", -1, 0))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(2, app.items[0].quality)
    }

    @Test
    fun agedBrieNotExpiredFiftyQuality() {
        val items = listOf(Item("Aged Brie", 5, 50))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(50, app.items[0].quality)
    }

    @Test
    fun agedBrieExpiredFiftyQuality1() {
        val items = listOf(Item("Aged Brie", 0, 50))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(50, app.items[0].quality)
    }

    @Test
    fun agedBrieExpiredFiftyQuality2() {
        val items = listOf(Item("Aged Brie", -1, 50))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(50, app.items[0].quality)
    }

    @Test
    fun sulfuras() {
        val items = listOf(Item("Sulfuras, Hand of Ragnaros", 0, 80))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(80, app.items[0].quality)
    }

    @Test
    fun backstagePassesMoreThan10DaysPositiveQuality() {
        val items = listOf(Item("Backstage passes to a TAFKAL80ETC concert", 11, 20))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(21, app.items[0].quality)
    }

    @Test
    fun backstagePasses10DaysPositiveQuality() {
        val items = listOf(Item("Backstage passes to a TAFKAL80ETC concert", 10, 20))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(22, app.items[0].quality)
    }

    @Test
    fun backstagePasses5to10DaysPositiveQuality() {
        val items = listOf(Item("Backstage passes to a TAFKAL80ETC concert", 9, 20))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(22, app.items[0].quality)
    }

    @Test
    fun backstagePasses5DaysPositiveQuality() {
        val items = listOf(Item("Backstage passes to a TAFKAL80ETC concert", 5, 20))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(23, app.items[0].quality)
    }

    @Test
    fun backstagePassesLessThan5DaysPositiveQuality() {
        val items = listOf(Item("Backstage passes to a TAFKAL80ETC concert", 4, 20))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(23, app.items[0].quality)
    }

    @Test
    fun backstagePasses0DaysPositiveQuality() {
        val items = listOf(Item("Backstage passes to a TAFKAL80ETC concert", 0, 20))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(0, app.items[0].quality)
    }

    @Test
    fun backstagePassesNegativeDaysPositiveQuality() {
        val items = listOf(Item("Backstage passes to a TAFKAL80ETC concert", -1, 20))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(0, app.items[0].quality)
    }

    @Test
    fun backstagePassesMoreThan10Days0Quality() {
        val items = listOf(Item("Backstage passes to a TAFKAL80ETC concert", 11, 0))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(1, app.items[0].quality)
    }

    @Test
    fun backstagePasses10Days0Quality() {
        val items = listOf(Item("Backstage passes to a TAFKAL80ETC concert", 10, 0))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(2, app.items[0].quality)
    }

    @Test
    fun backstagePasses5to10Days0Quality() {
        val items = listOf(Item("Backstage passes to a TAFKAL80ETC concert", 9, 0))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(2, app.items[0].quality)
    }

    @Test
    fun backstagePasses5Days0Quality() {
        val items = listOf(Item("Backstage passes to a TAFKAL80ETC concert", 5, 0))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(3, app.items[0].quality)
    }

    @Test
    fun backstagePassesLessThan5Days0Quality() {
        val items = listOf(Item("Backstage passes to a TAFKAL80ETC concert", 4, 0))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(3, app.items[0].quality)
    }

    @Test
    fun backstagePasses0Days0Quality() {
        val items = listOf(Item("Backstage passes to a TAFKAL80ETC concert", 0, 0))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(0, app.items[0].quality)
    }

    @Test
    fun backstagePassesMoreThan10Days50Quality() {
        val items = listOf(Item("Backstage passes to a TAFKAL80ETC concert", 11, 50))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(50, app.items[0].quality)
    }

    @Test
    fun backstagePasses10Days50Quality() {
        val items = listOf(Item("Backstage passes to a TAFKAL80ETC concert", 10, 50))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(50, app.items[0].quality)
    }

    @Test
    fun backstagePasses5to10Days50Quality() {
        val items = listOf(Item("Backstage passes to a TAFKAL80ETC concert", 9, 50))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(50, app.items[0].quality)
    }

    @Test
    fun backstagePasses5Days50Quality() {
        val items = listOf(Item("Backstage passes to a TAFKAL80ETC concert", 5, 50))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(50, app.items[0].quality)
    }

    @Test
    fun backstagePassesLessThan5Days50Quality() {
        val items = listOf(Item("Backstage passes to a TAFKAL80ETC concert", 4, 50))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(50, app.items[0].quality)
    }

    @Test
    fun backstage0Days50Quality() {
        val items = listOf(Item("Backstage passes to a TAFKAL80ETC concert", 0, 50))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(0, app.items[0].quality)
    }

    @Test
    fun sellIn_regularItem1() {
        val items = listOf(Item("foo", 2, 10))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(1, app.items[0].sellIn)
    }

    @Test
    fun sellIn_regularItem2() {
        val items = listOf(Item("foo", 0, 10))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(-1, app.items[0].sellIn)
    }

    @Test
    fun sellIn_agedBrie1() {
        val items = listOf(Item("Aged Brie", 2, 10))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(1, app.items[0].sellIn)
    }

    @Test
    fun sellIn_agedBrie2() {
        val items = listOf(Item("Aged Brie", 0, 10))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(-1, app.items[0].sellIn)
    }

    @Test
    fun sellIn_sulfuras() {
        val items = listOf(Item("Sulfuras, Hand of Ragnaros", 2, 10))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(2, app.items[0].sellIn)
    }

    @Test
    fun sellIn_backstagePasses1() {
        val items = listOf(Item("Backstage passes to a TAFKAL80ETC concert", 2, 10))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(1, app.items[0].sellIn)
    }

    @Test
    fun sellIn_backstagePasses2() {
        val items = listOf(Item("Backstage passes to a TAFKAL80ETC concert", 0, 10))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(-1, app.items[0].sellIn)
    }
}


