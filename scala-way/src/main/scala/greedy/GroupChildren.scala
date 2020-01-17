package greedy

/*
Your task is to divide a group of children in a party into groups such that each group has age difference between the children no 
more than 1 year. Your goal is to keep the number of groups minimum. For example, given children with ages 2,2.5,3,4 the minium 
number of such groups would be 2 [{2,2.5},{3,4}]
*/


/*Can we reduce this problem to the problem of minimum refuels (MinimumRefuels.scala)?
      We can if sort the ages of the children in ascending order and make an analogy between refueling stops children ages
      and maxDistanceOnFullTank = 1
      There is one major difference though; this problem unlike the MinRefuels problem is bound to return a solution for all cases.
*/
def minGroups(childrenAges: Array[Float]): Int =
    def minGroupsRecurse(remainingAges: Array[Float]): Int = remainingAges match 
        case Array() => 0 //empty array check
        case _ => 
            val firstChildAge = remainingAges.head
            val remaining = remainingAges.dropWhile(age => (age - firstChildAge) <= 1)
            if(remaining.isEmpty) 1 else 1 + minGroupsRecurse(remaining)
    minGroupsRecurse(childrenAges.sorted)