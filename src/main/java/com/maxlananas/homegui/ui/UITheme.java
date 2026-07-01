package com.maxlananas.homegui.ui;

/**
 * Palette de couleurs et constantes visuelles centralisées.
 * Modifier ici = modifier partout.
 */
public final class UITheme {

    private UITheme() {}

    // ── Fond ──────────────────────────────────────────────────────────────
    /** Fond d'écran global, très sombre avec légère transparence */
    public static final int BG_OVERLAY      = 0xD4050510;
    /** Fond du panneau principal */
    public static final int BG_PANEL        = 0xF0080818;
    /** Fond d'un élément secondaire (carte, rangée) */
    public static final int BG_ELEMENT      = 0xFF0D0D22;
    /** Fond d'un élément survolé */
    public static final int BG_HOVER        = 0xFF181832;
    /** Fond d'un élément cliqué / actif */
    public static final int BG_ACTIVE       = 0xFF1E1E42;

    // ── Texte ─────────────────────────────────────────────────────────────
    /** Texte principal */
    public static final int TEXT_PRIMARY    = 0xFFEEEEFF;
    /** Texte secondaire / subtil */
    public static final int TEXT_DIM        = 0xFF7777AA;
    /** Texte désactivé */
    public static final int TEXT_DISABLED   = 0xFF444466;

    // ── Accent ────────────────────────────────────────────────────────────
    /** Violet-bleu principal */
    public static final int ACCENT_PRIMARY  = 0xFF6C6CFF;
    /** Violet clair pour les titres */
    public static final int ACCENT_TITLE    = 0xFF9090FF;
    /** Lueur de l'accent (semi-transparent) */
    public static final int ACCENT_GLOW     = 0x336C6CFF;

    // ── Couleurs sémantiques ───────────────────────────────────────────────
    public static final int COLOR_GOLD      = 0xFFFFD700;
    public static final int COLOR_GOLD_DIM  = 0x55FFD700;
    public static final int COLOR_SILVER    = 0xFFB0B8C8;
    public static final int COLOR_BRONZE    = 0xFFCD7F32;
    public static final int COLOR_GREEN     = 0xFF44FF88;
    public static final int COLOR_RED       = 0xFFFF4444;

    // ── Bordures ──────────────────────────────────────────────────────────
    public static final int BORDER_NORMAL   = 0xFF252550;
    public static final int BORDER_ACCENT   = 0xFF4040A0;
    public static final int BORDER_GLOW     = 0x886C6CFF;

    // ── Boutons ───────────────────────────────────────────────────────────
    public static final int BTN_BG          = 0xFF10103A;
    public static final int BTN_BG_HOVER    = 0xFF1A1A50;
    public static final int BTN_BORDER      = 0xFF3A3A80;
    public static final int BTN_BORDER_FAV  = 0xFFB8860B;

    // ── Dimensions ────────────────────────────────────────────────────────
    public static final int PANEL_W         = 300;
    public static final int PAD             = 14;
    public static final int ROW_H           = 22;
    public static final int ROW_GAP         = 3;
    public static final int CORNER_R        = 3;
    public static final int HEADER_H        = 28;
    public static final int FOOTER_H        = 28;
    public static final int SCROLLBAR_W     = 4;
}
