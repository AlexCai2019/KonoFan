package kono_fan;

import kono_fan.events.BotOnline;
import kono_fan.events.DirectMessageListener;
import kono_fan.events.MessageListener;
import kono_fan.events.commands.UseCommand;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.interactions.commands.DefaultMemberPermissions;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.requests.GatewayIntent;

public class KonoFan
{
    public static final long LOBBY_CHANNEL = 976460093950394388L;
    public static final long BOT_CHANNEL = 865186410787766292L;
    public static TextChannel lobbyChannel;
    public static TextChannel botChannel;

    public static void main(String[] args) throws InterruptedException
    {
        if (args.length < 1)
            return;

        JDA jda = JDABuilder.createDefault(args[0])
                .enableIntents(GatewayIntent.MESSAGE_CONTENT)
                .addEventListeners(new MessageListener(),
                                   new DirectMessageListener(),
                                   new UseCommand(),
                                   new BotOnline())
                .setActivity(Activity.watching("https://www.youtube.com/@alexcai3002"))
                .build();

        jda.updateCommands().addCommands(
                Commands.slash("help", "Get help."),
                Commands.slash("invite", "Get invite link of this group."),
                Commands.slash("megumin", "Get an image of the best anime girl."),
                Commands.slash("shutdown", "Use this to make the bot stop.")
                        .setDefaultPermissions(DefaultMemberPermissions.enabledFor(Permission.ADMINISTRATOR))
        ).queue();

        jda.awaitReady();
    }
}
