import sun.plugin2.message.MarkTaintedMessage;

/**
 * Created with IntelliJ IDEA.
 * User: Arnar Thor
 * Date: 14.11.2012
 * Time: 22:04
 * To change this template use File | Settings | File Templates.
 */
public class Square implements Cloneable{

    private Mark mark;
    private int index;

    public boolean isEmpty(){
        if(this.mark == Mark.Open)
            return true;
        return false;
    }
    public Square(){
        this.mark = Mark.Open;
        this.index = 0;
    }

    public Object clone(){
        Square s = new Square();

        s.setMark(this.getMark());

        return s;
    }

    public Mark getMark() {
        return mark;
    }

    public void setMark(Mark mark) {
        this.mark = mark;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
