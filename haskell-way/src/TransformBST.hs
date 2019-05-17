module TransformBST where

import Data.Traversable

{-
      5                        27
   / \                      /  \
  2    7        =>         32   8
 /    / \                 /    / \
1    6   8               34   21  0
      \                        \
       6                        15
-}

data Tree a = Branch (Tree a) a (Tree a) | Bud
  deriving (Show)

instance Functor Tree where
  fmap f = go where
    go (Branch l v r) = Branch (go l) (f v) (go r)
    go Bud = Bud

instance Foldable Tree where
  foldMap f = go where
    go (Branch l v r) = go l <> f v <> go r
    go Bud = mempty

instance Traversable Tree where
  traverse f = go where
    go (Branch l v r) = Branch <$> go l <*> f v <*> go r
    go Bud = pure Bud

transformBST :: Num a => Tree a -> Tree a
transformBST = snd . mapAccumR (\a b -> (a+b, a)) 0

leaf :: a -> Tree a
leaf a = Branch Bud a Bud

root :: Tree Int
root = Branch interim1 5 interim2
  where
    interim1 = Branch (leaf 1) 2 Bud
    interim3 = Branch Bud 6 (leaf 6)
    interim2 = Branch interim3 7 (leaf 8)

main :: IO ()
main = putStrLn $ "Transformed root value = " <> show transformedRoot
  where transformedRoot = transformBST root