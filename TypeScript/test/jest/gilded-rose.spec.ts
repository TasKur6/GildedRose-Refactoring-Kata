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

  it('Backstage Passes quality should increase', () => {
    const gildedRose = new GildedRose([new Item('Aged Brie', 13, 44)]);
    const items = gildedRose.updateQuality();
    expect(items[0].quality).toBeGreaterThan(44);
  });
});

