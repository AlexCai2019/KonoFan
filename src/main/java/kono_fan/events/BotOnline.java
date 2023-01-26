package kono_fan.events;

import kono_fan.KonoFan;
import kono_fan.utilities.Logger;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.events.session.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class BotOnline extends ListenerAdapter
{
    @Override
    public void onReady(@NotNull ReadyEvent event)
    {
        super.onReady(event);
        JDA jda = event.getJDA();
        KonoFan.lobbyChannel = jda.getChannelById(TextChannel.class, KonoFan.LOBBY_CHANNEL); //大廳頻道
        if (KonoFan.lobbyChannel != null)
            KonoFan.lobbyChannel.sendMessage("上線").queue();
        Logger.log("上線");
        KonoFan.botChannel = jda.getChannelById(TextChannel.class, KonoFan.BOT_CHANNEL);
    }
}
