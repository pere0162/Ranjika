
//By Raigamage Perera


import java.nio.file.Path;
import java.nio.file.Paths;

import javafx.animation.FadeTransition;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.effect.Bloom;
import javafx.scene.effect.BoxBlur;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.effect.Glow;
import javafx.scene.effect.MotionBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;

public class EffectAndTransition extends Application {
	
	private RotateTransition rotateTransition;
    private ScaleTransition scaleTransition;
    private FadeTransition fadeTransition;
    private TranslateTransition translateTransition1;
    private TranslateTransition translateTransition2;

    public void play() {
    	//Sequential Transition object 
    	SequentialTransition st = new SequentialTransition();
    	// Set transitions 
    	st.getChildren().addAll(translateTransition1,translateTransition2,rotateTransition,fadeTransition,scaleTransition );
    	// Play Sequential Transition
    	st.play();    	
    }	
	
	
	@Override 
    public void start(Stage primaryStage) throws Exception {
		// New Group
		Group root = new Group();
		
		// Image 
        Path path = Paths.get("AlgonquinCollegeLogo.jpg");  
        Image image = new Image(path.toUri().toString());
        ImageView imagev = new ImageView(image); 
        
        // Box Blur effect
        BoxBlur boxblur = new BoxBlur();
        boxblur.setWidth(8.0f); 
        boxblur.setHeight(3.0f); 
        boxblur.setIterations(3);
        //imagev.setEffect(boxblur); 
        
        // Gaussian Blur effect
        GaussianBlur gaussianBlur = new GaussianBlur();  
        gaussianBlur.setRadius(10.5); 
        imagev.setEffect(gaussianBlur);  
        
       //Glow Effect
        Glow glow = new Glow();
        glow.setLevel(0.7);       
        
        //Bloom effect
        Bloom bloom = new Bloom();
        bloom.setThreshold(0.1);        
         
        // Motion blur effect 
        MotionBlur motionBlur = new MotionBlur(); 
        motionBlur.setRadius(10.5); 
        motionBlur.setAngle(45);
        
        //glow.setInput(bloom);   
        glow.setInput(motionBlur);
        imagev.setEffect(glow);
        
        // Add image to the group
        root.getChildren().add(imagev);
        
        //Setting title to the Stage 
        primaryStage.setTitle("Effect and Transition Assignment"); 
        
        // Scale Transition 
        scaleTransition = new ScaleTransition(Duration.seconds(4), imagev);
        scaleTransition.setToX(3);
        scaleTransition.setToY(3);
        scaleTransition.setCycleCount(2);
        scaleTransition.setAutoReverse(true);
        
        // Rotate Transition
        rotateTransition = new RotateTransition(Duration.seconds(1), imagev);
        rotateTransition.setFromAngle(0);
        rotateTransition.setToAngle(1440);
        rotateTransition.setCycleCount(2);
        rotateTransition.setAutoReverse(true);  
        
        // Fade Transition
        fadeTransition = new FadeTransition(Duration.seconds(4), imagev);
        fadeTransition.setFromValue(1);
        fadeTransition.setToValue(0);
        fadeTransition.setCycleCount(2);
        fadeTransition.setAutoReverse(true);
        
        // Translate Transition 1 (moving left)
        translateTransition1 =  new TranslateTransition(Duration.seconds(2), imagev);
        translateTransition1.setByX(500f);
        translateTransition1.setCycleCount(2);
        translateTransition1.setAutoReverse(true);
        
       // Translate Transition 2 (moving right)
        translateTransition2 =  new TranslateTransition(Duration.seconds(2), imagev);
        translateTransition2.setByX(-500f);
        translateTransition2.setCycleCount(2);
        translateTransition2.setAutoReverse(true);
        
        // Set Stage properties and show
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        
        play();
	
	}//start
	
	public static void main(String[] args) { launch(args);}

}// class
