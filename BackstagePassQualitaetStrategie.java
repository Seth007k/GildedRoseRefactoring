package BackstagePassQualitaetStrategie;

import BasicItemQualitaetStrategie.BasicItemQualitaetStrategie;
import IQualitaetStrategie.IQualitaetStrategie;
import Item.Item;

public class BackstagePassQualitaetStrategie extends BasicItemQualitaetStrategie implements IQualitaetStrategie {
    int limitQuality = super.limitQuality; // Erbt von BasicItem

    @Override
    public void updateQuality(Item item) {
        increaseQualityAbout1IfLimitUnder50AndSellInOver11(item);
        increaseQualityAbout2IfLimitUnder50AndSellInBetween5And10ButQualityNotOver50(item);
        increaseQualityAbout3IfLimitUnder50AndSellInUnderOrEqual5(item);
        setQualityToZeroIfSellInEqualZero(item);

    }

    /**
     * mjhvjhvjh
     * @param item
     */
    private void increaseQualityAbout1IfLimitUnder50AndSellInOver11(Item item) {
        if (item.quality <= limitQuality && item.sellIn > 11) {
            item.quality += 1;
        }
    }

    private void increaseQualityAbout2IfLimitUnder50AndSellInBetween5And10ButQualityNotOver50(Item item) {
        int newQuality = item.quality + 2;
        if (item.sellIn <= 10 && item.sellIn > 5 && newQuality <= limitQuality) {
            item.quality = newQuality; // item.quality wird nur dann erhöht wenn newQuality unter 50 ist. bei 49 also bleibt 49 stehen
        }
    }

    private void increaseQualityAbout3IfLimitUnder50AndSellInUnderOrEqual5(Item item) { // newQuality auch standartverhalten in basic
        int newQuality = item.quality + 3;
        if (item.sellIn <= 5 && newQuality <= limitQuality) {
            item.quality = newQuality;
        }
    }

    private void setQualityToZeroIfSellInEqualZero(Item item) {
        if (item.sellIn == 0) {
            item.quality = 0;
        }
    }
}
