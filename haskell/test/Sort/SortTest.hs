module Sort.SortTest where

import Test.Framework
import Test.Framework.Providers.HUnit
import Test.HUnit ((@?=))

import Sort.QuicksortTest
import Sort.MergesortTest

sortTests :: [Test]
sortTests = [ quicksortTest
            , mergesortTest
            ]
