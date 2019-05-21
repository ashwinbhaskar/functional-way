{-# LANGUAGE MultiWayIf #-}

module DiceProblem where

import Data.Function.Memoize (memoFix)

{-
  Given a number 'n', n>=0, find out the number of ways the number 'n' can be reached
by rolling a 6-faced dice
-}

{-
  This problem could be solved in Haskell using a linked list, similar to the eaxmple in Scala. It would be more idiomatic to 
-}

{- TODO: Original function, implemented with linked lists as in scala-}
noOfWays :: Int -> Integer
noOfWays = undefined

noOfWays' :: Int -> Integer
noOfWays' = memoFix $ \memo n ->
  if | n <= 0    -> 0
     | n <= 6    -> 1 + sum [ memo (n -i) | i <- [1..n] ]
     | otherwise -> sum [ memo (n - i) | i <- [1..6] ]