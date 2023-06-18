package kono_fan.events.commands;

import kono_fan.utilities.IDAndEntities;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.exceptions.ErrorHandler;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import net.dv8tion.jda.api.interactions.components.buttons.Button;
import net.dv8tion.jda.api.requests.ErrorResponse;

import java.util.regex.Pattern;

public class QuoteCommand implements ICommand
{
	private final Pattern guildMessageLinkRegex = Pattern.compile("https://discord\\.com/channels/757266205936451609/\\d+/\\d+");

	@Override
	public void commandProcess(SlashCommandInteractionEvent event)
	{
		String link = event.getOption("link", OptionMapping::getAsString);
		if (link == null)
		{
			event.reply("這是不可能的").queue();
			return;
		}

		if (!guildMessageLinkRegex.matcher(link).matches())
		{
			event.reply("請輸入一個非洲手遊俱樂部的訊息連結").queue();
			return;
		}

		MessageChannel linkChannel;
		String[] messageLink = link.substring(48).split("/");

		linkChannel = IDAndEntities.konoFanServer.getChannelById(MessageChannel.class, messageLink[0]);
		if (linkChannel == null)
		{
			event.reply("沒有這個頻道!").queue();
			return;
		}

		linkChannel.retrieveMessageById(messageLink[1]).queue(linkMessage ->
		{
			User linkAuthor = linkMessage.getAuthor(); //連結訊息的發送者

			EmbedBuilder embedBuilder = new EmbedBuilder()
					.setAuthor(linkAuthor.getEffectiveName(), linkAuthor.getAvatarUrl(), linkAuthor.getAvatarUrl())
					.appendDescription(linkMessage.getContentRaw()) //訊息的內容
					.setTimestamp(linkMessage.getTimeCreated()) //連結訊息的發送時間
					.setFooter(linkChannel.getName(), null); //訊息的發送頻道

			linkMessage.getAttachments()
					.stream()
					.filter(Message.Attachment::isImage)
					.findFirst()
					.ifPresent(firstAttachment -> embedBuilder.setImage(firstAttachment.getUrl()));

			event.replyEmbeds(embedBuilder.build())
					.addActionRow(Button.link(link, "跳至訊息"))
					.queue();
		}, new ErrorHandler().handle(ErrorResponse.UNKNOWN_MESSAGE, e ->
				event.reply("這則訊息可能已被刪除，或我沒有權限取得").queue()));
	}
}
