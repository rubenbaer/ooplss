abstract class List {
  type Node <: AbstractNode; /* \label{line:abstractType1} */
  type Value; /* \label{line:abstractType2} */
  def getNext(node: Node): Node;
  def getPrev(node: Node): Node;
  def getFirst(): Node;
  abstract class AbstractNode(val value: Value) {
    def insertAfter(value: Value): Node;
  }
  def getValue(): Value = {
    return value;
  }
}

abstract class AbstractList extends List {
  protected def createNode(node: Node, value: Value): Node; /* \label{line:factory} */
  protected var first: Node = _;
  def getFirst(): Node = {
    return first;
  }
  abstract class AbstractNodeImpl(value: Value) extends AbstractNode(value) {
    self: Node => /* \label{line:explicitSelf} */
    def insertAfter(value: Value): Node = {
      return createNode(self, value); /* \label{line:useFactory} */
    }
  }
}

class DoublyLinkedList[ValueType] extends AbstractList {
  type Node = DoublyLinkedNode; /* \label{line:typeInstance1} */
  type Value = ValueType; /* \label{line:typeInstance2} */
  def getNext(node: Node): Node = {
    return node.next;
  }
  def getPrev(node: Node): Node = {
    return node.prev;
  }
  protected def createNode(node: Node, value: Value): Node = {
    return new DoublyLinkedNode(node.prev, node.next, value)
  }
  protected class DoublyLinkedNode(val prev: Node, val next: Node, value: Value) extends AbstractNodeImpl(value) {
    // Initialisation code
  }
}
