package com.smilezyd.musichud.musiclisteners;

//import internal packages
import com.smilezyd.musichud.musiclisteners.MusicHudData;
import com.smilezyd.musichud.MusicHUDClient;

//import external packages
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.Resource;
import net.minecraft.server.packs.resources.ResourceManager;
import org.jetbrains.annotations.Nullable;

//import java packages
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;

public class SpriteProvider {
    // Default sprite if we can’t resolve anything
    private static final ResourceLocation DISC_SPRITE_DEFAULT =
            ResourceLocation.withDefaultNamespace("textures/item/music_disc_cat.png");
    private String songTitle = MusicHudData.songTitle;
    
    /**
     * Given a sound location like "minecraft:music_disc.cat",
     * return the corresponding vanilla disc texture.
     */
    public static ResourceLocation getDiscSprite(ResourceLocation soundLocation) {
        try {
            
            String discId = soundLocation.getPath().replace("music_disc.", "");     // Strip "music_disc." → becomes "cat"

            return ResourceLocation.withDefaultNamespace("textures/item/music_disc_" + discId + ".png");     // Build texture path: textures/item/music_disc_cat.png
        } catch (Exception e) {
            
            return getDefaultSprite(MusicHUDClient.getMusicTitle(soundLocation));
            
        }
        
    }

    /**
     * If a match cannot be found, return a generic fallback.
     */
    public static ResourceLocation getDefaultSprite(String title) {
        if (title.contains("C418")) {
            return ResourceLocation.withDefaultNamespace("textures/item/music_disc_blocks.png");
        } else if (title.contains("Lena Raine")) {
            return ResourceLocation.withDefaultNamespace("textures/item/music_disc_otherside.png");
        } else if (title.contains("Aaron Cherof")) {
            return ResourceLocation.withDefaultNamespace("textures/item/music_disc_relic.png");
        } else if (title.contains("Kumi Tanioka")) {
            return ResourceLocation.withDefaultNamespace("textures/item/music_disc_mall.png");
        } else {
            return DISC_SPRITE_DEFAULT;
        }
    }

}

