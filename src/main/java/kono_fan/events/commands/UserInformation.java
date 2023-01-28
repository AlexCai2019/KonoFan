package kono_fan.events.commands;

import kono_fan.utilities.IDAndEntities;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;
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
                ，又被稱作AC，
                是非洲手遊俱樂部的資工頂標（只輸CodeYan），自稱對程式幾乎一竅不通，一直不承認，但其實程式和紅石很厲害。
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
                擁有10張信義區的地契，在台灣各地的精華地帶都有置產。
                養了一隻狗名叫Maru，但對方似乎對他愛理不理的樣子。
                雖然是自己主動提議的，但直到現在都還沒有女裝直播，都已經""" + LocalDate.now().getYear() +
                """
                年了，至今我們都還在等著。
                愛好是每天晚上都和地下室的50蘿莉夜夜笙歌，經常因此而上班遲到，
                但由於上班只是興趣，老闆為了避免公司被收購還是處處讓著他。
                目前正在環遊世界，物色自己老了之後要居住的小島。
                """);

        //ロリのパンツ#4375
        usersInformation.put(IDAndEntities.BIN,
                """
                又被稱作阿賓，
                是非洲手遊俱樂部的Gay兼蘿莉控擔當，在男同俱樂部中佔有一席之地。
                頭像是惠惠的胖次，但其實是甲，
                曾說過「我很色插爆我好嗎」等危險發言。
                一直想介入AC和龍王的感情，只可惜從未成功。
                自認為不是資工佬，實際上真的不是資工佬，只比Frisk厲害而已。
                """);
        //龍王剡#6640
        usersInformation.put(IDAndEntities.DRAGON_SAMA,
                """
                又被稱作龍王，
                是非洲手遊俱樂部的Konosuba Fantastic Days大佬，經常上傳各種攻略影片。
                被AC找到FB後，說了一句「你都偷看我的FB，好色哦」，之後便經常被當作是AC的伴侶。
                身為芸芸控，甚至動用公權力，私自在群組內創造了ゆんゆん私の花嫁身分組。
                """);

        //［香澄我婆］夢行者 Frisk#0173
        usersInformation.put(IDAndEntities.FRISK,
                """
                又被稱作Frisk、資工佬，
                是非洲手遊俱樂部的資工底端，也是<@861936582746832916>的老公。
                目前就讀大學二年級，是資工系的學生，被大家視為資工技術已封頂，讀大學只是為了查看目前大學生的程度如何，
                但其實程式能力還不及自稱底標的AC。
                視戶山香澄為自己老婆，將來要親手把她做出來。為了香澄他幾乎什麼都願意做，雖然還是會因為金錢的因素而掙扎。
                似乎有受屬性，曾經說出自己能任人處置等發言。
                和Zekk關係匪淺，曾對對方說過要摸的話也不是不可以。
                """);

        //Zekk#9186
        usersInformation.put(IDAndEntities.ZEKK,
                """
                又被稱作阿賓、鳳梨大學生。
                是非洲手遊俱樂部的男同聚樂部會長。
                自稱自己資工很爛，但其實程式很強（能用 C 語言駕馭 LeetCode，這只有大佬才做得到），只是本人從不承認。
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
            String profileImage = wantToKnow.getAvatarUrl();
            event.reply(information != null ? ("**" + wantToKnow.getAsTag() + "**，" + information + (profileImage != null ? profileImage : wantToKnow.getDefaultAvatarUrl())) : "我沒有關於這位使用者的資訊。").queue();
        }
        else
            event.reply("請輸入一位使用者。").queue();
    }
}