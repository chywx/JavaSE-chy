package cn.year2022.assets;

import com.alibaba.fastjson.JSONObject;
import java.util.Set;

public class AssetsType {

    private final static String assets = "{\"tree\":{\"3D asset\":{\"building\":{\"balcony\":{},\"beam\":{},\"combined\":{},\"door\":{},\"pillar\":{},\"railing\":{},\"relief\":{},\"roof\":{},\"roof tile\":{},\"stair\":{},\"trim\":{},\"wall\":{},\"window\":{}},\"food\":{\"baked goods\":{},\"fruit\":{},\"meat\":{},\"mushroom\":{},\"nut\":{},\"vegetable\":{}},\"historical\":{\"cambodian ruins\":{},\"feudal japan\":{\"floor\":{},\"gravestone\":{},\"ornament\":{},\"pillar\":{},\"railing\":{},\"stairs\":{},\"statue\":{},\"stone\":{}},\"medieval\":{\"bench\":{},\"floor\":{},\"forge\":{},\"gate\":{},\"house\":{},\"ornament\":{},\"palisade\":{},\"pillar\":{},\"piscine\":{},\"props\":{},\"ruins\":{},\"stairs\":{},\"stone\":{},\"storage\":{},\"wall\":{},\"weapon\":{}},\"roman empire\":{\"coin\":{},\"floor\":{},\"gravestone\":{},\"ornament\":{},\"pillar\":{},\"plinth\":{},\"statue\":{},\"trim\":{}},\"wild west\":{\"crate\":{},\"farm\":{},\"fence\":{},\"furniture\":{},\"gravestone\":{},\"props\":{},\"storage\":{},\"stove\":{},\"wheel\":{}}},\"industrial\":{\"construction\":{\"brick\":{},\"debris\":{},\"demolished\":{},\"pallet\":{},\"rubble\":{}},\"hardware\":{\"accessories\":{},\"chain\":{},\"electrical\":{},\"nuts and bolts\":{},\"piping\":{},\"tools\":{}},\"mining\":{},\"railway\":{},\"storage\":{\"barrel\":{},\"cable reel\":{},\"canister\":{},\"tank\":{}}},\"interior\":{\"ceiling\":{},\"decoration\":{\"bowl\":{},\"candle holder\":{},\"kitchenware\":{},\"ornament\":{},\"picture frame\":{},\"pitcher\":{},\"plant pot\":{},\"statuette\":{},\"storage\":{},\"tableware\":{},\"vase\":{}},\"door\":{},\"fireplace\":{},\"furniture\":{\"seating\":{},\"table\":{}},\"railing\":{},\"stair\":{},\"wall\":{},\"window\":{}},\"nature\":{\"bone\":{},\"debris\":{},\"embankment\":{\"mossy\":{},\"root\":{},\"snow\":{}},\"mushroom\":{},\"rock\":{\"beach\":{},\"boulder\":{},\"cliff\":{},\"gemstone\":{},\"granite\":{},\"mossy\":{},\"quarry\":{},\"sandstone\":{},\"scatter\":{},\"volcanic\":{}},\"seabed\":{},\"snow\":{},\"tree\":{\"branch\":{},\"debris\":{},\"fallen\":{},\"log\":{},\"root\":{},\"stump\":{},\"trunk\":{}}},\"props\":{\"books\":{},\"farm\":{},\"firewood\":{},\"hardware\":{\"accessories\":{},\"chain\":{},\"electrical\":{},\"nuts and bolts\":{},\"piping\":{},\"tool\":{}},\"military\":{\"barrier\":{},\"container\":{},\"storage\":{}},\"palisade\":{},\"recreational\":{\"cigar\":{},\"sporting goods\":{},\"stationery items\":{},\"toy\":{}},\"storage\":{\"barrel\":{},\"box\":{},\"bucket\":{},\"canister\":{},\"crate\":{}},\"trash\":{},\"weaponry\":{},\"wheel\":{},\"wood\":{}},\"street\":{\"barrier\":{},\"bollard\":{},\"curb\":{},\"highway\":{},\"props\":{},\"sidewalk\":{},\"traffic cone\":{}}},\"3D plant\":{\"garden plant\":{\"bush\":{},\"flowering\":{},\"flowerless\":{}},\"aquatic\":{\"floating\":{},\"shore\":{},\"submerged\":{}},\"grass\":{\"lawn\":{},\"wild\":{}},\"climber\":{},\"flowering plant\":{\"flowerhead\":{},\"infloresence\":{}},\"shrub\":{\"forest\":{},\"meadow\":{},\"sandy\":{},\"urban\":{}},\"fern\":{},\"weed\":{\"forest\":{},\"meadow\":{},\"urban\":{}},\"ground cover\":{},\"herb\":{},\"crop\":{\"grass\":{},\"plant\":{}},\"houseplant\":{\"flowering\":{},\"flowerless\":{}},\"succulent\":{}},\"atlas\":{\"plant\":{\"branch\":{},\"flower\":{},\"leaf\":{},\"stem\":{}},\"grass\":{\"dried\":{},\"lawn\":{},\"wild\":{}},\"tree\":{\"bark\":{},\"branch\":{},\"flower\":{},\"leaf\":{},\"needle\":{},\"stem\":{},\"twig\":{}},\"moss\":{},\"debris\":{\"burnt\":{},\"nature\":{},\"other\":{},\"paper\":{},\"scrap\":{},\"trash\":{},\"wood\":{}},\"ocean\":{},\"other\":{\"assorted plant\":{},\"belt\":{},\"creature\":{},\"edible\":{},\"metal\":{},\"painting\":{},\"various\":{}},\"shrub\":{\"branch\":{},\"flower\":{},\"leaf\":{},\"needle\":{},\"stem\":{},\"twig\":{}},\"fresh water\":{},\"vine\":{\"branch\":{},\"flower\":{},\"leaf\":{},\"stem\":{}},\"herb\":{\"branch\":{},\"leaf\":{},\"stem\":{},\"twig\":{}},\"fern\":{},\"weed\":{}},\"decal\":{\"wood\":{\"board\":{},\"other\":{},\"plank\":{}},\"debris\":{\"ash\":{},\"burnt\":{},\"construction\":{},\"dirt\":{},\"mulch\":{},\"other\":{},\"paper\":{},\"stone\":{},\"tile\":{},\"trash\":{},\"wood\":{}},\"other\":{\"belt\":{},\"creature\":{},\"edible\":{},\"rock\":{},\"snow\":{},\"table mat\":{},\"various\":{}},\"leakage\":{\"stamp\":{},\"tileable\":{}},\"street\":{\"manhole cover\":{},\"other\":{},\"painted line\":{},\"patch\":{},\"pothole\":{},\"sidewalk\":{},\"stain\":{}},\"tree\":{\"bark\":{},\"branch\":{},\"log\":{}},\"metal\":{\"manhole cover\":{},\"other\":{},\"scrap\":{},\"sheet\":{},\"welding seam\":{}},\"concrete\":{\"crack\":{},\"damage\":{},\"other\":{},\"patch\":{}},\"stone\":{\"antique\":{},\"debris\":{},\"mosaic\":{},\"other\":{},\"trim\":{}},\"fabric\":{\"rag\":{},\"rug\":{}},\"blood\":{\"spatter\":{},\"stain\":{}},\"moss\":{\"patch\":{},\"spanish\":{}},\"vegetation\":{\"dried\":{},\"flower\":{},\"grass\":{},\"hay\":{},\"jungle\":{},\"leaf\":{},\"other\":{},\"twig\":{},\"vine\":{},\"weed\":{}},\"door\":{\"metal\":{},\"wood\":{}},\"trim\":{\"floor\":{},\"wall\":{}},\"commercial\":{\"poster\":{},\"sticker\":{}},\"graffiti\":{},\"mud\":{}},\"displacement\":{},\"imperfection\":{\"metal\":{\"clean\":{},\"scratched\":{}},\"leakage\":{},\"wipe mark\":{},\"fingerprint\":{},\"grunge\":{},\"other\":{},\"rubber\":{},\"grain\":{},\"stone\":{},\"stain\":{},\"dirt\":{},\"damage\":{},\"frost\":{}},\"surface\":{\"metal\":{\"bare\":{},\"corroded\":{},\"corrugated\":{},\"gun\":{},\"painted\":{},\"sheet\":{},\"treated\":{}},\"wood\":{\"board\":{},\"log\":{},\"other\":{},\"parquet\":{},\"plank\":{},\"veneer\":{}},\"fabric\":{\"carpet\":{},\"leather\":{},\"pattern\":{},\"plain\":{}},\"grass\":{\"artificial\":{},\"dried\":{},\"lawn\":{},\"patchy\":{},\"wild\":{}},\"concrete\":{\"cast in situ\":{},\"damaged\":{},\"dirty\":{},\"painted\":{},\"rough\":{},\"slab\":{},\"smooth\":{}},\"sand\":{\"beach\":{},\"desert\":{}},\"stone\":{\"castle\":{},\"cobblestone\":{},\"floor\":{},\"granite\":{},\"limestone\":{},\"mosaic\":{},\"pebble\":{},\"terrazzo\":{},\"tile\":{},\"wall\":{}},\"plaster\":{\"damaged\":{},\"fresh\":{},\"old\":{},\"painted\":{}},\"soil\":{\"clay\":{},\"mud\":{},\"mulch\":{},\"sandy\":{}},\"rock\":{\"cliff\":{},\"jagged\":{},\"lava\":{},\"mossy\":{},\"rough\":{},\"smooth\":{}},\"moss\":{\"ground\":{},\"rock\":{}},\"debris\":{\"construction\":{},\"nature\":{}},\"brick\":{\"modern\":{},\"mortar\":{},\"painted\":{},\"rough\":{}},\"tile\":{\"ceramic\":{},\"grout\":{},\"pavestone\":{},\"sidewalk\":{},\"stone\":{}},\"asphalt\":{\"fine\":{},\"rough\":{},\"torn\":{}},\"other\":{\"climber\":{},\"creature\":{},\"dirt road\":{},\"edible\":{},\"fur\":{},\"paper\":{},\"various\":{}},\"snow\":{\"mixed\":{},\"pure\":{}},\"bark\":{\"beech\":{},\"birch\":{},\"oak\":{},\"other\":{},\"palm\":{},\"pine\":{},\"spruce\":{},\"willow\":{}},\"gravel\":{\"construction\":{},\"natural\":{},\"pebbledash\":{}},\"marble\":{\"polished\":{},\"rough\":{},\"tile\":{}},\"ground\":{\"forest\":{},\"jungle\":{},\"other\":{},\"roots\":{}},\"roofing\":{\"new\":{},\"old\":{}},\"historical\":{\"asian\":{},\"medieval\":{},\"middle-eastern\":{},\"roman\":{}},\"coal\":{\"brick\":{},\"debris\":{}},\"branch\":{\"alder\":{},\"birch\":{},\"juniper\":{},\"pine\":{},\"spruce\":{}}},\"brush\":{\"blood\":{},\"damage\":{},\"grunge\":{},\"leakage\":{},\"print\":{},\"spatter\":{},\"sponge\":{},\"spray\":{},\"stain\":{},\"traditional\":{},\"graffiti\":{}}},\"totalAssets\":16591,\"freeAssetsTree\":{\"surface\":{\"fabric\":{\"leather\":{},\"plain\":{}},\"rock\":{\"rough\":{},\"jagged\":{},\"lava\":{},\"cliff\":{}},\"plaster\":{\"fresh\":{},\"old\":{}},\"concrete\":{\"damaged\":{},\"rough\":{},\"dirty\":{},\"cast in situ\":{},\"smooth\":{}},\"snow\":{\"pure\":{}},\"other\":{\"creature\":{},\"various\":{}},\"antique\":{\"medieval\":{}},\"stone\":{\"wall\":{},\"castle\":{}},\"gravel\":{\"natural\":{}},\"moss\":{\"ground\":{}},\"metal\":{\"bare\":{},\"gun\":{}},\"soil\":{\"sandy\":{},\"mud\":{}},\"brick\":{\"rough\":{},\"modern\":{}},\"grass\":{\"wild\":{}},\"asphalt\":{\"torn\":{}},\"sand\":{\"desert\":{},\"beach\":{}},\"ground\":{\"roots\":{}},\"wood\":{\"plank\":{}}},\"atlas\":{\"fern\":{}},\"3D asset\":{\"tree\":{\"debris\":{},\"stump\":{}},\"assembly\":{\"rock\":{}},\"rock\":{\"assembly\":{},\"sandstone\":{},\"mossy\":{},\"rough\":{},\"cliff\":{}},\"concrete\":{\"curb\":{},\"wall\":{},\"damaged\":{}},\"street\":{\"curb\":{}},\"modular\":{\"urban\":{}}},\"decal\":{\"street\":{\"pothole\":{},\"patch\":{},\"painted line\":{},\"sidewalk\":{}},\"metal\":{\"other\":{}},\"debris\":{\"wood\":{}},\"vegetation\":{\"twig\":{},\"leaf\":{},\"jungle\":{}},\"concrete\":{\"damage\":{}}},\"imperfection\":{\"metal\":{\"clean\":{}}},\"brush\":{\"leakage\":{}},\"3D plant\":{\"grass\":{\"wild\":{},\"lawn\":{}},\"garden plant\":{\"flowerless\":{}}}}}";

    public static void main(String[] args) {
        JSONObject jsonObject = JSONObject.parseObject(assets);
        JSONObject tree = jsonObject.getJSONObject("tree");
        Set<String> strings = tree.keySet();
        System.out.println(tree);
        System.out.println("资产类型");
        System.out.println(strings);
        strings.forEach(System.out::println);
    }


}