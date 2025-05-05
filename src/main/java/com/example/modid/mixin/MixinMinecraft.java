package com.example.modid.mixin;

import net.minecraft.client.Minecraft;
import org.apache.logging.log4j.Logger;
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.PixelFormat;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

/**
 * @author 小坤
 * @since 2025/5/5 18:25
 */
@Mixin(Minecraft.class)
public class MixinMinecraft {

    @Shadow
    @Final
    private static Logger LOGGER;

    @Shadow
    private boolean fullscreen;

    /**
     * @author 小坤
     * @reason 修改窗口标题
     */
    @Overwrite
    private void createDisplay() throws LWJGLException {
        Display.setResizable(true);
        Display.setTitle("Test Client");
        try {
            Display.create((new PixelFormat()).withDepthBits(24));
        } catch (LWJGLException lwjglexception) {
            LOGGER.error("Couldn't set pixel format", lwjglexception);
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException ignored) {
            }
            if (this.fullscreen) {
                this.updateDisplayMode();
            }
            Display.create();
        }
    }

    @Shadow
    private void updateDisplayMode() {
    }
}
