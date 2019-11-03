import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;
import javax.microedition.lcdui.Graphics;

public class Shapes extends MIDlet implements CommandListener {
  private Display display;
  private CanvasDraw canvas;

  public Shapes(){
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
      g.drawLine(10,10,w-10,10);
      g.drawRect(10,30,217,80);
      g.drawArc(40, 130, 100, 100, 0, 360);
      g.fillTriangle(getWidth() / 4, 150, 180, 130, 130, 180);
    }

    public void commandAction(Command c, Displayable d){
      if(c == exit){
        destroyApp(true);
      }
    }
  }
}