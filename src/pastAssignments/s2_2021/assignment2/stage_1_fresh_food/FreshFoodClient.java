package pastAssignments.s2_2021.assignment2.stage_1_fresh_food;

public class FreshFoodClient {
	public static void main(String[] args) {
		String output = getFreshFoodClientSampleOutputA();
		System.out.println(output);
	}

	public static String getFreshFoodClientSampleOutputA() {
		String result = "";

		Tray[] traysA = new Tray[8];
		for(int i=0; i < traysA.length; i++) {
			traysA[i] = new Tray(new TrayType(10+10*i), 5+8*i);
		}

		Tray[] traysB = new Tray[8];
		for(int i=0; i < traysB.length; i++) {
			traysB[i] = new Tray(new TrayType(10+10*i), 5+8*i);
		}

		Carton c1 = new Carton("Carton 1", traysA);
		Carton c2 = new Carton("Carton 2", traysB);

		result+=(c1+"\n");
		result+=(c2+"\n");

		result+=("identical?: "+c1.identical(c2)+"\n");
		result+=("same (with re-arrangement)?: "+c1.sameButRearranged(c2)+"\n");

		for(int i=0; i < traysB.length; i++) {
			int idx1 = i*83%traysB.length;
			int idx2 = (idx1+5)*83%traysB.length;
			Tray temp = traysB[idx1];
			traysB[idx1] = traysB[idx2];
			traysB[idx2] = temp;
		}

		result+=("After swapping in carton 2\n");
		result+=(c2+"\n");

		result+=("identical?: "+c1.identical(c2)+"\n");


		result+=("same (with re-arrangement)?: "+c1.sameButRearranged(c2)+"\n");
		result+=("increasing quantity of 4th item in carton 2\n");

		c2.trays[3].quantity++;
		result+=("same (with re-arrangement)?: "+c1.sameButRearranged(c2)+"\n");

		result+=("decreasing quantity back of 4th item in carton 2\n");

		c2.trays[3].quantity--;
		result+=("same (with re-arrangement)?: "+c1.sameButRearranged(c2)+"\n");

		result+=("decreasing quantity of last item in carton 1\n");

		c1.trays[c1.trays.length-1].quantity--;
		result+=("same (with re-arrangement)?: "+c1.sameButRearranged(c2)+"\n");

		return result;
	}


}
