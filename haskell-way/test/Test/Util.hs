module Test.Util (
    areSame
  , isSorted
  ) where

import Data.List

-- check if two lists are the same using Haskell's own sorting function
areSame :: (Ord a) => [a] -> [a] -> Bool
areSame a b = sort a == sort b

-- check if a list is sorted
isSorted x = isAscending x || isDescending x

-- check if a list is sorted ascendingly
isAscending :: (Ord a) => [a] -> Bool
isAscending []       = True
isAscending [_]      = True
isAscending (a:b:xs) = if a <= b then isAscending xs else False

-- check if a list is sorted descendingly
isDescending :: (Ord a) => [a] -> Bool
isDescending = isAscending . reverse

