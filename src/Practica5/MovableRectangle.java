package Practica5;
public class MovableRectangle implements Movable {
    private MovablePoint topLeft;
    private MovablePoint bottomRight;

    public MovableRectangle(int x1, int y1, int x2, int y2, int xSpeed, int ySpeed) {
        this.topLeft = new MovablePoint(x1, y1, xSpeed, ySpeed);
        this.bottomRight = new MovablePoint(x2, y2, xSpeed, ySpeed);
    }

    private boolean hasSameSpeed() {
        return topLeft.getXSpeed() == bottomRight.getXSpeed() &&
                topLeft.getYSpeed() == bottomRight.getYSpeed();
    }

    @Override
    public void moveUp() {
        if (hasSameSpeed()) {
            topLeft.moveUp();
            bottomRight.moveUp();
        }
    }

    @Override
    public void moveDown() {
        if (hasSameSpeed()) {
            topLeft.moveDown();
            bottomRight.moveDown();
        }
    }

    @Override
    public void moveLeft() {
        if (hasSameSpeed()) {
            topLeft.moveLeft();
            bottomRight.moveLeft();
        }
    }

    @Override
    public void moveRight() {
        if (hasSameSpeed()) {
            topLeft.moveRight();
            bottomRight.moveRight();
        }
    }

    @Override
    public String toString() {
        return "MovableRectangle[topLeft=" + topLeft + ", bottomRight=" + bottomRight + "]";
    }
}