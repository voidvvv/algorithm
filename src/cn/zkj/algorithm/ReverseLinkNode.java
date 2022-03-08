package cn.zkj.algorithm;

public class ReverseLinkNode {
    private LinkNodeDemo header=new LinkNodeDemo(0,"");

    //添加节点(添加到最后)
    public void add(LinkNodeDemo link){
        LinkNodeDemo temp =header;
        while (true){
            if (temp.next==null){
                break;
            }
            temp=temp.next;
        }
        temp.next=link;
    }

    //添加节点(按照id顺序并且查重)
    public void add2(LinkNodeDemo link){
        LinkNodeDemo temp =header;
        while (true){
            if (temp.next==null||temp.next.getId()>link.getId()){
                break;
            }
            temp=temp.next;
        }
        if (temp.getId()==link.getId()){
            throw new RuntimeException("已经存在，不要重复添加");
        }
        link.next=temp.next;
        temp.next=link;
    }

    //遍历并且展示链表所有节点
    public void show(){
        LinkNodeDemo temp = header.next;
        while (true){
            if (temp==null){
                break;
            }
            System.out.println(temp);
            temp=temp.next;
        }
    }

    //反转链表所有节点
    public static void reverseLinkNode(LinkNodeDemo linkNode){
         LinkNodeDemo reversheader = new LinkNodeDemo(0,"");

         LinkNodeDemo temp1 = linkNode.next;
        LinkNodeDemo temp2 =null;
        while (true){
            if (temp1==null){
                break;
            }
            temp2 = temp1.next;
            temp1.next=reversheader.next;
            reversheader.next=temp1;
            temp1=temp2;
        }
        linkNode.next=reversheader.next;
    }

    //遍历并且展示指定链表所有节点
    public static void show2(LinkNodeDemo link){
        LinkNodeDemo temp = link.next;
        while (true){
            if (temp==null){
                break;
            }
            System.out.println(temp);
            temp=temp.next;
        }
    }

    public LinkNodeDemo reverseLinkNode03(LinkNodeDemo node){
        LinkNodeDemo newHead = null;

        while (node!=null){
            LinkNodeDemo next = node.next;
            LinkNodeDemo tmp = newHead;
            newHead = node;
            node.next = tmp;
            node = next;
        }
        return newHead;
    }

    public LinkNodeDemo reservLinkNode04(LinkNodeDemo node){
        LinkNodeDemo newHead = null;
        while (node !=null){
            LinkNodeDemo next = node.next;
            LinkNodeDemo tmp = newHead;
            newHead = node;
            newHead.next = tmp;
            node = next;
        }
        return newHead;
    }

    public static void main(String[] args) {
        ReverseLinkNode l = new ReverseLinkNode();
        l.add(new LinkNodeDemo(1,"zs"));
        l.add(new LinkNodeDemo(2,"ls"));
        l.add(new LinkNodeDemo(3,"ww"));
        l.add(new LinkNodeDemo(4,"zl"));
        l.show2(l.header);
        System.out.println("========");
        l.show2(l.reservLinkNode04(l.header));
    }

}
