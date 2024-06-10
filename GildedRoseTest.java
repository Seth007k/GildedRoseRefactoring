package GildedRose;
import AgedBrieQualitaetStrategie.AgedBrieQualitaetStrategie;
import BackstagePassQualitaetStrategie.BackstagePassQualitaetStrategie;
import BasicItemQualitaetStrategie.BasicItemQualitaetStrategie;
import ConjuredItemQualitaetStrategie.ConjuredItemQualitaetStrategie;
import Item.Item;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


class GildedRoseTest {

    @Test
    void testUpdateQualityWithCorrectStrategy() {

        Item agedBrie         = new Item("Aged Brie",10,30);
        Item knorrigerStab    = new Item("Knorriger Stab",5,40);
        Item kaputterDolch    = new Item("Kaputter Dolch",0,30);
        Item backstagePass    = new Item("Backstage passes to a TAFKAL80ETC concert",5,15);
        Item backstagePassTwo = new Item("Backstage passes to a TAFKAL80ETC concert",0,20);
        Item conjuredKelch    = new Item("Beschworener Kelch",10,50);
        Item conjuredBuch     = new Item("Beschworenes Buch", 0,50);

        AgedBrieQualitaetStrategie agedStrategy              = new AgedBrieQualitaetStrategie();
        BasicItemQualitaetStrategie basicStategy             = new BasicItemQualitaetStrategie();
        BasicItemQualitaetStrategie basicStategy1            = new BasicItemQualitaetStrategie();
        BackstagePassQualitaetStrategie backstageStrategy    = new BackstagePassQualitaetStrategie();
        BackstagePassQualitaetStrategie backstageStrategyTwo = new BackstagePassQualitaetStrategie();
        ConjuredItemQualitaetStrategie conjuredStrategyKelch = new ConjuredItemQualitaetStrategie();
        ConjuredItemQualitaetStrategie conjuredStrategyBuch  = new ConjuredItemQualitaetStrategie();


        agedStrategy.updateQuality(agedBrie);
        basicStategy.updateQuality(knorrigerStab);
        basicStategy1.updateQuality(kaputterDolch);
        backstageStrategy.updateQuality(backstagePass);
        backstageStrategyTwo.updateQuality(backstagePassTwo);
        conjuredStrategyKelch.updateQuality(conjuredKelch);
        conjuredStrategyBuch.updateQuality(conjuredBuch);


        assertEquals(31, agedBrie.quality);
        assertEquals(39, knorrigerStab.quality);
        assertEquals(28, kaputterDolch.quality);
        assertEquals(18, backstagePass.quality);
        assertEquals(48, conjuredKelch.quality);
        assertEquals(46, conjuredBuch.quality);
        assertEquals(0 ,  backstagePassTwo.quality);

    }

    @Test
    void testUpdateQualityWithSellInReductionForAllStrategys(){
        Item agedBrie         = new Item("Aged Brie",10,30);
        Item knorrigerStab    = new Item("Knorriger Stab",5,40);
        Item kaputterDolch    = new Item("Kaputter Dolch",2,30);
        Item backstagePass    = new Item("Backstage passes to a TAFKAL80ETC concert",5,15);
        Item backstagePassTwo = new Item("Backstage passes to a TAFKAL80ETC concert",4,20);
        Item conjuredKelch    = new Item("Beschworener Kelch",11,50);
        Item conjuredBuch     = new Item("Beschworenes Buch", 3,50);

        AgedBrieQualitaetStrategie agedStrategy              = new AgedBrieQualitaetStrategie();
        BasicItemQualitaetStrategie basicStategy             = new BasicItemQualitaetStrategie();
        BasicItemQualitaetStrategie basicStategy1            = new BasicItemQualitaetStrategie();
        BackstagePassQualitaetStrategie backstageStrategy    = new BackstagePassQualitaetStrategie();
        BackstagePassQualitaetStrategie backstageStrategyTwo = new BackstagePassQualitaetStrategie();
        ConjuredItemQualitaetStrategie conjuredStrategyKelch = new ConjuredItemQualitaetStrategie();
        ConjuredItemQualitaetStrategie conjuredStrategyBuch  = new ConjuredItemQualitaetStrategie();

        agedStrategy.updateQuality(agedBrie);
        basicStategy.updateQuality(knorrigerStab);
        basicStategy1.updateQuality(kaputterDolch);
        backstageStrategy.updateQuality(backstagePass);
        backstageStrategyTwo.updateQuality(backstagePassTwo);
        conjuredStrategyKelch.updateQuality(conjuredKelch);
        conjuredStrategyBuch.updateQuality(conjuredBuch);

        assertEquals(9, agedBrie.sellIn);
        assertEquals(4, knorrigerStab.sellIn);
        assertEquals(1, kaputterDolch.sellIn);
        assertEquals(4, backstagePass.sellIn);
        assertEquals(3,  backstagePassTwo.sellIn);
        assertEquals(10, conjuredKelch.sellIn);
        assertEquals(2, conjuredBuch.sellIn);

    }





    @Test
    void testIncreaseQualityAbout1IfLimitUnder50(){ //Methode gibts nur in AgedBrie
        Item agedBrie  = new Item("Aged Brie",10,49);
        Item agedBrie2 = new Item("Aged Brie",10,35);
        Item agedBrie3 = new Item("Aged Brie",10,12);
        //GIVEN
            //ItemArray = [agedBrie, agedbrie2, agedbrie3]
        //WHEN
        //    gildedrose.updatedquality(ItemArray)

        //THEN
        //  itemarray[0]    is type of AgedBrieItem
        // itemarray[0].quality expect 50


        assertEquals(50,agedBrie.quality);
        assertEquals(36,agedBrie2.quality);
        assertEquals(13,agedBrie3.quality);
    }



    @Test
    void testGetCorrectItemStrategie() {
        Item agedBrie = new Item("Aged Brie",3,44);
        Item basicItem = new Item("Dolch",10,7);
        Item backstagePassItem = new Item("Backstage passes to a TAFKAL80ETC concert",15,30);
        Item conjuredItem = new Item("Conjured Item", 20,30);

        GildedRose.getItemStrategie(agedBrie);
        GildedRose.getItemStrategie(basicItem);
        GildedRose.getItemStrategie(backstagePassItem);
        GildedRose.getItemStrategie(conjuredItem);

        assertEquals("Aged Brie", agedBrie.name);
        assertEquals("Dolch", basicItem.name);
        assertEquals("Backstage passes to a TAFKAL80ETC concert", backstagePassItem.name);
        assertEquals("Conjured Item", conjuredItem.name);

    }
    /*
     @Test
    void testIncreaseQualityAbout1IfLimitUnder50AndSellInOver11(){ //Methode gibts nur in Backstage
        Item backstage  = new Item("Backstage passes to a TAFKAL80ETC concert",13,30);
        Item backstage2 = new Item("Backstage passes to a TAFKAL80ETC concert2",20,44);
        Item backstage3 = new Item("Backstage passes to a TAFKAL80ETC concert3",25,49);

        BackstagePassQualitaetStrategie backstageStrategy = new BackstagePassQualitaetStrategie();

        backstageStrategy.increaseQualityAbout1IfLimitUnder50AndSellInOver11(backstage);
        backstageStrategy.increaseQualityAbout1IfLimitUnder50AndSellInOver11(backstage2);
        backstageStrategy.increaseQualityAbout1IfLimitUnder50AndSellInOver11(backstage3);

        assertEquals(31, backstage.quality);
        assertEquals(45, backstage2.quality);
        assertEquals(50, backstage3.quality);

    }

    @Test
    void testIncreaseQualityAbout2IfLimitUnder50AndSellInBetween5And10(){ //Methode gibts nur in Backstage
        Item backstage  = new Item("Backstage passes to a TAFKAL80ETC concert",6,37);
        Item backstage2 = new Item("Backstage passes to a TAFKAL80ETC concert",7,5);
        Item backstage3 = new Item("Backstage passes to a TAFKAL80ETC concert",10,14);

        BackstagePassQualitaetStrategie backstrategy = new BackstagePassQualitaetStrategie();

        backstrategy.increaseQualityAbout2IfLimitUnder50AndSellInBetween5And10(backstage);
        backstrategy.increaseQualityAbout2IfLimitUnder50AndSellInBetween5And10(backstage2);
        backstrategy.increaseQualityAbout2IfLimitUnder50AndSellInBetween5And10(backstage3);

        assertEquals(39, backstage.quality);
        assertEquals(7, backstage2.quality);
        assertEquals(16, backstage3.quality);

    }

    @Test
    void testIncreaseQualityAbout3IfLimitUnder50AndSellInUnderOrEqual5(){ //Methode gibts nur in Backstage
        Item backstage  = new Item("Backstage passes to a TAFKAL80ETC concert",5,47);
        Item backstage2 = new Item("Backstage passes to a TAFKAL80ETC concert",4,29);
        Item backstage3 = new Item("Backstage passes to a TAFKAL80ETC concert",2,6);

        BackstagePassQualitaetStrategie backstrategy = new BackstagePassQualitaetStrategie();

        backstrategy.increaseQualityAbout3IfLimitUnder50AndSellInUnderOrEqual5(backstage);
        backstrategy.increaseQualityAbout3IfLimitUnder50AndSellInUnderOrEqual5(backstage2);
        backstrategy.increaseQualityAbout3IfLimitUnder50AndSellInUnderOrEqual5(backstage3);

        assertEquals(50, backstage.quality);
        assertEquals(32, backstage2.quality);
        assertEquals(9, backstage3.quality);
    }

    @Test
    void testSetQualityToZeroIfSellInEqualZero(){ //Methode gibts nur bei Backstage
        Item backstage  = new Item("Backstage passes to a TAFKAL80ETC concert",0,47);
        Item backstage2 = new Item("Backstage passes to a TAFKAL80ETC concert2",0,29);
        Item backstage3 = new Item("Backstage passes to a TAFKAL80ETC concert3",0,6);

        BackstagePassQualitaetStrategie backstageStrategy = new BackstagePassQualitaetStrategie();

        backstageStrategy.setQualityToZeroIfSellInEqualZero(backstage);
        backstageStrategy.setQualityToZeroIfSellInEqualZero(backstage2);
        backstageStrategy.setQualityToZeroIfSellInEqualZero(backstage3);

        assertEquals(0, backstage.quality);
        assertEquals(0, backstage2.quality);
        assertEquals(0, backstage3.quality);
    }

    @Test
    void testDecreaseQualityAbout2IfQualityUnder50AndSellInOver0(){ //Methode gibts nur in Conjured
        Item conjured  = new Item("Conjured Item",6,48);
        Item conjured2 = new Item("Conjured Item2",1,33);
        Item conjured3 = new Item("Conjured Item3",100,22);


        ConjuredItemQualitaetStrategie conjuredStrategy = new ConjuredItemQualitaetStrategie();

        conjuredStrategy.decreaseQualityAbout2IfQualityUnder50AndSellInOver0(conjured);
        conjuredStrategy.decreaseQualityAbout2IfQualityUnder50AndSellInOver0(conjured2);
        conjuredStrategy.decreaseQualityAbout2IfQualityUnder50AndSellInOver0(conjured3);

        assertEquals(46, conjured.quality);
        assertEquals(31, conjured2.quality);
        assertEquals(20, conjured3.quality);
    }
/*
    @Test
    void testDecreaseQualityAbout4IfQualityOver0AndSellInUnderOrEqual0(){ //Methode gibts nur in Conjured
        Item conjured  = new Item("Conjured Item",0,48);
        Item conjured2 = new Item("Conjured Item2",-500,33);
        Item conjured3 = new Item("Conjured Item3",-2,22);

        ConjuredItemQualitaetStrategie conjuredStrategy = new ConjuredItemQualitaetStrategie();

        conjuredStrategy.decreaseQualityAbout4IfQualityOver0AndSellInUnderOrEqual0(conjured);
        conjuredStrategy.decreaseQualityAbout4IfQualityOver0AndSellInUnderOrEqual0(conjured2);
        conjuredStrategy.decreaseQualityAbout4IfQualityOver0AndSellInUnderOrEqual0(conjured3);

        assertEquals(44, conjured.quality);
        assertEquals(29, conjured2.quality);
        assertEquals(18, conjured3.quality);
    }*//*
    @Test
    void testDecreaseQualityAbout1IfLimitUnder50AndSellInOver0(){    //Methode gibts nur in Basic
        Item basicItem  = new Item("Normaler Gegenstand",2,40);
        Item basicItem2 = new Item("Normaler Gegenstand2",5,20);
        Item basicItem3 = new Item("Normaler Gegenstand3",7,15);

        BasicItemQualitaetStrategie basicStrategy  = new BasicItemQualitaetStrategie();

        basicStrategy.decreaseQualityAbout1IfLimitUnder50AndSellInOver0(basicItem);
        basicStrategy.decreaseQualityAbout1IfLimitUnder50AndSellInOver0(basicItem2);
        basicStrategy.decreaseQualityAbout1IfLimitUnder50AndSellInOver0(basicItem3);


        assertEquals(39,basicItem.quality);
        assertEquals(19,basicItem2.quality);
        assertEquals(14,basicItem3.quality);

    }

    @Test
    void testDecreaseQualityAbout2IfLimitOver0AndSellInUnderOrEqual0(){   //Methode gibts nur in Basic
        Item basicItem  = new Item("Normaler Gegenstand",0,2);
        Item basicItem2 = new Item("Normaler Gegenstand2",0,10);
        Item basicItem3 = new Item("Normaler Gegenstand3",0,40);

        BasicItemQualitaetStrategie basicStrategy  = new BasicItemQualitaetStrategie();

        basicStrategy.decreaseQualityAbout2IfLimitOver0AndSellInUnderOrEqual0(basicItem);
        basicStrategy.decreaseQualityAbout2IfLimitOver0AndSellInUnderOrEqual0(basicItem2);
        basicStrategy.decreaseQualityAbout2IfLimitOver0AndSellInUnderOrEqual0(basicItem3);


        assertEquals(0,basicItem.quality);
        assertEquals(8,basicItem2.quality);
        assertEquals(38,basicItem3.quality);
    }*//*

     @Test
    void testDecreaseSellInAbout1IfItemIsntSulfurasForAllStrategys(){

        Item isntSulfurasAgedBrie = new Item("Nicht Sulfuras",7,30);
        Item isSulfurasAgedBrie   = new Item("Sulfuras, Hand of Ragnaros",0,80);

        Item isntSulfurasBackstage = new Item("Nicht Sulfuras",7,30);
        Item isSulfurasBackstage   = new Item("Sulfuras, Hand of Ragnaros",0,80);

        Item isntSulfurasBasic = new Item("Nicht Sulfuras",7,30);
        Item isSulfurasBasic   = new Item("Sulfuras, Hand of Ragnaros",0,80);

        Item isntSulfurasConjured = new Item("Nicht Sulfuras",7,30);
        Item isSulfurasConjured   = new Item("Sulfuras, Hand of Ragnaros",0,80);


        AgedBrieQualitaetStrategie.decreaseSellInAbout1IfItemIsntSulfuras(isntSulfurasAgedBrie);
        AgedBrieQualitaetStrategie.decreaseSellInAbout1IfItemIsntSulfuras(isSulfurasAgedBrie);

        BackstagePassQualitaetStrategie.decreaseSellInAbout1IfItemIsntSulfuras(isntSulfurasBackstage);
        BackstagePassQualitaetStrategie.decreaseSellInAbout1IfItemIsntSulfuras(isSulfurasBackstage);

        BasicItemQualitaetStrategie.decreaseSellInAbout1IfItemIsntSulfuras(isntSulfurasBasic);
        BasicItemQualitaetStrategie.decreaseSellInAbout1IfItemIsntSulfuras(isSulfurasBasic);

        ConjuredItemQualitaetStrategie.decreaseSellInAbout1IfItemIsntSulfuras(isntSulfurasConjured);
        ConjuredItemQualitaetStrategie.decreaseSellInAbout1IfItemIsntSulfuras(isSulfurasConjured);

        assertEquals(6, isntSulfurasAgedBrie.sellIn);
        assertEquals(0, isSulfurasAgedBrie.sellIn);

        assertEquals(6, isntSulfurasBackstage.sellIn);
        assertEquals(0, isSulfurasBackstage.sellIn);

        assertEquals(6, isntSulfurasBasic.sellIn);
        assertEquals(0, isSulfurasBasic.sellIn);

        assertEquals(6, isntSulfurasConjured.sellIn);
        assertEquals(0, isSulfurasConjured.sellIn);
    }
*/
}