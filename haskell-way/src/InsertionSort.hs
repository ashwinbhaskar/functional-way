module InsertionSort (insertionSort) where

{- Insertion Sort in Hakell -}

insert :: Ord a => a -> [a] -> [a]
insert x []     = [x]
insert x (y:ys) = if x <= y then x:y:ys else y:insert x ys

insertionSort :: Ord a => [a] -> [a]
insertionSort []     = []
insertionSort (x:xs) = insert x . insertionSort $ xs
