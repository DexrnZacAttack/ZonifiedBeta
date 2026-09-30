package me.dexrn.zonifiedbeta.mixin;

import net.minecraft.world.level.chunk.storage.ChunkStorage;
import net.minecraft.world.level.chunk.storage.ZonedChunkStorage;
import net.minecraft.world.level.dimension.Dimension;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import java.io.File;

@Mixin(Dimension.class)
public class DimensionMixin {
    /**
     * @author DexrnZacAttack
     * @reason create ZonedChunkStorage instead of OldChunkStorage
     */
    @Overwrite
    public ChunkStorage createStorage(File file) {
        return new ZonedChunkStorage(file);
    }
}
