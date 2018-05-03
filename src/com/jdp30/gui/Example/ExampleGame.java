package com.jdp30.gui.Example;

import com.jdp30.gui.Elements.TextArea;
import com.jdp30.gui.Elements.TextButton;
import com.jdp30.gui.GUIArea;
import com.jdp30.gui.util.BasicGUIGame;
import com.jdp30.gui.util.NinePatchBuilder;
import org.newdawn.slick.*;

import java.util.Random;

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

    Image i = null, ii = null;

    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        GUIArea area = new GUIArea(0, 0, gameContainer.getWidth(), gameContainer.getHeight());


        area.addElement(new TextButton("Hello World!", 0, 0, NinePatchBuilder.getImage(new Image("res/button.png"), 6, 6, 200,75)));


        addGUIArea(area);


    }


    @Override
    public void update(GameContainer gameContainer, int fi) throws SlickException {
        super.update(gameContainer, fi);


    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        super.render(gameContainer, graphics);
    }
}
