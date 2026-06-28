package name.modid.gui;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

public class ClickGuiScreen extends Screen {

    private static final int COLUMN_COUNT = 5;
    private static final int COLUMN_GAP = 10;
    private static final int CORNER_RADIUS = 12;
    private static final int BG_COLOR = 0xCC1A2A1A; // тёмно-зелёный

    public ClickGuiScreen() {
        super(Component.literal("ClickGUI"));
    }

    @Override
    public void render(GuiGraphics context, int mouseX, int mouseY, float delta) {
        super.render(context, mouseX, mouseY, delta);

        int screenWidth = this.width;
        int screenHeight = this.height;

        int columnWidth = (screenWidth - COLUMN_GAP * (COLUMN_COUNT + 1)) / COLUMN_COUNT;
        int columnHeight = screenHeight - 40;
        int startX = COLUMN_GAP;
        int startY = 20;

        for (int i = 0; i < COLUMN_COUNT; i++) {
            int x = startX + i * (columnWidth + COLUMN_GAP);
            int y = startY;

            // В Mojang маппингах нет fillRounded, используем обычный залитый прямоугольник
            context.fill(x, y, x + columnWidth, y + columnHeight, BG_COLOR);
        }
    }

    @Override
    public boolean shouldPause() {
        return false;
    }

    @Override
    public boolean keyPressed(int keyCode, int scanCode, int modifiers) {
        if (keyCode == 344) { // правый Shift
            this.onClose();
            return true;
        }
        return super.keyPressed(keyCode, scanCode, modifiers);
    }
}
