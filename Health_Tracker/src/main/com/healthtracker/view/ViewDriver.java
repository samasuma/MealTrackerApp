package main.com.healthtracker.view;

import javax.swing.UIManager;

import main.com.healthtracker.view.mainjframe.MainJFrame;
import main.com.healthtracker.view.mainjframe.MainJFrameController;
import main.com.healthtracker.view.meal.MealJFrame;
import main.com.healthtracker.view.meal.MealJFrameController;

public class ViewDriver {
	
	public ViewDriver() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		 MainJFrame mainJFrame = new MainJFrame();
		 
		 MainJFrameController mainJFrameController = new MainJFrameController(mainJFrame);
		 
		
	}
	
	
	
	
	public static void main(String[] args) {
		new ViewDriver();
		
	}

}
