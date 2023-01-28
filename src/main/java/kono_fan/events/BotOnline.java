package kono_fan.events;

import kono_fan.utilities.IDAndEntities;
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
        JDA jda = event.getJDA();
        IDAndEntities.konoFanServer = jda.getGuildById(IDAndEntities.KONO_FAN_SERVER); //獲得非洲手遊俱樂部
        if (IDAndEntities.konoFanServer == null)
        {
            System.err.println("Can't get KonoFan server.");
            Logger.log("Can't get KonoFan server.");
            System.exit(-1);
        }

        IDAndEntities.lobbyChannel = IDAndEntities.konoFanServer.getChannelById(TextChannel.class, IDAndEntities.LOBBY_CHANNEL); //大廳頻道
        if (IDAndEntities.lobbyChannel == null)
        {
            System.err.println("Can't get KonoFan server lobby channel.");
            Logger.log("Can't get KonoFan server lobby channel.");
            System.exit(-1);
        }

        IDAndEntities.botChannel = IDAndEntities.konoFanServer.getChannelById(TextChannel.class, IDAndEntities.BOT_CHANNEL); //機器人頻道
        if (IDAndEntities.lobbyChannel == null)
        {
            System.err.println("Can't get KonoFan server bot channel.");
            Logger.log("Can't get KonoFan server bot channel.");
            System.exit(-1);
        }
        IDAndEntities.botChannel.sendMessage("上線").queue(); //傳送上線
        Logger.log("上線"); //紀錄上線

        IDAndEntities.gay = IDAndEntities.konoFanServer.getRoleById(IDAndEntities.GAY_ROLE);
        if (IDAndEntities.gay == null)
        {
            System.err.println("Can't get gay.");
            Logger.log("Can't get gay.");
            System.exit(-1);
        }
    }
}