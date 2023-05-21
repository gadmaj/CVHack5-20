

/*
 * This class is used to create a wordle in Java using the Wordle API (http://www.wordle.net/api).
*/

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random; 

public class PooleFunHouse {
	
	// Define instance variables
    private ArrayList<String> words;
    private HashMap<String, Integer> color;
    private Color background;
	
	public PooleFunHouse() {
		// Set instance variables to default values
        words = new ArrayList<String>();
        color = new HashMap<String, Integer>();
        background = Color.BLACK;
	}
	
	// Method to add words to the wordle
    public void addWord(String word) {
        words.add(word);
    }
	
	// Method to remove words from the wordle
    public void removeWord(String word) {
        words.remove(word);
    }
	
	// Method to generate random colors for each word
    public void randomizeColors() {
        Random random = new Random();
        for (String word : words) {
            int randomColorValue = random.nextInt(255);
            color.put(word, randomColorValue);
        }
    }
	
	// Method to set the background color of the wordle
    public void setBackground(Color backgroundColor) {
        background = backgroundColor;
    }
	
	// Method to submit the wordle, using the API
    public void submit() {
		// Use the API to submit the wordle, with the words, colors, and background
    }

}