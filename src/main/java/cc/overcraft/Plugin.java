package cc.overcraft;

import org.bukkit.plugin.java.JavaPlugin;

import javax.security.auth.login.LoginException;

public class Plugin extends JavaPlugin {

    @Override
    public void onEnable() {
        try {
            new Bot();
        } catch (LoginException e) {
            e.printStackTrace();
        }
    }
}
