/*
   Copyright 2014 River Marmorstein

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
 */

package sexy.riveris.minerest;

import net.milkbowl.vault.chat.Chat;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.permission.Permission;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;


/**
 * Created by River on 22-Dec-14.
 */

public class MineRest extends JavaPlugin {

    private static Economy econ = null;
    private static Chat chat = null;
    private static Permission perms = null;

    @Override
    public void onLoad() {

    }

    @Override
    public void onEnable() {
        this.saveDefaultConfig();
        if(!this.getConfig().getBoolean("enable")) {
            getLogger().severe("Disabling MineRest. Set Disabled in the Configuration.");
            this.setEnabled(false);
        }
        if(this.getConfig().getString("key").equalsIgnoreCase("change me")) {
            getLogger().severe("Unable to load MineRest. Please update your API Key!");
            getLogger().severe("Without updating the API Key, anyone can access your API!");
            getLogger().severe("Disabling MineRest! Update your Config!");
            this.setEnabled(false);
        }

        try {
            setupVault();
        } catch (Exception ex) {
            ex.printStackTrace();
            getLogger().severe("Unable to load vault api features. Disabling integration with vault.");
        }
    }

    @Override
    public void onDisable() {

    }

    private void setupVault() throws Exception{
        RegisteredServiceProvider<Economy> economyProvider = getServer().getServicesManager().getRegistration(net.milkbowl.vault.economy.Economy.class);
        RegisteredServiceProvider<Chat> chatProvider = getServer().getServicesManager().getRegistration(net.milkbowl.vault.chat.Chat.class);
        RegisteredServiceProvider<Permission> permissionProvider = getServer().getServicesManager().getRegistration(net.milkbowl.vault.permission.Permission.class);

        if (economyProvider != null) {
            econ = economyProvider.getProvider();
        } else {
            throw new Exception("Unable to initialize Economy integration.. disabling this feature");
        }

        if (chatProvider != null) {
            chat = chatProvider.getProvider();
        } else {
            throw new Exception("Unable to initialize Chat integration.. disabling this feature.");
        }

        if (permissionProvider != null) {
            perms = permissionProvider.getProvider();
        } else {
            throw new Exception("Unable to initialize Permissions integration.. disabling this feature");
        }
    }
}
