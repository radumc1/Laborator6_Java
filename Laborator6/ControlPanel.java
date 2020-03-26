package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ControlPanel extends JPanel {
    final MainFrame frame;
    JButton saveBtn = new JButton("Save");
    JButton loadBtn = new JButton("Load");
    JButton resetBtn = new JButton("Reset");
    JButton exitBtn = new JButton("Exit");


    //create all buttons (Load, Reset, Exit)
 //...TODO
    public ControlPanel(MainFrame frame) {
        this.frame = frame; init();
    }
    private void init() {
        //change the default layout manager (just for fun)
        setLayout(new GridLayout(1, 4));
        add(saveBtn);
        add(resetBtn);
        add(loadBtn);
        add(exitBtn);
        //add all buttons ...TODO

        //configure listeners for all buttons
        saveBtn.addActionListener(this::save);
        loadBtn.addActionListener(this::load);
        resetBtn.addActionListener(this::reset);
        exitBtn.addActionListener(this::exit);

 //...TODO
    }

    private void exit(ActionEvent actionEvent) {
        System.exit(0);
    }

    private void reset(ActionEvent actionEvent) {

        frame.canvas.graphics.setColor(new Color(255,255,255));
        frame.canvas.graphics.fillRect(0,0,DrawingPanel.W,DrawingPanel.H);
        frame.repaint();

    }

    private void load(ActionEvent actionEvent)  {

        try {
            BufferedImage originalImage = ImageIO.read(new File("e:/test.png"));
            frame.canvas.graphics.drawImage(originalImage,0,0,this);
        } catch (IOException ex) { System.err.println(ex); }
    }
        


    private void save(ActionEvent e) {
        try {
            ImageIO.write(frame.canvas.image, "PNG", new File("e:/test.png"));
        } catch (IOException ex) { System.err.println(ex); }
    }
 //...TODO
}
