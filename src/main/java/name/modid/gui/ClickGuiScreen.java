package name.modid.gui;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;

public class ClickGuiScreen extends Screen {

    private static final int COLUMN_COUNT = 5;
    private static final int COLUMN_GAP = 10;
    private static final int CORNER_RADIUS = 12;
    private static final int BG_COLOR = 0xCC1A2A1A; // тёмно-зелёный
    private static final int BORDER_COLOR = 0xAA3A5A3A;

    public ClickGuiScreen() {
        super(Text.literal("ClickGUI"));
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        super.render(context, mouseX, mouseY, delta);

        int screenWidth = this.width;
        int screenHeight = this.height;

        // Считаем ширину колонки
        int columnWidth = (screenWidth - COLUMN_GAP * (COLUMN_COUNT + 1)) / COLUMN_COUNT;
        int columnHeight = screenHeight - 40; // небольшой отступ сверху/снизу
        int startX = COLUMN_GAP;
        int startY = 20;

        for (int i = 0; i < COLUMN_COUNT; i++) {
            int x = startX + i * (columnWidth + COLUMN_GAP);
            int y = startY;

            // Рисуем колонку с закруглёнными углами
            context.fillRounded(x, y, x + columnWidth, y + columnHeight, CORNER_RADIUS, BG_COLOR);

            // Можно добавить обводку (опционально)
            // context.fillRounded(x, y, x + columnWidth, y + columnHeight, CORNER_RADIUS, BORDER_COLOR);
        }
    }

    @Override
    public boolean shouldPause() {
        return false;
    }

    @Override
    public boolean keyPressed(int keyCode, int scanCode, int modifiers) {
        if (keyCode == 344) { // правый Shift
            this.close();
            return true;
        }
        return super.keyPressed(keyCode, scanCode, modifiers);
    }
}
