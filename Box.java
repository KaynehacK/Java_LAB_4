// Задание 1.1

public class Box<type> {
    private type object;

    public type get() {
        type t = object;
        object = null;
        return t;
    }

    public void set(type t) throws Exception {
        if (object != null) {
            throw new Exception("Box is already full.");
        }
        else {
            object = t;
        }
    }

    public Box(type object){
        this.object = object;
    }

    public Box(){
        this(null);
    }

    public boolean isEmpty(){
        return object == null;
    }
}
