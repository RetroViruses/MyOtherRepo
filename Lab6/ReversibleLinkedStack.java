
public class ReversibleLinkedStack<T> extends LinkedStack<T>
{
  public void reverse() {
	  LinkedStack<T> tempStack=new LinkedStack<T>();
	  while (this.isEmpty()==false){
		  tempStack.push(this.pop());
	  }
	  LinearNode<T> tempTop = new LinearNode<T>();
	  this.top = tempStack.top;
	  this.count = tempStack.count;
  }

}