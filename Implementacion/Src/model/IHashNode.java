package Implementacion.Src.model;

public interface IHashNode {
    public IHashNode getNext();
    public void setNext(IHashNode next);
    public Object getKey();
    public void setKey(Object key);
    public Object getValue();
    public void setValue(Object value);
}
