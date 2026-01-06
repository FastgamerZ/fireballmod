
package it.tuonome.fireballmod;

import net.fabricmc.fabric.api.event.player.UseItemCallback;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.FireballEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class FireballAttack {

    public static void register() {
        UseItemCallback.EVENT.register(FireballAttack::onUse);
    }

    private static TypedActionResult<ItemStack> onUse(PlayerEntity player, World world, net.minecraft.util.Hand hand) {
        if (!world.isClient && world instanceof ServerWorld serverWorld) {
            Vec3d look = player.getRotationVec(1.0F);

            FireballEntity fireball = new FireballEntity(
                    serverWorld,
                    player,
                    look.x,
                    look.y,
                    look.z,
                    2
            );

            fireball.setPosition(
                    player.getX() + look.x,
                    player.getEyeY() - 0.1,
                    player.getZ() + look.z
            );

            serverWorld.spawnEntity(fireball);
        }
        return TypedActionResult.pass(player.getStackInHand(hand));
    }
}
