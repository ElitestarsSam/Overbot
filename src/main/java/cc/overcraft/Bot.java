package cc.overcraft;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;

import javax.security.auth.login.LoginException;

@Deprecated
public class Bot {

    public static JDA jda;

    Bot() throws LoginException {
        new JDABuilder()
                .setToken(Config.get("TOKEN"))
                .addEventListeners(new Listener())
                .setActivity(Activity.watching("Overcraft"))
                .build();
    }

    public static void main(String[] args) throws LoginException {
        new Bot();
    }
}
