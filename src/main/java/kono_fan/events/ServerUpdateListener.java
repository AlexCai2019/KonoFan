package kono_fan.events;

import kono_fan.utilities.IDAndEntities;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.events.guild.update.GuildUpdateNameEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class ServerUpdateListener extends ListenerAdapter
{
    @Override
    public void onGuildUpdateName(@NotNull GuildUpdateNameEvent event)
    {
        Guild guild = event.getGuild();
        if (guild.getIdLong() == IDAndEntities.KONO_FAN_SERVER)
            IDAndEntities.konoFanServerName = guild.getName();
    }
}