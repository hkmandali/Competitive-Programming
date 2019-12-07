package src.DynamicProgramming;
// given an array with weights in each cell , find the min cost required to go to that cell from (0,0)
// it can go either up or down or left or right
// for any cell the min cost can be thought of as MinCost[i,j] = Min(MinCost[i-1,j-1] , MinCost[i,j-1],MinCost[i-1,j]) + cost(i,j)
// arr contains the weights of those respective cells
public class MinCostAllSideNonNeg {
}
