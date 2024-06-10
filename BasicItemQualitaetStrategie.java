package BasicItemQualitaetStrategie;
import IQualitaetStrategie.IQualitaetStrategie;
import Item.Item;
import SulfurasHandOfRagnarosStrategie.SulfurasHandOfRagnarosStrategie;

public class BasicItemQualitaetStrategie implements IQualitaetStrategie {

    protected int limitQuality = 50; // Wird an Kindklassen weitervererbt (protected: innerhalb Kindklassen private)
    public void update(Item item){
        this.updateSellIn(item);
        this.updateQuality(item);
    }
    @Override
    public void updateSellIn(Item item){
        item.sellIn--;
    }
    @Override
    public void updateQuality(Item item) {
        decreaseQualityAbout1IfLimitUnder50AndSellInOver0(item);
        decreaseQualityAbout2IfLimitOver0AndSellInUnderOrEqual0(item);
    }
    private void decreaseQualityAbout1IfLimitUnder50AndSellInOver0(Item item){
        if(item.quality <= limitQuality && item.sellIn > 0){
            item.quality--;
        }
    }
    private void decreaseQualityAbout2IfLimitOver0AndSellInUnderOrEqual0(Item item){
        if(item.sellIn <= 0 && item.quality > 0){
            item.quality -= 2;
        }
    }
    public boolean precludeItemQualityOver50(Item item){
        int newQuality = item.quality +2;
        return newQuality <= limitQuality;
    }

}
