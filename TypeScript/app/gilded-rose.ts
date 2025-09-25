export class Item {
  name: string;
  sellIn: number;
  quality: number;

  constructor(name, sellIn, quality) {
    this.name = name;
    this.sellIn = sellIn;
    this.quality = quality;
  }
}

export class GildedRose {
  items: Array<Item>;

  constructor(items = [] as Array<Item>) {
    this.items = items;
  }

  updateQuality() {
    for (const currentItem of this.items) {
      if (currentItem.name === 'Aged Brie' || currentItem.name.startsWith('Backstage pass')) {
        currentItem.quality++;
        if (currentItem.name.startsWith('Backstage pass')) {
          if (currentItem.sellIn <= 10) {
            currentItem.quality += currentItem.sellIn <= 5 ? 2 : 1;
          }
        }
      } else {
        if (currentItem.quality > 0) {
          if (currentItem.name != 'Sulfuras, Hand of Ragnaros') {
            currentItem.quality = currentItem.quality - 1;
          }
        }
      }
      if (currentItem.name != 'Sulfuras, Hand of Ragnaros') {
        currentItem.sellIn = currentItem.sellIn - 1;
      }
      if (currentItem.sellIn < 0) {
        if (currentItem.name != 'Aged Brie') {
          if (!currentItem.name.startsWith('Backstage pass')) {
            if (currentItem.quality > 0) {
              if (currentItem.name != 'Sulfuras, Hand of Ragnaros') {
                currentItem.quality = currentItem.quality - 1;
              }
            }
          } else {
            currentItem.quality = currentItem.quality - currentItem.quality
          }
        } else {
          if (currentItem.quality < 50) {
            currentItem.quality = currentItem.quality + 1;
          }
        }
      }

      if (currentItem.name !== 'Sulfuras, Hand of Ragnaros') {
        currentItem.quality = Math.min(currentItem.quality, 50);
      }
    };

    return this.items;
  }
}
