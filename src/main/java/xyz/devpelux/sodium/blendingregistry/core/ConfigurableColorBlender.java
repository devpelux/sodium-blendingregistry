package xyz.devpelux.sodium.blendingregistry.core;

import me.jellysquid.mods.sodium.client.model.quad.ModelQuadView;
import me.jellysquid.mods.sodium.client.model.quad.blender.ColorBlender;
import me.jellysquid.mods.sodium.client.model.quad.blender.ColorSampler;
import me.jellysquid.mods.sodium.client.model.quad.blender.FlatColorBlender;
import me.jellysquid.mods.sodium.client.model.quad.blender.LinearColorBlender;
import net.minecraft.block.BlockState;
import net.minecraft.client.MinecraftClient;
import net.minecraft.fluid.FluidState;
import net.minecraft.state.State;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockRenderView;
import xyz.devpelux.sodium.blendingregistry.DefaultBlockColorSettings;

/**
 * Configurable color blender.
 */
public class ConfigurableColorBlender implements ColorBlender {
	private final ColorBlender flatBlender;
	private final ColorBlender smoothBlender;

	/**
	 * Initialized a new instance with the specified client.
	 */
	public ConfigurableColorBlender(MinecraftClient client) {
		this.flatBlender = new FlatColorBlender();
		this.smoothBlender = isSmoothBlendingEnabled(client) ? new LinearColorBlender() : this.flatBlender;
	}

	/**
	 * Gets the color array.
	 */
	@Override
	public <T> int[] getColors(BlockRenderView world, BlockPos origin, ModelQuadView quad, ColorSampler<T> sampler, T state) {
		ColorBlender blender;

		//Select the correct color blender basing on the specified block or fluid.
		//By default, the flat blender is used.
		if (state instanceof State<?, ?> s && isSmoothBlendingEnabled(s)) {
			blender = this.smoothBlender;
		} else {
			blender = this.flatBlender;
		}

		return blender.getColors(world, origin, quad, sampler, state);
	}

	/**
	 * Returns a value indicating if the current block in the current position has smooth blending enabled.
	 */
	private static boolean isSmoothBlendingEnabled(State<?, ?> state) {
		//Checks if the specified block or fluid has smooth blending enabled.
		if (state instanceof BlockState blockState) {
			return DefaultBlockColorSettings.isSmoothBlendingAvailable(blockState.getBlock());
		} else if (state instanceof FluidState fluidState) {
			return DefaultBlockColorSettings.isSmoothBlendingAvailable(fluidState.getFluid());
		}

		return false;
	}

	/**
	 * Returns a value indicating if the current client has smooth blending enabled.
	 */
	private static boolean isSmoothBlendingEnabled(MinecraftClient client) {
		return client.options.getBiomeBlendRadius().getValue() > 0;
	}
}
