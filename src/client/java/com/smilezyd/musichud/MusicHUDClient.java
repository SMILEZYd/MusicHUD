package com.smilezyd.musichud;

import com.smilezyd.musichud.hud.MusicHudOverlay;
import com.smilezyd.musichud.musiclisteners.MusicHudData;
import com.smilezyd.musichud.musiclisteners.ClientMusicListner;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientLifecycleEvents;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.network.chat.Component;

public class MusicHUDClient implements ClientModInitializer {
	
    public static final String MOD_ID = "musichud";
    
    public static String nameFromPath(String path) {
        String name = I18n.get(path);
        return name;
    }
    
    public static String getMusicTitle(ResourceLocation location) {
        
        String path = location.getPath();
        if (path.contains("records")) {
            String[] splitName = path.split("/");
            String recordName = splitName[splitName.length - 1];
            MusicHudData.key = "jukebox_song.minecraft." + recordName;
        }
        else {
            MusicHudData.key = "musichud.lang:" + path;
        }
        
        String name = nameFromPath(MusicHudData.key);
        return name;
        
    }
    
    
    @Override
	public void onInitializeClient() {
        
        ClientLifecycleEvents.CLIENT_STARTED.register(client -> {
            client.getSoundManager().addListener(new ClientMusicListner());
        });
        
        MusicHudOverlay.register();
        
        
	}
    
}
