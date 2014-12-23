package sexy.riveris.minerest;

import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by River on 22-Dec-14.
 */

public class MineRest extends JavaPlugin {

    @Override
    public void onLoad() {

    }

    @Override
    public void onEnable() {
        this.saveDefaultConfig();
        if(this.getConfig().getString("key").equalsIgnoreCase("change me")) {
            getLogger().severe("Unable to load MineRest. Please update your API Key!");
            getLogger().severe("Without updating the API Key, anyone can access your API!");
            getLogger().severe("Disabling MineRest! Update your Config!");
            this.setEnabled(false);
        }
    }

    @Override
    public void onDisable() {

    }
}
