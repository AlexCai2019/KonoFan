package kono_fan.events;

import kono_fan.utilities.Logger;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.events.session.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import static kono_fan.utilities.IDAndEntities.*;

public class BotOnline extends ListenerAdapter
{
	@Override
	public void onReady(@NotNull ReadyEvent event)
	{
		konoFanServer = jda.getGuildById(KONO_FAN_SERVER); //獲得非洲手遊俱樂部
		if (konoFanServer == null)
			errorOccurred("Can't get KonoFan server.");

		lobbyChannel = konoFanServer.getChannelById(TextChannel.class, LOBBY_CHANNEL); //大廳頻道
		if (lobbyChannel == null)
			errorOccurred("Can't get KonoFan server lobby channel.");

		botChannel = konoFanServer.getChannelById(TextChannel.class, BOT_CHANNEL); //機器人頻道
		if (botChannel == null)
			errorOccurred("Can't get KonoFan server bot channel.");
		botChannel.sendMessage("上線").queue(); //傳送上線
		Logger.log("上線"); //紀錄上線

		gay = konoFanServer.getRoleById(GAY_ROLE);
		if (gay == null)
			errorOccurred("Can't get gay.");
	}

	private void errorOccurred(String errorMessage)
	{
		System.err.println(errorMessage);
		System.err.print('\u0007');
		Logger.log(errorMessage);
		jda.shutdownNow();
	}
}