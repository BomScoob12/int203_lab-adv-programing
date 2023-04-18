package byteStreams2;

public class Lab1 {
    public static void main(String[] args) {
        Circle circle = new Circle();
        RedShapeDecorator redCircle = new RedShapeDecorator(circle);
        Rectangle rectangle = new Rectangle();
        RedShapeDecorator redRectangle = new RedShapeDecorator(rectangle);
        redCircle.draw();
        redRectangle.draw();

        RedShapeDecorator redCircle2 = new RedShapeDecorator(new Circle());
        redCircle2.draw();
    }
}
