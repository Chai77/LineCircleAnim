import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.Timer;

public class Main extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;
    
    private int sizeX;
    private int sizeY;
    private int num;
    private Timer timer;

    public Main() {
        this.sizeX = 500;
        this.sizeY = 500;

        this.num = 2;

        initializeJFrame();

        timer = new Timer(400, this);

    }

    public void actionPerformed(ActionEvent e) {
        num++;
        repaint();
        if(num == 1000) {
            timer.stop();
        }
    }

    public void initializeJFrame() {
        setSize(this.sizeX, this.sizeY);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Line Circle Animation");
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, this.sizeX, this.sizeY);

        drawShape(g, num);

        timer.start();
    }

    public void drawShape(Graphics g, int num) {
        g.setColor(Color.WHITE);
        double centerX = this.sizeX/2.0;
        double centerY = this.sizeY/2.0;

        double changeX = this.sizeX - 100 - centerX;
        double changeY = this.sizeY - 100 - centerY;

        double angleChange = 360.0/(double)num;

        double currentAngle = 0;

        Coordinate prevPoint = getPointAtAngle(currentAngle, changeX, changeY, centerX, centerY);
        for(int i = 0; i < num; i++) {
            currentAngle += angleChange;
            Coordinate currentPoint = getPointAtAngle(currentAngle, changeX, changeY, centerX, centerY);

            g.drawLine((int)prevPoint.getX(), (int)prevPoint.getY(), (int)currentPoint.getX(), (int)currentPoint.getY());
            
            prevPoint = currentPoint;
        }
    }

    public Coordinate getPointAtAngle(double angle, double changeX, double changeY, double centerX, double centerY) {
        double x = centerX + Math.cos(Math.toRadians(angle)) * changeX;
        double y = sizeX - (centerY + Math.sin(Math.toRadians(angle)) * changeY);
        return new Coordinate(x, y);
    }

    public class Coordinate {
        private double x;
        private double y;

        public Coordinate(double x, double y) {
            this.x = Math.round(x);
            this.y = Math.round(y);
        }

        public double getX() {
            return x;
        }

        public double getY() {
            return y;
        }
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.setVisible(true);
    }
}