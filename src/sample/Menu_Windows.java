package sample;

import javafx.scene.control.ContextMenu;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class Menu_Windows {
    public BorderPane makePane(double width, double height){
        BorderPane pane = new BorderPane();
            VBox left = new VBox();

            VBox middle = new VBox();

            VBox right = new VBox();

        left.setMaxWidth(100);
        left.setMinWidth(100);
        pane.setLeft(left);

        ScrollPane middleScroll = new ScrollPane();
        middleScroll.setContent(middle);
        middleScroll.setMaxWidth(400);
        middleScroll.setMinWidth(400);
        pane.setCenter(middleScroll);


        ScrollPane rightScroll = new ScrollPane();
        rightScroll.setContent(right);
        rightScroll.setMaxWidth(700);
        rightScroll.setMinWidth(700);
        pane.setRight(rightScroll);


        pane.setMinHeight(600);
        pane.setMaxHeight(600);
        pane.setLayoutX(0);
        pane.setLayoutY(600);
        return pane;
    }
}
