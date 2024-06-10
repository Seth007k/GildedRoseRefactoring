package ConjuredItemQualitaetStrategie;
import BasicItemQualitaetStrategie.BasicItemQualitaetStrategie;
import IQualitaetStrategie.IQualitaetStrategie;
import Item.Item;

public class ConjuredItemQualitaetStrategie extends BasicItemQualitaetStrategie implements IQualitaetStrategie {

    int limitQuality = super.limitQuality; //Erbt von BasicItem
    @Override
    public void updateQuality(Item item) {
        decreaseQualityAbout2IfQualityUnder50AndSellInOver0(item);
        decreaseQualityAbout4IfQualityOver0AndSellInUnderOrEqual0(item);
    }

    private void decreaseQualityAbout2IfQualityUnder50AndSellInOver0(Item item){
        if(item.quality <= limitQuality && item.sellIn > 0){
            item.quality -= 2;
        }
    }

    private void decreaseQualityAbout4IfQualityOver0AndSellInUnderOrEqual0(Item item){
        if(item.sellIn <= 0 && item.quality > 0){
            item.quality -= 4;
        }
    }


}
