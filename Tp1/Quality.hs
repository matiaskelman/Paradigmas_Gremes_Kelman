module Quality (Quality , newQ, capacityQ, delayQ) where

import City (City , distanceC, nameC, newC)
import Point (Point , difP, newP)

data Quality = Qua String Int Float deriving (Eq, Show)

newQ :: String -> Int -> Float -> Quality 
newQ = Qua

capacityQ :: Quality -> Int 
capacityQ (Qua _ capacidad _) = capacidad

delayQ :: Quality -> Float
delayQ (Qua _ _ demora) = demora

