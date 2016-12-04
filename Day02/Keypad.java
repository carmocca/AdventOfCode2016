public class Keypad {
	private int ypos, xpos;

	public Keypad (int startPos) {
		intToPos(startPos);
	}

	public int getCurrentButton(){
		return posToInt(ypos, xpos);
	}

	public void move(char move)	{
		switch (move) {
			case 'U':	if (ypos > 0) {
							ypos--;
						}
						break;
			case 'D':	if (ypos < 2) {
							ypos++;
						}
						break;
			case 'R':	if (xpos < 2) {
							xpos++;
						}
						break;
			case 'L':	if (xpos > 0) {
							xpos--;
						}
						break;
			default: 	System.out.println("Error: Wrong move");
						System.exit(0);
						break;
		}
	}

	/* Given the key modifies the position
	*/
	public void intToPos(int startPos) {
		switch (startPos) {
			case 1:	ypos = 0;
					xpos = 0;
					break;
			case 2:	ypos = 0;
					xpos = 1;
					break;
			case 3: ypos = 0;
					xpos = 2;
					break;
			case 4: ypos = 1;
					xpos = 0;
					break;
			case 5: ypos = 1;
					xpos = 1;
					break;
			case 6: ypos = 1;
					xpos = 2;
					break;
			case 7: ypos = 2;
					xpos = 0;
					break;
			case 8: ypos = 2;
					xpos = 1;
					break;
			case 9: ypos = 2;
					xpos = 2;
					break;
		   default: ypos = 1; //Center
					xpos = 1;
					break;
		}
	}

	/*	Given the position on the matrix returns the key number
	*/
	public int posToInt(int x, int y) {
		return x * 3 + y + 1;
	}	
}
