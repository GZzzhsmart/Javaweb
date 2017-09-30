package T1;

public class EatFish {
	
	 public static void main(String args[]) {
        NodeEat head = new NodeEat("吸血鬼");
        LinkEat link = new LinkEat(head);
        link.addNode(new NodeEat("人"));
        link.addNode(new NodeEat("大鱼"));
        link.addNode(new NodeEat("小鱼"));
        link.addNode(new NodeEat("小虾"));
        link.addNode(new NodeEat("紫泥"));
        NodeEat p = head;
        System.out.println("这是一条食物链。。");
        while (p.hasNext()) { //首先遍历整个链表
            p = p.getNext();
        }

        while (head.hasNext()) { //不断的删除最后一个节点
            link.delLastNode();
        }
    }
}

class LinkEat {
    private NodeEat head;
    public LinkEat(NodeEat head) {
        this.head = head;
    }

    //追加节点
    public void addNode(NodeEat node) {
        NodeEat p = head;
        while (true) {
            if (!p.hasNext()) {
                p.setNext(node);
                break;
            }
            p = p.getNext();
        }
    }
	//删除节点
    public boolean delLastNode() {
        NodeEat p = head;
        if (!p.hasNext()) {
            System.out.println("此表为空");
            return false;
        } 
		while (p.getNext().getNext() != null) {
            p = p.getNext();
        }
        System.out.println("\n" + p.getName() + " 看见了 "
                           + p.getNext().getName() + " 啊呜一口，吃掉了：-（");
        p.setNext(null);
        return true;
    }

    //遍历链表
    public void display() {
        NodeEat p = head.getNext();
        while (p != null) {
            System.out.println(p.getName());
            p = p.getNext();
        }
    }
}

class NodeEat {
  private String nodeName;
    private NodeEat next;
    //用数据域构造一个节点对象
    public NodeEat(String nodeName) {
        this.nodeName = nodeName;
    }

    //返回下一节点的对象
    public NodeEat getNext() {
        return this.next;
    }

    //设置本节点的链域
    public void setNext(NodeEat next) {
        this.next = next;
    }

    //返回节点的数据域
    public String getName() {
        return this.nodeName;
    }

    //判断是否有下一节点
    public boolean hasNext() {
        boolean is = false;
        if (this.next != null) {
            is = true;
        }
        return is;
    }
}


