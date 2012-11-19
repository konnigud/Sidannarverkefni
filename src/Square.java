/**
 * Created with IntelliJ IDEA.
 * Author: Óskar Ögri Birgisson
 * Date: 15.11.2012
 * Last Updated: 15.11.2012
 * Time: 14:07
 * Description:
 */
public class Square {
    private Mark mark;
    private int index;

    public Square() {
        this.mark = Mark.Open;
        this.index = 0;
    }

    public boolean IsEmtpy() {
        if (this.mark == Mark.Open)
            return true;
        return false;
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
