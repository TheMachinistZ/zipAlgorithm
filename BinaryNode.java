public class BinaryNode <T>{
    private T dataPortion;
    private BinaryNode<T> leftChild;
    private BinaryNode<T> rightChild;
    public BinaryNode(T dataPortion,BinaryNode<T> leftChild,BinaryNode<T> rightChild){
        this.dataPortion=dataPortion;
        this.leftChild =leftChild;
        this.rightChild=rightChild;
    }
    public BinaryNode(T dataPortion){
       this(dataPortion,null,null);
    }
    public BinaryNode(){
        this(null);
    }

    public T getDataPortion() {
        return dataPortion;
    }

    public void setDataPortion(T dataPortion) {
        this.dataPortion = dataPortion;
    }

    public BinaryNode<T> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(BinaryNode<T> leftChild) {
        this.leftChild = leftChild;
    }

    public BinaryNode<T> getRightChild() {
        return rightChild;
    }

    public void setRightChild(BinaryNode<T> rightChild) {
        this.rightChild = rightChild;
    }
    public boolean hasLeftChild(){
        return this.leftChild!=null;
    }
    public boolean hasRightChild(){
        return this.rightChild!=null;
    }
    public boolean isLeaf(){
        return this.leftChild==null && this.rightChild ==null;
    }
    public int getHeight(){
       return getHeight(this);
    };
   private int getHeight(BinaryNode<T> node){
        int height=0;
        if (node !=null)
            height= Math.max(getHeight(node.getLeftChild()),
                    getHeight(node.getRightChild()));
        return height;
   }
   public int getNumberOfNodes(){
        int leftChildNumberOfNodes=0;
        int rightChildNumberOfNodes =0;
        if (leftChild!=null){
            leftChildNumberOfNodes=leftChild.getNumberOfNodes();
        }
        if (rightChild!=null){
            rightChildNumberOfNodes=rightChild.getNumberOfNodes();
        }
        return 1+leftChildNumberOfNodes+rightChildNumberOfNodes;
   }
}
