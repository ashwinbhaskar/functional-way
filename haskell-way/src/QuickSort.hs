module QuickSort (quickSort) where

    -- Using ZF expressions
    quickSort :: Ord a => [a] -> [a]
    quickSort (x:xs) = quickSort [ y | y <- xs,  y < x ] ++ x:quickSort [ y | y <- xs, y >= x ]
    quickSort []     = []
    
    -- Little test                  
    main :: IO ()
    main = 
      print $ quickSort [6, 7, 2, 3, -5, 9, 4, 11, 1, 1]