import java.util.ArrayList;
import java.util.List;

public class HuffmanTree {
     //统计类
     static class CharAndItsFrequence{
        char aChar;
        int frequence;
    }
    static class CharacterAndItsCode{
      //  char aChar;
      //  byte[] code;
        String code="";
        CharAndItsFrequence charAndItsFrequence;
        int count;
    }


    public static void main(String[] args){
    //    String str = "adfgdagdgddddss";
        String str = "aaabbdddddfeeea";
        List<CharAndItsFrequence> charAndItsFrequenceList =new ArrayList();
        List<Character> charList =new ArrayList();
        for (int i=0;i<str.length();i++){
             charList.add(str.charAt(i));
        }
        char currentChar;
        while (charList.size()>0){
            currentChar=charList.get(0);
            CharAndItsFrequence charAndItsFrequence =new CharAndItsFrequence();
            charAndItsFrequence.aChar=currentChar;
            charAndItsFrequence.frequence=0;
            for (int i=0;i<charList.size();i++){
                if (currentChar == charList.get(i)){
                    charAndItsFrequence.frequence++;

                }
            }
            System.out.print("清除字符:"+currentChar);
//            for (int i=0;i<charList.size();i++){
//                if (currentChar == charList.get(i)){
//                  charList.remove(i);
//                  i=0;
//                }
//            }
            //重写清理部分
            int counter=0;//计数器
            while (counter < charList.size()){
                if (currentChar == charList.get(counter)){
                    charList.remove(counter);
                    counter=0;
                }else {
                    counter++;
                }
            }
            System.out.print("清洗后的字符串:");
            for (char a: charList){
                System.out.print(a+"\t");
            }
            System.out.println();


            charAndItsFrequenceList.add(charAndItsFrequence);
        }
        for(int i=0;i<charAndItsFrequenceList.size();i++){
            System.out.println(""+charAndItsFrequenceList.get(i).aChar+"的频度为"+
                    charAndItsFrequenceList.get(i).frequence);
        }
        sortList(charAndItsFrequenceList);
        int count=0;
      while (charAndItsFrequenceList.size()>=2){
         CharAndItsFrequence newNode=generateNewNode(charAndItsFrequenceList.get(0),charAndItsFrequenceList.get(1));
          buildTree(charAndItsFrequenceList.get(0),charAndItsFrequenceList.get(1));
          System.out.println("当前根为："+currentRoot.getRootNode()+"");
          System.out.println("start--");
         currentRoot.preOrderTraverse(new BinaryTree.DataAccess() {
             @Override
             public void dataAccessAction(Object o) {
                 if (o!=null){
                     char a=  ((CharacterAndItsCode)o).charAndItsFrequence.aChar;
                     System.out.println("这次为"+a);
                 }else {
                     System.out.println("数字根");
                 }
             }
         });
          System.out.println("--end");
          charAndItsFrequenceList.remove(1);
          charAndItsFrequenceList.remove(0);
          charAndItsFrequenceList.add(newNode);
          sortList(charAndItsFrequenceList);

      }
      if (charAndItsFrequenceList.size()>0){

      }
        System.out.println("树的高度为："+currentRoot.getHeight()+"");
        BinaryTree.DataAccess dataAccess =new BinaryTree.DataAccess() {
            @Override
            public void dataAccessAction(Object o) {
             //   System.out.println("数据域为："+o);
                if (o!=null){
                    char a=  ((CharacterAndItsCode)o).charAndItsFrequence.aChar;
                    System.out.println("这次为"+a+"\t计数为"+((CharacterAndItsCode)o).count+"编码为"+((CharacterAndItsCode)o).code);
                }

//
            }
        };
      System.out.println("遍历开始" );
       currentRoot.preOrderTraverseCode(new BinaryTree.DataCode() {
           @Override
           public void dataAccessAction(Object o, String code) {
               if (o!=null)
               ((CharacterAndItsCode)o).code=code;
           }
       }, "");
      currentRoot.preOrderTraverse(dataAccess);
    //  currentRoot.inOrderTraverse();
       System.out.println("合并"+countx);
        List<String> test =new ArrayList<>();
        for (int i=0;i<5;i++){
            test.add("2");
        }
        String c =test.get(2);
        c="3";
        for (String a:test){
            System.out.println(a);
        }
    }
    static void sortList(List<CharAndItsFrequence> list){
        for (int i=0;i<list.size();i++){
            CharAndItsFrequence theSmallestOne =list.get(i);
            //在一个小范围内总是搜索最小的

            for (int j=i+1;j<list.size();j++){
                if (list.get(j).frequence < theSmallestOne.frequence){

                    CharAndItsFrequence temp =theSmallestOne;
                    theSmallestOne=list.get(j);
                    list.set(i,list.get(j));
//                    System.out.println("已经复制"+list.get(j).aChar);
                   CharAndItsFrequence charAndItsFrequence= list.set(j,temp);
//                   System.out.println("被替换"+charAndItsFrequence.aChar);
                }
            }
         //   System.out.println("这轮最小的是"+theSmallestOne.aChar);
         //   System.out.println("当前位置中"+list.get(i).aChar);

        }
        System.out.println("打印分割:");
        //控制台打印校验结果
        for (CharAndItsFrequence charAndItsFrequence:list){
            System.out.println("字符："+charAndItsFrequence.aChar+"字符频度"+charAndItsFrequence.frequence);
        }
        System.out.println(":打印分割");


    }
    static CharAndItsFrequence generateNewNode(CharAndItsFrequence left,CharAndItsFrequence right){
         CharAndItsFrequence charAndItsFrequence =new CharAndItsFrequence();
         charAndItsFrequence.aChar='1';
         charAndItsFrequence.frequence=right.frequence+left.frequence;
         return charAndItsFrequence;
    }
    static BinaryTree<CharacterAndItsCode> currentRoot;
    static  int  countx=0;

     static void buildTree(CharAndItsFrequence left,CharAndItsFrequence right){
         BinaryTree<CharacterAndItsCode> binaryTree =new BinaryTree();

          if (left.aChar=='1' && right.aChar!='1'){
              CharacterAndItsCode rightNode =new CharacterAndItsCode();
              rightNode.charAndItsFrequence=right;
              binaryTree.setTree(null,currentRoot,new BinaryTree<>(rightNode));
              binaryTree.preOrderTraverse(new BinaryTree.DataAccess() {
                  @Override
                  public void dataAccessAction(Object o) {
                      if (o!=null){
                          ((CharacterAndItsCode)o).count++;

                      }
                  }
              });
              currentRoot=binaryTree;
              countx++;
              return;
          }
          if (left.aChar!='1' && right.aChar=='1'){
              CharacterAndItsCode leftNode =new CharacterAndItsCode();
              leftNode.charAndItsFrequence=left;
              binaryTree.setTree(null,new BinaryTree<>(leftNode),currentRoot);
              binaryTree.preOrderTraverse(new BinaryTree.DataAccess() {
                  @Override
                  public void dataAccessAction(Object o) {
                      if (o!=null){
                          ((CharacterAndItsCode)o).count++;

                      }
                  }
              });
              currentRoot=binaryTree;

              countx++;
              return;
          }

        CharacterAndItsCode leftNode =new CharacterAndItsCode();
        leftNode.charAndItsFrequence=left;
        CharacterAndItsCode rightNode =new CharacterAndItsCode();
        rightNode.charAndItsFrequence=right;
        if (right.aChar=='1'&& left.aChar=='1'){
            return;
        }
        binaryTree.setTree(null,new BinaryTree<>(leftNode),new BinaryTree<>(rightNode));
        if (currentRoot!=null){
            BinaryTree<CharacterAndItsCode> binaryTreeRoot =new BinaryTree();
            binaryTreeRoot.setTree(null,currentRoot,binaryTree);
            binaryTree.preOrderTraverse(new BinaryTree.DataAccess() {
                @Override
                public void dataAccessAction(Object o) {
                    if (o!=null){
                        ((CharacterAndItsCode)o).count++;

                    }
                }
            });
            currentRoot=binaryTreeRoot;
        }else {
            binaryTree.preOrderTraverse(new BinaryTree.DataAccess() {
                @Override
                public void dataAccessAction(Object o) {
                    if (o!=null){
                        ((CharacterAndItsCode)o).count++;

                    }
                }
            });
            currentRoot=binaryTree;
        }


        }




    }

