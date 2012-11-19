/**
 * Created with IntelliJ IDEA.
 * Author: Óskar Ögri Birgisson
 * Date: 15.11.2012
 * Last Updated: 15.11.2012
 * Time: 14:05
 * Description:
 */

import java.util.Iterator;

public class Board implements Cloneable, Iterator {

    private Square[] squares = new Square[9];
    private Mark mark;

    public int GetValidMoves()
    {
        return -1;
    }
    public boolean Evaluate(Mark oPolo)
    {
        return false;
    }
    public boolean IsFull()
    {
        return false;
    }
    @Override
    protected Object clone ()
    {

    }

    @Override
    public boolean hasNext() {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Object next() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void remove() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    /*

   +GetValidMoves():int[]
   +Evaluate(Mark):bool
   +IsFull():bool
   +Clone():object
   +GetEnumerator:IEnumerator<Square> */

}
