import java.util.Scanner;

public class RelTest {
	
	public static void main (String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter a non-negative integer giving the number of strings in the set: ");
		int numberOfStrings = input.nextInt();
		System.out.println("Enter " + numberOfStrings + " words naming the disctinct strings in the set: ");
		String[] array = new String[numberOfStrings];
		for(int i=0; i<array.length; i++) {
			array[i]=input.next();
		}
		
		System.out.println("Enter a non-negative integer giving the number of pairs in the relation: ");
		int numberOfPairs = input.nextInt();
		System.out.println("Enter " + numberOfPairs + " distinct pairs: ");
		int numberOfPairs2 = numberOfPairs * 2;
		String[] array2 = new String[numberOfPairs2];
		for (int i=0; i<(numberOfPairs * 2); i++) {
			array2[i] = input.next();
		}input.close();
		
		System.out.println("\n\nRelationship Summary");
		System.out.println("---------------------");
		
		//Code will check the Reflexive Status
		int count = 0;
		boolean reflexStats = false;
		for(int i=0; i<array.length; i++) {
			for(int j=0; j<array2.length; j+=2) {
				if(array[i].equals(array2[j]) && (array[i].equals(array2[j+1]))) {
					count++;
				}
			}
		}
		if (count == array.length) {
			System.out.println("Reflexive");
			reflexStats = true;
		}else {
			System.out.println("Not Reflexive");
		}
		
		//Code will check the Symmetric Status
		int[] indexArray = new int[numberOfPairs];
		int index = 0;
		boolean symmetryStats = false;
		for(int i=0; i<array2.length; i+=2) {
			if(!array2[i].equals(array2[i+1])) {
				indexArray[index] = i;
				index++;
			}
		}
		int count2 = 0;
		for(int i=0; i<index; i++) {
			for(int j=0; j<array.length; j+=2) {
				if((array2[indexArray[i]].equals(array2[j+1])) &&(array2[indexArray[i]+1].equals(array2[j]))) {
					count2++;
				}
			}
		}
		if(count2 == index) {
			System.out.println("Symmetric");
			symmetryStats = true;
		}else {
			System.out.println("Not Symmetric");
		}
		
		//Code will check the Transitivity Status
		int count3 = 0;
		int count4 = 0;
		boolean tranStats = false;
		for(int i=0; i<array2.length - 3; i+=2) {
			for(int j=i+2; j<array2.length - 1; j+=2) {
				if(array2[i+1].equals(array2[j])) {
					count3++;
					for(int k=0; k<array2.length; k+=2) {
						if((array2[k].equals(array2[i])) && (array2[k+1].equals(array2[j+1]))){
							count4++;
						}
					}
				}
			}
		}
		if(count3 == count4) {
			System.out.println("Transitive");
			tranStats = true;
		}else {
			System.out.println("Not Transitive");
		}
		
		//Code will check the Anti-Symmetry
		int[] indexArray2 = new int[numberOfPairs];
		int index2 = 0;
		boolean antiStats = false;
		for(int i=0; i<array2.length; i+=2) {
			if(!array2[i].equals(array2[i+1])) {
				indexArray2[index2] = i;
				index2++;
			}
		}
		int ct = 0;
		for(int i=0; i<index2; i++) {
			for(int j=0; j<array2.length; j+=2) {
				if((array2[indexArray2[i]].equals(array2[j+1])) && (array2[indexArray[i] + 1].equals(array2[j]))) {
					ct++;
				}
			}
		}
		if(ct == 0) {
			System.out.println("Antisymmetric");
			antiStats = true;
		}else {
			System.out.println("Not Antisymmetric");
		}
		
		if((reflexStats == true) && (symmetryStats == true) && (tranStats == true) && (antiStats = true)) {
			System.out.println("---------------------");
			System.out.println("Both");
		}else if(((reflexStats == true) && (symmetryStats == true) && (tranStats == true))) {
			System.out.println("---------------------");
			System.out.println("Equivalence Relation");
		}else if((reflexStats == true) && (antiStats == true) && (tranStats == true)) {
			System.out.println("---------------------");
			System.out.println("Partial Order");
		}else {
			System.out.println("---------------------");
			System.out.println("Neither");
		}
		
	}
	
}
