package divideandconquer

/* 
Description taken from haskell course CIS 194 - https://www.cis.upenn.edu/~cis194/spring13/lectures.html [Homework1]
The Towers of Hanoi is a classic puzzle with a solution
that can be described recursively. Disks of different sizes are stacked
on three pegs; the goal is to get from a starting configuration with
all disks stacked on the first peg to an ending configuration with all
disks stacked on the last peg.
The only rules are
• you may only move one disk at a time, and
• a larger disk may never be stacked on top of a smaller one
*/

import types.{Peg, Move}

def towerOfHanoi(numberOfDiscs: Int, fromPeg: Peg, toPeg: Peg, bufferPeg: Peg): List[Move] = numberOfDiscs match
    case 0 => List()
    case n => towerOfHanoi(n-1, fromPeg, bufferPeg, toPeg) ++ List(Move(fromPeg, toPeg)) ++ towerOfHanoi(n-1, bufferPeg, toPeg, fromPeg)

    