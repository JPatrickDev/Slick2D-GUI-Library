package com.jdp30.gui.Elements;

import com.jdp30.gui.GUIArea;
import com.jdp30.gui.GUIElement;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

import java.util.ArrayList;

public class List extends GUIElement {

    private float scroll_pos = 0;

    private ArrayList<GUIArea> views = new ArrayList<>();
    private ArrayList<Object> data = new ArrayList<>();
    private ListElement adapter;
    private SelectListener selectListener;

    public List(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    @Override
    public void render(Graphics graphics) {
        int y_pos = 0;
        for (GUIArea area : views) {
            graphics.translate(0, y_pos);
            area.render(graphics);
            graphics.translate(0, -y_pos);
            y_pos += area.getHeight();
        }
    }

    public void setData(ArrayList<Object> data) {
        this.data = data;
        views.clear();
        for (Object obj : data) {
            if (obj == null)
                continue;
            views.add(adapter.getElement(obj, getWidth(), 60));
        }
    }

    @Override
    public void update(GameContainer container) {

    }


    public SelectListener getSelectListener() {
        return selectListener;
    }

    public void setSelectListener(SelectListener selectListener) {
        this.selectListener = selectListener;
    }

    public ListElement getAdapter() {
        return adapter;
    }

    public void setAdapter(ListElement adapter) {
        this.adapter = adapter;
    }

    @Override
    public void mouseDown(int x, int y, int button) {
        super.mouseDown(x, y, button);
        x = x - this.getX();
        y = y - this.getY();
        int yPos = y / 60;
        try {
            Object obj = data.get(yPos);
            if (this.getSelectListener() != null) {
                getSelectListener().selected(obj, views.get(yPos));
            }
        } catch (Exception e) {

        }
    }

    public abstract static class ListElement {
        public abstract GUIArea getElement(Object data, int width, int height);
    }

    public abstract static class SelectListener {
        public abstract void selected(Object object, GUIArea area);
    }
}
