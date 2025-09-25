package com.smilezyd.musichud;

import com.smilezyd.musichud.MusicHUDClient;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;

public final class Localization {
    
    public static String translationKey(String path) {
        return MusicHUDClient.MOD_ID + "." + path;
    }
    
    public static String translationKey(String domain, String path) {
        return domain + "." + MusicHUDClient.MOD_ID + "." + path;
    }
    
}

