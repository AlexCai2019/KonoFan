package kono_fan.events;

import kono_fan.utilities.IDAndEntities;
import kono_fan.utilities.Logger;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.entities.channel.ChannelType;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.util.stream.Collectors;

public class DirectMessageListener extends ListenerAdapter
{
    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event)
    {
        if (event.isFromType(ChannelType.PRIVATE))
        {
            Message message = event.getMessage();
            String rawMessage = message.getContentRaw();
            String attachments = "\n" + message.getAttachments().stream().map(Message.Attachment::getUrl).collect(Collectors.joining("\n"));
            IDAndEntities.botChannel.sendMessage(rawMessage + attachments).queue(); //私訊轉到機器人互動
            User user = event.getAuthor();
            Logger.log("User " + user.getName() + "(" + user.getId() + ") typed " + rawMessage + attachments + " in direct message");
        }
    }
}