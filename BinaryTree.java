public class BinaryTree<T> implements ThreeInterface<T>,BinaryTreeInterface<T>  {
    //用户若需要自定义数据访问行为，需实现下面接口
    public interface DataAccess{
         void dataAccessAction(Object o);

    }
    public interface DataCode{
        void dataAccessAction(Object o,String code);

    }
    DataAccess dataAccess;
    private BinaryNode<T> root;
    public BinaryTree(){//初始化一个空树
        this.root =null;
    }
    public BinaryTree(T rootData){//初始化只有一个节点的树
        this.root =new BinaryNode<>(rootData);
    }
    public BinaryTree(T rootData,BinaryTree<T> leftChildTree,BinaryTree<T> rightChildTree){
        privateSetTree(rootData,leftChildTree,rightChildTree);
    }

    private void privateSetTree(T rootData, BinaryTree<T> leftChildTree, BinaryTree<T> rightChildTree) {
         this.root =new BinaryNode<>(rootData);
         if (leftChildTree !=null){
             this.root.setLeftChild(leftChildTree.root);
         }
         if (rightChildTree !=null){
             this.root.setRightChild(rightChildTree.root);
         }
    }

    @Override
    public void setTree(T rootNode) {

    }

    @Override
    public void setTree(T rootData, BinaryTreeInterface<T> leftTree, BinaryTreeInterface<T> rightTree) {
        privateSetTree(rootData,(BinaryTree<T>) leftTree,(BinaryTree<T>)rightTree);
    }

    @Override
    public T getRootData() throws  Exception {
         if (root == null)
             throw new Exception();
          else {
             return root.getDataPortion();
         }

    }

    @Override
    public int getHeight() {
        return root.getHeight();
    }

    @Override
    public int getNumberOfNodes() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public void clear() {
       root =null;
    }
    protected  void setRootData(T data){
        root.setDataPortion(data);
    }
    protected void setRootNode(BinaryNode rootNode){
         root =rootNode;
    }
    protected BinaryNode<T> getRootNode(){
        return  root;
    }
    public void inOrderTraverse(){
        inOrderTraverse(this.root);
    }
    private void inOrderTraverse(BinaryNode node){
        if (node!= null){
            inOrderTraverse(node.getLeftChild());
            System.out.println(""+node.getDataPortion());
            inOrderTraverse(node.getRightChild());
        }
    }
    public void preOrderTraverse(){
        preOrderTraverse(this.root,null);
    }
    public void preOrderTraverse(DataAccess dataAccess){
        preOrderTraverse(this.root,dataAccess);
    }
    private void preOrderTraverse(BinaryNode node,DataAccess dataAccess){
      if (node!=null){
          if (dataAccess!=null){
             dataAccess.dataAccessAction(node.getDataPortion());
          }
        //  System.out.println(""+node.getDataPortion());
          preOrderTraverse(node.getLeftChild(),dataAccess);
          preOrderTraverse(node.getRightChild(),dataAccess);
      }
    }
    private void preOrderTraverse(BinaryNode node,DataCode dataAccess,String code){
        String getCode=""+code;
        if (node!=null){
            if (dataAccess!=null){
                dataAccess.dataAccessAction(node.getDataPortion(),getCode);
            }
            //  System.out.println(""+node.getDataPortion());
            preOrderTraverse(node.getLeftChild(),dataAccess,getCode+"0");
            preOrderTraverse(node.getRightChild(),dataAccess,getCode+"1");
        }
    }
    public void preOrderTraverseCode(DataCode dataAccess,String code){
        preOrderTraverse(this.root,dataAccess,code);
    }
    //迭代版的中序遍历
    public void iterativeInOrderTraverse(){
        StackInterface<BinaryNode<T>> nodeStack = new LinkedStack<>();
        BinaryNode<T> currentNode =root;
        while (!nodeStack.isEmpty()|| currentNode!=null ){
            //find the leftmost node with no left child
            while (currentNode!=null){
                nodeStack.push(currentNode);
                currentNode =currentNode.getLeftChild();
            }
           //visit leftmost node , then visit its root and then travel its right subtree\
         if (!nodeStack.isEmpty()){
             BinaryNode<T> nextNode = nodeStack.pop();
             //它的左子树已经作为下一级子树的根被访问过了，这里直接访问根
             //数据访问行为，客制化访问行为
             if (dataAccess!=null)
             dataAccess.dataAccessAction(nextNode.getDataPortion());
             currentNode=nextNode.getRightChild();

         }

        }
    };
    //借助栈的迭代版中序遍历 7.19复习
    public void iterativeInOrderTraverse2(){
      //  StackInterface
        StackInterface<BinaryNode<T>> nodeStack=new LinkedStack<>();
        BinaryNode<T> currentNode=root;
        //从当前节点开始，总是找最左边的节点
        //开始节点可以是整个的根，也可以是某个子树的根
        while (currentNode!=null){
            nodeStack.push(currentNode);
            currentNode =currentNode.getLeftChild();
        }
        if (nodeStack!=null){
            BinaryNode<T> nextNode=nodeStack.pop();
            //数据访问动作
            System.out.println(nextNode.getDataPortion());
            currentNode=nextNode.getRightChild();
        }

    }

}
