package GildedRose;
import AgedBrieQualitaetStrategie.AgedBrieQualitaetStrategie;
import BackstagePassQualitaetStrategie.BackstagePassQualitaetStrategie;
import BasicItemQualitaetStrategie.BasicItemQualitaetStrategie;
import ConjuredItemQualitaetStrategie.ConjuredItemQualitaetStrategie;
import IQualitaetStrategie.IQualitaetStrategie;
import Item.Item;
import SulfurasHandOfRagnarosStrategie.SulfurasHandOfRagnarosStrategie;

public class GildedRose{
    Item[] items;

    private static final String AGED_BRIE = "Aged Brie";
    private static final String BACKSTAGEPASS = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";
    private static final String CONJURED_ITEM = "Conjured Item";
    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality(Item[] items) {                                           //Methode iteriert durch Item Array und prüft welche Strategie für welches Item angewendet werden muss.
        for (Item item : items) {
            IQualitaetStrategie strategy = getItemStrategie(item);
            strategy.update(item);                                               //Hier wird die Qualität geupdatet.
        }
    }
    public static IQualitaetStrategie getItemStrategie(Item item){
        switch(item.name){
            case AGED_BRIE:
                return new AgedBrieQualitaetStrategie();
            case BACKSTAGEPASS:
                return new BackstagePassQualitaetStrategie();
            case SULFURAS_HAND_OF_RAGNAROS:
                return new SulfurasHandOfRagnarosStrategie();
            case CONJURED_ITEM:
                return new ConjuredItemQualitaetStrategie();
            default:
                return new BasicItemQualitaetStrategie();
        }
    }

}






