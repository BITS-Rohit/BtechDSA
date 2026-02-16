package btech.JAVA_AWT.Centipede;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;

public class CentipedePanel extends JPanel implements MouseMotionListener {
    private static final int SEGMENT_SIZE = 20;
    private static final int INITIAL_NUM_SEGMENTS = 10;
    private static final int GROWTH_RATE = 50;  // The centipede grows every 50 frames
    private static final double SMOOTHING_FACTOR = 0.2;

    private final List<Point> centipedeSegments;
    private final List<Double> segmentAngles;
    private final Point headDirection;
    private int frameCounter = 0;

    public CentipedePanel() {
        centipedeSegments = new ArrayList<>();
        segmentAngles = new ArrayList<>();

        // Initialize the centipede at the center
        for (int i = 0; i < INITIAL_NUM_SEGMENTS; i++) {
            centipedeSegments.add(new Point(400, 300));
            segmentAngles.add(0.0);
        }
        headDirection = new Point(0, 0);
        addMouseMotionListener(this);

        Timer timer = new Timer(30, e -> updateCentipedePosition());
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (int i = 0; i < centipedeSegments.size(); i++) {
            Point segment = centipedeSegments.get(i);
            double angle = segmentAngles.get(i);

            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setColor(i == 0 ? Color.RED : Color.GREEN);  // Head is red, body is green
            g2d.translate(segment.x, segment.y);
            g2d.rotate(angle);
            g2d.fillOval(-SEGMENT_SIZE / 2, -SEGMENT_SIZE / 2, SEGMENT_SIZE, SEGMENT_SIZE);
            g2d.dispose();
        }
    }

    private void updateCentipedePosition() {
        Point head = centipedeSegments.getFirst();

        // Move the head towards the direction
        head.x += headDirection.x;
        head.y += headDirection.y;

        segmentAngles.set(0, Math.atan2(headDirection.y, headDirection.x));

        // Smoothly transition each segment to follow the previous one
        for (int i = 1; i < centipedeSegments.size(); i++) {
            Point current = centipedeSegments.get(i);
            Point previous = centipedeSegments.get(i - 1);

            double dx = previous.x - current.x;
            double dy = previous.y - current.y;

            current.x += (int) (dx * SMOOTHING_FACTOR);
            current.y += (int) (dy * SMOOTHING_FACTOR);

            segmentAngles.set(i, Math.atan2(dy, dx));
        }

        frameCounter++;
        if (frameCounter % GROWTH_RATE == 0) {
            growCentipede();
        }

        repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        Point mousePoint = e.getPoint();
        Point head = centipedeSegments.getFirst();

        // Calculate the distance to the mouse
        double distance = mousePoint.distance(head);

        // Adjust speed based on distance
        double speed = Math.min(distance / 10, 10);

        // Calculate the direction from the head to the mouse
        double angle = Math.atan2(mousePoint.y - head.y, mousePoint.x - head.x);
        headDirection.x = (int) (Math.cos(angle) * speed);
        headDirection.y = (int) (Math.sin(angle) * speed);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        // No action needed for mouse dragged, but required to implement the interface
    }

    private void growCentipede() {
        Point lastSegment = centipedeSegments.getLast();
//        centipedeSegments.add(new Point(lastSegment.x, lastSegment.y));
        segmentAngles.add(segmentAngles.getLast());
    }
}
