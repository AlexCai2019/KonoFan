package kono_fan.events;

import kono_fan.utilities.IDAndEntities;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.Message.MentionType;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;
import net.dv8tion.jda.api.entities.emoji.Emoji;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.util.Random;
import java.util.regex.Pattern;

/**
 * <p>
 *     {@code MessageListener} 是監聽伺服器內訊息的類別，在 {@link kono_fan.KonoFan#main(String[])} 內註冊。擁有一
 *     個從 {@link ListenerAdapter} 繼承而來的方法 {@link #onMessageReceived(MessageReceivedEvent)}，針對群組內的
 *     訊息做出反應。
 * </p>
 *
 * @author Alex Cai
 * @since 1.0
 */
public class MessageListener extends ListenerAdapter
{
	private final Emoji head_cmonPlease = Emoji.fromCustom("head_cmonPlease", 1004415142596968559L, false);
	private final Emoji catsmile = Emoji.fromCustom("catsmile", 847792833884979230L, false);
	private final Emoji VT_rushiacry = Emoji.fromCustom("VT_rushiacry", 805837203833880638L, false);
	private final Emoji arrow_upper_left = Emoji.fromUnicode("↖");
	private final Emoji c_lie = Emoji.fromCustom("c_lie", 861601187509829643L, false);
	private final Emoji c_you = Emoji.fromCustom("c_you", 871031987610202122L, false);
	private final Emoji zekk1 = Emoji.fromCustom("zekk1", 1000314923039064134L, false);
	private final Emoji c_fbi = Emoji.fromCustom("c_fbi", 847791997564747786L, false);

	private final Pattern codeYanRegex = Pattern.compile("(?i).*codeyan.*");
	private final Pattern meguminRegex = Pattern.compile("(?i).*megumin.*");
	private final Pattern lolRegex = Pattern.compile("(?i).*lol*");
	private final Pattern gayRegex = Pattern.compile("(?i).*gay.*");

	private final Random random = new Random();

	@Override
	public void onMessageReceived(@NotNull MessageReceivedEvent event)
	{
		if (!event.isFromGuild())
			return;
		Member member = event.getMember();
		User user = event.getAuthor(); //發送訊息的人
		if (user.isBot() || member == null) //如果是機器人就不執行了
			return;
		Message message = event.getMessage(); //訊息
		String rawMessage = message.getContentRaw(); //訊息字串
		MessageChannel channel = event.getChannel(); //接收到訊息的頻道
		long userID = user.getIdLong();

		//當使用者不是AC 且擁有Gay身分組 或者是巧虎
		int gayChance = random.nextInt(20);
		if (gayChance == 0 && userID != IDAndEntities.AC &&
				(userID == IDAndEntities.AMX || member.getRoles().contains(IDAndEntities.gay)))
			channel.sendMessage("Gay式發言").queue(); //5%機率說出Gay式發言

		//😭
		if (codeYanRegex.matcher(rawMessage).matches())
			message.addReaction(VT_rushiacry).queue();

		//惠惠
		if (rawMessage.contains("惠惠") || rawMessage.contains("めぐみん") || meguminRegex.matcher(rawMessage).matches())
			channel.sendMessage("☆めぐみん大好き！☆").queue();

		//LOL
		if (lolRegex.matcher(rawMessage).matches())
			channel.sendMessage("LOL").queue();

		//10%機率說出巧虎一毫秒不炫富真的渾身不舒服
		if (random.nextInt(10) == 0 && rawMessage.contains("炫富")) //當訊息內含「炫富」
			channel.sendMessage("https://media.discordapp.net/attachments/976460093950394388/1026871205879349258/image0.jpg").queue();

		//有人tag gay身分組
		if (message.getMentions().isMentioned(IDAndEntities.gay, MentionType.ROLE))
			channel.sendMessage("<@170985598297964544>").queue();

		//群主女裝
		if (rawMessage.contains("女裝") && rawMessage.contains("群主") && !rawMessage.contains("不"))
			channel.sendMessage("不女裝，枉為虎").queue();

		//早安
		if (rawMessage.contains("早安"))
			channel.sendMessage("早上好中國 現在我有Bing Chilling").queue();

		//午安
		//if (rawMessage.contains("午安"))
			//channel.sendMessage("").queue();

		//晚安
		if (rawMessage.contains("晚安"))
			channel.sendMessage("那我也要睡啦").queue();

		//複讀
		if (rawMessage.contains("複讀") || rawMessage.contains("復讀"))
			channel.sendMessage("你從桃園新竹\n你從桃園新竹\n你從桃園新竹").queue();

		if (userID == IDAndEntities.AMX) //當使用者是巧虎
		{
			if (rawMessage.contains("cmonBruh"))
				message.addReaction(head_cmonPlease).queue();

			if (rawMessage.contains("catbruh"))
				message.addReaction(catsmile).queue();

			if (rawMessage.contains("沒錢") || rawMessage.contains("窮"))
				message.addReaction(c_lie).queue();

			if (gayRegex.matcher(rawMessage).matches())
			{
				message.addReaction(arrow_upper_left).queue();
				message.addReaction(c_you).queue();
				message.addReaction(zekk1).queue();
				if (gayChance != 0)
					channel.sendMessage("Gay式發言").queue();
			}

			if (rawMessage.contains("蘿"))
				message.addReaction(c_fbi).queue();
		}
	}
}