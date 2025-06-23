package com.jools.collections_;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/5/5 15:24
 * @description: TODO
 */
public class HTMLColorsTest {

    static final int DISPLAY_SIZE = 10;

    public static void main(String[] args) {
        HTMLColors.show(HTMLColors.MAP, DISPLAY_SIZE);
        HTMLColors.border();
        HTMLColors.showInv(HTMLColors.INVMAP, DISPLAY_SIZE);
        HTMLColors.border();
        HTMLColors.show(HTMLColors.LIST, DISPLAY_SIZE);
        HTMLColors.border();
        HTMLColors.showrgb(HTMLColors.RGBLIST, DISPLAY_SIZE);

        /*
         输出结果:
            0xF0F8FF: AliceBlue
            0xFAEBD7: AntiqueWhite
            0x7FFFD4: Aquamarine
            0xF0FFFF: Azure
            0xF5F5DC: Beige
            0xFFE4C4: Bisque
            0x000000: Black
            0xFFEBCD: BlanchedAlmond
            0x0000FF: Blue
            0x8A2BE2: BlueViolet
            ******************************
            AliceBlue             0xF0F8FF
            AntiqueWhite          0xFAEBD7
            Aquamarine            0x7FFFD4
            Azure                 0xF0FFFF
            Beige                 0xF5F5DC
            Bisque                0xFFE4C4
            Black                 0x000000
            BlanchedAlmond        0xFFEBCD
            Blue                  0x0000FF
            BlueViolet            0x8A2BE2
            ******************************
            AliceBlue
            AntiqueWhite
            Aquamarine
            Azure
            Beige
            Bisque
            Black
            BlanchedAlmond
            Blue
            BlueViolet
            ******************************
            0xF0F8FF
            0xFAEBD7
            0x7FFFD4
            0xF0FFFF
            0xF5F5DC
            0xFFE4C4
            0x000000
            0xFFEBCD
            0x0000FF
            0x8A2BE2
         */
    }
}
