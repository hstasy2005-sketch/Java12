package practica6;

public class MovablePoint {
    public class MovablePoint implements Movable {
        private int x;
        private int y;
        private int xSpeed;
        private int ySpeed;

        public MovablePoint(int x, int y, int xSpeed, int ySpeed) {
            this.x = x;
            this.y = y;
            this.xSpeed = xSpeed;
            this.ySpeed = ySpeed;
        }

        @Override
        public void moveUp() {
            y -= ySpeed;
        }

        @Override
        public void moveDown() {
            y += ySpeed;
        }

        @Override
        public void moveLeft() {
            x -= xSpeed;
        }

        @Override
        public void moveRight() {
            x += xSpeed;
        }

        public boolean speedTest(MovablePoint other) {
            return this.xSpeed == other.xSpeed && this.ySpeed == other.ySpeed;
        }

        @Override
        public String toString() {
            return "Point(" + x + ", " + y + ") Speed(" + xSpeed + ", " + ySpeed + ")";
        }
    }
}
