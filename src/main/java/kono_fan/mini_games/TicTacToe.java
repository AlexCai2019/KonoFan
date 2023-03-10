package kono_fan.mini_games;

public class TicTacToe implements IMiniClass
{
	private final Piece[][] board =
			{
					{ Piece.BLANK, Piece.BLANK, Piece.BLANK},
					{ Piece.BLANK, Piece.BLANK, Piece.BLANK},
					{ Piece.BLANK, Piece.BLANK, Piece.BLANK}
			};
	private final StringBuilder builder = new StringBuilder();
	private int stage = 0;
	private final Place[] humanPlace = new Place[3];
	private final int[][] humanRowAndColumn = new int[3][2];

	public boolean put(int row, int column)
	{
		if (0 <= row && row <= 2 && 0 <= column && column <= 2)
		{
			if (board[row][column] == Piece.BLANK)
			{
				board[row][column] = Piece.CROSS;
				humanPlace[stage] = (row == 1 && column == 1) ? Place.CENTER : (Math.abs(row - column) == 1) ? Place.SIDE : Place.CORNER;
				humanRowAndColumn[stage][0] = row;
				humanRowAndColumn[stage][1] = column;
				stage++;
				return true;
			}
		}
		return false;
	}

	public void thinking()
	{
		switch (stage)
		{
			case 1: //第一階段
				if (humanPlace[0] == Place.CENTER) //玩家下在中心
					board[0][0] = Piece.NOUGHT; //放在左上角
				else //玩家下在中心旁或是下在角落
					board[1][1] = Piece.NOUGHT; //都放中間
				return;

			case 2: //第二階段
				switch (humanPlace[0])
				{
					//我知道它很長
					//但我懶得管了
					//能動就行
					case CENTER: //第一階段玩家下在中心
						if (board[2][2] == Piece.NOUGHT) //第二階段玩家下在右下角
							board[0][2] = Piece.NOUGHT; //直接搶占第一列 因為左上角已經在第一階段阻止了
						else //玩家下在其他地方
							board[2 - humanRowAndColumn[1][0]][2 - humanRowAndColumn[1][1]] = Piece.NOUGHT; //下在對面阻止他
						return;

					case SIDE: //第一階段玩家下在側邊
						if (humanPlace[1] == Place.SIDE) //第二階段玩家還是下在側邊
							board[0][0] = Piece.NOUGHT; //直接搶佔左上角 中間已經搶到了 無須擔心
						else //第二階段玩家下在角落
						{
							if (board[0][1] == Piece.CROSS) //第一階段玩家下在中上
							{
								if (board[0][0] == Piece.CROSS) //第二階段玩家下在左上
									board[0][2] = Piece.NOUGHT; //阻止右上
								else if (board[0][2] == Piece.CROSS) //第二階段玩家下在右上
									board[0][0] = Piece.NOUGHT; //阻止左上
								else //不足為懼
									board[2 - humanRowAndColumn[1][0]][2 - humanRowAndColumn[1][1]] = Piece.NOUGHT; //下在他下的那顆子的對面
							}
							else if (board[1][0] == Piece.CROSS) //第一階段玩家下在中左
							{
								if (board[0][0] == Piece.CROSS) //第二階段玩家下在左上
									board[2][0] = Piece.NOUGHT; //阻止左下
								else if (board[2][0] == Piece.CROSS) //第二階段玩家下在左下
									board[0][0] = Piece.NOUGHT; //阻止左上
								else //不足為懼
									board[2 - humanRowAndColumn[1][0]][2 - humanRowAndColumn[1][1]] = Piece.NOUGHT; //下在他下的那顆子的對面
							}
							else if (board[1][2] == Piece.CROSS) //第一階段玩家下在中右
							{
								if (board[0][2] == Piece.CROSS) //第二階段玩家下在右上
									board[2][2] = Piece.NOUGHT; //阻止右下
								else if (board[2][2] == Piece.CROSS) //第二階段玩家下在右下
									board[0][2] = Piece.NOUGHT; //阻止右上
								else //不足為懼
									board[2 - humanRowAndColumn[1][0]][2 - humanRowAndColumn[1][1]] = Piece.NOUGHT; //下在他下的那顆子的對面
							}
							else if (board[2][1] == Piece.CROSS) //第一階段玩家下在中下
							{
								if (board[2][0] == Piece.CROSS) //第二階段玩家下在左下
									board[2][2] = Piece.NOUGHT; //阻止右下
								else if (board[2][2] == Piece.CROSS) //第二階段玩家下在右下
									board[2][0] = Piece.NOUGHT; //阻止左下
								else //不足為懼
									board[2 - humanRowAndColumn[1][0]][2 - humanRowAndColumn[1][1]] = Piece.NOUGHT; //下在他下的那顆子的對面
							}
							else //不足為懼
								board[2 - humanRowAndColumn[1][0]][2 - humanRowAndColumn[1][1]] = Piece.NOUGHT; //下在他下的那顆子的對面
						}
						return;

					case CORNER: //第一階段玩家下在角落
						if (humanPlace[1] == Place.CORNER) //玩家在第二階段也下在角落
						{
							//00 20 02 22
							if (board[0][0] == Piece.CROSS) //玩家下在左上
							{
								if (board[0][2] == Piece.CROSS) //玩家下在右上
									board[0][1] = Piece.NOUGHT; //阻止中上
								else if (board[2][0] == Piece.CROSS) //玩家下在左下
									board[1][0] = Piece.NOUGHT; //阻止中左
								else //不足為懼
									board[0][1] = Piece.NOUGHT;
							}
							else if (board[0][2] == Piece.CROSS) //玩家下在右上
							{
								if (board[2][2] == Piece.CROSS) //玩家下在右下
									board[1][2] = Piece.NOUGHT; //阻止中右
								else //不足為懼
									board[0][1] = Piece.NOUGHT;
							}
							else //玩家下在左下和右下
								board[2][1] = Piece.NOUGHT;
							//之所以不需檢查其他第一階段玩家下在左下和右下的情形
							//是因為順序並不重要
							//如果玩家第一階段下在左下 第二階段上在左上
							//還是會在第一個if就被檢查出來
						}
						else //玩家在第二階段下在側邊
						{
							;
						}
				}
				return;
		}
	}

	@Override
	public String getName()
	{
		return "Tic-Tac-Toe";
	}

	@Override
	public String toString()
	{
		builder.setLength(0);
		builder.append("```\n");
		for (byte i = 0; i <= 2; i++)
			for (byte j = 0; j <= 2; j++)
				builder.append(board[i][j]).append(j != 2 ? " | " : i != 2 ? "\n---------\n" : "\n```");
		return builder.toString();
	}
}

enum Piece
{
	BLANK
	{
		@Override
		public String toString()
		{
			return " ";
		}
	},
	NOUGHT
	{
		@Override
		public String toString()
		{
			return "O";
		}
	},
	CROSS
	{
		@Override
		public String toString()
		{
			return "X";
		}
	}
}

enum Place
{
	CENTER,
	SIDE,
	CORNER
}