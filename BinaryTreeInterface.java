public interface BinaryTreeInterface<T> extends  ThreeInterface<T> {
    public void setTree(T rootNode);
    public void setTree(T rootData,BinaryTreeInterface<T> leftTree,BinaryTreeInterface<T> rightTree);
}
