package com.smilezyd.musichud.musiclisteners;

//import internal packages
import com.smilezyd.musichud.MusicHUDClient;
import com.smilezyd.musichud.musiclisteners.MusicHudData;

//import external packages
import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.client.sounds.SoundEventListener;
import net.minecraft.client.sounds.WeighedSoundEvents;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;

public class ClientMusicListner implements SoundEventListener {
    
    @Override
    public void onPlaySound(@NotNull SoundInstance soundInstance, @NotNull WeighedSoundEvents soundSet, float f) {
        
        if (soundInstance.getSource() == SoundSource.MUSIC) {
            
            ResourceLocation location = soundInstance.getSound().getLocation();

            Component rawTitle = MusicHUDClient.getTranslatedTitle(location.toString());
            MusicHudData.songTitle = rawTitle.getString();
                    
            MusicHudData.currentSong = location.getPath();

        }
        
    }
    
}

