package Queue;

import java.util.Iterator;
import node.node;

public class Queue<T> implements iQueue<T>, Iterable<T> {
	
	private int tam = 0;
	private node<T> sentinel = null;
	private node<T> tmp = null;
	node<T> entrada;
    public node<T> back, front;
    public int count = 0, size = 10;
    private node<T> start = null;
    private node<T> end = null;

	public Queue(){
		start = new node<>();
        end = new node<>();
        node<T> nodo = new node<>();
        start.setIndex(-1);
        end.setIndex(-1);
        node<T> tmp = start.getRight();
        start.setRight(nodo);
        nodo.setLeft(start);
        while (count < size) {
            node<T> _new = new node<>();
            tmp.setRight(_new);
            _new.setLeft(tmp);
            tmp = tmp.getRight();
            count += 1;
        }
        end.setLeft(tmp);
        Reindex();
        front = start.getRight();
        back = start.getRight();
    }
	
    public Queue(int size) {
        count = 0;
        this.size = size;
        start = new node<>();
        start.setIndex(-1);
        end = new node<>();
        end.setIndex(-1);
        node<T> nodo = new node<>();
        start.setRight(nodo);
        nodo.setLeft(start);
        node<T> tmp = start.getRight();
        while (count < size) {
            node<T> _new = new node<>();
            tmp.setRight(_new);
            _new.setLeft(tmp);
            tmp = tmp.getRight();
            count += 1;
        }
        end.setLeft(tmp);
        Reindex();
        front = start.getRight();
        back = start.getRight();
        count = 0;
    }
	
	private void Reindex() {
		node<T> tmp = start;
        int i = 0;
        while (tmp.getRight() != null) {
            tmp = tmp.getRight();
            tmp.setIndex(i);
            i++;
        }
	}
	
	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>() {
			node<T> extra = sentinel.getRight();
			@Override
			public boolean hasNext() 
			{
				System.out.println(extra.getValue());
				extra = extra.getRight();
				return (extra != sentinel.getRight());
			}
			@Override
			public T next() 
			{
				return extra.getValue();
			}
		};
	}

	@Override
	public void enQueue(T value) throws QueueFullException 
	{
		if (isFull()) throw new QueueFullException("Cola Llena");
		tmp = sentinel.getRight();
		entrada = new node<T>(value);
		if(isEmpty())
		{
			sentinel.setRight(entrada);
			entrada.setRight(entrada);
			
		}
		else if(!isFull())
		{
			while(!tmp.getRight().equals(sentinel.getRight())) 
			{
				tmp = tmp.getRight();
			}
			tmp.setRight(entrada);
			entrada.setRight(sentinel.getRight());
		}
		count++;
	}

	@Override
	public T deQueue() throws QueueEmptyException 
	{
		if (isEmpty()) throw new QueueEmptyException("Cola Vacia Por Favor De Llenar");
		if(size() > 1) 
		{
			tmp = buscanuevo(front(), sentinel.getRight());
			sentinel.setRight(sentinel.getRight().getRight());
			tmp.setRight(tmp.getRight().getRight());
			count--;
			return sentinel.getRight().getValue();
		}
		return null;
	}

	@Override
	public boolean isEmpty() 
	{
		return (count == 0);
	}

	@Override
	public boolean isFull() 
	{
		return (count == tam);
	}

	@Override
	public T front() throws QueueEmptyException {
		if (isEmpty()) throw new QueueEmptyException("Cola Vacia Por Favor De Llenar");
		if(!isEmpty())
		{
			return sentinel.getRight().getValue();
		}
		return null;
	}
	private node<T> buscanuevo(T value, node<T> lista)
	{
		if(lista.getRight().getValue().equals(value))
		{
			return lista;
		}
		return buscanuevo(value, lista.getRight());
	}
	@Override
	public T search(T value) throws QueueEmptyException 
	{
		if (isEmpty()) throw new QueueEmptyException("Cola Vacia Por Favor De Llenar");
		return search(value, sentinel.getRight());
	}
	private T search(T value, node<T> lista)
	{
		if(lista.getRight().getValue().equals(value))
		{
			return lista.getRight().getValue();
		}
		return search(value, lista.getRight());
	}

	@Override
	public void clear() 
	{
		sentinel.setRight(null);
        count = 0;
	}

	@Override
	public boolean frontOf(T value, int priority) throws QueueFullException 
	{
		return false;
	}

	@Override
	public int size() 
	{
		return count;
	}
}
