
//public class Stasik {
//    private String name;
//    private String email;
//    private char gender; // 'M' - мужчина, 'F' - женщина, 'U' - неизвестно
//
//    public Stasik (String name, String email, char gender) {
//        this.name = name;
//        this.email = email;
//        this.gender = gender;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public char getGender() {
//        return gender;
//    }
//
//    @Override
//    public String toString() {
//        return name + " (" + gender + ") at " + email;
//    }
//}
//
package Stasik;
public class Ball {
    private double x = 0.0;
    private double y = 0.0;
    public Ball(){}
    public Ball(double x, double y){
        this.x = x;
        this.y = y;
    }
    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }
    public void setX(double x) {
        this.x = x;
    }
    public void setY(double y) {
        this.y = y;
    }
    public void setXY(double x, double y){
        this.x = x;
        this.y = y;
    }
    public void move( double xDisp, double yDisp){
        x+=xDisp;
        y+=yDisp;
    }
    @Override
    public String toString() {
        return "Ball @ ("+this.x+", "+this.y+").";
    }
}