import { Item, GildedRose } from '@/gilded-rose';

describe('Gilded Rose updateQuality', () => {
  it('Aged Brie quality should increase by 1', () => {
    const gildedRose = new GildedRose([new Item('Aged Brie', 23, 30)]);
    const items = gildedRose.updateQuality();
    expect(items[0].quality).toBe(31);
  });

  it('Quality should never go above 50', () => {
    const gildedRose = new GildedRose([new Item('Aged Brie', 23, 50)]);
    const items = gildedRose.updateQuality();
    expect(items[0].quality).toBe(50);
  });

  it('Backstage Passes quality should increase by 1 if sellIn > 10', () => {
    const gildedRose = new GildedRose([new Item('Backstage passes to Phoebe Bridgers', 13, 44)]);
    const items = gildedRose.updateQuality();
    expect(items[0].quality).toBe(45);
  });

  it('Backstage Passes quality should increase by 2 if sellIn <= 10', () => {
    const gildedRose = new GildedRose([new Item('Backstage passes to Coldplay', 10, 44)]);
    const items = gildedRose.updateQuality();
    expect(items[0].quality).toBe(46);
  });

  it('Backstage Passes quality should increase by 3 if sellIn <= 5', () => {
    const gildedRose = new GildedRose([new Item('Backstage passes to Green Day', 5, 44)]);
    const items = gildedRose.updateQuality();
    expect(items[0].quality).toBe(47);
  });
});

