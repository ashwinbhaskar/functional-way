module SelectionSort (selectionSort) where

{- Selection Sort in Haskell
 -
 - a pretty canonical implementation of the selection sort in Haskell
 -
 - -}

import Data.List (elemIndex)

selectionSort :: Ord a => [a] -> [a]
selectionSort [] = []
selectionSort xs = min : selectionSort rest
  where
    min  = minimum xs
    rest = removeElem min xs

-- remove the first instance of a given elemnt from a given list
removeElem :: Eq a => a -> [a] -> [a]
removeElem x xs = preSplit ++ safeTail postSplit
  where
    (preSplit, postSplit) = splitAt (elemIndex' x xs) xs

-- wrapper around elemntIndex to get the index of an object in a list. We ignore
-- the Nothing case since we'll be passing the minimum object of the list to
-- this function i.e. an element that is by definition in the list
elemIndex' :: Eq a => a -> [a] -> Int
elemIndex' x xs = case elemIndex x xs of
  Just i  -> i
  Nothing -> undefined

-- tail but does not attempt to get the tail of a void list 
safeTail :: [a] -> [a]
safeTail [] = []
safeTail ps = tail ps


