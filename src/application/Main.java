package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;

/*
 * Die Klasse Main beinhaltet die start-Methode fuer die JavaFX Anwendung.
 * 
 * @author Lucas Johns
 * @version 1.0
 */
public class Main extends Application
{
	@Override
	public void start(Stage primaryStage)
	{
		try
		{
			/*
			 * Unter Verwendung von SceneBuilder wurde die "MainWindow.fxml" fuer
			 * den Aufbau der JavaFX Anwendung erstellt. Die darin enthaltene Hierarchie
			 * wird mit FXMLLoader importiert.
			 */
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("MainWindow.fxml"));
			AnchorPane root = loader.load();// Ein AnchorPane dient als root, welches alle weiteren Elemente beinhaltet.
			Scene scene = new Scene(root);
			/*
			 * Die Datei "application.css" beinhaltet CSS Styles fuer einige Elemente der Anwendung.
			 */
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setMaxHeight(700);
			primaryStage.setMaxWidth(850);
			primaryStage.setTitle("Mensch aergere dich nicht");
			primaryStage.setResizable(false);// Da, das GUI bei einer Größenänderung nicht skaliert wird, wird Resizable auf "false" gesetzt.
			primaryStage.setScene(scene);
			primaryStage.show();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static void main(String[] args)
	{
		launch(args);
	}
}
