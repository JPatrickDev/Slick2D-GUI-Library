package com.jdp30.gui.Example;

import com.jdp30.gui.Elements.TextArea;
import com.jdp30.gui.GUIArea;
import com.jdp30.gui.util.BasicGUIGame;
import org.newdawn.slick.*;

/**
 * Created by Jack on 01/05/2018.
 */
public class ExampleGame extends BasicGUIGame {

    public ExampleGame(String title) {
        super(title);
    }

    public static void main(String[] args) throws SlickException {
        AppGameContainer agc = new AppGameContainer(new ExampleGame("Example"));
        agc.setDisplayMode(400, 400, false);
        agc.start();
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        GUIArea area = new GUIArea(0, 0, gameContainer.getWidth(), gameContainer.getHeight());

        for (int i = 0; i != 15; i++)
            area.addElement(new TextArea("Hello World!", 0, i * 30, area.getWidth(), 30, Color.magenta, Color.orange));

        addGUIArea(area);
    }

    @Override
    public void update(GameContainer gameContainer, int i) throws SlickException {
        super.update(gameContainer, i);
    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        super.render(gameContainer, graphics);
    }
}
