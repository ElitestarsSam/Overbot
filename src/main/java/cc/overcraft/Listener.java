package cc.overcraft;

import me.duncte123.botcommons.BotCommons;
import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Listener extends ListenerAdapter {

    private static final Logger LOGGER = LoggerFactory.getLogger(Listener.class);

    @Override
    public void onReady(@NotNull ReadyEvent event) {
        LOGGER.info("{} is ready", event.getJDA().getSelfUser().getAsTag());
    }

    @Override
    public void onGuildMessageReceived(@NotNull GuildMessageReceivedEvent event) {
        String prefix = Config.get("PREFIX");
        String raw = event.getMessage().getContentRaw();
        if (raw.equalsIgnoreCase(prefix + "shutdown")
                && event.getAuthor().getId().equals(Config.get("ELITE_ID"))
                || event.getAuthor().getId().equals(Config.get("XCII_ID"))) {
            LOGGER.info("Shut down by " + event.getAuthor().getAsTag());
            event.getJDA().shutdown();
            BotCommons.shutdown(event.getJDA());
        }
    }
}
