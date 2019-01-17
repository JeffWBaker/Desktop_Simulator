package sample;

import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCombination;

public class Menu_Right {
    public ContextMenu makeMenu(){
        ContextMenu rightClickMenu = new ContextMenu();

        Menu view = new Menu("View");
        RadioMenuItem large = new RadioMenuItem("Large");
        RadioMenuItem medium = new RadioMenuItem("Medium");
        RadioMenuItem small = new RadioMenuItem("Small");
        SeparatorMenuItem line = new SeparatorMenuItem();
        CheckMenuItem auto = new CheckMenuItem("Auto arrange icons");
        CheckMenuItem allign = new CheckMenuItem("Allign icons to grid");
        SeparatorMenuItem line2 = new SeparatorMenuItem();
        CheckMenuItem show = new CheckMenuItem("Show desktop icons");
        view.getItems().addAll(large,medium,small,line,auto,allign,line2,show);

        Menu sort = new Menu("Sort");
        MenuItem name = new MenuItem("Name");
        MenuItem size = new MenuItem("Size");
        MenuItem itemType = new MenuItem("Item Type");
        MenuItem dateMod = new MenuItem("Date Modified");
        sort.getItems().addAll(name,size,itemType,dateMod);

        MenuItem refresh = new MenuItem("Refresh");
        SeparatorMenuItem line3 = new SeparatorMenuItem();

        MenuItem paste = new MenuItem("Paste");
        MenuItem pasteShortcut = new MenuItem("Paste shortcut");
        MenuItem undo = new MenuItem("Undo");
        undo.setAccelerator(KeyCombination.keyCombination("Ctrl + Z"));
        MenuItem openVS = new MenuItem("Open in Visual Studio");
        MenuItem openBracket = new MenuItem("Open as Brackets project");
        Image openIcon = new Image(getClass().getResourceAsStream("/resources/bracketsIcon.png"));
        ImageView openView = new ImageView(openIcon);
        openView.setFitWidth(20);
        openView.setFitHeight(20);
        openBracket.setGraphic(openView);
        MenuItem gitGUI = new MenuItem("Git GUI Here");
        Image gitIcon = new Image(getClass().getResourceAsStream("/resources/icon_git.png"));
        ImageView gitView = new ImageView(gitIcon);
        gitView.setFitWidth(20);
        gitView.setFitHeight(20);
        gitGUI.setGraphic(gitView);
        MenuItem gitBash = new MenuItem("Git Bash Here");
        gitBash.setGraphic(openView);
        SeparatorMenuItem line4 = new SeparatorMenuItem();
        MenuItem graphicsProp = new MenuItem("Graphics Properties...");
        Image graphicsIcon = new Image(getClass().getResourceAsStream("/resources/icon_intel.png"));
        ImageView graphicsView = new ImageView(graphicsIcon);
        graphicsView.setFitWidth(20);
        graphicsView.setFitHeight(20);
        graphicsProp.setGraphic(graphicsView);
        //Menu graphicsOpt = new Menu("Graphics Options");

        MenuItem nvidia = new MenuItem("NVIDIA Control Panel");
        Image nvidiaIcon = new Image(getClass().getResourceAsStream("/resources/icon_nvidia.png"));
        ImageView nvidiaView = new ImageView(nvidiaIcon);
        nvidiaView.setFitWidth(20);
        nvidiaView.setFitHeight(20);
        nvidia.setGraphic(nvidiaView);
        SeparatorMenuItem line5 = new SeparatorMenuItem();

        Menu neww = new Menu("New");
        MenuItem folder = new MenuItem("Folder");
        MenuItem shortcut = new MenuItem("Shortcut");
        SeparatorMenuItem line7 = new SeparatorMenuItem();


        SeparatorMenuItem line6 = new SeparatorMenuItem();
        MenuItem displaySett = new MenuItem("Display settings");
        Image displayIcon = new Image(getClass().getResourceAsStream("/resources/icon_displaySettings.png"));
        ImageView displayView = new ImageView(displayIcon);
        displayView.setFitWidth(20);
        displayView.setFitHeight(20);
        displaySett.setGraphic(displayView);
        MenuItem personalize = new MenuItem("Personalize");
        Image personalizeIcon = new Image(getClass().getResourceAsStream("/resources/icon_personalize.png"));
        ImageView personalizeView = new ImageView(personalizeIcon);
        personalizeView.setFitWidth(20);
        personalizeView.setFitHeight(20);
        personalize.setGraphic(openView);

        rightClickMenu.getItems().addAll(view,sort,refresh,line3,paste,pasteShortcut,undo,openVS,openBracket,gitGUI,gitBash,line4,graphicsProp,nvidia,line5,neww,line6,displaySett,personalize);
        return rightClickMenu;
    }
}
