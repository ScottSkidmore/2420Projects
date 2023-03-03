package assign06;

import java.util.NoSuchElementException;

public class WebBrowser<URL> {
	private LinkedListStack<URL> backStack;
	private LinkedListStack<URL> forwardStack;

	public WebBrowser() {
		backStack = new LinkedListStack<URL>();
		forwardStack = new LinkedListStack<URL>();
	}

	public WebBrowser(SinglyLinkedList<URL> history) {
		for (int i = 0; i < history.size()-1; i++) {
			backStack.push(history.delete(history.size() - i));
		}
	}

	public void visit(URL webpage) {
		backStack.push(webpage);
		forwardStack.clear();
	}

	public URL back() throws NoSuchElementException {
		if (backStack.isEmpty()) {
			throw new NoSuchElementException();
		} else {
			forwardStack.push(backStack.pop());
			return backStack.peek();
		}
	}

	public URL forward() throws NoSuchElementException {
		if (forwardStack.isEmpty()) {
			throw new NoSuchElementException();
		} else {
			backStack.push(forwardStack.peek());
			return forwardStack.pop();
		}

	}
	public SinglyLinkedList<URL> history(){
		return backStack.get();
	}
}
