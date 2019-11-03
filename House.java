import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;

public class House extends MIDlet implements CommandListener {
  private Display display;
  private CanvasDraw canvas;

  public House(){
    display = Display.getDisplay(this);
    canvas = new CanvasDraw();
  }

  public void startApp() {
    display.setCurrent(canvas);
  }

  public void pauseApp(){}

  public void destroyApp(boolean unconditional){
    notifyDestroyed();
  }

  public void commandAction(Command c, Displayable d){}

  class CanvasDraw extends Canvas implements CommandListener {
    Command exit;
    int w,h;

    public CanvasDraw() {
      exit = new Command("Exit", Command.EXIT, 1);
      addCommand(exit);
      setCommandListener(this);
      w = getWidth();
      h = getHeight();
    }

    public void paint(Graphics g){
      g.fillRect(0, 0, w, h);
      g.setColor(255, 255, 0);
      g.drawRect(w/3, h/2, w/3, h/3);
      g.drawLine(w/3,h/2,w/2,h/3);
      g.drawLine(w/2,h/3,2*w/3,h/2);
      g.drawRect(104,188,35,54);
    }

    public void commandAction(Command c, Displayable d){
      if(c == exit){
        destroyApp(true);
      }
    }
  }
}