

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
 
public class Dhruvsheaven
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.println("!! Welcome to Wordle !!\n");
        System.out.println("Choose between three levels: E - Easy, M - Medium, H - Hard \n");
        
        String inputLevel = in.nextLine();
        int level;
        int maxScore = 0;
       
        //Selecting difficulty
        if (inputLevel.equalsIgnoreCase("E"))
        {
            System.out.println("\n You selected Easy!");
            level = 4;
            maxScore = 10;
        }
        else if (inputLevel.equalsIgnoreCase("M"))
        {
            System.out.println("\n You chose Medium!");
            level = 6;
            maxScore = 20;
        }
        else 
        {
            System.out.println("\n You chose Hard!");
            level = 8;
            maxScore = 30;
        }
       
        ArrayList<String> wordList = new ArrayList<String>();
        try 
        {
            InputStream dict = new FileInputStream ("./words.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(dict));
            for (String line; (line = br.readLine()) != null;)
            {
                // for each line, give me an array of words
                String[] words = line.split(" ");
 
                for (int i=0; i<words.length; i++)
                {   
                    wordList.add(words[i]);
                }
            }
        }
        catch (IOException e) 
        {
            // if an I/O Exception is thrown, we'll print a generic message
            System.out.println("Error");
        }
       
        //shuffling a list
        Collections.shuffle(wordList);
       
        //generating a number within the range of shuffled list
        Random randNumGenerator = new Random();
       
        int score = 0;
        String inputWord;
        int length;
        for ( int i = 0; i < maxScore; i++ )
        {
            // set a random value to length
            length = randNumGenerator.nextInt(wordList.size());
           
            System.out.println("\n Guess the word with " + level + " characters : " +wordList.get(length).substring(0,level)+"\n");
            inputWord = in.nextLine();
           
            if(inputWord.equalsIgnoreCase(wordList.get(length)))
            {
                System.out.println("That's CORRECT !!");
                score++;
            }
            else
            {
                System.out.println("That's WRONG !!");
            }
        }
       
        System.out.println("\nYour Total Score is " + score);
    }
}