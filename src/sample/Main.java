package sample;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Screen;
import javafx.stage.Stage;


/*
---------Sources-----------
1). -Getting screen size
    http://www.java2s.com/Code/Java/JavaFX/GetScreensize.htm
2). -Right click with popup menu
    https://o7planning.org/en/11115/javafx-contextmenu-tutorial
3). -Displaying Time
    https://stackoverflow.com/questions/38566638/javafx-displaying-time-and-refresh-in-every-second/38567319
4). -Right Click mouse event
    http://java-buddy.blogspot.com/2015/02/javafx-detect-right-click-on-mouse.html
5). -Context Menu
    https://o7planning.org/en/11115/javafx-contextmenu-tutorial
6). -Date Time format
    https://howtodoinjava.com/java/date-time/java8-datetimeformatter-example/
7).

 */
public class Main extends Application {
    @Override
    public void start(Stage stage) {

        Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
        final double SCREEN_X = primaryScreenBounds.getMinX() ;
        final double SCREEN_Y = primaryScreenBounds.getMinY();
        final double SCREEN_WIDTH = primaryScreenBounds.getWidth() ;
        final double SCREEN_HEIGHT = primaryScreenBounds.getHeight();

        Pane mainPortion = new Pane();
        mainPortion.setMinHeight(SCREEN_HEIGHT * .92);// 93 percent of screen
        BorderPane taskBar = new BorderPane();
        taskBar.setId("taskbar");
        taskBar.setMinHeight(SCREEN_HEIGHT * .08);// 7 percent of screen

        VBox desktop = new VBox();
        desktop.getChildren().addAll(mainPortion,taskBar);

        Label iconWin10 = new Label();
        iconWin10.setMinWidth(100);
        iconWin10.setMinHeight(SCREEN_HEIGHT * .05);
        iconWin10.setId("icon-win10");

        Time time = new Time();
        Label timeLabel = time.timeLabel();
        timeLabel.setId("time-label");
        timeLabel.setMinHeight(SCREEN_HEIGHT * .05);
        timeLabel.setPadding(new Insets(0,10,0,10));


        HBox leftTask = new HBox();
        HBox rightTask = new HBox();
        leftTask.getChildren().addAll(iconWin10);
        rightTask.getChildren().addAll(timeLabel);
        taskBar.setLeft(leftTask);
        taskBar.setRight(rightTask);

        Grid grid = new Grid();
        GridPane gridpane = grid.makeGrid(SCREEN_WIDTH,SCREEN_HEIGHT);
        mainPortion.getChildren().add(gridpane);
        gridpane.getStyleClass().add("pane");


        Scene scene = new Scene(desktop, 500, 200);
        scene.getStylesheets().add(getClass().getResource("/resources/styles.css").toExternalForm());
        stage.setScene(scene);
        stage.setX(SCREEN_X);
        stage.setY(SCREEN_Y);
        stage.setWidth(SCREEN_WIDTH);
        stage.setHeight(SCREEN_HEIGHT);
        stage.setResizable(false);
        stage.show();


        //event handlers
        Menu_Windows menu = new Menu_Windows();
        BorderPane menuPane = menu.makePane(SCREEN_WIDTH,SCREEN_HEIGHT);
        menuPane.setId("menu-win10");
        scene.addEventFilter(MouseEvent.MOUSE_RELEASED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if((event.getButton() == MouseButton.PRIMARY && iconWin10.isHover() && !mainPortion.getChildren().contains(menuPane))){
                    mainPortion.getChildren().add(menuPane);
                    event.consume();
                    System.out.println("2" + mainPortion.getChildren().contains(menuPane));
                }
                else{
                    mainPortion.getChildren().remove(menuPane);
                    event.consume();
                    if (event.getButton() == MouseButton.SECONDARY) {
                        Menu_Right menu = new Menu_Right();
                        menu.makeMenu().show(stage,event.getX(),event.getY());
                        event.consume();
                    }
                }
                event.consume();

            }
        });
    }
    public static void main(String[] args) {
        launch(args);
    }
}
