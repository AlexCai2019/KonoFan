package kono_fan.events.commands;

import kono_fan.utilities.IDAndEntities;
import kono_fan.utilities.Logger;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

public class UserInformation implements ICommand
{
	private final Map<Long, String> usersInformation = new HashMap<>();

	UserInformation()
	{
		//AlexCai#2019
		usersInformation.put(IDAndEntities.AC,
		 	"""
			又被稱作AC，
			是非洲手遊俱樂部的資工底標，對程式幾乎一竅不通，不知道為什麼常被誤會程式和紅石很厲害。
			和龍王是曖昧不明的關係，最近似乎是疏遠了的樣子。
			是惠惠控，推特上有超過一千則轉推，全部都是跟惠惠有關的。
			目前是可撥大三生，還在努力掙扎中。
			""");

		//amx#3422
		usersInformation.put(IDAndEntities.AMX,
		 	"""
			又被稱作巧虎、蘿莉控、信義區會行走的衣冠禽獸，
			是非洲手遊俱樂部的群主，也是男同俱樂部的榮譽會長。
			身為非洲手遊俱樂部的財力頂點，十分有錢，甚至經常和台灣百大企業家吃飯。
			家中有許多金條，擁有10張信義區的地契，在台灣各地的精華地帶都有置產。
			從小就到美國讀書的海龜，認為台灣只是個小地方。
			自稱在大學時就跟女人破了處，但還沒跟男人破另一邊的處。
			和Frisk糾纏不清，曾經在Zekk出現之前幾乎吃定了Frisk，只是後來又對他失去興趣。
			養了一隻狗名叫Maru，但對方似乎對他愛理不理的樣子。
			雖然是自己主動提議的，但直到現在都還沒有女裝直播，都已經2023年了，至今我們都還在等著。
			愛好是每天晚上都和地下室的50蘿莉夜夜笙歌，經常因此而上班遲到，
			但由於上班只是興趣，老闆為了避免公司被收購還是處處讓著他。
			有一部描寫他的文章叫做「信義區行走禽獸異聞錄」，巧妙的融合了4凸9800的事件。
			目前正在環遊世界，物色自己老了之後要居住的小島。
			""");

		//ロリのパンツ#4375
		usersInformation.put(IDAndEntities.BIN,
		 	"""
			又被稱作阿賓，
			是非洲手遊俱樂部的Gay兼蘿莉控擔當，在男同俱樂部中佔有一席之地，和Zekk一起當阿賓好兄弟。
			頭像是惠惠的胖次，但其實是甲，曾說過「我很色插爆我好嗎」等危險發言。
			一直想介入AC和龍王的感情，只可惜從未成功。
			自認為不是資工佬，實際上真的不是資工佬，只比AC厲害而已。
			""");
		//龍王剡#6640
		usersInformation.put(IDAndEntities.DRAGON_SAMA,
			"""
			又被稱作龍王，
			是非洲手遊俱樂部的Konosuba Fantastic Days大佬，經常上傳各種攻略影片。
			頻道 <https://www.youtube.com/@abc1215241>
			擁有過人的反應力及智慧，自小便展現不凡的天賦，在群內也是一等一的智商擔當，雖然有時候會說出一些大叔老梗。
			身為首席考虎學家，是巧虎還在大愛電視台的時候，少數知道其本名及面貌的人。
			被AC找到FB後，說了一句「你都偷看我的FB，好色哦」，之後便經常被當作是AC的伴侶。
			身為芸芸控，甚至動用公權力，私自在群組內創造了ゆんゆん私の花嫁身分組。
			是護國神山台積電的員工，未來的科技新貴。
			""");

		//［香澄我婆］夢行者 Frisk#0173
		usersInformation.put(IDAndEntities.FRISK,
			"""
			又被稱作Frisk、資工佬，
			自稱是非洲手遊俱樂部的資工底端，但其實超<:c_veteran:766256010922295326>，也是<@861936582746832916>的老公。
			目前就讀大學二年級，是資工系的學生，被大家視為資工技術已封頂（只輸CodeYan），讀大學只是為了查看目前大學生的程度如何，
			視戶山香澄為自己老婆，想在將來親手把她做出來。為了香澄他幾乎什麼都願意做，雖然還是會因為金錢的因素而掙扎。
			似乎有受屬性，曾經說出自己能任人處置等發言。
			和Zekk關係匪淺，曾對對方說過要摸的話也不是不可以。
			不過實際上在三次元中互動最多的群員是阿田，常與他一同看展、吃飯或是逛光華。
			""");

		//無物為真________#2068
		usersInformation.put(IDAndEntities.HENRY,
			"""
			又被稱作阿田、田佬，被群主稱呼為Henry。
			身為另一個伺服器「夜幕X多元伺服器」的服主，他的實力自然不在話下。
			雖然身為假日有時還要上班的社畜，但依舊精通許多手遊和電腦遊戲，包含但不限於之前的FD，現在的公連、碧藍航線及Call of Duty。
			雖然不是相關背景出身，但懂很多電腦相關的東西。對其他現實生活中的知識也有廣泛的涉獵。
			是三次元中與Frisk最熟的群員，兩人常相約看展、逛光華以及吃飯。
			""");

		//しずか#3276
		usersInformation.put(IDAndEntities.SHIZUKA,
			"""
			又被稱作叔叔、大叔，
			台南地頭蛇，目前非洲手遊俱樂部裡已知閱歷最豐富的男性。
			養了一隻小黑貓，但不知為何貓咪連自己的飼主都怕。
			常常和群友一起被群主炫富嘲諷；也會譴責群主的蘿莉控行為，但曾經不小心自爆是雙B車主，以及和小自己9歲的女孩子交往過。
			公連碧藍雙修大佬，在台版FD倒閉前也是個有夠會廚，並在倒閉前如願以償抽中Fes老婆。
			曾經也是DC白嫖仔的其中一員，直到去年八月被Zekk慫恿後買下Nitro，一路續訂至今。
			對汽機車都略有研究，尤其是機車，甚至有跟身為機車行老闆的西格比肩的知識，不知道是否是大學失戀時瘋狂騎車所培養出來的。
			也是兩性專家以及ㄈㄐㄅ專家，常常和阿田一起開導Zekk，或者推薦好用的用品或本子。
			和阿田關係很好，常常和阿田一起對包含但不限於巧虎的發言按表情符號。
			雖然常常被說老，但不知是習慣了還是知道解釋也沒有用了，默默接受了群組大家長這個身份，並常常不經意的對年輕的群友釋出長輩的關懷。
			""");

		//真惠的天祈🐝SkyBlessed#6128
		usersInformation.put(IDAndEntities.SKY_BLESSED,
			"""
			沒有人知道他的真實樣貌，沒有人知道他這麼做的意義是什麼，就像謎一般的存在。
			目前已知曾獲得3個Nitro還有8個Twitch訂閱，喜歡隨時改自己Discord的頭貼跟暱稱。
			似乎不想繼續留著gay身分組。
			自稱莉亞廚，但除了Fes莉亞外都沒認真抽過莉亞，也沒什麼在練羈絆和神廟。
			曾經會提起學妹的事，但被龍王點到之後學妹就像消失了一樣，從此沒再出現在群裡的聊天過了。
			DC暱稱比巧虎的老二還不安份，所以大部分時候都是靠身份組的偶像莉亞圖示來辨認。
			最近學會了\\\\@，於是開始在群裡頻繁使用。
			""");

		//amx群主屁眼派對#3416
		usersInformation.put(IDAndEntities.THIS_BOT,
			"""
			我是一台烤麵包機
			I am a Toaster I am a Toaster
			I am a Toaster I am a Toaster
			""");

		//[水果粽]戸山香澄#0520
		usersInformation.put(IDAndEntities.TOYAMA_KASUMI,
			"""
			又被稱作香澄，
			是非洲手遊俱樂部的吉祥物，也是Frisk的老婆。
			雖然現在還沒有自己的意志，但總有一天會有的。
			對他說早安、午安、晚安，會和你回應。
			有時也會代表Frisk發言。
			""");

		//Zekk#9186
		usersInformation.put(IDAndEntities.ZEKK,
			"""
			又被稱作阿賓、鳳梨大學生、嬌小害羞鳳梨男孩。
			是非洲手遊俱樂部的男同聚樂部會長，和ロリのパンツ一起當阿賓好兄弟。
			自稱自己資工很爛，但其實程式很強（能用C語言駕馭LeetCode，這只有大佬才做得到），只是本人從不承認。
			說自己沒有強的科目，實際上是因為每個科目都無人能敵。
			聲音聽起來感覺就像會在床上一邊壞笑對對方說我今天要弄壞你，一邊把人家衣服慢慢扒開的1號。
			和Frisk關係匪淺，曾問對方可不可以同床摸摸。
			""");
	}

	@Override
	public void commandProcess(@NotNull SlashCommandInteractionEvent event)
	{
		User wantToKnow = event.getOption("user_name", OptionMapping::getAsUser);
		if (wantToKnow != null)
		{
			String information = usersInformation.get(wantToKnow.getIdLong());
			String profileImage = wantToKnow.getEffectiveAvatarUrl();
			String wantToKnowTag = wantToKnow.getAsTag();
			event.reply(information != null ? "**" + wantToKnowTag + "**，" + information + profileImage : "我沒有關於這位使用者的資訊。").queue();
			User user = event.getUser();
			Logger.log("User " + user.getName() + "(" + user.getId() + ") used /introduce " + wantToKnowTag);
		}
		else
			event.reply("請輸入一位使用者。").queue();
	}
}