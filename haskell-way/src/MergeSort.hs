module MergeSort (mergeSort) where

-- I am a Haskell noob at the moment. This code was written for shits and giggles when I was
-- reading the merge-sort code for clojure. I just thought, why not translate it to haskell when you are learning it
-- I am sure there will be a more elegant way to implement in Haskell, which I will updtate to

merge :: (Ord a) => [a] -> [a] -> [a]
merge [] ys = ys
merge xs [] = xs        
merge l@(x:xs) r@(y:ys) | x < y     = x : merge xs r
                        | otherwise = y : merge l ys
                
mergeSort :: (Ord a) => [a] -> [a]
mergeSort  [] = []
mergeSort [x] = [x]
mergeSort  xs = merge (mergeSort firstHalf) (mergeSort secondHalf)
  where
    (firstHalf, secondHalf) = splitAt (length xs `div` 2) xs

-- Poor man's test                    
main :: IO ()
main = 
  print $ mergeSort [6, 7, 2, 3, -5, 9, 4, 11, 1, 1]
