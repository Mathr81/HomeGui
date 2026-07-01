package com.maxlananas.homegui.screen;

import com.maxlananas.homegui.HomesManager;
import com.maxlananas.homegui.config.LangManager;
import com.maxlananas.homegui.config.ModConfig;
import com.maxlananas.homegui.widget.StyledButton;
import com.maxlananas.homegui.widget.Theme;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

import java.util.List;

public class HistoryScreen extends Screen {

    private static final int PANEL_W = 280;

    private final Screen parent;
    private boolean needsRebuild = true;

    public HistoryScreen(Screen parent) {
        super(Component.literal("History"));
        this.parent = parent;
    }

    @Override
    protected void init() { needsRebuild = true; }

    @Override
    public void tick() {
        if (needsRebuild) { needsRebuild = false; rebuildUI(); }
    }

    private void rebuildUI() {
        clearWidgets();
        LangManager L = LangManager.getInstance();

        int panelX = width / 2 - PANEL_W / 2;
        int pad = 12;
        int listY = 52;

        List<ModConfig.HistoryEntry> history = ModConfig.getInstance().getHistory();
        int max = Math.min(history.size(), 12);

        for (int i = 0; i < max; i++) {
            final ModConfig.HistoryEntry entry = history.get(i);
            int y = listY + i * 26;
            String label = (i + 1) + ". " + entry.homeName;

            addRenderableWidget(new StyledButton(panelX + pad, y, PANEL_W - pad * 2 - 50, 22, label,
                    () -> {
                        ModConfig.getInstance().incrementUseCount(entry.homeName);
                        ModConfig.getInstance().addToHistory(entry.homeName);
                        HomesManager.getInstance().teleportToHome(entry.homeName);
                    }));

            // Time ago label (non-clickable, drawn in render)
        }

        int panelH = height - 50;
        int btnY = 20 + panelH - 24;
        int bW = 90;
        int clearX = panelX + (PANEL_W / 2) - bW - 6;
        int backX  = panelX + (PANEL_W / 2) + 6;

        addRenderableWidget(new StyledButton(clearX, btnY, bW, 18, L.get("button.clear"),
                () -> { ModConfig.getInstance().clearHistory(); needsRebuild = true; },
                Theme.BTN, 0xFF3A1A1A, Theme.DANGER, Theme.DIM, Theme.DANGER));

        addRenderableWidget(new StyledButton(backX, btnY, bW, 18, L.get("button.back"),
                () -> { if (minecraft != null) minecraft.setScreen(parent); }));
    }

    @Override
    public void render(GuiGraphics g, int mouseX, int mouseY, float delta) {
        LangManager L = LangManager.getInstance();
        Font f = font;

        g.fill(0, 0, width, height, Theme.BG);

        int panelX = width / 2 - PANEL_W / 2;
        int panelY = 20;
        int panelH = height - 50;

        Theme.drawPanel(g, panelX, panelY, PANEL_W, panelH);
        Theme.drawTextCentered(g, f, "⟳ " + L.get("title.history"),
                width / 2, panelY + 10, Theme.ACCENT);

        // Time ago overlays
        List<ModConfig.HistoryEntry> history = ModConfig.getInstance().getHistory();
        int listY = 52;
        int pad = 12;
        for (int i = 0; i < Math.min(history.size(), 12); i++) {
            ModConfig.HistoryEntry e = history.get(i);
            int y = listY + i * 26;
            g.drawString(f, Component.literal("§8" + e.getTimeAgo()),
                    panelX + PANEL_W - pad - 44, y + 7, Theme.FAINT);
        }

        if (history.isEmpty()) {
            Theme.drawTextCentered(g, f, "§7☁  " + L.get("message.no_history"),
                    width / 2, panelY + 80, Theme.DIM);
        }

        super.render(g, mouseX, mouseY, delta);
    }

    @Override
    public void onClose() { if (minecraft != null) minecraft.setScreen(parent); }

    @Override
    public boolean isPauseScreen() { return false; }
}
