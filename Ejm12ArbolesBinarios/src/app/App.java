package app;

import btree.btree;


public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

        btree<Integer> prueba = new btree<>();

        prueba.add(20);
        prueba.add(40);
        prueba.add(10);
        prueba.add(60);
        prueba.add(50);
        prueba.add(30);
        prueba.add(70);
        prueba.add(75);
        prueba.add(22);

        System.out.println("breadthsearch: ");
        System.out.println(""+prueba.breadthSearch(70));
        System.out.println("preorder:");
        prueba.printPreorder();
        System.out.println("posorder");
        prueba.printPosOrder();
        System.out.println("inorder");
        prueba.printInorder();
        System.out.println("\nborrar:");
        prueba.clear();
        System.out.println("isempty:");
        System.out.println(""+prueba.isEmpty());
        
        System.out.println(""+prueba.deepSearch(70));
		
	}
		
		
		
		
		
		
		/*
		btree<Integer> numeritos = new btree<Integer>();
		btree<String> names = new btree<String>();
		numeritos.add(0);
		numeritos.add(2);
		numeritos.add(-4);
		numeritos.add(3);
		numeritos.add(-50);
		numeritos.add(10);
		numeritos.add(11);
		numeritos.add(12);
		*/
		/*numeritos.add(0);
		numeritos.add(0);
	/*	int i=0,value = (int)Math.random()*100;
		
		while (i<10000) {
			numeritos.add((int)Math.random()*100);
			i++;
		}*/
		//numeritos.remove(0);
		//numeritos.clear();
		
		//System.out.println("La profundidad es: " + numeritos.maxDepth()); 
		//numeritos.printInorder();
		
		//numeritos.printPosOrder();
		//numeritos.printPreorder();
		//while (numeritos.remove(0));
		//System.out.println("");
		//System.out.println("--------------------------------------");
		//numeritos.printInorder();
		
		/*
		node<Integer> tmp = numeritos.isChild(9);
		if (tmp!=null )System.out.println("Padre del 9 es "+tmp.getValue());
		
		
		names.add("Fernando");
		names.add("Rotzana");
		names.add("Jalil");
		names.add("Milton");
		names.add("Chardo");
		names.printInorder();
		*/
		


}





