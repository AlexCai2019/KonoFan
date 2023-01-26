package kono_fan.events;

import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.channel.unions.MessageChannelUnion;
import net.dv8tion.jda.api.entities.emoji.Emoji;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.util.Random;

public class MessageListener extends ListenerAdapter
{
    private final Emoji head_cmonPlease = Emoji.fromCustom("head_cmonPlease", 1004415142596968559L, false);
    private final Emoji c_lie = Emoji.fromCustom("c_lie", 861601187509829643L, false);
    private final Emoji VT_rushiacry = Emoji.fromCustom("VT_rushiacry", 805837203833880638L, false);
    private final Random random = new Random();
    private static final long GAY_ROLE = 901364648039829554L;
    private static final long AMX_ID = 170985598297964544L;

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event)
    {
        super.onMessageReceived(event);

        Member member = event.getMember(); //發送訊息的人
        if (member == null || member.getUser().isBot()) //如果是機器人就不執行了
            return;
        Message message = event.getMessage(); //訊息
        String rawMessage = message.getContentRaw(); //訊息字串
        MessageChannelUnion channel = event.getChannel(); //接收到訊息的頻道

        member.getRoles().forEach(role ->
        {
            if (role.getIdLong() == GAY_ROLE && random.nextInt(10) == 0) //當使用者擁有Gay身分組
                channel.sendMessage("Gay式發言").queue(); //10%機率說出Gay式發言
        });

        if (rawMessage.contains("CodeYan") || rawMessage.contains("codeyan"))
            message.addReaction(VT_rushiacry).queue();

        if (rawMessage.contains("megumin") || rawMessage.contains("惠惠") || rawMessage.contains("めぐみん"))
            channel.sendMessage("☆めぐみん大好き！☆").queue();

        if (rawMessage.contains("炫富") && random.nextInt(10) == 0) //當訊息內含「炫富」
            channel.sendMessage("https://media.discordapp.net/attachments/976460093950394388/1026871205879349258/image0.jpg").queue();
            //10%機率說出巧虎一毫秒不炫富真的渾身不舒服

        if (member.getIdLong() == AMX_ID) //當使用者是巧虎
        {
            if (rawMessage.contains("cmonBruh"))
                message.addReaction(head_cmonPlease).queue();

            if (rawMessage.contains("沒錢") || rawMessage.contains("窮"))
                message.addReaction(c_lie).queue();
        }
    }
}
