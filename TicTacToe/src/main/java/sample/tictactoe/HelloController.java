package sample.tictactoe;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

import java.util.Arrays;

public class HelloController {

    @FXML
    private Label label00;

    @FXML
    private Label label01;

    @FXML
    private Label label02;

    @FXML
    private Label label10;

    @FXML
    private Label label11;

    @FXML
    private Label label12;

    @FXML
    private Label label20;

    @FXML
    private Label label21;

    @FXML
    private Label label22;

    @FXML
    private Text whosMove;

    @FXML
    void reset(MouseEvent event) {
        label00.setText("");
        label01.setText("");
        label02.setText("");
        label10.setText("");
        label11.setText("");
        label12.setText("");
        label20.setText("");
        label21.setText("");
        label22.setText("");

        for (int i = 0; i < 3; ++i)
            Arrays.fill(map[i], 0);
        counter = 0;
        setCurrentSymbol();
    }

    private String currentSymbol = "❌";
    private final int[][] map = new int[3][3];
    private int counter = 0;

    @FXML
    void initialize() {
        label00.setOnMousePressed(event -> {
            if (map[0][0] == 0){
                label00.setText(currentSymbol);
                setCurrentSymbol();
                counter++;
                addNumber(0, 0);
            }
        });
        label01.setOnMousePressed(event -> {
            if (map[0][1] == 0) {
                label01.setText(currentSymbol);
                setCurrentSymbol();
                counter++;
                addNumber(0, 1);
            }
        });
        label02.setOnMousePressed(event -> {
            if (map[0][2] == 0) {
                label02.setText(currentSymbol);
                setCurrentSymbol();
                counter++;
                addNumber(0, 2);
            }
        });
        label10.setOnMousePressed(event -> {
            if (map[1][0] == 0) {
                label10.setText(currentSymbol);
                setCurrentSymbol();
                counter++;
                addNumber(1, 0);
            }
        });
        label11.setOnMousePressed(event -> {
            if (map[1][1] == 0) {
                label11.setText(currentSymbol);
                setCurrentSymbol();
                counter++;
                addNumber(1, 1);
            }
        });
        label12.setOnMousePressed(event -> {
            if (map[1][2] == 0) {
                label12.setText(currentSymbol);
                setCurrentSymbol();
                counter++;
                addNumber(1, 2);
            }
        });
        label20.setOnMousePressed(event -> {
            if (map[2][0] == 0) {
                label20.setText(currentSymbol);
                setCurrentSymbol();
                counter++;
                addNumber(2, 0);
            }
        });
        label21.setOnMousePressed(event -> {
            if (map[2][1] == 0) {
                label21.setText(currentSymbol);
                setCurrentSymbol();
                counter++;
                addNumber(2, 1);
            }
        });
        label22.setOnMousePressed(event -> {
            if (map[2][2] == 0) {
                label22.setText(currentSymbol);
                setCurrentSymbol();
                counter++;
                addNumber(2, 2);
            }
        });
    }

    private void setCurrentSymbol(){
        changeCurrentSymbol();
        whosMove.setText(currentSymbol + " move");
    }

    private void changeCurrentSymbol() {
        if (currentSymbol.equals("❌"))
            currentSymbol = "⭕";
        else currentSymbol = "❌";
    }

    private void addNumber (int i, int j) {
        map[i][j] = currentSymbol.equals("❌") ? 1:2;

        if (counter == 9)
            draw();
        else if (counter >= 5)
            checkForWin();
    }

    private void checkForWin() {
        if ((map[0][0] != 3 && map[0][0] != 0) && (map[0][0] == map[1][1] && map[1][1] == map[2][2]))
            win();
        else if ((map[2][0] != 3 && map[2][0] != 0) && (map[2][0] == map[1][1] && map[1][1] == map[0][2]))
            win();

        for (int i = 0; i < 3; ++i){
            if ((map[i][0] != 3 && map[i][0] != 0) && (map[i][0] == map[i][1] && map[i][1] == map[i][2]))
                win();
            else if ((map[0][i] != 3 && map[0][i] != 0) && (map[0][i] == map[1][i] && map[1][i] == map[2][i]))
                win();
        }
    }

    private void win() {
        changeCurrentSymbol();
        whosMove.setText(currentSymbol + " WON!");
        gameStop();
    }

    private void draw() {
        whosMove.setText("DRAW!");
        gameStop();
    }

    private void gameStop () {
        for (int i = 0; i < 3; ++i)
            Arrays.fill(map[i], 3);
    }
}
