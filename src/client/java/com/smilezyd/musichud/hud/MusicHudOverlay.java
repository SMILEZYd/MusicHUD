package com.smilezyd.musichud.hud;

import com.smilezyd.musichud.musiclisteners.MusicHudData;

import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.renderer.RenderType;

public class MusicHudOverlay {
    public static void register() {
        HudRenderCallback.EVENT.register((guiGraphics, tickDelta) -> {
            Minecraft mc = Minecraft.getInstance();

            if (!MusicHudData.songTitle.isEmpty()) {
                // Draw text: "Author - Title"
                String text = MusicHudData.songTitle;
                
                guiGraphics.drawString(mc.font, text, 10, 10, 0xFFFFFF, true);

                // Draw disc sprite (if present)
                if (MusicHudData.currentDiscSprite != null) {
                    guiGraphics.blit(
                        RenderType::guiTextured,
                        MusicHudData.currentDiscSprite,
                        10, 25,   // X, Y position
                        0, 0,     // U, V texture offset
                        16, 16,   // width, height
                        16, 16    // texture sheet size
                    );
                }
            }
        });
    }
}

