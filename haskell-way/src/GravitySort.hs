module GravitySort (gravitySort) where

{- Gravity/Bead Sort in Haskell
 -
 - sort a list of positive integers in a natural way
 -
 - we use the term "binary matrix" below for lack of a better one: we don't work
 - with matrices at all since the algorithm allows us to cut off most rows early
 -
 - -}

import Data.List (transpose)

gravitySort :: [Int] -> [Int]
gravitySort =  collapse . matricize . collapse . matricize

-- transform a list to a binary matrix
matricize :: [Int] -> [[Int]]
matricize = map (\n -> take n . repeat $ 1)

-- count number of 1s on each column of a binary matrix
collapse :: [[Int]] -> [Int]
collapse = map length . transpose
