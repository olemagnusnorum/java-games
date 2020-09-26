package games;

public class LifeLogic2 {
	
	int[][] cells;
	int[][] copy;

	private int size;
	
	public LifeLogic2(int size) {
		this.size = size;
		cells = new int[size][size];
		copy = new int[size][size];
		this.add();
	}
	
	public void add() {
		for(int i = 0; i < size; i++) {
			for(int a = 0; a < size; a++) {
				cells[i][a] = (int) Math.round(Math.random());
			}
		}
	}
	
	
	public boolean isLeftEgdeCell(int row, int coll) {
		return coll == 0;
	}
	
	public boolean isRightEgdeCell(int row, int coll) {
		return coll == size-1;
	}
	
	public boolean isUpEgdeCell(int row, int coll) {
		return row == 0;
	}
	
	public boolean isDownEgdeCell(int row, int coll) {
		return row == size-1;
	}
	
	public boolean isCornerCell(int row, int coll) {
		return ((row == 0 && coll == 0) ||
				(row == 0 && coll == size-1) ||
				(row == size-1 && coll == 0) ||
				(row == size-1 && coll == size-1));
	}
	
	

	public int getCaseNumb(int row, int coll) {
		if(isCornerCell(row,coll)) {
			if(row == 0 && coll == 0) {  // upleft
				return 1;
			}
			else if(row == 0 && coll == size-1) { //upright
				return 2;
			}
			else if(row == size-1 && coll == 0) { // downleft
				return 3;
			}
			else if(row == size-1 && coll == size-1) { // downright
				return 4;
			}
		}
		else if(isLeftEgdeCell(row,coll)) {
			return 5;
		}
		else if(isUpEgdeCell(row,coll)) {
			return 6;
		}
		else if(isRightEgdeCell(row,coll)) {
			return 7;
		}
		else if(isDownEgdeCell(row,coll)) {
			return 8;
		}
		return 0;
	}
	
	
	public void upLeftCorner(int row, int coll) {
		int i = 0;
		if(cells[row][coll+1] == 1) {
			i++;
		}
		if(cells[row+1][coll] == 1) {
			i++;
		}
		if(cells[row+1][coll+1] == 1) {
			i++;
		}
		if(i >= 4 || i <= 1) {
			copy[row][coll] = 0;
		}else if(i == 3) {
			copy[row][coll] = 1;
		}
	}
	
	
	public void upRightCorner(int row, int coll) {
		int i = 0;
		if(cells[row][coll-1] == 1) {
			i++;
		}
		if(cells[row+1][coll] == 1) {
			i++;
		}
		if(cells[row+1][coll-1] == 1) {
			i++;
		}
		if(i >= 4 || i <= 1) {
			copy[row][coll] = 0;
		}else if(i == 3) {
			copy[row][coll] = 1;
		}
	}
	
	public void downLeftCorner(int row, int coll) {
		int i = 0;
		if(cells[row][coll+1] == 1) {
			i++;
		}
		if(cells[row-1][coll] == 1) {
			i++;
		}
		if(cells[row-1][coll+1] == 1) {
			i++;
		}
		if(i >= 4 || i <= 1) {
			copy[row][coll] = 0;
		}else if(i == 3) {
			copy[row][coll] = 1;
		}
	}	
	
	public void downRightCorner(int row, int coll) {
		int i = 0;
		if(cells[row][coll-1] == 1) {
			i++;
		}
		if(cells[row-1][coll] == 1) {
			i++;
		}
		if(cells[row-1][coll-1] == 1) {
			i++;
		}
		if(i >= 4 || i <= 1) {
			copy[row][coll] = 0;
		}else if(i == 3) {
			copy[row][coll] = 1;
		}
	}	
	
	public void leftEdge(int row, int coll) {
		int i = 0;
		if(cells[row-1][coll] == 1) {
			i++;
		}
		if(cells[row-1][coll+1] == 1) {
			i++;
		}
		if(cells[row][coll+1] == 1) {
			i++;
		}
		if(cells[row+1][coll+1] == 1) {
			i++;
		}
		if(cells[row+1][coll] == 1) {
			i++;
		}
		if(i >= 4 || i <= 1) {
			copy[row][coll] = 0;
		}else if(i == 3) {
			copy[row][coll] = 1;
		}
	}
	
	public void upEdge(int row, int coll) {
		int i = 0;
		if(cells[row][coll-1] == 1) {
			i++;
		}
		if(cells[row+1][coll-1] == 1) {
			i++;
		}
		if(cells[row+1][coll] == 1) {
			i++;
		}
		if(cells[row+1][coll+1] == 1) {
			i++;
		}
		if(cells[row][coll+1] == 1) {
			i++;
		}
		if(i >= 4 || i <= 1) {
			copy[row][coll] = 0;
		}else if(i == 3) {
			copy[row][coll] = 1;
		}
	}
	
	public void rightEdge(int row, int coll) {
		int i = 0;
		if(cells[row-1][coll] == 1) {
			i++;
		}
		if(cells[row-1][coll-1] == 1) {
			i++;
		}
		if(cells[row][coll-1] == 1) {
			i++;
		}
		if(cells[row+1][coll-1] == 1) {
			i++;
		}
		if(cells[row+1][coll] == 1) {
			i++;
		}
		if(i >= 4 || i <= 1) {
			copy[row][coll] = 0;
		}else if(i == 3) {
			copy[row][coll] = 1;
		}
	}
	
	public void downEdge(int row, int coll) {
		int i = 0;
		if(cells[row][coll-1] == 1) {
			i++;
		}
		if(cells[row-1][coll-1] == 1) {
			i++;
		}
		if(cells[row-1][coll] == 1) {
			i++;
		}
		if(cells[row-1][coll+1] == 1) {
			i++;
		}
		if(cells[row][coll+1] == 1) {
			i++;
		}
		if(i >= 4 || i <= 1) {
			copy[row][coll] = 0;
		}else if(i == 3) {
			copy[row][coll] = 1;
		}
	}
	
	
	public void center(int row, int coll) {
		int i = 0;
		if(cells[row-1][coll-1] == 1) {
			i++;
		}
		if(cells[row-1][coll] == 1) {
			i++;
		}
		if(cells[row-1][coll+1] == 1) {
			i++;
		}
		if(cells[row][coll+1] == 1) {
			i++;
		}
		if(cells[row+1][coll+1] == 1) {
			i++;
		}
		if(cells[row+1][coll] == 1) {
			i++;
		}
		if(cells[row+1][coll-1] == 1) {
			i++;
		}
		if(cells[row][coll-1] == 1) {
			i++;
		}
		if(i >= 4 || i <= 1) {
			copy[row][coll] = 0;
		}else if(i == 3) {
			copy[row][coll] = 1;
		}
		
	}
	
	
	public void simulate() {
		for(int x = 0; x < size; x++) {
			for(int a = 0; a < size; a++) {
				switch(getCaseNumb(x,a)) {
					case 1:
						this.upLeftCorner(x, a);
						break;
					case 2:
						this.upRightCorner(x, a);
						break;
					case 3:
						this.downLeftCorner(x, a);
						break;
					case 4:
						this.downRightCorner(x, a);
						break;
					case 5:
						this.leftEdge(x, a);
						break;
					case 6:
						this.upEdge(x, a);
						break;
					case 7:
						this.rightEdge(x, a);
						break;
					case 8: 
						this.downEdge(x, a);
						break;
					default:
						this.center(x, a);
				}
			}
		}
		for(int x = 0; x < size; x++) {
			for(int a = 0; a < size; a++) {
				cells[x][a] = copy[x][a];
			}
		}
	}
	
	
	public String toString() {
		String numb = "";
		for(int i = 0; i < size; i++) {
			for(int a = 0; a < size; a++) {
				if(a == size-1) {
					numb += cells[i][a]+" \n";
				}else {
					numb += cells[i][a]+" ";	
				}
			}
		}
		return numb;
	}
	
	public int getSize() {
		return this.size;
	}
	
	
	public static void main(String[] args) {
		LifeLogic2 test = new LifeLogic2(20);
		System.out.println(test);
		System.out.println("----------------------");
		test.simulate();
		System.out.println(test);
		test.simulate();
		System.out.println(test);
		test.simulate();
		System.out.println(test);
		test.simulate();
		System.out.println(test);
		test.simulate();
		System.out.println(test);
		test.simulate();
		System.out.println(test);
	}

}
