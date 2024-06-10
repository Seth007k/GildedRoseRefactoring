package SulfurasHandOfRagnarosStrategie;
import BasicItemQualitaetStrategie.BasicItemQualitaetStrategie;
import IQualitaetStrategie.IQualitaetStrategie;
import Item.Item;

public class SulfurasHandOfRagnarosStrategie extends BasicItemQualitaetStrategie implements IQualitaetStrategie {

    @Override
    public void update(Item item) {
        //Wird weder schlecht noch verkauft
    }

}
