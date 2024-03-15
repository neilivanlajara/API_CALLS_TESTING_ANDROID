package com.example.api_calls_testing_android.ui.dashboard;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.api_calls_testing_android.model.Artwork;
import com.example.api_calls_testing_android.model.DepartmentInfo;
import com.example.api_calls_testing_android.repository.GetArtworkRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class DashboardViewModel extends AndroidViewModel {
    AtomicInteger indexArtworkToExtractFromArray= new AtomicInteger(0);

    Map<Integer, Integer> MapToCheckArtworkDuplicate = new HashMap<>();

    private final MutableLiveData<List<Artwork>> artworkList = new MutableLiveData<>(new ArrayList<>());

    public DashboardViewModel(@NonNull Application application) {
        super(application);
        feedArtworkBuffer();
    }

    public void removeArtwork(Artwork artworkToRemove) {
        List<Artwork> currentList = artworkList.getValue();
        if (currentList != null) {
            currentList.remove(artworkToRemove);
            artworkList.setValue(currentList);
        }
    }



    //bravo ivan
    public void removeCurrentListArtwork(){

        int index = artworkList.getValue().size()-1;
        while(index >= 0 ){
            removeArtwork(artworkList.getValue().get(0));
            index--;
        }

    }

    public void feedArtworkByQuery(List<Integer> searchQuery){
        int index = 0;
        removeCurrentListArtwork();
        if(searchQuery.size()>10){
            searchQuery = searchQuery.subList(0, 10);
        }

        for (int i = 0 ; i < searchQuery.size();i++) {

            indexArtworkToExtractFromArray.set(index);
            index++;
            GetArtworkRepository.getObject(
                    searchQuery.get(indexArtworkToExtractFromArray.get()),
                    artwork->{

                        if (!MapToCheckArtworkDuplicate.containsKey(indexArtworkToExtractFromArray.get())) {
                            //se è vuoto
                            try {
                                Log.d("please", artwork.getConstituents().get(0).getName() + "" + artwork.getPrimaryImageSmall().length() + " " + artwork.getPrimaryImageSmall() + "" + artwork.getTitle() + "" + "feedArtworkBuffer:  " + indexArtworkToExtractFromArray.get() + "<->" + artwork.getObjectID() + "<->" + artwork.isHighLight() + "<->" + artwork.getPrimaryImageSmall() + " " + artwork.getPeriod());

                                    Objects.requireNonNull(artworkList.getValue()).add(artwork);
                                    artworkList.setValue(artworkList.getValue());




                            } catch (NullPointerException e) {
                                Log.d("please", "feedArtworkBuffer: devo rifare la chiamata perché ci sono dei dati mancanti nel artwork e verebbe visualizzata male");
                            }
                        }else{
                            MapToCheckArtworkDuplicate.put(indexArtworkToExtractFromArray.get(),  MapToCheckArtworkDuplicate.getOrDefault(indexArtworkToExtractFromArray.get(), 0) + 1);
                        }



                    },
                    ()->{
                        Log.d("errors", "feedArtworkBuffer: error ");
                    }
            );

        }

    }



    public void feedArtworkBuffer(){
        removeCurrentListArtwork();

        List<Artwork> temp = new ArrayList<>();

        AtomicBoolean shouldContinue = new AtomicBoolean(true);

        Object lock = new Object();  // Oggetto di blocco per la sincronizzazione

        int indexArtworkToExtractFromArray = 0;

        Integer[] bestPaintings = {435641,436573,437609,436323,437891,255275,4438605,436658,436918,437423,437869,591855,436106,436105,436792,437056,435802,679844,438815,634108,436575,436603,437532,436838,435621,435809,488486,487695,488978,669451,436944,436545,459119,459107,435962,488732,451270,437654,435702,493210,459007,500194,435882,437658,437127,436095,489307,437053,435908,459052,437344,436579,436947,436504,701989,436121,435739,440723,435888,458994,437835,437133,436101,437926,459088,485901,458978,438820,436002,459087,435984,459142,459082,459016,437097,437261,437490,438817,626692,459093,459123,459080,492697,459092,438816,437131,437430,437397,459136,749639,458967,435896,435817,437394,40055,436532,436622,458977,438818,815112,437881,676458,435876,500488,37971,436528,435826,459139,436253,458961,458971,817303,459131,437153,440393,437675,436535,435839,437790,785431,769369,459090,437749,459106,459084,438822,489513,436839,435868,459083,437299,505722,489972,488496,459182,438112,436516,438821,436896,437160,459072,436819,489625,458956,490184,441769,827660,250945,436966,437372,282883,470600,459174,487065,20517,470308,437283,482605,436892,459045,816458,436282,435600,14930,11116,11130,12828,544326,10080,11981,13065,10813,19261,11227,459055,16687,13171,11050,11834,10497,11605,544776,543937,11122,10482,13052,11145,11133,10388,12822,10159,544320,11619,11734,10819,694642,14472,20888,486818,10557,20768,11396,10786,821931,10554,10186,11263,10425,10175,10207,10127,21126,10501,10393,20129,11287,11764,10811,17897,11417,11269,11207,12842,11311,10464,10746,13315,707486,14931,16947,5223,10946,764087,10154,11088,10586,11325,12674,813585,16584,635401,11307,13211,13184,698529,813594,10469,12670,677910,13223,765285,11080,12477,10527,10391,195456,13345,13346,13344,768547,834263,719486,13070,19303,11804,10049,11737,12140,10481,10830,752047,12052,10827,13124,18354,10997,13758,11160,10065,10978,10499,459144,488315,483000,459161,459028,459027,744549,459110,489403,489674,544501,459112,459086,812918,486014,471904,437854,490225,437487,655833,486316,485308,754093,702950,435844,459062,490004,488221,655815,489977,484522,438417,436037,489994,484524,459159,488915,459061,488694,486308,488750,75274,725889,482740,485934,543903,38228,199674,764095,78188,78190,682118,544720,696866,544453,13471,458998,544319,544702,9317,544060,544853,548343,544056,490036,547951,764091,247017,37801,42716,766640,712182,544039,724721,631985,65576,752049,489409,459046,544752,193344,451373,7874,476711,202996,486996,494826,548338,472387,459246,544683,451804,470603,543899,543901,548212,1815,543864,548344,544740,544524,464607,327830,209063,205485,547257,544210,545281,451490,830038,74448,21303,205526,470304,843659,471061,39666,78197,830024,465991,37557,72589,662163,662161,446860,470311,466580,544450,448671,483560,470312,11797,470310,61429,488916,469857,786826,499568,484216,484362,490064,310652,451909,37450,469856,471884,503517,473047,473008,503940,469866,469887,451717,451715,453576,37800,38330,444897,747199,466084,12600,716497,459037,459038,467594,38039,770850,10531,786261,19294,11707,15026,494509,12127,45428,19346,834269,489321,12702,20893,11055,10465,10522,12602,39901,37813,37966,478211,74906,14521,10956,20414,37788,38021,11040,78189,485302,37802,78195,75909,502040,254649,503043,38038,472155,469959,463795,544214,665918,17139,714877,768411,455082,464156,544919,470313,473007,501788,830041,708024,21209,48948,78187,503625,313240,291951,485416,39883,39881,817408,459249,37942,40447,37962,39887,39936,39889,50360,499559,36029,64893,44696,37799,653727,39888,40081,49156,37854,39668,65584,38011,38006,59669,37886,4591,548264,448938,36457,37789,464596,326243,310454,453312,72419,202115,311290,78193,324917,39915,327066,311183,455304,11234,475513,209104,311651,459248,452037,503271,481545,37947,309868,311294,314366,314370,313830,453054,312119,313313,313780,311237,317735,311171,319233,44987,448294,335663,44918,452102,744940,755777,465966,464483,313546,309959,13751,493597,451995,311950,50897,19763,36451,253370,501767,446595,817398,44858,769306,452160,5505,36131,747794,206499,488364,500396,629418,446892,502761,22876,451444,455059,452112,452111,547802,24907,717563,459190,503678,447086,459189,454011,453683,910099,451286,446560,446567,454013,248499,250951,500782,334002,334650,488043,452845,447572,11757,889323,22634,81132,359882,247964,503939,681349,446563,333813,910038,267838,464142,453317,451405,4285,717564,76114,454015,5630,337498,483438,335240,910066,39189,38379,38583,910055,254896,337702,470309,459254,251935,14932,492332,267363,591826,10818,267757,910031,317618,459188,841614,459192,266332,816148,204804,910072,459244,503503,3395,19037,503442,910009,202192,253566,501492,788171,459210,446562,231667,271885,909678,896183,484650,910041,337172,486837,2046,449154,544782,251050,249222,448183,12544,459245,751516,337699,79778,816628,447510,742937,267842,189164,591837,333990,459191,37145,354644,755524,37558,282,25111,820841,896212,446642,208816,700610,229993,910011,910102,339751,785466,785496,202718,38518,50799,896188,253349,459239,910035,337494,337491,267175,283236,459243,283626,266855,337489,459208,459185,11907,19356,11897,10983,701086,591836,591862,459183,11268,19256,281940,889319,81141,459205,495553,19255,459195,910016,38127,910003,448647,492826,193632,470315,10409,11380,503932,547775,256548,191259,38341,11375,12075,1083,12138,751515,751510,751508,751513,751509,665501,892625,820215,359362,839174,459213,910018,13390,717547,466045,459236,591858,20621,459240,334245,271890,267717,486989,336162,24693,459235,591846,271963,282039,459241,282757,266859,337490,444378,336489,889914,910067,910049,910052,910028,470306,337499,196439,484870,79893,591861,336327,492566,449457,910064,10571,13245,3158,544690,544227,20498,889916,669209,545113,736324,910054,254843,678732,760941,38926,466070,200668,50356,481891,490007,910017,909985,459253,19745,466182,591848,96434,265904,267087,266102,888556,337894,503505,286725,267010,267193,283277,266850,488551,447071,838205,205250,459242,313386,237,354631,83605,11985,459207,16761,13115,267019,326655,889938,503046,459211,822464,337496,310073,39918,309861,505399,490215,352328,337497,503613,471975,206976,820544,591824,497522,492777,910015,284086,503530,503818,74425,463188,501762,312180,451802,13878,490222,45432,11388,12774,204533,467746,254923,199737,201895,888594,20615,318345,265563,11760,446285,12004,309428,751995,191803,199708,192716,312460,202614,310364,337075,13907,327497,325562,309427,488755,451402,310870,39738,313256,312781,459186,11096,13755,12078,459251,459206,451092,547900,247020,824771,488326,324687,324695,547689,485518,450409,39707,17716,313629,12953,16577,693134,447000,444607,469960,317823,444812,317793,65397,337844,336046,40524,451400,255154,788081,194432,453053,453243,236688,312602,488452,451042,252451,248902,252948,256846,337625,760942,266262,477499,17053,42301,42308,72307,50444,436173,446011,337088,81558,198715,207032,446297,452100,250551,251532,464377,466198,466191,39496,40528,488601,323178,331619,247916,469858,255949,202141,206990,450509,253351,488342,451332,337500,201862,314299,448282,446999,236643,219394,254587,22275,253348,229770,333915,464125,310542,337105,486757,255973,252973,468346,39730,248904,468233,468106,472507,23939,470305,467730,37614,453227};

        for (int i = 0; i < 10 && shouldContinue.get(); i++) {
            int currentIndex = indexArtworkToExtractFromArray;  // Cattura l'indice corrente in una variabile locale


            synchronized (lock) {
                if (!shouldContinue.get()) {
                    break;  // Se shouldContinue è false, esci dal loop
                }
            }
            GetArtworkRepository.getObject(
                    bestPaintings[new Random().nextInt(bestPaintings.length)],
                    artwork -> {
                        if (!MapToCheckArtworkDuplicate.containsKey(currentIndex)) {
                            try {
                                Log.d("dai mado!", artwork.getConstituents().get(0).getName() + " " + artwork.getPrimaryImageSmall().length() + " " + artwork.getPrimaryImageSmall() + " " + artwork.getTitle() + " " + "feedArtworkBuffer:  " + currentIndex + "<->" + artwork.getObjectID() + "<->" + artwork.isHighLight() + "<->" + artwork.getPrimaryImageSmall() + " " + artwork.getPeriod());
                                if (artwork.getPrimaryImageSmall().length() > 0) {
                                    Objects.requireNonNull(artworkList.getValue()).add(artwork);
                                    artworkList.setValue(artworkList.getValue());
                                }

                                if (artworkList.getValue().size() >= 5) {
                                    shouldContinue.set(false);  // Imposta la variabile di controllo per terminare il loop
                                }
                            } catch (NullPointerException e) {
                                Log.d("dai mado!", "feedArtworkBuffer: devo rifare la chiamata perché ci sono dei dati mancanti nel artwork e verrebbe visualizzata male");
                            } finally {

                            }
                        } else {
                            MapToCheckArtworkDuplicate.put(currentIndex, MapToCheckArtworkDuplicate.getOrDefault(currentIndex, 0) + 1);
                        }
                    },
                    () -> {
                        Log.d("errors", "feedArtworkBuffer: error ");
                    }
            );

            Log.d("feedArtworkBuffer", "feedArtworkBuffer: " + artworkList.getValue().size());

            // Incrementa in modo atomico l'indice
            indexArtworkToExtractFromArray++;
        }




    }





    public MutableLiveData<List<Artwork>> getArtworkList (){

        return this.artworkList;
    }


}
