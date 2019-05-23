module Main where

-- import algorithms
import GravitySort
import MergeSort
import SelectionSort

-- utility modules
import System.Exit
import Test.Util

-- test array
testList = [12234, 34532, 543, 1, 324, 6534]

-- test gravity sort on a given list
testGravitySort :: [Int] -> Bool
testGravitySort x = and [isSorted x', areSame x x']
  where x' = gravitySort x

-- test merge sort on a given list
testMergeSort :: Ord a => [a] -> Bool
testMergeSort x = and [isSorted x', areSame x x']
  where x' = mergeSort x

-- test selection sort on a given list
testSelectionSort :: Ord a => [a] -> Bool
testSelectionSort x = and [isSorted x', areSame x x']
  where x' = selectionSort x

main :: IO ()
main = if and allTests then exitSuccess else exitFailure

allTests :: [Bool]
allTests =  [
    testGravitySort testList
  , testMergeSort testList
  , testSelectionSort testList
  ]

  
