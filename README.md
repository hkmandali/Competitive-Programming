# Competitive-Programming
This repo has the code for the practice problems I solve

Caveat : Some of the problems have been taken up from Geeks for geeks or has the approach similiar to them

Priority Queue - comparator. The ordering is based on the return value of compare function which takes in two arguments obj1 and obj2.

In case of min heap ,the ordering is if the return value > 0 i.e +ve obj1 is placed to right to obj2 
If return value is < 0 obj1 is placed to the left of obj 2.

 
In case of max heap ,the ordering is if the return value > 0 i.e +ve obj1 is placed to left to obj2 
If return value is < 0 obj1 is placed to the right of obj 2

In any of the above two cases of ret is +ve , obj1 is placed to right of obj2 , else it is placed
 towards left.

If we are developing our own comparator , make sure to ret -1 and +1 to get towards left and right respectively.left means most preferred
I.e left means min in min queue and max in max queue.
