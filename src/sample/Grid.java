package sample;

import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

public class Grid {
    public GridPane makeGrid(double screenWidth, double screenHeight){
        final double width = screenWidth/27;
        final double height = screenHeight/10;

        GridPane pane = new GridPane();

        Label zeroZero = new Label();
        zeroZero.setMinHeight(height);
        zeroZero.setMinWidth(width);
        zeroZero.setId("icon");

        pane.add(zeroZero,0,0);


        return pane;
    }
}
