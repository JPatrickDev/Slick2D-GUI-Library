package com.jdp30.gui.Elements;


import com.jdp30.gui.GUIElement;
import org.newdawn.slick.*;


import java.awt.Font;
import java.util.HashMap;
import java.util.Random;

/**
 * Created by Jack on 21/04/2018.
 */
public class TextArea extends GUIElement {

    private String text;

    private Color backgroundColor, textColor;
    private Image backgroundImage;
    private float fontSize = -1f;
    public static HashMap<Float, Font> fontLookup = new HashMap<Float, Font>();
    private TrueTypeFont drawFont;

    public TextArea(String text, int x, int y, Image backgroundImage) {
        this(text, x, y, backgroundImage.getWidth(), backgroundImage.getHeight());
        this.backgroundImage = backgroundImage;
    }

    public TextArea(String text, int x, int y, int width, int height) {
        this(text, x, y, width, height, null, Color.black);
    }

    public TextArea(String text, int x, int y, int width, int height, Color backgroundColor, Color textColor) {
        super(x, y, width, height);
        this.text = text;
        this.backgroundColor = backgroundColor;
        this.textColor = textColor;
        setFontSize(12f);
    }

    private int tX = -1, tY = -1;

    @Override
    public void render(Graphics graphics) {
        org.newdawn.slick.Font backup = null;
        if(fontSize != -1 && drawFont != null){
            backup =graphics.getFont();
            graphics.setFont(drawFont);
        }
        if (tX == -1 && tY == -1) {
            tX = (getWidth() / 2) - (graphics.getFont().getWidth(text) / 2);
            tY = (getHeight() / 2) - (graphics.getFont().getLineHeight() / 2);
        }
        if (backgroundColor != null) {
            graphics.setColor(backgroundColor);
            graphics.fillRect(0, 0, getWidth(), getHeight());
        }
        if (backgroundImage != null) {
            graphics.drawImage(backgroundImage, 0, 0);
        }
        graphics.setColor(textColor);
        graphics.drawString(text, tX, tY);
        graphics.setColor(Color.white);

        graphics.setFont(backup);
    }


    @Override
    public void update(GameContainer container) {

    }

    public void setText(String newText) {
        this.text = newText;
        this.tX = -1;
        this.tY = -1;
    }

    public String getText() {
        return text;
    }


    Random r = new Random();

    @Override
    public void mouseLeave(int cMX, int cMY) {
        super.mouseLeave(cMX, cMY);

        //    this.backgroundColor = new Color(r.nextInt(255),r.nextInt(255),r.nextInt(255));
        //    this.textColor = new Color(r.nextInt(255),r.nextInt(255),r.nextInt(255));
    }

    @Override
    public void mouseEnter(int cMX, int cMY) {
        super.mouseEnter(cMX, cMY);
        //    this.backgroundColor = new Color(r.nextInt(255),r.nextInt(255),r.nextInt(255));
        //    this.textColor = new Color(r.nextInt(255),r.nextInt(255),r.nextInt(255));
    }

    public GUIElement setFontSize(float size) {
        this.fontSize = size;
        Font font = new Font("Verdana", Font.PLAIN, (int)size);
        TrueTypeFont ttf = new TrueTypeFont(font, true);
        this.drawFont = ttf;
        return this;
    }
}
