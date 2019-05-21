module Test.Main where

import qualified Test.TransformBST

main = do
  quickCheck TransformBST.tests