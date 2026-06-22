package com.example.homegui.screen;

import com.example.homegui.HomesManager;
import com.example.homegui.config.LangManager;
import com.example.homegui.config.ModConfig;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;

import java.util.List;

public class HistoryScreen extends Screen {

    private static final int COLOR_BG     = 0xEE0A0A1A;
    private static final int COLOR_PANEL  = 0xDD121228;
    private static final int COLOR_ACCENT = 0xFF5B5BFF;
    private static final int COLOR_TEXT   = 0xFFE0E0FF;
    private static final int COLOR_DIM    = 0xFF8888AA;
    private static final int COLOR_BORDER = 0xFF3A3A7A;
    private static final int COLOR_BTN    = 0xFF1E1E3F;
    private static final int COLOR_ENTRY  = 0xFF1A1A3A;
    private static final int COLOR_HOVER  = 0xFF2A2A5A;

    private final Screen parent;
    private int hoveredIndex = -1;

    public HistoryScreen(Screen parent) {
        super(Text.literal("History"));
        this.parent = parent;
    }

    @Override
    public void render(DrawContext ctx, int mouseX, int mouseY, float delta) {
        ctx.fill(0, 0, width, height, COLOR_BG);

        int panelX = width / 2 - 130;
        int panelW = 260;
        int panelY = 20;
        int panelH = height - 50;

        // Panneau
        ctx.fill(panelX, panelY, panelX + panelW, panelY + panelH, COLOR_PANEL);
        ctx.fill(panelX, panelY, panelX + panelW, panelY + 1, COLOR_BORDER);
        ctx.fill(panelX, panelY + panelH - 1, panelX + panelW, panelY + panelH, COLOR_BORDER);
        ctx.fill(panelX, panelY, panelX + 1, panelY + panelH, COLOR_BORDER);
        ctx.fill(panelX + panelW - 1, panelY, panelX + panelW, panelY + panelH, COLOR_BORDER);

        // Titre
        String title = LangManager.getInstance().get("title.history");
        ctx.drawCenteredTextWithShadow(textRenderer,
                Text.literal("⟳ " + title), width / 2, panelY + 8, COLOR_ACCENT);

        List<ModConfig.HistoryEntry> history = ModConfig.getInstance().getHistory();
        hoveredIndex = -1;
        int y = panelY + 26;

        if (history.isEmpty()) {
            ctx.drawCenteredTextWithShadow(textRenderer,
                    Text.literal("§7" + LangManager.getInstance().get("message.no_history")),
                    width / 2, y + 20, COLOR_DIM);
        } else {
            for (int i = 0; i < history.size() && i < 12; i++) {
                ModConfig.HistoryEntry entry = history.get(i);
                int bX = panelX + 12;
                int bW = panelW - 24;
                int bH = 22;

                boolean hov = mouseX >= bX && mouseX <= bX + bW
                        && mouseY >= y 
