package kono_fan.events.commands;

import kono_fan.utilities.IDAndEntities;
import kono_fan.utilities.Logger;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class UseCommand extends ListenerAdapter
{
    private final Map<String, ICommand> commandsMap = new HashMap<>();
    private final TwitterAuthor[] twitterAuthors = {new TwitterAuthor("_mexif",1375088851446755332L),new TwitterAuthor("_Mizugasi",1444998923739824131L),new TwitterAuthor("_Rivia_",1370370105696161794L),new TwitterAuthor("_ukoyr",1544612178556121088L),new TwitterAuthor("1G9Xw69kePSLI6p",1420731295156477954L),new TwitterAuthor("27miyamoto",1417530610831093766L),new TwitterAuthor("3CDtvmmpuqKhl7J",1471803818048634884L),new TwitterAuthor("7egTXS0GKWh3wGP",1334542548497387521L,1342110371662888960L,1346091304124497920L,1360614029748654092L,1416720114066415617L,1455918876990996489L,1485297876947566594L,1489998923825815552L,1498326952289386499L,1527310236247560193L,1533389156755603456L,1535966498552180736L,1557015010668609536L,1595465406420221952L,1606956350596317185L),new TwitterAuthor("9aBGoLUanvcjd7O",1599205425127501824L),new TwitterAuthor("afulofuwafuwa",1372512531546181633L),new TwitterAuthor("ahmadjendro",1488530273373683713L),new TwitterAuthor("aihamuteki",1392050607628820482L),new TwitterAuthor("Aloe_04maho",1334828369507098624L,1342795265724436481L,1360906615008886784L,1403669632108564485L,1423601843368730625L,1445719564185075722L,1531955222569881600L,1573801227376214017L),new TwitterAuthor("AONAGINEMURI",1378657231659364362L),new TwitterAuthor("askr_otr",1468201641723965447L),new TwitterAuthor("atasom",1343169561680519169L),new TwitterAuthor("az210309",1383254021201297414L,1384006403623243781L,1391411800420151310L),new TwitterAuthor("bhive003",1362331371243413504L,1366659543455780866L,1382662692729618434L,1506027874825895938L,1588833560546676737L),new TwitterAuthor("bKCxAnfS8G0M4rQ",1334515572864811008L),new TwitterAuthor("BNC_0116",1120180446392807424L,1123935283995713543L,1128289624126738432L,1129402831587274752L,1211311585571917825L,1228335403221966849L,1231258586723938304L,1348629296458338305L,1353732864177623040L),new TwitterAuthor("cachi_lo",1423468322893357056L),new TwitterAuthor("catharpoon",1395598782675357698L,1428436939015741440L),new TwitterAuthor("chakichaki33",1529055947767050240L),new TwitterAuthor("CHILLY_karon",1342054914290278400L,1378395239845482499L,1391408248587120640L,1409898538360659972L,1419968305973141512L,1434023637498032134L,1536657197387726849L),new TwitterAuthor("creates_blue",1389692031606267904L,1393257386287144963L,1400192682480136194L),new TwitterAuthor("d_recolors",1505061496505913347L),new TwitterAuthor("DaskachanJp",1365971177265528836L),new TwitterAuthor("DlrfMimikyu",1362948691376619524L,1352830077696962560L,1400129807925628933L),new TwitterAuthor("E_GA_KU",1596505160175747072L),new TwitterAuthor("Edacchi73",1487748613908615182L),new TwitterAuthor("EJAMIARTSTUDIO",1370264344903045120L),new TwitterAuthor("Fagi_Kakikaki",1416334656371269634L),new TwitterAuthor("FevJF0EICCKnLlD",1347026153098211331L),new TwitterAuthor("gakkari_orz",1388805801859452928L,1538592731962179587L),new TwitterAuthor("galua_0707",1350654316588089347L),new TwitterAuthor("Gasolineillust",1565325467850518529L),new TwitterAuthor("gazercide",1373256680763396106L),new TwitterAuthor("GReeeeNmodoki2",1599057455702765568L),new TwitterAuthor("GuRa_fgo",1348538564900917248L,1349713455033561088L,1352926702398185473L),new TwitterAuthor("habaki",1344098778849058816L),new TwitterAuthor("HagGy0327_",1338114471143739392L),new TwitterAuthor("hagi_neco",1376064544179544064L,1393868573106327563L,1429373932159660032L,1452204203825238020L),new TwitterAuthor("hapycloud",1343423407442948101L),new TwitterAuthor("harehareota",1492876221751136260L,1590287809692459008L,1598270723747098624L),new TwitterAuthor("Harimax8",1364157933689262083L,1383359465366323209L,1403283171903303680L,1422891821772906500L,1443880758838394883L,1458382171517816834L,1493238988705959937L,1538112903555215360L,1596347482916950018L,1602278950289694721L),new TwitterAuthor("hatuganookome",1344206596310761472L),new TwitterAuthor("he_shan123",1557726596202606595L),new TwitterAuthor("HereticxxA",1398405163677671425L),new TwitterAuthor("Hi_me_520So",1399677759698337797L),new TwitterAuthor("hiroserii",1391709681911963651L),new TwitterAuthor("hiiragi1014dq",1484684229032099840L),new TwitterAuthor("HongBsWs",1549006884807446528L),new TwitterAuthor("hwa_n01",1353356379889700864L),new TwitterAuthor("icetea_art",1425026652422082560L,1495035441246003210L,1528012740656345088L,1545769743151353856L,1553379890128306177L,1555916614138150912L,1573673618172624896L,1593967339036450820L,1599055870897393664L,1600802621207420932L,1609127220991201284L),new TwitterAuthor("ishiiyunosuke",1431326897930072065L),new TwitterAuthor("ishiyunokenzen",1417521896824786955L),new TwitterAuthor("isonnoha",1504494884765396994L),new TwitterAuthor("Ixy",1334516599760490498L,1353673446719250433L,1391319694859137024L,1417105811650727936L,1599059007498772480L),new TwitterAuthor("J02GGOgpQ6dueGu",1336638090828341250L,1336868237141704705L,1345199258220126216L,1345279854040649728L,1352167601951002624L,1355069629840855042L,1358677301731368964L,1367304489468796932L,1372667245726298113L,1378316365128331264L,1380295158676090880L,1382095993429135364L,1391201021091741702L,1391719839681581059L,1434746622911516673L,1467024737448886274L),new TwitterAuthor("JackRockhardt",1421495091001135106L),new TwitterAuthor("jirafuru1",1385345798372741120L),new TwitterAuthor("kadokawasneaker",1463416144765751300L,1463709023455399936L),new TwitterAuthor("kaduki2402",1524356704586301440L),new TwitterAuthor("kaiiruuu",1435533706161102852L),new TwitterAuthor("kaketemasu",1361977131513704449L),new TwitterAuthor("kakeyu888",1498949265611132930L),new TwitterAuthor("kamindani",1364578421406199822L,1375859306424197121L),new TwitterAuthor("kanata_mako",1602994234142986240L),new TwitterAuthor("kanekan15",1344659652210921477L,1358079319751364610L,1604042760503570435L),new TwitterAuthor("kanzi30855",1352189635531718656L),new TwitterAuthor("karst_bunny",1487062233343426561L,1502885083614973952L,1577615125720485888L),new TwitterAuthor("kasumiM224",1408089488358723585L,1530582872184483840L),new TwitterAuthor("kgs_jf",1459384335799562241L),new TwitterAuthor("kiriya_ff",1349643268120690690L),new TwitterAuthor("kisasageDrawing",1571040020219428865L),new TwitterAuthor("kiyoe_sans",853678045479260160L),new TwitterAuthor("KMTM_kmk0819",1334712230911229953L,1334709568580898818L,1356814844792504321L,1388147012881707009L,1400465949963145226L,1406994090743328773L,1579411417559465984L,1583419880988037121L,1606986710520565761L,1614200785335623682L),new TwitterAuthor("konosubaanime",1530534355558203394L),new TwitterAuthor("kosame_H2O",1367079770870046720L),new TwitterAuthor("kumamakupillow",1375780942556528648L),new TwitterAuthor("kuragen000",1464202279897104391L),new TwitterAuthor("kuro_gbp02",1458399016023060481L,1606632160756396032L),new TwitterAuthor("kurosugarfree",1342832584351305728L),new TwitterAuthor("kyo_k",1357357057213538309L),new TwitterAuthor("LiveTM_08",1484269503563264000L),new TwitterAuthor("lkpk_g",1394177004967108608L,1403247020245098498L,1429742364428431367L),new TwitterAuthor("lu_i_su",1373739018634981378L),new TwitterAuthor("LungBank_DGArt",1336589790947409921L),new TwitterAuthor("Mahdi_011",1401149547724820482L),new TwitterAuthor("maika_82",1401554662130556928L,1432335609712971781L),new TwitterAuthor("mcmc__factory",1390245622175780864L),new TwitterAuthor("MegaMouseArts",1370182918258184192L),new TwitterAuthor("mikazuki_akira",1379289441450139654L),new TwitterAuthor("mishima_kurone",1451479334636572676L,1456979191736377344L),new TwitterAuthor("mm_pentab",1388151774595325954L,1403371578327404544L,1533100144828108800L),new TwitterAuthor("mnk_nk1414",1381215456741138434L),new TwitterAuthor("mokuka_noe",1363396372309901313L),new TwitterAuthor("monmota61",1420182545614868482L),new TwitterAuthor("MOS98612700",1381216754752352256L,1390303439599509518L),new TwitterAuthor("MP26player",1335131654415818753L),new TwitterAuthor("muotou",1364544925908533251L),new TwitterAuthor("MyungYi_",1340544944470020097L,1346389393750204416L,1367020232334663683L),new TwitterAuthor("nagio1222",1371770277487538176L,1389860676886175745L),new TwitterAuthor("Najucajuarts",1556072418862682113L),new TwitterAuthor("namahyou",1441056569236463637L),new TwitterAuthor("Namakura_noelle",1408435172224114691L),new TwitterAuthor("nasubisamurai15",1524090497249075206L),new TwitterAuthor("natu_7273",1569990932568891392L),new TwitterAuthor("nekotyuta_fncl",1435918084703854593L),new TwitterAuthor("nemuhosi",1355473834326061062L),new TwitterAuthor("ni_tamagoEX",1377825653769203714L),new TwitterAuthor("NohikariAi",1523465539678785536L,1569857584685002753L,1583586641737699328L),new TwitterAuthor("noir2more",1334513715660644355L),new TwitterAuthor("nomoregrass417",1526173684355870720L),new TwitterAuthor("noneru_pix",1349470312648290307L),new TwitterAuthor("nut_megu",1336584872471584768L,1338774453711355904L,1340946345096450049L,1345658481076887553L,1347105835885842434L,1348193043229278208L,1360514394136866816L,1363775871711014919L,1380808129676333064L,1401107716651638786L,1412336326108610563L,1417047602130993154L,1418859623973589000L,1435528909366333442L,1436616211828129798L,1504421763479920640L,1507644448079253508L,1540621318374162433L),new TwitterAuthor("nyanpasuAxela",1336990001486209024L,1382653829716398084L),new TwitterAuthor("omurice4684",1334513374726643715L),new TwitterAuthor("OnsenSyndicate",1401606597584068617L),new TwitterAuthor("ORE_HARUWO",1425408631747485697L),new TwitterAuthor("osaillust",1360868971990241285L),new TwitterAuthor("Osuzu_botan",1458708798562918400L),new TwitterAuthor("pensukeo",1334513603865686018L,1345392705837309952L,888014816266211329L,895656010974502912L,901510162657050624L,914382762978680832L,925014913285734402L,942065366179627008L,944902949238595585L,966604879312515072L,984138081564442624L,1038481866993500163L,1068471996369915906L,1080105327196921856L,1089361339376517121L,1099923406571528193L,1105799480396279809L,1113333584654266368L,1123238336359886849L,1123913549934473216L,1127271844384395264L,1129119914638233600L,1129334190695100416L,1130947782209024000L,1132349932705214465L,1144666786433884160L,1151414483669008385L,1167384162317168640L,1172969592458600448L,1184557949714219009L,1189861171395870721L,1191768898187587585L,1202157304117809152L,1231062523014565888L,1231101803770462208L,1243708636955734016L,1271368885682319360L,1400214535080878081L),new TwitterAuthor("Pictolita",1455005915992584196L),new TwitterAuthor("popo_rinngo",1581592183341166592L),new TwitterAuthor("ptrtear",1413824587935010820L),new TwitterAuthor("ranfptn",1355848490383855617L,1412021766822580232L),new TwitterAuthor("reeto0909",1544800325172731904L),new TwitterAuthor("romromm_06",1395963963318226945L),new TwitterAuthor("rouka0101",1377561442694488064L,1380098158366052361L),new TwitterAuthor("Ruroi31",1416330421525041152L),new TwitterAuthor("Sabcoo",1354433463043022849L),new TwitterAuthor("sannshi_34",1334743269582938112L,1416979268928634880L),new TwitterAuthor("senrihinZK",1357115564607512579L,1526404539121037312L),new TwitterAuthor("shisui0178",1380913346589822978L),new TwitterAuthor("shONe_Banana",1487825453427863553L),new TwitterAuthor("shouu_kyun",1452032402742669313L),new TwitterAuthor("shoyu_maru",1334113954218479622L,1350413371363848196L,1358023126894825472L,1363817144018866178L,1365634168839790601L,1365995755194880003L,1369256816794771456L,1373243591322005508L,1382302645726027782L,1382671158902857729L,1383375535967903749L,1388463621164859395L,1390276726958170115L,1395715515306307585L,1406221231045562368L,1411293459474911237L,1416352027169357831L,1426514140554698753L,1434109889056428034L,1436648676349251585L,1449698306620227589L,1454041990329352192L,1459477324437458946L,1466361693324210183L,1482306755447050241L,1487746415602577409L,1493198582299897856L,1497902031813890058L,1501533220445503488L,1535957094251507712L,1543204937144094720L,1546102725196550144L,1586696036126711809L,1593937896784166912L,1600838962406625280L,1606620722864214017L,1606981310349967366L,1617133096385773569L),new TwitterAuthor("shimohurizz221",1364455309423439872L),new TwitterAuthor("sirnoatelier",1433754686394286083L),new TwitterAuthor("sirokohi",1563453805462974464L,1567482644199526405L,1571069570269708288L,1574507658786525184L,1577584510858067969L,1581208936329641985L,1593168316646182912L,1593893460427567104L,1594140374712602624L,1598241999026782208L,1606411965232185344L,1614185975844081666L),new TwitterAuthor("sozoshu_kyo",1350060583358394368L,1385928402499108866L,1519874790840217600L,1607006210833936387L),new TwitterAuthor("storm_stx",1506648238430072835L),new TwitterAuthor("suke_yuno",1334837425667969024L,1342076712587206658L,1344635807965974528L,1348240561505853442L,1356574457360310273L,1359838927914373130L,1260533099361787905L,1264158961671921664L,1267778380994236416L,1277202674916589570L,1360925354773241857L,1363822716260782080L,1378677005764292611L,1380491541450424320L,1384431678454521860L,1390275707347951621L,1401870084285493252L,1406218302515384322L,1416757349046382592L,1418673457491943428L,1422169100533460995L,1432310655512506386L,1443910414455107588L,1454782046337781770L,1455867948883529732L,1460578197477552133L,1474349388307005448L,1480872741784125441L,1493194450688159746L,1496087004211453960L,1547189145818525696L,1558054431153082368L,1559510936616321024L,1565673703215886337L,1577266429568901124L,1579436145725026304L,1583789431949230081L,1587050690895310853L,1594666279511945216L,1602273539247476738L,1605171507097145344L,1609197162726055936L,1613869444387983362L),new TwitterAuthor("sunhyun3715",1358159212686229505L),new TwitterAuthor("suzurika26",1466784287881981954L),new TwitterAuthor("syu_an_n",1478490774585376768L),new TwitterAuthor("Takumi_ha_DX",1360628558599659525L,1370690390576164865L,1378299101071085569L,1380122050883293189L,1382673881903689730L,1413238581548572672L),new TwitterAuthor("TannyV5",1370204297917460485L),new TwitterAuthor("tkd14059560",1380758914401099777L),new TwitterAuthor("tmzr_ovo_",1373556726469775363L),new TwitterAuthor("toketa15",1360559485664677889L),new TwitterAuthor("toukan_drawing",1373572772983574537L,1424305682589708293L,1507656088103297026L,1614930786440065024L),new TwitterAuthor("TsutaKaede",1528329828012785664L,1529054613655015424L,1541753284070965249L,1570004558142652416L),new TwitterAuthor("tUWU284MlWaU7VA",1367024008223354880L),new TwitterAuthor("ud864",1427601524688003072L),new TwitterAuthor("udeude96",1349425136118636544L),new TwitterAuthor("Usa4gi",1438652486806425603L),new TwitterAuthor("Vi3q1ahbJM31goT",1345234835741188105L),new TwitterAuthor("vmDXhrkjDz7vbRY",1385233041023332357L),new TwitterAuthor("wa_ki_ya_ku",1360906994673016833L,1372881405705744384L,1379025064020996096L,1387723681833447427L,1394971615864270850L,1406206671571984384L,1422886552280072195L,1424383682442268683L,1435205520265121793L,1448264639385509892L,1487915699548798979L,1495134351272529926L,1496077312516780032L,1542545014298771457L,1599242577865478145L,1605951078180061184L,1610423761794379776L,1618336105027473408L),new TwitterAuthor("waiwaityo",1616481245437001732L),new TwitterAuthor("wumalutsufuri",1461695108055658496L,1463503094977687554L,1464586977114607616L,1465279326392176641L,1474425440760897536L,1474737540821561345L,1493204800414322689L,1505947094192095235L,1514219512388026373L,1529128009676247040L,1532330229880205312L,1559492213809496064L,1607322393818849281L),new TwitterAuthor("XaJgt7S9FkzWCiy",1550699515476189184L,1553715061713039360L,1599198155077472257L),new TwitterAuthor("yachiyo_naga",1422834901066207237L),new TwitterAuthor("yakankome",1372863514977574915L),new TwitterAuthor("YakiSnake",1385134714604777475L),new TwitterAuthor("yano_t",1378351221283594241L),new TwitterAuthor("Yansae81",1334864422934757376L,1345655525795512321L,1348915439527620608L,1356888607328358403L,1467394004971323393L),new TwitterAuthor("yuanagae",1418169760991178766L),new TwitterAuthor("yuu_hiyori30",1376157389435506696L),new TwitterAuthor("yuzufu_1",1544305092333129728L),new TwitterAuthor("zyu90gg",1334575930908397568L,1418913957067194368L,1423605503146426376L)};
    private final Random random = new Random();

    public UseCommand()
    {
        commandsMap.put("help", event -> event.reply(
                """
                        `/invite`: 獲得本群邀請連結
                        `/megumin`: 獲得一張惠惠圖
                        `/introduce <user_name>: 介紹一名使用者""").queue());
        commandsMap.put("invite", event -> event.reply("https://discord.gg/4pxSyQFTJT").queue());
        commandsMap.put("megumin", event ->
        {
            TwitterAuthor author = twitterAuthors[random.nextInt(twitterAuthors.length)];
            long imageID = author.artworks()[random.nextInt(author.artworks().length)];
            event.reply("https://twitter.com/" + author.name() + "/status/" + imageID).queue();
        });
        commandsMap.put("introduce", new UserInformation());
        commandsMap.put("shutdown", event ->
        {
            event.reply("關機中...").queue();
            // 將下線訊息發送到機器人頻道中
            IDAndEntities.botChannel.sendMessage("下線").queue();
            Logger.log("下線");
            event.getJDA().shutdown();
        });
    }

    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event)
    {
        String commandName = event.getName();
        ICommand command = commandsMap.get(commandName);
        if (command != null)
        {
            command.commandProcess(event);
            User user = event.getUser();
            Logger.log("User " + user.getName() + "(" + user.getId() + ") used /" + commandName);
        }
    }
}

record TwitterAuthor(String name, long... artworks) {}