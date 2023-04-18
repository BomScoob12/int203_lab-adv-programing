package byteStreams2;

public class RedShapeDecorator extends ShapeDecorator {
    public RedShapeDecorator(Shape shape) {
        super(shape);
    }

    @Override
    public void draw(){
        shape.draw();
        System.out.println("Border color: Red");
    }
}
