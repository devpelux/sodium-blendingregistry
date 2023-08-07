package xyz.devpelux.sodium.blendingregistry.mixin;

import me.jellysquid.mods.sodium.client.model.quad.blender.ColorBlender;
import me.jellysquid.mods.sodium.client.render.pipeline.context.ChunkRenderCacheLocal;
import net.minecraft.client.MinecraftClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import xyz.devpelux.sodium.blendingregistry.core.ConfigurableColorBlender;

@Mixin(ChunkRenderCacheLocal.class)
public class MixinChunkRenderCacheLocal {
	private static final Logger LOGGER = LoggerFactory.getLogger("sodium-blendingregistry");

	//Replaces the default color blender with the configurable color blender.
	@SuppressWarnings("InvalidInjectorMethodSignature")
	@ModifyVariable(method = "<init>", at = @At("STORE"))
	private ColorBlender injectConfigurableColorBlender(ColorBlender value) {
		LOGGER.info("Changed sodium color blender with ConfigurableColorBlender. (LOCAL)");
		return new ConfigurableColorBlender(MinecraftClient.getInstance());
	}
}
