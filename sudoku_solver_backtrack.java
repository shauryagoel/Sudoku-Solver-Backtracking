class coor
{
	public static int row;
	public static int col;
}

public class sudoku_solver_backtrack 
{
	static int grid[][];
	
	public static boolean solve()
	{
		if(!find())
			return true;
		int row=coor.row;
		int col=coor.col;
		for(int num=1;num<=9;num++)
		{
			if(issafe(row,col,num))
			{
				grid[row][col]=num;
				if(solve())
					return true;
				grid[row][col]=0;
			}
		}
		return false;
	}
	
	public static boolean find()
	{
		for(coor.row=0;coor.row<9;coor.row++)
			for(coor.col=0;coor.col<9;coor.col++)
				if(grid[coor.row][coor.col]==0)
					return true;
		return false;
	}
	
	public static boolean inrow(int row,int num)
	{
		for(int j=0;j<9;j++)
			if(grid[row][j]==num)
				return true;
		return false;
	}
	
	public static boolean incol(int col,int num)
	{
		for(int i=0;i<9;i++)
			if(grid[i][col]==num)
				return true;
		return false;
	}
	
	public static boolean inbox(int boxstartrow,int boxstartcol,int num)
	{
		for(int r=0;r<3;r++)
			for(int c=0;c<3;c++)
				if(grid[boxstartrow+r][boxstartcol+c]==num)
					return true;
		return false;
	}
	
	public static void display()
	{
		for(int i=0;i<9;i++)
		{
			for(int j=0;j<9;j++)
				System.out.print(grid[i][j]+" ");
			System.out.println();
		}
	}
	
	public static boolean issafe(int row,int col,int num)
	{
		return !inrow(row,num) && !incol(col,num) && !inbox(row-(row%3),col-(col%3),num);
	}
	public static void main(String[] args) 
	{
		grid=new int[][]
				{{1,0,9,3,7,0,0,0,4},
			{0,0,3,2,0,5,7,0,0},
			{6,7,0,0,0,0,3,0,0},
			{0,3,0,0,8,0,0,0,0},
			{0,0,4,6,0,7,5,0,0},
			{0,0,0,0,3,0,0,8,0},
			{0,0,0,0,0,0,0,3,1},
			{0,0,7,8,0,1,0,0,0},
			{5,0,0,0,0,0,9,7,6}};
        grid=new int[][]
        		{{0,0,0,7,0,2,0,8,0},
        	{5,0,0,4,0,0,1,0,0},
        	{0,0,6,0,0,0,0,0,0},
        	{4,0,0,0,0,0,0,0,7},
        	{0,0,3,0,8,0,6,0,0},
        	{9,0,0,0,0,0,0,0,5},
        	{0,0,0,0,0,0,9,0,0},
        	{0,0,8,0,0,6,0,0,3},
        	{0,2,0,1,0,5,0,0,0}};
       grid=new int[][]
           		{{0,0,0,0,0,0,0,0,0},
           	{0,0,0,0,0,0,0,0,0},
           	{0,0,0,0,0,0,0,0,0},
           	{0,0,0,0,0,0,0,0,0},
           	{0,0,0,0,0,0,0,0,0},
           	{0,0,0,0,0,0,0,0,0},
           	{0,0,0,0,0,0,0,0,0},
           	{0,0,0,0,0,0,0,0,0},
           	{0,0,0,0,0,0,0,0,0}};        		
		solve();
		display();
	}
}
