package AgedBrieQualitaetStrategie;
import BasicItemQualitaetStrategie.BasicItemQualitaetStrategie;
import IQualitaetStrategie.IQualitaetStrategie;
import Item.Item;


public class AgedBrieQualitaetStrategie extends BasicItemQualitaetStrategie implements IQualitaetStrategie {

    @Override
    public void updateQuality(Item item) {
        increaseQualityAbout1IfLimitUnder50(item);
    }
    private void increaseQualityAbout1IfLimitUnder50(Item item){
        if(item.quality < super.limitQuality){ //super.limitQuality erbt von BasicItem und wird hier deklariert da nur einmal hier benötigt
            item.quality++;
        }
    }
}

