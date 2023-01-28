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
        usersInformation.put(IDAndEntities.AMX, "又被稱作巧虎、信義區會行走的衣冠禽獸，\n" //amx#3422
                + "是" + IDAndEntities.konoFanServerName + "的群主，也是男同俱樂部的榮譽會長。\n"
                + "身為" + IDAndEntities.konoFanServerName + "的財力頂點，十分有錢，甚至經常和台灣百大企業家吃飯。\n"
                + "擁有10張信義區的地契，在台灣各地的精華地帶都有置產。\n"
                + "養了一隻狗名叫Maru，但對方似乎對他愛理不理的樣子。\n"
                + "直到現在都還沒有女裝直播，都已經" + LocalDate.now().getYear() + "年了，至今我們都還在等著。\n"
                + "愛好是每天晚上都和地下室的50蘿莉夜夜笙歌，經常因此而上班遲到，\n"
                + "但由於上班只是興趣，老闆為了避免公司被收購還是處處讓著他。\n"
                + "目前正在環遊世界，物色自己老了之後要居住的小島。");
        usersInformation.put(IDAndEntities.DRAGON_SAMA, "又被稱作龍王，\n" //龍王剡#6640
                + "是" + IDAndEntities.konoFanServerName + "的Konosuba Fantastic Days大佬，經常上傳各種攻略影片。\n"
                + "被AC找到FB後，說了一句「你都偷看我的FB，好色哦」，之後便經常被當作是AC的伴侶。\n"
                + "身為芸芸控，甚至動用公權力，私自在群組內創造了" + IDAndEntities.loveYunYunName + "身分組。");
        usersInformation.put(IDAndEntities.FRISK, "又被稱作Frisk、資工佬，\n" //［香澄我婆］夢行者 Frisk#0173
                + "是" + IDAndEntities.konoFanServerName + "的資工頂點，也是<@861936582746832916>的老公。\n"
                + "目前就讀大學二年級，是資工系的學生，\n"
                + "但其資工技術已封頂，讀大學只是為了查看目前大學生的程度如何。\n"
                + "視戶山香澄為自己老婆，將來要娶她的，為了香澄他什麼都願意做。\n"
                + "似乎有受屬性，曾經說出自己能任人處置等發言。\n"
                + "和Zekk關係匪淺，曾對對方說過要摸的話也不是不可以。");
        usersInformation.put(IDAndEntities.ZEKK, "又被稱作阿賓、鳳梨大學生。\n" //Zekk#9186
                + "是" + IDAndEntities.konoFanServerName + "的男同聚樂部會長。\n"
                + "自稱自己資工很爛，但其實程式很強，只是本人從不承認"
                + "聲音聽起來感覺就像會在床上一邊壞笑對對方說我今天要弄壞你，一邊把人家衣服慢慢扒開的1號。\n"
                + "和Frisk關係匪淺，曾問對方可不可以同床摸摸。");
    }

    @Override
    public void commandProcess(@NotNull SlashCommandInteractionEvent event)
    {
        User wantToKnow = event.getOption("user_name", OptionMapping::getAsUser);
        if (wantToKnow != null)
        {
            String information = usersInformation.get(wantToKnow.getIdLong());
            event.reply(information != null ? ("**" + wantToKnow.getAsTag() + "**，" + information) : "我沒有關於這位使用者的資訊").queue();
        }
        else
            event.reply("請輸入一位使用者").queue();
    }
}