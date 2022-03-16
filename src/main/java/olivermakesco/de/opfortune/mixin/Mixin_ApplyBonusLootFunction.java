package olivermakesco.de.opfortune.mixin;

import net.minecraft.loot.function.ApplyBonusLootFunction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Random;

@Mixin(targets = {"net/minecraft/loot/function/ApplyBonusLootFunction$OreDrops"})
public class Mixin_ApplyBonusLootFunction {
    @Inject(at=@At("RETURN"), method = "Lnet/minecraft/loot/function/ApplyBonusLootFunction$OreDrops;getValue(Ljava/util/Random;II)I", cancellable = true)
    private void maxOutFortune(Random random, int initialCount, int enchantmentLevel, CallbackInfoReturnable<Integer> cir) {
        if (enchantmentLevel < 0) return;

        cir.setReturnValue(initialCount * (enchantmentLevel + 1));
    }
}
