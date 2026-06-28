package name.modid.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.KeyMapping;
import org.lwjgl.glfw.GLFW;
import name.modid.gui.ClickGuiScreen;

public class DusaruysClientClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        KeyMapping keyBinding = KeyBindingHelper.registerKeyBinding(new KeyMapping(
                "key.dusaruysclient.clickgui",
                GLFW.GLFW_KEY_RIGHT_SHIFT,
                "category.dusaruysclient"
        ));

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (keyBinding.consumeClick()) {
                if (client.screen instanceof ClickGuiScreen) {
                    client.setScreen(null);
                } else {
                    client.setScreen(new ClickGuiScreen());
                }
            }
        });
    }
}
