package com.smilezyd.musichud;

import static com.smilezyd.musichud.Localization.translationKey;

import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.network.chat.Component;

public class MusicHUDClient implements ClientModInitializer {
	
    public static final String MOD_ID = "musichud";
    
    
    public static Component getTranslatedTitle(String location) {
        
        String key = Localization.translationKey(location);
        if (!I18n.exists(key)) {
            String[] splitLocation = location.split("/");
            if (splitLocation.length > 0) {
                String name = splitLocation[splitLocation.length -1];
                if (name != null && !name.isBlank()) {
                    String oldKey = Localization.translationKey("music", name);
                    if (I18n.exists(oldKey)) {
                        return Component.translatable(oldKey);
                    }
                    
                }
                
            }
            
        }
        
        return Component.translatable(key);
        
    }
    
    
    @Override
	public void onInitializeClient() {
        
        
        
        
        
        
        
        
        
        
        
        
	}
    
}
