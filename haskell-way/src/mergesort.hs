module MergeSort where

-- I am a Haskell noob at the moment. This code was written for shits and giggles when I was
-- reading the merge-sort code for clojure. I just thought, why not translate it to haskell when you are learning it
-- I am sure there will be a more elegant way to implement in Haskell, which I will updtate to
    
mergeSortArray :: (Ord a) => [a] -> [a] -> [a]
mergeSortArray [] [] = []
mergeSortArray [] y = y
mergeSortArray x [] = x
        
mergeSortArray x y = if (head x) < (head y) then
    (head x) : mergeSortArray (tail x) y else
        (head y) : mergeSortArray (tail y) x
                
mergeSort :: (Ord a) => [a] -> [a]
mergeSort x =
    let midPoint = length x `div` 2
        firstHalf = take midPoint x
        secondHalf = drop midPoint x
    in if length firstHalf == 1 && length secondHalf == 1 then 
        mergeSortArray firstHalf secondHalf else
            if length firstHalf == 0 then mergeSortArray [] secondHalf else
                if length secondHalf == 0 then mergeSortArray [] firstHalf else
                    mergeSortArray (mergeSort firstHalf) (mergeSort secondHalf)
    
-- Poor man's test                    
main :: IO ()
main = do
    let x = mergeSort [6, 7, 2, 3, -5, 9, 4, 11, 1, 1] in print x