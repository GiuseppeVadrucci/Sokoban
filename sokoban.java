

public class Sokoban {
	
	
	private /*@spec_public@*/ boolean[][] scacchiera;
	int a=0, b=0;

	
	
	
	/*@ ensures (\forall int i; i >= 0 && i < 5;(\forall int j; j >=0 && j < 5;!(i==1 && j==1)==> 
	 @  scacchiera[i][j] == false));
	 
	
	 @*/
	public Sokoban(){
		
	

			scacchiera = new boolean[5][5];
			int i = 0, j = 0;
			
				while(i < 5){
					while( j < 5){
						if(scacchiera[i][j] == true){
							scacchiera[i][j] = false;
						}
					j = j+1;
					}
				i = i+1;
				j = 0;
				}
			this.a = 0;
			this.b = 0;
			scacchiera[1][1] = true;
					
		
	
		}
	
	 
	
	
	
	/*@ requires dir >=1 && dir <=4; 
	  @ ensures (\num_of int i, j;i>=0 && i<5 &&  j>=0 && j <5;
	  @ scacchiera[i][j] == true) == 0;
	 
	  @*/ 

	
	 public boolean move(int dir){
		
		if(dir == 1){
			
			if(this.a == 0){
				return false;
			}
			if(scacchiera[this.a - 1][this.b] != true){
				this.a = this.a - 1;
				return true;
			}
			else
				if(this.a - 1 == 0){
					return false;
				}
				else
					scacchiera[this.a -2][b] = true;
					scacchiera[this.a - 1][this.b] = false;
					this.a = this.a -1;
					return true;
			
		}
			
		
		if(dir == 2){
			
			if(this.b == 4){
				return false;
			}
			if(scacchiera[this.a][this.b + 1] != true){
				this.b = this.b + 1;
				return true;
			}
			else
				if(this.b + 1 == 4){
					return false;
				}
				else
					scacchiera[this.a][this.b + 2] = true;
					scacchiera[this.a][this.b + 1] = false;
					this.b = this.b +1;
					return true;
			
		}
		if(dir == 3){
			
			if(this.a == 4){
				return false;
			}
			if(scacchiera[this.a + 1][this.b] != true){
				this.a = this.a + 1;
				return true;
			}
			else
				if(this.a + 1 == 4){
					return false;
				}
				else
					scacchiera[this.a +2][this.b] = true;
					scacchiera[this.a + 1][this.b] = false;
					this.a = this.a +1;
					return true;
	
		}
		if(dir == 4){
			
			
				if(this.b == 0){
					return false;
				}
				if(scacchiera[this.a][this.b - 1] != true){
					this.b = this.b - 1;
					return true;
				}
				else
					if(this.b - 1 == 0){
						return false;
					}
					else
						scacchiera[this.a][this.b - 2] = true;
						scacchiera[this.a][this.b - 1] = false;
						this.b = this.b -1;
						return true;
				
	
		}
		return false;
	}
	
	
	
	public String print() {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < 5; i++) {
			System.out.print(" ");
			for(int j = 0; j < 4; j++) {
				System.out.print(getSign(i, j) +  " | ");
			}
			System.out.println(getSign(i, 4));
			if(i < 4) {
				for(int j = 0; j < 5; j++) {
					System.out.print("----");
				}
			}
			System.out.println();
		}
		return sb.toString();
	}

	private String getSign(int r, int c) {
		if(r == this.a && this.b == c) {
			return "A";
		}
		else if(scacchiera[r][c]) {
			return "B";
		}
		else {
			return " ";
		}
	}


		
