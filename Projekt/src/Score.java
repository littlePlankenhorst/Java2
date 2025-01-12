import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Score {
    private static final String SCORE_FILE = "scores.csv";
    private int currentScore;
    private static int highScore = 0;
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    
    public Score() {
        currentScore = 10;
        loadHighScore();
    }
    
    public void addPoints(int points) {
        currentScore += points;
        updateHighScore();
    }
    
    public int getCurrentScore() {
        return currentScore;
    }
    
    public static int getHighScore() {
        return highScore;
    }
    
    private void updateHighScore() {
        if (currentScore > highScore) {
            highScore = currentScore;
        }
    }
    
    private void loadHighScore() {
        try {
            File file = new File(SCORE_FILE);
            if (!file.exists()) {
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                    writer.write("Timestamp,Score\n");
                }
                return;
            }
            
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                boolean isFirstLine = true;
                while ((line = reader.readLine()) != null) {
                    if (isFirstLine) { 
                        isFirstLine = false;
                        continue;
                    }
                    String[] parts = line.split(",");
                    if (parts.length >= 2) {
                        try {
                            int score = Integer.parseInt(parts[1].trim());
                            highScore = Math.max(highScore, score);
                        } catch (NumberFormatException e) {
                           
                        }
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading scores: " + e.getMessage());
        }
    }
    
    public void saveScore() {
        try {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(SCORE_FILE, true))) {
                String timestamp = LocalDateTime.now().format(formatter);
                writer.write(String.format("%s,%d\n", timestamp, currentScore));
            }
        } catch (IOException e) {
            System.out.println("Error saving score: " + e.getMessage());
        }
    }
    
    public static List<String[]> getAllScores() {
        List<String[]> scores = new ArrayList<>();
        try {
            File file = new File(SCORE_FILE);
            if (!file.exists()) {
                return scores;
            }
            
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                boolean isFirstLine = true;
                while ((line = reader.readLine()) != null) {
                    if (isFirstLine) {  
                        isFirstLine = false;
                        continue;
                    }
                    scores.add(line.split(","));
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading scores: " + e.getMessage());
        }
        return scores;
    }
    
    public static String[] getHighScoreWithTimestamp() {
        String[] result = {"Never", "0"}; 
        try {
            File file = new File(SCORE_FILE);
            if (!file.exists()) {
                return result;
            }
            
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                boolean isFirstLine = true;
                int maxScore = 0;
                String maxScoreTimestamp = "";
                
                while ((line = reader.readLine()) != null) {
                    if (isFirstLine) { 
                        isFirstLine = false;
                        continue;
                    }
                    String[] parts = line.split(",");
                    if (parts.length >= 2) {
                        try {
                            int score = Integer.parseInt(parts[1].trim());
                            if (score > maxScore) {
                                maxScore = score;
                                maxScoreTimestamp = parts[0].trim();
                            }
                        } catch (NumberFormatException e) {
                          
                        }
                    }
                }
                
                if (maxScore > 0) {
                    result[0] = maxScoreTimestamp;
                    result[1] = String.valueOf(maxScore);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading scores: " + e.getMessage());
        }
        return result;
    }
} 