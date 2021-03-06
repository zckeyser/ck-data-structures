module Math.Sieve
  ( eratosthenes
  ) where

type Divisor = Integer
type Prime = Integer

eratosthenes :: Integer -> [Prime]
eratosthenes upTo
    | upTo <= 1 = []
    | otherwise = let
                    primes = [2..upTo]
                  in
                    eratosthenesHelper primes $ head primes

divisible :: Integer -> Divisor -> Bool
divisible divisor num = num `mod` divisor == 0

eratosthenesHelper :: [Integer] -> Divisor -> [Prime]
eratosthenesHelper primes divisor
    | divisor > maximum primes `div` 2 = primes
    | otherwise                        = let filteredPrimes = filter (\x -> or
                                                                          [ not . divisible divisor $ x -- make sure it isn't divisible
                                                                          , x <= divisor -- only try to filter numbers which are greater than the divisor
                                                                          ])
                                                                     primes
                                         in eratosthenesHelper filteredPrimes $ nextDivisor divisor filteredPrimes

nextDivisor :: Divisor -> ([Integer] -> Divisor)
nextDivisor current = head . filter (> current)
