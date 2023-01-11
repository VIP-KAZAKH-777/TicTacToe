module sample.tictactoe {
    requires javafx.controls;
    requires javafx.fxml;


    opens sample.tictactoe to javafx.fxml;
    exports sample.tictactoe;
}