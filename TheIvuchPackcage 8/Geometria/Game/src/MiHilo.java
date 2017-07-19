
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class MiHilo extends Thread
{
    @Override
   public void run()
   {
      try{
    String music1 ="D:\\Mi música\\My Shared Folder\\Tote king\\toteking-algo mas que recuerdos (con xhelazz).mp3";
    String music2="D:\\Mi música\\Daft punk\\Daft Punk - Discovery\\Daft Punk - Discovery - 03 - Digital Love.mp3";
    FileInputStream fis=new FileInputStream(music1);
    FileInputStream fis2 =new FileInputStream(music2);
    Player sound =new Player(fis);
    Player sound1=new Player(fis2);
    sound.play();
    sound1.play();
    
   } 
   catch(FileNotFoundException | JavaLayerException e){System.err.printf("Nada");}
    }
}
