package cn.zkj.algorithm;

/**
 * @Classname ReverseLinkNode02
 * @Description
 * @Date 2022/3/16 16:12
 * @Created by zkj
 */
public class ReverseLinkNode02 {
    static class LinkNode{
        private LinkNode next;
        private int v;

        public LinkNode(int v) {
            this.v = v;
        }
    }

    public static void reverseLinkNode(LinkNode node,int start,int end){
        if (start>=end){
            return;
        }
        LinkNode startNode = null;
        LinkNode endNode = null;
        LinkNode tmp = node;
        int x= 0;
        LinkNode sp = null;
        boolean f = true;
        while (tmp!=null){
            if (x == start){
                f= false;
                startNode = tmp;
            }else if (x == end){
                endNode = tmp;
                break;
            }
            if (f){
                sp = tmp;
            }
            x++;
            tmp = tmp.next;
        }
        if ( startNode == null || endNode == null){
            return;
        }
        LinkNode next = endNode.next;
        LinkNode newHead = startNode;
        tmp = startNode.next;
        while (tmp!=next){
            LinkNode tmpNext = tmp.next;

            tmp.next = newHead;
            newHead = tmp;
            tmp = tmpNext;
        }
        startNode.next = next;

        if (sp!=null){
            sp.next = newHead;
        }

    }

    public static void showLinkList(LinkNode node){
        while (node!=null){
            System.out.print(node.v+"\t");
            node = node.next;
        }
        System.out.println();
    }


    public static void main(String[] args) {
        LinkNode linkNode = new LinkNode(1);
        LinkNode tmp = linkNode;
        for (int x=2;x<20;x++){
            linkNode.next = new LinkNode(x);
            linkNode = linkNode.next;
        }
        showLinkList(tmp);
        reverseLinkNode(tmp,2,3);
        showLinkList(tmp);
    }
}
