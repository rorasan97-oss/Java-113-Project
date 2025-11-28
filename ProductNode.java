import java.io.Serializable;

public class ProductNode implements Serializable {
    private Products data;
    private ProductNode next;

    public ProductNode(Products obj) {
        data = obj;
        next = null;
    }

    public void setNext(ProductNode nextPtr) {
        next = nextPtr;
    }

    public ProductNode getNext() {
        return next;
    }

    public void setData(Products obj) {
        data = obj;
    }

    public Products getData() {
        return data;
    }
}
