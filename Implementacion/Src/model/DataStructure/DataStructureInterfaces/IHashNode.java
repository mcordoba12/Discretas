package Model.DataStructure.DataStructureInterfaces;

/** The code is defining an interface called `IHashNode`. This interface specifies the methods that a
*hash node should have.
 */
public interface IHashNode {
    public IHashNode getNext();
    public void setNext(IHashNode next);
    public Object getKey();
    public void setKey(Object key);
    public Object getValue();
    public void setValue(Object value);
}
