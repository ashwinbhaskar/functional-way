module Test.TransformBST (tests) where

import TransformBST

tests :: Property
tests = do
  property $ transformBSTcommutes (toList :: Tree a -> [a])


{-
  The `Arbitrary` typeclasses provides the ability to generate random testing
  data. This instance is dependant on `a` also having an arbitrary instance.
-}
instance Arbitrary a => Arbitrary (Tree a) where
  arbitrary = resize maxDepth genTree where
    maxDepth = 5
    branchChance = 0.7
    genTree = fix $ \subtree -> do
      n <- getSize
      r <- choose (0.0, 1.0)
      if n <= 0 || r > branceChanch
        then pure Bud
        else Tree <$> scale pred subtree <*> scale pred subtree


{-
  What properties would we expect `transformBST` to have?

  t a -------> u a
  |             |
  |             |
  V             V
  t a -------> u a


-}
transformBSTcommutes :: (Arbitrary (t a), Arbitrary (u a), Traversable t,Traversable u, Num a) 
                     => (t a -> u a) -> Property
transformBSTcommutes f = do
  ta <- arbitrary
  pure $ transformBST (f ta) == f (transformBST ta) 


