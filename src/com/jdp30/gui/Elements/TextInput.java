package com.jdp30.gui.Elements;

import com.jdp30.gui.GUIElement;
import org.lwjgl.input.Keyboard;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

/**
 * Created by Jack on 04/05/2018.
 */
public class TextInput extends GUIElement {

    private String data = "";

    public TextInput(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    int i = 0;
    int j = 0;

    @Override
    public void render(Graphics graphics) {
        graphics.setColor(Color.red);
        if (i > 40) {
            graphics.drawString(getDisplayText() + ".", 0, 0);
            if (j >= 15) {
                i = 0;
                j = 0;
            }
            j++;
        } else {
            graphics.drawString(getDisplayText(), 0, 0);
        }
        i++;
        graphics.setColor(Color.white);
    }

    @Override
    public void update(GameContainer container) {
        System.out.println(getText());
    }

    @Override
    public void keyPressed(char c, int code) {
        super.keyPressed(c, code);
        if (c == Character.MIN_VALUE)
            return;
        if (code == Keyboard.KEY_RETURN) {
            data += "\n";
        } else if (code == Keyboard.KEY_BACK) {
            if (data.length() >= 1)
                data = data.substring(0, data.length() - 1);
        } else {
            data += c;
        }
    }

    public String getDisplayText() {
        return this.data;
    }

    public String getText() {
        return this.data;
    }
}
