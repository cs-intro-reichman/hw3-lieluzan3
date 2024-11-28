
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
	    // Tests some of the operations
	    System.out.println(plus(2,3));   // 2 + 3
	    System.out.println(minus(7,2));  // 7 - 2
   		System.out.println(minus(2,7));  // 2 - 7
 		System.out.println(times(3,4));  // 3 * 4
   		System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
   		System.out.println(pow(5,3));      // 5^3
   		System.out.println(pow(3,5));      // 3^5
   		System.out.println(div(12,3));   // 12 / 3    
   		System.out.println(div(5,5));    // 5 / 5  
   		System.out.println(div(25,7));   // 25 / 7
   		System.out.println(mod(25,7));   // 25 % 7
   		System.out.println(mod(120,6));  // 120 % 6    
   		 System.out.println(sqrt(36));
		 System.out.println(sqrt(263169));
   		 System.out.println(sqrt(76123));
   		 System.out.println(sqrt(76123));

	}  

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		if(x2<0){
			int num=0;
			for(int j=x2; j<0; j++){
				num++;
			}
			return (minus(x1, num));
		}
		for(int i=0; i<x2; i++){
			x1++;

		}
		return x1;
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		if(x2<0){
		int num=0;
		for(int j=x2; j<0; j++){
			num++;
		}
		return (plus(x1, num));
	}

		for (int i = 0; i < x2; i++) {
			x1--;
		}
		
		
		return x1;
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {
		int num=0;
		int num2=0;
		if(x1<0&&x2<0){
			for (int i =x1; i < 0; i++) {
				num++;
				
			}
			for (int i = x2; i < 0; i++) {
				num2++;
				
			}
			return times(num, num2);
		}
		else if(x1<0){
			for (int i = x1; i <0; i++) {
				num++;
				
			}
			num2=times(num, x2);
			num=0;
			for (int i = 0; i < num2; i++) {
				num--;
				
			}
			return num;
			
		}

		else if(x2<0){
			for (int i = x2; i <0; i++) {
				num++;
				
			}
			num2=times(x1, num);
			num=0;
			for (int i = 0; i < num2; i++) {
				num--;
				
			}
			return num;

		}
		else{
		for (int i = 0; i < x2; i++) {
			for (int j = 0; j < x1; j++) {
				num++;

				
			}
			
		}
		return num;
	}
}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		int num=0;
		int num1=x;
		int num2=0;
		if(n==0){
			return 1;
		}
		
	
	  if(x<0&&mod(n, 2)==1){
		for (int i = x; i < 0;i++) {
			num++;
			
		}
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < num; j++) {
				for (int k = 0; k < x; k++) {
					num2++;
				}
			}
		}
		num=0;
		for (int i = 0; i < num2; i++) {
			num--;
			
		}
		return num2;
	}
			
			else if(x<0&&mod(n, 2)==0){
				for (int i = x; i < 0;i++) {
					num++;
					
				}
				return pow(num, n);
				


			}
			else{
				
					for (int i = 1; i < n; i++) {
						for (int j = 0; j < num1; j++) {
							for (int k = 0; k < x; k++) {
								num++;
							}
						}
						num1=num;
						num=0;
					}
					return num1;
			} 
		}
			


	
	

	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) {
		int num1=0;
		int num2=0;
		if(x1<0){
			while(num1>x1){
				for(int i=0; i<x2; i++){
					num1--;
				}
				num2--;
			}
			if(num1<x1){
				num2++;
			}
			return num2;
		}
		else if (x2<0) {
			for (int i =x2; i < 0; i++) {
				num1++;
				
			}
			x2=num1;
			num1=0;
			while(num1<x1){
				for(int i=0; i<x2; i++){
					num1++;
				}
				num2++;
			}
			if(num1>x1){
				num2--;
			}
			num1=0;
			for (int i = 0; i < num2; i++) {
				num1--;

				
			}
			return num1;
			
		}
		else if(x1<0&&x2<0){
			for (int i = x1; i < 0; i++) {
				num1++;
				
			}
			for (int i = x2; i < 0; i++) {
				num2++;
				
			}
			return pow(num1, num1);
		}
	
			else 
			while(num1<x1){
				for(int i=0; i<x2; i++){
					num1++;
				}
				num2++;
			}
			if(num1>x1){
				num2--;
			}
			
		return num2;
	}
	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		if(x2>x1){
		return x1;
		}
		while(x2<=x1){
			for (int i = 0; i <x2; i++) {
				x1--;
				
			}
		
			
		}

		
		return x1;
	}	

	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {
		int num=0;
		while(num<x){
			if(times(num, num)<x){
			num++;
			}
		
			else if(times(num,num)==x){
				return num;
			}
			else {
				num--;
				return num;
			}

			
		}

		return num;
	}	  	  
}