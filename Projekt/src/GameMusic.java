import java.io.File;
import javax.sound.sampled.*;

public class GameMusic {
    private Clip musicClip;
    private boolean isPlaying = false;
    
    public GameMusic() {
        try {
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(
                new File("sound/background_music.wav")
            );
            musicClip = AudioSystem.getClip();
            musicClip.open(audioStream);
            
            musicClip.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (Exception e) {
            System.out.println("Error loading background music: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    public void start() {
        if (musicClip != null && !isPlaying) {
            musicClip.setFramePosition(0);
            musicClip.start();
            isPlaying = true;
        }
    }
    
    public void stop() {
        if (musicClip != null && isPlaying) {
            musicClip.stop();
            isPlaying = false;
        }
    }
} 