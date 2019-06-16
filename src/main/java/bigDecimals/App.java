package bigDecimals;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class App extends Application {

    private HBox hBox = new HBox();

    private TextArea a = new TextArea();
    private TextArea b = new TextArea();
    private TextArea c = new TextArea();
    private TextArea d = new TextArea();

    private TextArea output = new TextArea();

    private Label aLabel = new Label("Wsp. a");
    private Label bLabel = new Label("Wsp. b");
    private Label cLabel = new Label("Wsp. c");
    private Label dLabel = new Label("Wsp. d");

    private Cubic cubic = new Cubic();

    private Button solve = new Button("Rozwiaz!");

    private GridPane createPane() {
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(20, 20, 20, 20));
        pane.setHgap(10);
        pane.setVgap(10);
        return pane;
    }

    private void setUIControls(GridPane pane, Stage primaryStage) throws Exception {

        a.setMaxSize(200, 20);
        b.setMaxSize(200, 20);
        c.setMaxSize(200, 20);
        d.setMaxSize(200, 20);

        aLabel.setMaxSize(200, 20);
        bLabel.setMaxSize(200, 20);
        cLabel.setMaxSize(200, 20);
        dLabel.setMaxSize(200, 20);

        //output.setMaxSize(200, 20);

        pane.add(a, 1 , 0);
        pane.add(b, 1 , 1);
        pane.add(c, 1 , 2);
        pane.add(d, 1 , 3);

        pane.add(aLabel, 0 , 0);
        pane.add(bLabel, 0 , 1);
        pane.add(cLabel, 0 , 2);
        pane.add(dLabel, 0 , 3);

        pane.add(output,0,4,2,1);

        pane.add(solve, 0,5);

        solve.setOnAction(e -> {
            cubic.solve(Double.valueOf(a.getText()),Double.valueOf(b.getText()),Double.valueOf(c.getText()),Double.valueOf(d.getText()));
            output.setText(cubic.getResultString());
        });

    }

    @Override
    public void start(final Stage primaryStage) throws Exception {



        GridPane gridPane = createPane();
        setUIControls(gridPane, primaryStage);
        primaryStage.setScene(new Scene(gridPane, 1000, 500));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
