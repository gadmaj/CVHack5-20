package com.steal;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.awt.Desktop;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.lang.UnsupportedOperationException;
import org.json.JSONObject;
import java.io.InputStream;

public class App {
    private static Runtime m_rt = Runtime.getRuntime();

    public static void writeFile(String path, String contents) {

        File path2 = new File(path);
        try {
            FileWriter wr = new FileWriter(path2);
            wr.write(contents);
            wr.flush();
            wr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeFile(String folder, String contents, String ext, String filename) {
        File path = new File("stealyojob\\src\\main\\resources\\projects\\" + folder);
        if (!path.exists())
            path.mkdirs();

        File path2 = new File("stealyojob\\src\\main\\resources\\projects\\" + folder + "\\" + filename + "." + ext);
        try {
            FileWriter wr = new FileWriter(path2);
            wr.write(contents);
            wr.flush();
            wr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("do you want to decide your language(y/n)");

        boolean USERchooseit;
        while (true) {
            String langchooser = sc.nextLine();
            if (langchooser.equals("y")) {
                USERchooseit = true;
                break;
            } else if (langchooser.equals("n")) {
                USERchooseit = false;
                break;
            } else {
                System.out.println("bruh (y/n))");
            }
        }
        System.out.println("-----------------");
        System.out.println("project name:");
        String projectname = sc.nextLine();
        System.out.println("-----------------");
        System.out.println("prompt:");
        String prompt = sc.nextLine();
        System.out.println("-----------------");
        String lang = "";
        if (USERchooseit) {
            while (true) {
                System.out.println("language (py/cpp/java/html):");
                System.out.println("-----------------");
                lang = sc.nextLine();
                if (lang.equals("py") || lang.equals("cpp") || lang.equals("java") || lang.equals("html")
                        || lang.equals("lua") || lang.equals("c#"))
                    break;
                else {
                    System.out.println("choose a valid language bruh (py/cpp/java/html/lua/c#)");
                    System.out.println("-----------------");
                }
            }
        }

        if (!USERchooseit) {

            try {
                System.out.println("-----------------");
                System.out.println(
                        "creating file with\n name: " + projectname + "\n language: " + lang + "\n prompt: " + prompt);
                System.out.println("-----------------");
                String answer = promptchatGPT(prompt, projectname);
                String langextention = etcchatGPT(
                        "ONLY GIVE ME BACK the language extention what language is this code written in: " + answer);
                writeFile(projectname, answer, langextention, projectname);

                // createBat(javabat(projectname), projectname);
                Desktop desktop = Desktop.getDesktop();
                // desktop.open(new File("stealyojob\\src\\main\\resources\\run\\" + projectname
                // + ".bat"));
            } catch (Exception e) {
                System.out.println(e);
            }
            // try {
            // String answer = promptchatGPT(prompt);
            // // System.out.println(answer);
            // String langextention = etcchatGPT("ONLY GIVE ME BACK the language extenstion
            // what language is this code written in? ");
            // writeFile(projectname,answer, langextention, projectname);//how do we know
            // what lang chat gpt wrote it in?
            // } catch (Exception e) {
            // System.out.println(e);
            // }
        } else {

            try {
                System.out.println("-----------------");
                System.out.println(
                        "creating file with\n name: " + projectname + "\n language: " + lang + "\n prompt: " + prompt);
                System.out.println("-----------------");
                String answer = promptLangchatGPT(prompt, lang, projectname);

                writeFile(projectname, answer, lang, projectname);

                // createBat(javabat(projectname), projectname);
                Desktop desktop = Desktop.getDesktop();
                // desktop.open(new File("stealyojob\\src\\main\\resources\\run\\" + projectname
                // + ".bat"));
            } catch (Exception e) {
                System.out.println(e);
            }

        }
        // debugFile("stealyojob\\src\\main\\resources\\run\\" + projectname + ".bat");
    }

    public static void debugFile(String path) {

        try {
            Path path2 = Paths.get(path);
            byte[] bytes = Files.readAllBytes(path2);
            String fileContent = new String(bytes);

            String debugedcode = etcchatGPT("Debug this piece of code: " + fileContent);
            writeFile(path, debugedcode);
            System.out.println("DEBUGINED" + path);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // public static String javabat(String projectname) {
    // return "@echo on\nset JAVA_FILE=" + projectname
    // + "\nset
    // CLASSPATH=C:\\Users\\gadym\\OneDrive\\Desktop\\MrStealYourJob\\stealyojob\\src\\main\\resources\\projects\\"
    // + projectname + "\\"
    // + "\njavac %JAVA_FILE%.java\nif %errorlevel% equ 0 (\n echo compiled!!\n java
    // -cp %CLASSPATH% %JAVA_FILE%\n) else (\n echo no compile\n)cmd /k";

    // }

    // public static void createBat(String contents, String projectname) {
    // File path = new File("stealyojob\\src\\main\\resources\\run\\" + projectname
    // + ".bat");

    // try {
    // FileWriter wr = new FileWriter(path);
    // wr.write(contents);
    // wr.flush();
    // wr.close();
    // } catch (IOException e) {
    // e.printStackTrace();
    // }
    // }

    public static String promptLangchatGPT(String code, String lang, String classname) throws Exception {
        HttpURLConnection con = (HttpURLConnection) new URL("https://api.openai.com/v1/completions").openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "application/json");
        con.setRequestProperty("Authorization", "Bearer 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");

        JSONObject data = new JSONObject();
        data.put("model", "text-davinci-003");
        data.put("prompt",
                "I will provide you with a prompt to code, and a langauge to code it in. ONLY PROVIDE ME WITH THE ENTIRE CLASS/FILE, named \""
                        + classname + "\" . Here is the prompt: " + code + " Here is the language: " + lang);
        data.put("max_tokens", 2200);
        data.put("temperature", 1.0);

        con.setDoOutput(true);
        con.getOutputStream().write(data.toString().getBytes());

        String output = new BufferedReader(new InputStreamReader(con.getInputStream())).lines().reduce((a, b) -> a + b)
                .get();

        return (new JSONObject(output).getJSONArray("choices").getJSONObject(0).getString("text"));

    }

    public static String promptchatGPT(String code, String classname) throws Exception {
        HttpURLConnection con = (HttpURLConnection) new URL("https://api.openai.com/v1/completions").openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "application/json");
        con.setRequestProperty("Authorization", "Bearer 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");

        JSONObject data = new JSONObject();
        data.put("model", "text-davinci-003");
        data.put("prompt",
                "I will provide you with a prompt to code. ONLY PROVIDE ME WITH THE CODE. named \""
                        + classname + "\" Here is the prompt: " + code);
        data.put("max_tokens", 1850);
        data.put("temperature", 1.0);

        con.setDoOutput(true);
        con.getOutputStream().write(data.toString().getBytes());

        String output = new BufferedReader(new InputStreamReader(con.getInputStream())).lines().reduce((a, b) -> a + b)
                .get();

        return (new JSONObject(output).getJSONArray("choices").getJSONObject(0).getString("text"));

    }

    public static String etcchatGPT(String code) throws Exception {
        HttpURLConnection con = (HttpURLConnection) new URL("https://api.openai.com/v1/completions").openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "application/json");
        con.setRequestProperty("Authorization", "Bearer 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");

        JSONObject data = new JSONObject();
        data.put("model", "text-davinci-003");
        data.put("prompt", code);
        data.put("max_tokens", 2200);
        data.put("temperature", 1.0);

        con.setDoOutput(true);
        con.getOutputStream().write(data.toString().getBytes());

        String output = new BufferedReader(new InputStreamReader(con.getInputStream())).lines().reduce((a, b) -> a + b)
                .get();

        return (new JSONObject(output).getJSONArray("choices").getJSONObject(0).getString("text"));

    }
}
