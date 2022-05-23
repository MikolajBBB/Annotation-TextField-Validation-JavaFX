/*
 * Copyright (c) 2011, 2014 Oracle and/or its affiliates.
 * All rights reserved. Use is subject to license terms.
 *
 * This file is available and licensed under the following license:
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *  - Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 *  - Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in
 *    the documentation and/or other materials provided with the distribution.
 *  - Neither the name of Oracle nor the names of its
 *    contributors may be used to endorse or promote products derived
 *    from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package com.example.lab5;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;


public class Controller extends VBox{

    @FXML private ImageView image;
    @FXML private Button button;
    @FXML private TextField textfield;
    @FXML private Tooltip tool;

    String g;
    TestBean test = new TestBean(g);

    public Controller() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("custom_control.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
            button.setDisable(true);
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    @FXML
    void setInput() throws NoSuchFieldException, FileNotFoundException {

        g=textfield.getText();
        test.setName(g);
        PatternValidator patt = new PatternValidator();

        // create Field object
        Field field = TestBean.class
                .getDeclaredField("Validation");
        // apply getAnnotation()
        Pattern annotations = field
                .getAnnotation(Pattern.class);
        patt.validate(test.getName(),annotations);
        if(patt.isValid()){
            button.setDisable(false);
            InputStream stream = new FileInputStream("C:\\Users\\xXMik\\IdeaProjects\\lab5\\src\\main\\resources\\com\\example\\lab5\\zero.jpg");
            Image view = new Image(stream);
            image.setImage(view);
            tool.setText("Correct");


        }else{
            button.setDisable(true);
            InputStream stream = new FileInputStream("C:\\Users\\xXMik\\IdeaProjects\\lab5\\src\\main\\resources\\com\\example\\lab5\\jeden.jpg");
            Image view = new Image(stream);
            image.setImage(view);
            tool.setText(annotations.message());
            Tooltip.install(image, tool);
        }
    }


}
