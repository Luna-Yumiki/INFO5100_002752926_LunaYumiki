package com.example.finalproject;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HelloApplication extends Application {
    final private List<File> loadedImages = new ArrayList<>();
    private File selectedDirectory;
    final private List<String> supportedFormats = Arrays.asList("png", "jpg", "gif", "tiff"); // Add more supported formats

    final private Label conversionStatus = new Label();


    @Override
    public void start(Stage primaryStage) {
        // Create a FileChooser for selecting images
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select Image Files");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif", "*.tiff")
        );

        // Load images button
        Button loadImagesButton = new Button("Load Images");
        loadImagesButton.setOnAction(e -> {
            // Show open file dialog
            loadedImages.clear();
            fileChooser.setTitle("Select Image Files (Max 10)");
            fileChooser.getExtensionFilters().addAll(
                    new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif", "*.tiff")
            );
            List<File> selectedFiles = fileChooser.showOpenMultipleDialog(primaryStage);

            if (selectedFiles != null) {
                // Limit the selection to 10 images
                int limit = Math.min(selectedFiles.size(), 10);
                for (int i = 0; i < limit; i++) {
                    loadedImages.add(selectedFiles.get(i));
                }

                // Display thumbnails of uploaded images
                displayThumbnails(loadedImages);
            }
        });

        // Create a ChoiceBox to display available formats for conversion
        ChoiceBox<String> formatChoiceBox = new ChoiceBox<>();
        formatChoiceBox.getItems().addAll(supportedFormats);
        formatChoiceBox.setValue(supportedFormats.get(0)); // Set default value

        // Convert button
        Button convertButton = new Button("Convert");
        convertButton.setOnAction(e -> {
            if (!loadedImages.isEmpty()) {
                String selectedFormat = formatChoiceBox.getValue();
                // Open directory chooser after selecting the format
                openDirectoryChooser(loadedImages, selectedFormat, primaryStage);
            }
        });

        // Create a GridPane layout to arrange the components
        GridPane root = new GridPane();
        root.setPadding(new Insets(10));
        root.setHgap(10);
        root.setVgap(10);
        root.addRow(0, new Label("Load Images:"), loadImagesButton);
        root.addRow(1, new Label("Select Format:"), formatChoiceBox);
        root.addRow(2, new Label("Convert:"), convertButton);
        root.addRow(3, conversionStatus);

        // Create a Scene and set it on the Stage
        Scene scene = new Scene(root, 500, 200);
        primaryStage.setTitle("Welcome to Image Format Convertor Program!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Method to open images as thumbnails in a new window with image information tooltips
    private void displayThumbnails(List<File> imageFiles) {
        Stage newStage = new Stage();

        FlowPane thumbnailsPane = new FlowPane();
        thumbnailsPane.setPadding(new Insets(10));
        thumbnailsPane.setHgap(10);
        thumbnailsPane.setVgap(10);

        for (File imageFile : imageFiles) {
            Image image = new Image(imageFile.toURI().toString());
            ImageView imageView = new ImageView();
            imageView.setImage(image);
            imageView.setFitWidth(100);
            imageView.setFitHeight(100);
            imageView.setPreserveRatio(true);

            // Create a Tooltip with image information including a title
            Tooltip tooltip = new Tooltip(
                    "Raw Image Info:\n" +
                            "Width: " + image.getWidth() + "px\n" +
                            "Height: " + image.getHeight() + "px\n" +
                            "Location: " + imageFile.getAbsolutePath()
            );

            Tooltip.install(imageView, tooltip);

            StackPane thumbnailPane = new StackPane();
            thumbnailPane.getChildren().add(imageView);

            // Add a mouse moved event to update tooltip position
            imageView.setOnMouseMoved(event -> {
                double x = event.getScreenX() + 10; // Shift the tooltip right from the cursor
                double y = event.getScreenY() + 10; // Shift the tooltip below the cursor
                tooltip.show(imageView, x, y);
            });

            // Add a mouse exited event to hide the tooltip
            imageView.setOnMouseExited(event -> {
                tooltip.hide();
            });

            thumbnailsPane.getChildren().add(thumbnailPane);
        }

        Scene scene = new Scene(thumbnailsPane);
        newStage.setTitle("Image Info Thumbnail Viewer");
        newStage.setScene(scene);
        newStage.show();
    }

    // Method to open directory chooser after selecting the format
    private void openDirectoryChooser(List<File> imageFiles, String selectedFormat, Stage primaryStage) {
        Stage directoryStage = new Stage();
        directoryStage.setTitle("Choose Destination Folder");

        DirectoryChooser directoryChooser = new DirectoryChooser();
        directoryChooser.setTitle("Choose Destination Folder");

        Button selectDirectoryButton = new Button("Select Directory");
        selectDirectoryButton.setOnAction(e -> {
            selectedDirectory = directoryChooser.showDialog(directoryStage);
            if (selectedDirectory != null) {
                saveImagesAs(imageFiles, selectedFormat, selectedDirectory);
                directoryStage.close();
            }
        });

        VBox directoryLayout = new VBox(10);
        directoryLayout.setPadding(new Insets(10));
        directoryLayout.getChildren().addAll(new Label("Select a directory to save converted images:"), selectDirectoryButton);

        Scene directoryScene = new Scene(directoryLayout, 400, 200);
        directoryStage.setScene(directoryScene);
        directoryStage.show();
    }

    public static BufferedImage convertToBufferedImage(Image image) {
        int width = (int) image.getWidth();
        int height = (int) image.getHeight();

        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        javafx.scene.image.PixelReader reader = image.getPixelReader();
        int[] pixels = new int[width * height];

        reader.getPixels(0, 0, width, height, javafx.scene.image.PixelFormat.getIntArgbInstance(), pixels, 0, width);

        bufferedImage.setRGB(0, 0, width, height, pixels, 0, width);
        return bufferedImage;
    }

    // Method to save images after format conversion
    private void saveImagesAs(List<File> imageFiles, String selectedFormat, File destinationFolder) {
        new Thread(() -> {
            for (File imageFile : imageFiles) {
                try {
                    // Load image using ImageIO
                    Image image = new Image(imageFile.toURI().toString());
                    BufferedImage bufferedImage = convertToBufferedImage(image);

                    // Convert and save the image to the selected format in the destination folder
                    File outputFile = new File(destinationFolder, imageFile.getName().replaceFirst("[.][^.]+$", "") + "_converted." + selectedFormat);
                    ImageIO.write(bufferedImage, selectedFormat, outputFile);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
            // Update the UI in JavaFX thread
            javafx.application.Platform.runLater(() -> {
                conversionStatus.setText("Conversion complete! \n Summary: Converted " + imageFiles.size() +
                        " images to " + selectedFormat + " format in \n " + destinationFolder.getPath());
            });
        }).start();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
