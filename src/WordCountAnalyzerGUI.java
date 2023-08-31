import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class WordCountAnalyzerGUI extends Application {
    private TextArea inputTextArea;
    private TextArea resultTextArea;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Word Count Analyzer");

        VBox root = new VBox();
        root.setSpacing(10);
        root.setPadding(new javafx.geometry.Insets(10));

        Label inputLabel = new Label("Enter text or provide a file:");
        inputTextArea = new TextArea();
        inputTextArea.setWrapText(true);
        inputTextArea.setPrefRowCount(5);

        Button analyzeButton = new Button("Analyze");
        analyzeButton.setOnAction(event -> analyzeInput());

        resultTextArea = new TextArea();
        resultTextArea.setEditable(false);
        resultTextArea.setWrapText(true);
        resultTextArea.setPrefRowCount(10);

        root.getChildren().addAll(inputLabel, inputTextArea, analyzeButton, resultTextArea);

        Scene scene = new Scene(root, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void analyzeInput() {
        String inputText = inputTextArea.getText();

        if (inputText.isEmpty()) {
            resultTextArea.setText("No input provided.");
            return;
        }

        String[] words = inputText.split("[\\s\\p{Punct}]+");
        int wordCount = words.length;

        StringBuilder result = new StringBuilder("Total word count: " + wordCount + "\n");

        Set<String> uniqueWords = new HashSet<>(Arrays.asList(words));
        result.append("Number of unique words: ").append(uniqueWords.size()).append("\n");

        Map<String, Integer> wordFrequency = new HashMap<>();
        for (String word : words) {
            wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
        }
        result.append("Word frequency:\n");
        for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
            result.append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
        }

        resultTextArea.setText(result.toString());
    }

    public static String readFileContent(String filePath) {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            // Todo remove this
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
        return content.toString();
    }
}
