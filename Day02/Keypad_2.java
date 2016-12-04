public class Keypad_2 {
	private char [][] keypad;
	private int ypos, xpos;

	public Keypad_2 (char startPos) {
		keypad = new char[][]{{'.','.','1','.','.'},
							  {'.','2','3','4','.'},
							  {'5','6','7','8','9'},
							  {'.','A','B','C','.'},
							  {'.','.','D','.','.'}};
		buttonToPos(startPos);
	}

	public char getCurrentButton(){
		return posToButton(ypos, xpos);
	}

	public void move(char move)	{
		switch (move) {
			case 'U':	if (ypos > 0 && keypad[ypos - 1][xpos] != '.') {
							ypos--;
						}
						break;
			case 'D':	if (ypos < 4 && keypad[ypos + 1][xpos] != '.') {
							ypos++;
						}
						break;
			case 'R':	if (xpos < 4 && keypad[ypos][xpos + 1] != '.') {
							xpos++;
						}
						break;
			case 'L':	if (xpos > 0 && keypad[ypos][xpos - 1] != '.') {
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
	public void buttonToPos(char startPos) {
		switch (startPos) {
			case '1':	ypos = 0;
						xpos = 2;
						break;
			case '2':	ypos = 1;
						xpos = 1;
						break;
			case '3':	ypos = 1;
						xpos = 2;
						break;
			case '4':	ypos = 1;
						xpos = 3;
						break;
			case '5':	ypos = 2;
						xpos = 0;
						break;
			case '6':	ypos = 2;
						xpos = 1;
						break;
			case '7':	ypos = 2;
						xpos = 2;
						break;
			case '8':	ypos = 2;
						xpos = 3;
						break;
			case '9':	ypos = 2;
						xpos = 4;
						break;
			case 'A':	ypos = 3;
						xpos = 1;
						break;
			case 'B':	ypos = 3;
						xpos = 2;
						break;
			case 'C':	ypos = 3;
						xpos = 3;
						break;
			case 'D':	ypos = 4;
						xpos = 2;
						break;
			default:	ypos = 2; //Center
						xpos = 2;
						break;
		}
	}

	/*	Given the position on the matrix returns the key number
	*/
	public char posToButton(int y, int x) {
		return keypad[y][x];
	}	
}
